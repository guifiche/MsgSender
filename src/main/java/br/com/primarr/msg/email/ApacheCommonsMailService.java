package br.com.primarr.msg.email;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;

import br.com.primarr.msg.MassMessageDeliveryService;
import br.com.primarr.msg.Message;
import br.com.primarr.msg.exceptions.UnsupportedMessageException;


public class ApacheCommonsMailService extends AbstractMailService implements MassMessageDeliveryService {

	private static Log logger = LogFactory.getLog(ApacheCommonsMailService.class);
	
	public void sendMessage(Message message)
	{	
		try
		{
			EmailTemplate emailTemplate = (EmailTemplate)message;
			
			if(emailTemplate != null)
			{
				if(!emailTemplate.hasSmtpServer())
				{
					emailTemplate.setSmtpServer(getSmtpServer());
				}
				Email email = emailTemplate.getEmail();
				email.send();
				emailTemplate.setSent(true);
			}
		}
		catch (ClassCastException e){
			message.setFailed(true);
			throw new UnsupportedMessageException(e);
		}
		catch (EmailException e) {
			message.setFailed(true);
			throw new br.com.primarr.msg.exceptions.MessagingException(e);
		}
	}	
	
	public void sendMessages(List<Message> messages)
	{
		if(messages == null)
			return;
		
		for(Message msg : messages)
		{
			try
			{
				sendMessage(msg);
			}
			catch (br.com.primarr.msg.exceptions.MessagingException e)
			{
				logger.error("Não foi possível enviar a mensagem: "+msg, e);
			}
		}
	}
}
