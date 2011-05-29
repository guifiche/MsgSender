package br.com.primarr.msg.body.builder;

import java.util.Locale;
import java.util.Map;

import br.com.primarr.msg.replacer.ReplacerSupport;

/**
 * Provides only a String setted as content. Does not support Locales or parameters.  
 * @author Guilherme Fiche
 *
 */
public class StringBuilder extends ReplacerSupport implements ContentBuilder {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3198436259469526812L;
	String content = "";
	
	public StringBuilder() {
		
	}
	
	public StringBuilder(String content) {
		this.content=content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}

	public String getContent()
	{	
		return getContent(null, null);
	}


	public String getContent(Map<String, Object> params) {		
		return getContent(params, null);
	}


	public String getContent(Locale locale) {
		return getContent(null, locale);
	}


	public String getContent(Map<String, Object> params, Locale locale) {
		return replace(this.content, params, locale);
	}

}
