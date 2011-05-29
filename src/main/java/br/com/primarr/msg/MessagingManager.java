package br.com.primarr.msg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.primarr.msg.copy.DeepCopy;
import br.com.primarr.msg.email.EmailAddress;
import br.com.primarr.msg.email.EmailTemplate;
import br.com.primarr.msg.exceptions.UnsupportedDeliveryServiceException;
import br.com.primarr.msg.exceptions.UnsupportedMessageException;
import br.com.primarr.msg.optout.AbstractOptOutSupport;
import br.com.primarr.msg.optout.MailListOptOutSupport;

public class MessagingManager
{
	public MessagingManager()
	{}
	
	private static Log logger = LogFactory.getLog(MessagingManager.class);
	
	private Map<String, MessageDeliveryService> deliveryServices;
	
    private MessagingThread m_EmailThread = null;
    
    private boolean sendMessageSynchronously = false;
    
    private Map<String, Message> messageTemplates = new HashMap<String, Message>();
    
    private Map<String, AbstractOptOutSupport> optOutSupportMap = new HashMap<String, AbstractOptOutSupport>();
    
    private List<String> mailAddressTestList = new ArrayList<String>();
    
    private List<MassMessagingThread> massMessagingThreads = new ArrayList<MassMessagingThread>();
    
    public boolean isSendMessageSynchronously() {
		return sendMessageSynchronously;
	}
    
	public void setSendMessageSynchronously(boolean sendMessageSynchronously) {
		this.sendMessageSynchronously = sendMessageSynchronously;
	}
	
	public Map<String, MessageDeliveryService> getThreadDeliveryServices()
    {
    	return this.m_EmailThread.getDeliveryServices();
    }
	
    public List<String> getMailAddressTestList() {
		return mailAddressTestList;
	}
    
	public void setMailAddressTestList(List<String> mailAddressTestList) {
		this.mailAddressTestList = mailAddressTestList;
	}
	
	public Map<String, Message> getEmailTemplates() {
		return messageTemplates;
	}
	public void setEmailTemplates(Map<String, Message> emailTemplates) {
		this.messageTemplates = emailTemplates;
	}
	
	
	 /**
	  * Envia o email. Tem opção de envio síncrono (imediato) e asíncrono (colocado na fila de envio) 
	  * @param emailInformation Definição do e-mail a ser enviado.
	  * @param sendMessageSynchronously se <code>true</code> envia no mesmo momento, se <code>false</code> coloca na fila da thread de envio.
	  * @return <code>true</code> caso sucesso de envio (síncrono) ou colocação na fila (asíncrono), <code>false</code> caso falha.  
	  */
	public boolean sendMessage(Message message, boolean sendMessageSynchronously)
	{
		if(isOptedOut(message))
			return false;
		
		if(sendMessageSynchronously)
		{   //envia agora!
			try
			{
				getMessageDeliveryService(message).sendMessage(message);
			}
			catch (Exception e) {
				
				if(logger.isErrorEnabled())
					logger.error("Error sending e-mail.", e);
				
				return false;
			}
		}
		else
		{   //adiciona na fila da thread de envio
			synchronized (this)
			{
				m_EmailThread.addMessage(message);
			}
		}
		return true;
	}
	
	
	public MessageDeliveryService getMessageDeliveryService(Message message)
	{
		return selectMessageDeliveryService(getDeliveryServices(), message);
	}
	
	/**
	 * Seleciona MessageDeliveryService adequado para o envio da message
	 * @param deliveryServices
	 * @param message
	 * @return
	 */
	public static MessageDeliveryService selectMessageDeliveryService(Map<String, MessageDeliveryService> deliveryServices, Message message)
	{
		MessageDeliveryService s = deliveryServices.get(message.getDeliveryServiceKey());
		if(s == null)
			throw new UnsupportedDeliveryServiceException("Não foi possível encontrar um serviço de envio de mensagem para "+message.getDeliveryServiceKey());
		if(!s.isSupported(message))
			throw new UnsupportedMessageException("Serviço de envio de mensagem [ "+s+" ] não suporta o envio da mensagem ["+message+" ]");
		
		return s;
	}
	
	/**
	 * Mesmo que <code>sendEmail(EmailInformation, boolean)</code>, no entanto a definição de envio síncrono ou asíncrono é definido pelo método <code>isSendEmailSynchronously()</code>.  
	 * @param p_EmailInformation
	 * @return true caso haja sucesso.
	 */
	public boolean sendMessage(Message message)
	{
		return sendMessage(message, isSendMessageSynchronously());
	}

	public Message getMessageTemplate(String messageTemplateKey)
	{
		if (messageTemplates.containsKey(messageTemplateKey))
		{
			Message messageTemplate = messageTemplates.get(messageTemplateKey);
			try
			{
				return (Message)DeepCopy.copy(messageTemplate);
			}
			catch (Exception e) {
				if(logger.isErrorEnabled())
					logger.error("Can't get deep copy of the template: "+messageTemplateKey, e);
			}
		}
		
		return null;
	}

	
	private synchronized void setEmailThreadReferenceNull()
	{
		if ((m_EmailThread != null) && (m_EmailThread.getMessageQueueCount() > 0))
		{
			m_EmailThread = null;
		}
	}

