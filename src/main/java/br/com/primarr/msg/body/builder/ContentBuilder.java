package br.com.primarr.msg.body.builder;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

public interface ContentBuilder extends Serializable {

	/**
	 * Gets the content with all default values.
	 * @return content 
	 */
	public String getContent();

	/**
	 * Gets the content with optional parameters to be used when building the content.
	 * @param params Map with parameters to be replaced in the body.
	 * @return content
	 */
	public String getContent(Map<String, Object> params);
	
	/**
	 * Gets the content considering the locale for i18n support.
	 * @param locale
	 * @return content
	 */
	public String getContent(Locale locale);
	
	/**
	 * Gets the content optionally  specifying both parameters and locale.
	 * 
	 * @param params
	 * @param locale
	 * @return content
	 */
	public String getContent(Map<String, Object> params, Locale locale);
	
}
