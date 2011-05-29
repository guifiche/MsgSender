package br.com.primarr.msg.body;

import java.util.Locale;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import br.com.primarr.msg.body.builder.ContentBuilder;
import br.com.primarr.msg.body.builder.StringBuilder;
import br.com.primarr.msg.email.EmailBody;
import br.com.primarr.msg.replacer.HTMLCharReplacer;

public class HtmlBody extends TextBody implements EmailBody {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8101254958295130848L;
	protected ContentBuilder html=null;
	
	private boolean convertParametersToHTML = true;
	private HTMLCharReplacer htmlCharReplacer =  new HTMLCharReplacer();
	
	public HtmlBody() {		
	}
	
	public HtmlBody(ContentBuilder text, ContentBuilder html) {
		this.text=text;
		this.html=html;
	}
	
	public HtmlBody(String text, String html) {
		this.text=new StringBuilder(text);
		this.html=new StringBuilder(html);
	}
	
	
	public ContentBuilder getHtml() {
		return html;
	}

	public void setHtml(ContentBuilder html) {
		this.html = html;
	}
	
	public void setHtml(String html) {
		this.html = new StringBuilder(html);
	}


	@Override
	public Email getEmail() {
		
		return getEmail(null);
	}
	
	@Override
	public Email getEmail(Locale locale) {
		
		HtmlEmail email = new HtmlEmail();		
		try
		{   
			if(this.html != null){
				email.setHtmlMsg(this.html.getContent(getParameters(),locale));
			}
			
			if(this.text != null){
				email.setTextMsg(this.text.getContent(getParameters(),locale));
			}			
			
		} 
		catch (EmailException e) 
		{
			throw new br.com.primarr.msg.exceptions.MessagingException(e);
		}
		
		return email;
	}
	
	@Override
	public void insertParameter(String key, Object value)
	{
		if(isConvertParametersToHTML() && value != null)
		{
			value = htmlCharReplacer.replaceHtmlChars(value.toString());
		}
		
		super.insertParameter(key, value);
	}

	
	/**
	 * Default é true
	 * @return se true substitúi caracteres especiais dos parâmetros para códigos HTML para evitar conflitos de character encoding no envio.
	 */
	public boolean isConvertParametersToHTML() {
		return convertParametersToHTML;
	}

	public void setConvertParametersToHTML(boolean convertParametersToHTML){
		this.convertParametersToHTML = convertParametersToHTML;
	}
}
