package br.com.primarr.msg.replacer;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

public interface Replacer extends Serializable 
{
	public String replace(String text, Map<String, Object> parameters, Locale locale);
}
