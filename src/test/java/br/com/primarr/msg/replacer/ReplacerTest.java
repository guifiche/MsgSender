package br.com.primarr.msg.replacer;

import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;
import junit.framework.JUnit4TestAdapter;

import org.junit.Test;

public class ReplacerTest {

	public ReplacerTest() {
		
	}
	
	public static junit.framework.Test suite() 
	{ 
	    return new JUnit4TestAdapter(ReplacerTest.class); 
	}
	
	@Test
	public void testReplacers()
	{			
		String textToReplace = "Olá Guilherme. Hoje temos uma promoção especial para você.";
		String expectedResult = "Ol&aacute; Guilherme. Hoje temos uma promo&ccedil;&atilde;o especial para voc&ecirc;.";
		HTMLCharReplacer htmlCharReplacer = new HTMLCharReplacer();
		htmlCharReplacer.setFriendlyCode(true);
		htmlCharReplacer.setNumericalCode(false);
		String result = htmlCharReplacer.replace(textToReplace, null, null);
		Assert.assertTrue(expectedResult.equals(result));
		
		
		Map<String, Object> attributesMap = new HashMap<String, Object>();
		attributesMap.put("name", "Guilherme");
		
		textToReplace = "My name is #{name}";
		expectedResult = "My name is Guilherme";
		
		AttributeReplacer attributeReplacer = new AttributeReplacer();
		result = attributeReplacer.replace(textToReplace, attributesMap, null);
		Assert.assertTrue(expectedResult.equals(result));
		
		
		textToReplace = "My name is nobody";
		expectedResult = "My name is nobody";
		
		result = attributeReplacer.replace(textToReplace, attributesMap, null);
		Assert.assertTrue(expectedResult.equals(result));
	}
	
}
