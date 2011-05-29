package br.com.primarr.msg.replacer;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

public class ReplacerSupport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1226756067801421102L;
	private Replacer replacer = null;

	public Replacer getReplacer() {
		return replacer;
	}

	public void setReplacer(Replacer replacer) {
		this.replacer = replacer;
	}
	
	public boolean hasReplacer()
	{
		return replacer != null;
	}
	
	protected String replace(String text, Map<String, Object> parameters, Locale locale)
	{
		if(hasReplacer())
			return getReplacer().replace(text, parameters, locale);
		else
			return text;
	}
}
