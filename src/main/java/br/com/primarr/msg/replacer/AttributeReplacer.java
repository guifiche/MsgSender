package br.com.primarr.msg.replacer;

import java.lang.reflect.Method;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.primarr.msg.utils.Is;


public class AttributeReplacer implements Replacer
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 315247495433836909L;

	private final String datePattern = "dd/MM/yyyy HH:mm:ss";
	
	private String especialTag = "#";

	private HTMLCharReplacer htmlCharReplacer= null;
	
	public AttributeReplacer(String especialTag)
	{
		this.especialTag = especialTag;
	}
	
	public AttributeReplacer()
	{}
	
	private Log logger()
	{ 
		return LogFactory.getLog(AttributeReplacer.class);
	}
	
	public String getEspecialTag()
	{
		return this.especialTag;
	}

	public void setEspecialTag(String especialTag)
	{
		this.especialTag = especialTag;
	}
	
	public String replace(String text, Map<String, Object> attributesMap, Locale locale) {
		
		String newText = text;
		
		if (!Is.empty(attributesMap) && !Is.empty(newText))
		{
			Iterator<Entry<String, Object>> iterator = attributesMap.entrySet().iterator();
			while (iterator.hasNext())
			{
				Entry<String, Object> entry = iterator.next();
				String key = entry.getKey();
				Object value = entry.getValue();

				try {
					newText = replace(newText, key, value, locale);
				} 
				catch (Exception e) 
				{
					if(logger().isErrorEnabled())
						logger().error("Can't replace: "+key+":"+value, e);
				}
			}
		}
		
		return newText;
	}
	
	public String replaceAll(String text)
	{
		return replace(text, new HashMap<String, Object>(), null);
	}

	public String replace(String text, String attributeName, Object attributeValue, Locale locale) throws Exception
	{
		String newText = text;
		
		if(!Is.empty(newText))
		{
			while (atributeNameExistsInText(newText, attributeName))
			{
				newText = internalReplace(newText, attributeName, attributeValue, locale);
				
				if(logger().isDebugEnabled())
					logger().debug("replaced attributeName: "+attributeName+", object:"+attributeValue+" \n result:\n"+newText);
			}
		}
		
		return newText;
	}
		
	
	private String internalReplace(String text, String attributeName, Object object, Locale locale) throws Exception
	{
		if ((attributeName != null) && (!attributeName.equals("")))
		{
			String initialTextAttributeName = this.especialTag + "{" + attributeName;
			int initialTextAttributeNameIndex = text.indexOf(initialTextAttributeName);
			if (initialTextAttributeNameIndex >= 0)
			{
				int endTextAttributeNameIndex = text.indexOf("}", initialTextAttributeNameIndex);
				String textAttributeName = text.substring(initialTextAttributeNameIndex, endTextAttributeNameIndex + 1);
				String value = "";
				if (textAttributeName.indexOf(".") < 0)
				{
					value = getValue(object);
				}
				else
				{
					int firstDotIndex = textAttributeName.indexOf(".");
					String newAttributeName = textAttributeName.substring(firstDotIndex+1, textAttributeName.length() - 1);
					
					value = getObjectValue(newAttributeName, object);
				}
				
				int openParenthesisIndex = endTextAttributeNameIndex + 1;
				if ((openParenthesisIndex < text.length() - 1) && (text.charAt(openParenthesisIndex) == '('))
				{
					int closeParenthesisIndex = text.indexOf(")", openParenthesisIndex);
					if (closeParenthesisIndex > openParenthesisIndex)
					{	
						return getTreatedText(text, value, initialTextAttributeNameIndex, endTextAttributeNameIndex, openParenthesisIndex, closeParenthesisIndex, locale);
					}
				}

				return text.substring(0, initialTextAttributeNameIndex) + 
				replaceHtmlCharacters(value) +
					text.substring(endTextAttributeNameIndex+1, text.length());
			}
		}
		
		return text;
	}
	
	private String getTreatedText(String text, String value, int initialTextAttributeNameIndex, int endTextAttributeNameIndex, int openParenthesisIndex, int closeParenthesisIndex, Locale locale) throws Exception
	{
		String[] parameterList = text.substring(openParenthesisIndex+1, closeParenthesisIndex).split(",");

		if ((parameterList != null) && (parameterList.length > 0))
		{
			String leftAdd = "", rightAdd = "", valueIfNull = "";

			for (int k = 0; k < parameterList.length; k++)
			{
				String[] parameterData = parameterList[k].split("=");
				if (parameterData.length == 1)
				{
					parameterData = new String[2];
					parameterData[0] = "maxlength";
					parameterData[1] = parameterList[k];
				}

				if (parameterData[0].equalsIgnoreCase("dateFormat"))
				{
					try
					{
						SimpleDateFormat sdf = new SimpleDateFormat(parameterData[1]);
						Date date = (new SimpleDateFormat(datePattern)).parse((String)value, new ParsePosition(0));
						String formatedDate = sdf.format(date);
						value = formatedDate;						
					}
					catch (Exception ex)
					{
						if(logger().isErrorEnabled())
							logger().error("Can't format date.", ex);
					}
				}
				else if (parameterData[0].equalsIgnoreCase("addLeft"))
				{
					leftAdd = replaceAll(parameterData[1]);
				}
				else if (parameterData[0].equalsIgnoreCase("addRight"))
				{
					rightAdd = replaceAll(parameterData[1]);
				}
				else if (parameterData[0].equalsIgnoreCase("ifNull"))
				{
					valueIfNull = replaceAll(parameterData[1]);
				}
				else if (parameterData[0].equalsIgnoreCase("maxlength"))
				{
					int cutQuantity = Integer.parseInt(parameterData[1]);
					if (cutQuantity < 0)
						cutQuantity = 0;
					
					if (cutQuantity >= 0)
					{
						value = value.substring(0, ((cutQuantity < value.length()) ? cutQuantity : value.length()) );
						//text = text.substring(0, openParenthesisIndex) + text.substring(closeParenthesisIndex+1, text.length());
					}
				}
			}

			String newValue = ((!value.equals(""))?value:valueIfNull);

			return text.substring(0, initialTextAttributeNameIndex) +
			replaceHtmlCharacters(((!newValue.equals(""))?leftAdd + newValue + rightAdd : "")) +
			text.substring(closeParenthesisIndex+1, text.length());
		}
		
		return text.substring(0, initialTextAttributeNameIndex) + 
		replaceHtmlCharacters(value) +
		text.substring(endTextAttributeNameIndex+1, text.length());
	}
	
	private boolean atributeNameExistsInText(String text, String attributeName)
	{
		if ((attributeName != null) && (!attributeName.equals("")))
		{
			String initialTextAttributeName = this.especialTag + "{" + attributeName;
			int initialTextAttributeNameIndex = text.indexOf(initialTextAttributeName);
			if (initialTextAttributeNameIndex >= 0)
			{
				int endTextAttributeNameIndex = text.indexOf("}", initialTextAttributeNameIndex);
				
				return (initialTextAttributeNameIndex >= 0) && (endTextAttributeNameIndex >= 0);
			}
		}
		
		return false;
	}
	
	private String getObjectValue(String attributeName, Object object) throws Exception
	{
		if (attributeName.indexOf(".") < 0)
		{
			return getValue(callGetMethod(attributeName, object));
		}
		else
		{
			int firstDotIndex = attributeName.indexOf(".");
			String firstObjectName = attributeName.substring(0, firstDotIndex);
			String newAttributeName = attributeName.substring(firstDotIndex+1, attributeName.length());
			
			Object newObject = callGetMethod(firstObjectName, object);
			return getObjectValue(newAttributeName, newObject);
		}
	}
	
	private String getValue(Object objectValue)
	{
		if (objectValue != null)
		{
			if (objectValue instanceof Date)
			{
				SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
				return dateFormat.format((Date)objectValue);
			}
			else
			{
				return String.valueOf(objectValue);
			}
		}
		else
		{
			return "";
		}
	}
	
	private Object callGetMethod(String methodShortName, Object objectToCallMethod) throws Exception
	{
		Method[] methodList = objectToCallMethod.getClass().getMethods();
		
		String methodToSearch = "get" +
			methodShortName.substring(0, 1).toUpperCase() +
			methodShortName.substring(1, methodShortName.length());
		
		for (int k = 0; k < methodList.length; k++)
		{
			if (methodList[k].getName().equals(methodToSearch))
			{
				return methodList[k].invoke(objectToCallMethod, (Object[])null);
			}
		}

		return "";
	}

	
	private String replaceHtmlCharacters(String value)
	{
		if(logger().isDebugEnabled())
			logger().debug("Is replace html characters enabled: "+htmlCharReplacer);
		
		if(htmlCharReplacer != null)
		{	
			return htmlCharReplacer.replaceHtmlChars(value);
		}
		else
		{
			return value;
		}
	}

	public HTMLCharReplacer getHtmlCharReplacer() {
		return htmlCharReplacer;
	}

	public void setHtmlCharReplacer(HTMLCharReplacer htmlCharReplacer) {
		this.htmlCharReplacer = htmlCharReplacer;
	}

	
}
