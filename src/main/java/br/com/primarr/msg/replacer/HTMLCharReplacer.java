package br.com.primarr.msg.replacer;

import java.util.Locale;
import java.util.Map;

public class HTMLCharReplacer implements Replacer {
	
	private boolean friendlyCode = false;
	private boolean numericalCode = true;
	private boolean hexCode = false;
	private boolean useFullHtmlCharacterTable = false;
	private boolean removeNewLineCharacter = false;
	private boolean convertNewLineCharacterToHtmlTag = true;
	
	public String replace(String text, Map<String, Object> parameters, Locale locale) {
		return replaceHtmlChars(text);
	}
		
	public String replaceHtmlChars(String plainText)
	{	
		String htmlText = "";
		if(plainText != null)
		{
			for(int i = 0 ; i < plainText.length() ; i++)
			{
				htmlText+=replaceHtmlChar(plainText.charAt(i));
			}
		}
		return htmlText;
	}
	
	private Map<Character, HtmlCharacter> getCharacterTable()
	{
		if(useFullHtmlCharacterTable)
			return HtmlCharacter.getHtmlCharacterMap(HtmlCharacter.HTML_CHARACTER_MAP_FULL);
		else
			return HtmlCharacter.getHtmlCharacterMap(HtmlCharacter.HTML_CHARACTER_MAP_DEFAULT);
	}
	
	private String replaceHtmlChar(char c)
	{	
		if('\n' == c)
		{
			if(isRemoveNewLineCharacter())
				return "";
			else if(isConvertNewLineCharacterToHtmlTag())
				return "<br/>";
		}
		
		HtmlCharacter htmlCharacter = getCharacterTable().get(c);
		
		if(htmlCharacter != null){
			if(numericalCode)
			 return	htmlCharacter.getNumericalCode();
			else if(hexCode)
				return	htmlCharacter.getHexCode();
			else if(friendlyCode)
				return	htmlCharacter.getFriendlyCode();
			else			
				return	htmlCharacter.getCharacter().toString();
		}
		else
			return String.valueOf(c);
	}
	

	public boolean isFriendlyCode() {
		return this.friendlyCode;
	}

	public void setFriendlyCode(boolean friendlyCode) {
		this.friendlyCode = friendlyCode;
	}

	public boolean isHexCode() {
		return this.hexCode;
	}

	public void setHexCode(boolean hexCode) {
		this.hexCode = hexCode;
	}

	public boolean isNumericalCode() {
		return this.numericalCode;
	}

	public void setNumericalCode(boolean numericalCode) {
		this.numericalCode = numericalCode;
	}
	
	public boolean isUseFullHtmlCharacterTable() {
		return this.useFullHtmlCharacterTable;
	}

	public void setUseFullHtmlCharacterTable(boolean useFullHtmlCharacterTable) {
		this.useFullHtmlCharacterTable = useFullHtmlCharacterTable;
	}
	
	/**
	 * Default é true
	 * @return
	 */
	public boolean isConvertNewLineCharacterToHtmlTag() {
		return convertNewLineCharacterToHtmlTag;
	}

	public void setConvertNewLineCharacterToHtmlTag(
			boolean convertNewLineCharacterToHtmlTag) {
		this.convertNewLineCharacterToHtmlTag = convertNewLineCharacterToHtmlTag;
	}

	/**
	 * 
	 * Tem precedência sobre isConvertNewLineCharacterToHtmlTag
	 * 
	 * Default é false
	 * @return
	 */
	public boolean isRemoveNewLineCharacter() {
		return removeNewLineCharacter;
	}

	public void setRemoveNewLineCharacter(boolean removeNewLineCharacter) {
		this.removeNewLineCharacter = removeNewLineCharacter;
	}


}
