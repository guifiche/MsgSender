package br.com.primarr.msg.email;

import br.com.primarr.msg.MessageDeliveryService;


public interface MailService extends MessageDeliveryService{

	/**
	 * 
	 * Get the default SMTP server to send the e-mail  
	 * @return <code>SmtpServer</code>
	 */
	public SmtpServer getSmtpServer();
	
	/**
	 * Define the default SMTP server to use when sending the e-mail.
	 * @param smtpServer
	 */
	public void setSmtpServer(SmtpServer smtpServer);

}