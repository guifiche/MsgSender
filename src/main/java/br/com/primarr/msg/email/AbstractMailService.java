package br.com.primarr.msg.email;

import br.com.primarr.msg.Message;

public abstract class AbstractMailService implements MailService {

	private SmtpServer smtpServer;
	
	public SmtpServer getSmtpServer() {
		
		return this.smtpServer;
	}
	
	public void setSmtpServer(SmtpServer smtpServer) {
		this.smtpServer = smtpServer;
	}

	public boolean isSupported(Message message) 
	{	
		return (message instanceof EmailTemplate);
	}

	/**
	 * @return MailService.class.getName();
	 */
	public String getDefaultDeliveryServiceKey() {
		return MailService.class.getName();
	}
}
