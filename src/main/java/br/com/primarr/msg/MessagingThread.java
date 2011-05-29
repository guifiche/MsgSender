package br.com.primarr.msg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

class MessagingThread extends Thread
{
	
	private static Log logger = LogFactory.getLog(MessagingThread.class);

	private ArrayList<Message> m_messageList = null;
	
	private Map<String, MessageDeliveryService> deliveryServices = new HashMap<String, MessageDeliveryService>();
	
	public MessagingThread(Map<String, MessageDeliveryService> deliveryServices)
	{
		m_messageList = new ArrayList<Message>();
		this.deliveryServices = deliveryServices;
	}
	
	public void run()
	{
		int v_NumeroTentativasSemSucesso = 0;
		Message v_message = null;
		while (true)
		{
			v_message = getNextMessage();
			
			if (v_message != null)
		    {
				try
				{
					log("Enviando mensagem -> ([From: " + v_message + "],[Priority: " + v_message.getPriority().getPriority() + "])");
					
					MessageDeliveryService deliveryService = MessagingManager.selectMessageDeliveryService(getDeliveryServices(), v_message);
					deliveryService.sendMessage(v_message);

					removeMessage(v_message);

					v_NumeroTentativasSemSucesso = 0;
				}
				catch (Exception ex)
				{
					ex.printStackTrace();
					putAsLastInTheQueue(v_message);
					if (v_NumeroTentativasSemSucesso > 10)
					{
						try { sleep(1*60*1000); } catch (Exception ex2) {}
					}
					else
					{
						v_NumeroTentativasSemSucesso++;
					}
				}
		    }
			else
			{
				try { sleep(30*1000); } catch (Exception ex2) {}
			}
		}
	}

	private synchronized Message getNextMessage()
	{
		if (m_messageList.size() > 0)
		{
			Message v_HighestPriorityMessage = m_messageList.get(0);
			for (int c_Message = 1; c_Message < m_messageList.size(); c_Message++)
			{
				Message v_Message = m_messageList.get(c_Message);
				
				if (v_Message.getPriority().getPriority() > v_HighestPriorityMessage.getPriority().getPriority())
				{
					v_HighestPriorityMessage = v_Message;
				}
			}
			
			return v_HighestPriorityMessage;
		}
		
		return null;
	}
	
	private synchronized void putAsLastInTheQueue(Message  p_Message)
	{
		log("putAsLastInTheQueue([From: " + p_Message+ "],[Priority: " + p_Message.getPriority().getPriority() + "])");
		m_messageList.remove(p_Message);

		m_messageList.add(p_Message);
	}

	private synchronized void removeMessage(Message p_Message)
	{
		log("removeMessage([From: " + p_Message+ "],[Priority: " + p_Message.getPriority().getPriority() + "])");
		m_messageList.remove(p_Message);
	}
	
	public synchronized void addMessage(Message message)
	{
		log("addMessage([" + message + "],[Priority: " + message.getPriority().getPriority() + "])");
		m_messageList.add(message);
	}
	
	public synchronized int getMessageQueueCount()
	{
		log("getMessageQueueCount()="+m_messageList.size());
		return m_messageList.size();
	}
	
	protected static void log(String p_Text)
	{
	    if(logger.isDebugEnabled())
	        logger.debug(p_Text);
	}
	
	protected static void log_DEBUG(String p_Text)
	{
	    if(logger.isDebugEnabled())
	        logger.debug(p_Text);
	}
	
	protected static void log_INFO(String p_Text)
	{
	    if(logger.isInfoEnabled())
	        logger.info(p_Text);
	}

	public Map<String, MessageDeliveryService> getDeliveryServices() {
		return deliveryServices;
	}

	public void setDeliveryServices(
			Map<String, MessageDeliveryService> deliveryServices) {
		this.deliveryServices = deliveryServices;
	}
}
