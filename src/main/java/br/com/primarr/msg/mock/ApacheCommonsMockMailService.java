package br.com.primarr.msg.mock;

import br.com.primarr.msg.Message;
import br.com.primarr.msg.email.AbstractMailService;
import br.com.primarr.msg.email.ApacheCommonsMailService;
import br.com.primarr.msg.email.EmailTemplate;
import br.com.primarr.msg.exceptions.UnsupportedMessageException;

/**
 * Faz tudo que {@link ApacheCommonsMailService} faz, exceto chamar o metodo email.send()
 * para enviar o e-mail.
 * @author Guilherme Fiche
 *
 */
public class ApacheCommonsMockMailService extends AbstractMailService  {

	public void sendMessage(Message message) {
		
		try
		{
			EmailTemplate emailTemplate = (EmailTemplate)message;
			
			if(!emailTemplate.hasSmtpServer())
			{
				emailTemplate.setSmtpServer(getSmtpServer());
			}
			emailTemplate.getEmail();
//			email.send();
			emailTemplate.setSent(true);
		}
		catch (ClassCastException e){
			message.setFailed(true);
			throw new UnsupportedMessageException(e);
		}
//		catch (EmailException e) {
//			throw new br.com.primarr.msg.exceptions.MessagingException(e);
//		}
	}

	
	
	
}
