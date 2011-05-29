package br.com.primarr.msg.replacer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import br.com.primarr.msg.utils.Is;

/**
 * This replacer wraps a list of replacers to execute them in series.
 * Replacers are stored in an ArrayList. The are executed in the order they are added to the list.
 * @author fiche
 *
 */
public class ReplacerChain implements Replacer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4734619600864803023L;
	private List<Replacer> replacers = new ArrayList<Replacer>();
	
	
	public List<Replacer> getReplacers() {
		return replacers;
	}



	public void setReplacers(List<Replacer> replacers) {
		this.replacers = replacers;
	}


	public String replace(String text, Map<String, Object> parameters,	Locale locale) {
		
		String replacedText = text;
		
		if(!Is.empty(replacers)){
			Iterator<Replacer> it = replacers.iterator();
			while(it.hasNext())
			{
				replacedText = it.next().replace(replacedText, parameters, locale);
			}
		}
		
		return replacedText;
			
	}

}
