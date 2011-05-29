package br.com.primarr.msg.body.builder;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.HttpMethod;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.httpclient.NameValuePair;

import br.com.primarr.msg.replacer.ReplacerSupport;
import br.com.primarr.msg.utils.Is;

public class PostBuilder extends ReplacerSupport implements ContentBuilder {

	/**
	 * 
	 */
	private static final long serialVersionUID = 850776292371695188L;

	/**
	 * Name of the parameter for the locale
	 */
	public static final String PARAM_NAME_locale = "lang";
	
	private Log logger()
	{
		return LogFactory.getLog(PostBuilder.class);
	} 
	
	private String url;
	
	private String localeParamName  = PARAM_NAME_locale;
	
	private String locale = null;
	
	private Map<String , Object> params = null;
	
	public PostBuilder() {
		
	}
	
	public PostBuilder(String url) {
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}

	/**
	 * Set the default url for the post in order the retrieve the content.
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}


	public String getLocaleParamName() {
		return localeParamName;
	}


	/**
	 * Changes the default name for the locale parameter to be submmited in the post.
	 * @param localeParamName
	 */
	public void setLocaleParamName(String localeParamName) {
		this.localeParamName = localeParamName;
	}


	public String getLocale() {
		return locale;
	}

	/**
	 * Sets the default locale to be submmited in the post. The actual default is null, which will not post any locale parameter.
	 * <pre>
	 * Example:
	 * en 
	 * en_US 
	 * es
	 * pt_BR</pre>
	 * @param locale
	 */
	public void setLocale(String locale) {
		this.locale = locale;
	}


	public Map<String, Object> getParams() {
		return params;
	}


	/**
	 * Sets the default parameters to be subbmited in the post. By default no parameter will be sent.
	 * @param params
	 */
	public void setParams(Map<String, Object> params) {
		this.params = params;
	}


	/**
	 * Adds the parameters contained in the <code>Map</code> to the post parameters. Null values will become an empty string.  
	 * @param post
	 * @param params
	 */
	private void setupParams(PostMethod post, Map<String, Object> params)
	{
		if(!Is.empty(params))
        {
        	Iterator<Entry<String, Object>> it =params.entrySet().iterator();
        	while(it.hasNext())
        	{
        		Entry<String, Object> entry = it.next();        		 
        		String paramStr = entry.getValue().toString();
        		post.addParameter(entry.getKey(), entry.getValue() == null ? "" : paramStr);
        	}
        }
	}
	
	
	/**
	 * Inserts the {@link Locale} parameter to define internationalization language. If the <code>Locale</code> is null, no parameter will be set.
	 * @param post
	 * @param locale
	 */
	private void setupLocale(PostMethod post, Locale locale)
	{
		if(locale != null)
		{	//Custom locale specified
			
			if(logger().isDebugEnabled())
            	logger().debug(getLocaleParamName()+" "+locale);
			
			post.addParameter(getLocaleParamName(), locale.toString());
		}
		else if(this.locale != null)
		{	//Default locale specified
			
			if(logger().isDebugEnabled())
            	logger().debug(getLocaleParamName()+" "+this.locale);
			
			post.addParameter(getLocaleParamName(), this.locale);
		}
	}
	
	public String getContent()
	{
		return getContent(this.url, null, null);
	}

	public String getContent(Map<String, Object> params)
	{
		return getContent(this.url, params, null);
	}
	
	public String getContent(Locale locale)
	{
		return getContent(this.url, null, locale);
	}
	
	public String getContent(Map<String, Object> params, Locale locale)
	{
		return getContent(this.url, params, locale);
	}
	
	private String buildQueryStringParams(boolean isFirstParam, Map<String, Object> params)
	{
		String queryString = "";
		if(params != null && !params.isEmpty())
		{
			Iterator<Entry<String, Object>> it = params.entrySet().iterator();
			while(it.hasNext())
			{
				Entry<String, Object> entry = it.next();
				
				queryString += (isFirstParam?"?":"&")+entry.getKey()+"="+(entry.getValue() == null ? "" : encodeParamValue(entry.getValue().toString()));
				isFirstParam= false;
			}
		}
		return queryString;
	}
	
	private String buildQueryString(Map<String, Object> params, Locale locale)
	{
		String queryString= "";
			
		boolean isFirstParam = true;
		
		if(locale != null)
		{
			queryString += (isFirstParam?"?":"&")+getLocaleParamName()+"="+encodeParamValue(locale.toString());
			isFirstParam= false;
		}
		
		queryString += buildQueryStringParams("".equals(queryString), this.params);
		queryString += buildQueryStringParams("".equals(queryString), params);
			
		
		return queryString;
	}
	
	private String encodeParamValue(String paramValue)
	{	
		try
		{
			return URLEncoder.encode(paramValue,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			
			if(logger().isErrorEnabled())
				logger().debug("Param value can not be url encoded: "+paramValue, e);
		}
		
		return paramValue;
	}
	
	public GetMethod prepareGetMethod(String url, Map<String, Object> params, Locale locale)
	{
		String getUrl = url+buildQueryString(params, locale); 
		GetMethod get = new GetMethod(getUrl);
		return get;
	}

	public PostMethod preparePostMethod(String url, Map<String, Object> params, Locale locale)
	{
		PostMethod post = new PostMethod(url);		
        //post.setRequestHeader("Content-type", "text/xml; charset=ISO-8859-1");        
        setupParams(post, this.params);//Default parameters        
        setupParams(post, params);//Custom parameters        
        setupLocale(post, locale);//Define locale
        NameValuePair[] nvp = post.getParameters();
        
        if(logger().isDebugEnabled())
        {
        	String nameValuePairs = "";
            for(int i=0; i<nvp.length; i++)
            {
            	nameValuePairs += nvp[i]+", ";
            }
        	logger().debug("Posting to: "+url+" with params: "+nameValuePairs);
        }
        
        
        return post;
	}
	
	public HttpMethod prepareHttpMethod(String url, Map<String, Object> params, Locale locale)
	{
		boolean doPost = false;
		if(doPost)
		{
			return preparePostMethod(url, params, locale);
		}
		else
		{
			return prepareGetMethod(url, params, locale);
		}
	}
	
	public String getContent(String url, Map<String, Object> params, Locale locale)
	{
		HttpMethod method = prepareHttpMethod(url, params, locale);
		
		HttpClient httpclient = new HttpClient();
		        
        String content = null;
        try
        {
            int result = httpclient.executeMethod(method);
            if (result == 200)
            {
            	InputStream inputStream =  method.getResponseBodyAsStream();
            	
	    		BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
	    		StringBuffer buffer = new StringBuffer();
	    		String line = null;
	    		while ((line = in.readLine()) != null) 
	    		{
	    			buffer.append(line+"\n");
	    		}
	    		
	    		content = buffer.toString();
            }
            else
            {
            	content = null;
            }
            
            if(logger().isDebugEnabled())
            	logger().debug("URI: "+method.getURI().toString()+"\nHTTP result code: "+result+"\nContent:\n"+content);
        }
        catch (Exception e)
        {
        	if(logger().isErrorEnabled())
        		logger().error("Can not return the content.", e);
        	content =  null;
        }
        finally
        {
        	method.releaseConnection();
        }
        
        return replace(content, params, locale);
	}
	
	
}
