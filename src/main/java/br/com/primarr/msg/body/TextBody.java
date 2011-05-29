package br.com.primarr.msg.body;

import java.util.Locale;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import br.com.primarr.msg.body.builder.ContentBuilder;
import br.com.primarr.msg.body.builder.StringBuilder;
import br.com.primarr.msg.email.EmailBody;

public class TextBody extends BaseBody implements EmailBody {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1393194117210838048L;
	protected ContentBuilder text=null;
	
	
	public TextBody() {		
	}
	
	public TextBody(ContentBuilder text) {
		this.text=text;
		
	}
	
	public TextBody(String text) {
		this.text=new StringBuilder(text);
	}
	
	public ContentBuilder getText() {
		return text;
	}

	public void setText(ContentBuilder text) {
		this.text = text;
	}
	
	public void setText(String text){
		this.text = new StringBuilder(text);
	}

	
	public Email getEmail() 
	{
		return getEmail(null);
	}

	public Email getEmail(Locale locale)
	{
		SimpleEmail simpleEmail = new SimpleEmail();
		try
		{
			if(this.text != null){				
				simpleEmail.setMsg(this.text.getContent(getParameters(),locale));
			}
		} 
		catch (EmailException e)
		{
			throw new br.com.primarr.msg.exceptions.MessagingException(e);
		}
		return simpleEmail;		
	}



}
