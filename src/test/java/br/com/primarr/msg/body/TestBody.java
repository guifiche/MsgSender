package br.com.primarr.msg.body;

import org.junit.Assert;
import org.junit.Test;

import junit.framework.JUnit4TestAdapter;
import br.com.primarr.msg.SendEmailTest;
import br.com.primarr.msg.body.HtmlBody;
import br.com.primarr.msg.body.builder.PostBuilder;
import br.com.primarr.msg.email.EmailBody;
import br.com.primarr.msg.replacer.AttributeReplacer;

public class TestBody {

	public TestBody() {
		
	}
	
	public static junit.framework.Test suite() { 
	    return new JUnit4TestAdapter(SendEmailTest.class); 
	}
	
	public void testHtmlBody()
	{	}
	
	@Test
	public void test()
	{
		Assert.assertTrue(true);
	}
	
	/**
	 * Gets a default HtmlBody for testing
	 * @return
	 */
	public HtmlBody getHtmlBody()
	{
		AttributeReplacer replacer = new AttributeReplacer();
		
		PostBuilder html = new PostBuilder();
		html.setUrl("http://localhost/otm/pages/email/recoverPassword.jsp");
		html.setReplacer(replacer);
		
		PostBuilder text = new PostBuilder();
		text.setUrl("http://localhost/otm/pages/email/text/recoverPassword.jsp");
		text.setReplacer(replacer);
		
		HtmlBody htmlBody = new HtmlBody();
		htmlBody.setHtml(html);
		htmlBody.setText(text);
		
		return htmlBody;
	}
	
	public void callGetEmail(EmailBody  body)
	{
		body.getEmail();
	}
	
	public void callGetEmail(int iterationQty)
	{
		EmailBody body = getHtmlBody();
		
		for(int i=0;i<iterationQty; i++)
		{
			System.out.println((i+1)+"/"+iterationQty);
			callGetEmail(body);
		}
	}
	
	
	
//	public static void main(String[] args)
//	{
//		System.out.println("Qty;Time;Time/Qty");
//		PerformanceTest performanceTest = new PerformanceTest();
//		for(int i=1;i<2;i++)
//		{
//			int qty = 1000;
//			Date time1 = new Date();
//			performanceTest.callGetEmail(qty);
//			Date time2 = new Date();
//			long time = (time2.getTime()-time1.getTime());
//			System.out.println(qty+";"+time+";"+(time/qty));
//		}
//	}
}
