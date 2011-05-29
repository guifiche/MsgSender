package br.com.primarr.msg.email;

import java.util.Locale;

import org.apache.commons.mail.Email;

import br.com.primarr.msg.body.MessageBody;
import br.com.primarr.msg.body.ParameterizedContent;

public interface EmailBody extends MessageBody, ParameterizedContent {
		
	public Email getEmail();
	
	public Email getEmail(Locale locale);
	
}
