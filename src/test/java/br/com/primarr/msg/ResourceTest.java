package br.com.primarr.msg;

import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Assert;
import org.junit.Test;


public class ResourceTest 
{
	public ResourceTest() {
		
	}

	@Test
	public void test() 
	{	
		
		//ResourceBundle bundle =  ResourceBundle.getBundle("br.com.primarr.msg.emailResources", Locale.ROOT);
		ResourceBundle bundle =  ResourceBundle.getBundle("EmailSubject", new Locale("pt","BR"));
		
		System.out.println(bundle.getString("subject1"));
		System.out.println("dafeult "+Locale.getDefault()+", used "+bundle.getLocale());
		Assert.assertTrue(true);
//		System.out.println(bundleUS.getString("subject10"));
		//System.out.println(bundleBR.getString("subject1"));
		
	}
	
	public static void main(String[] args) 
	{
		(new ResourceTest()).test();
	}
}
