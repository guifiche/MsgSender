package br.com.primarr.msg.body.builder;

import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import junit.framework.Assert;
import junit.framework.JUnit4TestAdapter;

import org.junit.Test;

import br.com.primarr.msg.body.builder.PostBuilder;
import br.com.primarr.msg.utils.Is;

public class TestContentBuilder {

	public TestContentBuilder() {
		
	}
	public static junit.framework.Test suite() 
	{ 
	    return new JUnit4TestAdapter(TestContentBuilder.class); 
	}
	public Map<String, Object> getParams(int n, int offset)
	{
		Map<String, Object> params = new TreeMap<String, Object>();
		for(int i=offset; i<n+offset; i++)
		{
			params.put("key"+i, "value"+i);
		}		
		return params;
	}
	
	String url = "http://www.fiche.com.br";
	String locale = "pt_BR";
	int initialParamsNumber = 2;
	int initialParamsOffset = 0;
	
	public PostBuilder getPostBuilder()
	{
		PostBuilder postBuilder = new PostBuilder();
		postBuilder.setUrl(url);
		postBuilder.setLocale(locale);		
		postBuilder.setParams(getParams(initialParamsNumber, initialParamsOffset));
		return postBuilder;
	}
	
	@Test
	public void testPostBuilder()
	{			
		String content = null;
		content = getPostBuilder().getContent();
		
		Assert.assertTrue(!Is.empty(content));
		
		content = null;
		content = getPostBuilder().getContent(Locale.ENGLISH);		
		Assert.assertTrue(!Is.empty(content));
		
		content = null;
		content = getPostBuilder().getContent(getParams(initialParamsNumber, initialParamsOffset+2));		
		Assert.assertTrue(!Is.empty(content));
		
		content = null;
		content = getPostBuilder().getContent(getParams(initialParamsNumber, initialParamsOffset+2), Locale.FRENCH);		
		Assert.assertTrue(!Is.empty(content));
	}
}