	private synchronized MessagingThread getEmailThreadReference()
	{
		return m_EmailThread;
	}

	private static void log(String p_Text)
	{
	    if(logger.isDebugEnabled())
	        logger.debug(p_Text);
	}
	
	private static void log_DEBUG(String p_Text)
	{
	    if(logger.isDebugEnabled())
	        logger.debug(p_Text);
	}
	
	private static void log_INFO(String p_Text)
	{
	    if(logger.isInfoEnabled())
	        logger.info(p_Text);
	}
	
	public void sendTestMail()
	{
		if(!messageTemplates.isEmpty() && !mailAddressTestList.isEmpty())
		{
			Iterator<String> it = messageTemplates.keySet().iterator();
			while(it.hasNext())
			{
				String mailKey = it.next();
				Message messageTemplate = getMessageTemplate(mailKey);
				if(messageTemplate instanceof EmailTemplate)
				{
					EmailTemplate emailTemplate = (EmailTemplate)messageTemplate;
					Iterator<String> itAddr = mailAddressTestList.iterator();
					while(itAddr.hasNext())
						emailTemplate.setAddCc(itAddr.next());
					sendMessage(emailTemplate);
				}
			}
			
		}
	}
	
	
	public void setMailListOptOutSupportList(List<MailListOptOutSupport> list)
	{
		if(list != null)
		{
			for(MailListOptOutSupport optOutSupport : list)
			{
				optOutSupportMap.put(optOutSupport.getMailListName(), optOutSupport);
			}
		}
	}

	public Map<String, AbstractOptOutSupport> getOptOutSupportMap() {
		return optOutSupportMap;
	}

	public void setOptOutSupportMap(
			Map<String, AbstractOptOutSupport> optOutSupportMap) {
		this.optOutSupportMap = optOutSupportMap;
	}
	
	/**
	 * Check if each receiver has opted out and remove it from the emailTemplate.toMap
	 * If the emailTemplate.toMap gets empty in the end, this method returns true;
	 * @param emailTemplate
	 * @return
	 */
	public boolean isOptedOut(Message message)
	{
		if(message instanceof EmailTemplate)
		{
			EmailTemplate emailTemplate = (EmailTemplate)message;
			String mailListName  = emailTemplate.getMailListName();
			if(mailListName == null)
				return false;
			else
			{
				AbstractOptOutSupport optOutSupport = getOptOutSupportMap().get(mailListName);
				if(optOutSupport == null)
					return false;
				else
				{
					Iterator<EmailAddress> toIt =  emailTemplate.getToMap().values().iterator();
					while(toIt.hasNext())
					{
						String toAddress = toIt.next().getAddress();
						String fromAddress = emailTemplate.getAddressResponsibleForMailList() != null ? emailTemplate.getAddressResponsibleForMailList() : emailTemplate.getFromAddress().getAddress();  
						if(optOutSupport.isOptedOut(toAddress, fromAddress))
						{
							emailTemplate.getToMap().remove(toAddress);						
						}
					}
					
					if(emailTemplate.getToMap().isEmpty())
						return true;
					else
						return false;
				}
			}
		}
		
		return false;
	}

	public Map<String, MessageDeliveryService> getDeliveryServices() {
		return deliveryServices;
	}

	/**
	 * Injeta serviços de envio de mensagem
	 * @param deliveryServices
	 */
	public void setDeliveryServices(Map<String, MessageDeliveryService> deliveryServices)
	{	
		this.deliveryServices = deliveryServices;
    	this.m_EmailThread = new MessagingThread(this.deliveryServices);
    	this.m_EmailThread.start();
	}
	
	public void addDeliveryServices(MessageDeliveryService deliveryService, String deliveryServiceKey)
	{
		if(deliveryService != null)
		{	
			if(getDeliveryServices() == null)
				setDeliveryServices(new HashMap<String, MessageDeliveryService>());
			
			getDeliveryServices().put(deliveryServiceKey != null ? deliveryServiceKey : deliveryService.getDefaultDeliveryServiceKey(), deliveryService);
		}
	}
	
	public void addDeliveryServices(MessageDeliveryService deliveryService){
		addDeliveryServices(deliveryService, null);
	}

	public List<MassMessagingThread> getMassMessagingThreads() {
		return massMessagingThreads;
	}

	public void setMassMessagingThreads(List<MassMessagingThread> massMessagingThreads) 
	{
		this.massMessagingThreads = massMessagingThreads;
		
		for(MassMessagingThread t : this.massMessagingThreads)
		{
			if(!t.isAlive())
				t.start();
		}
	}
}
