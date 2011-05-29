package br.com.primarr.msg.email;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import br.com.primarr.msg.exceptions.MessagingException;
import br.com.primarr.msg.utils.Is;

public class EmailAddress implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1400659992333570961L;
	
	private String address = null;
	private String name = null;
	private String charset = null;
	
	public EmailAddress(String address, String name, String charset) {
		super();
		this.address = address;
		this.name = name;
		this.charset = charset;
	}
	
	
	
	public EmailAddress(String address, String name) {
		super();
		this.address = address;
		this.name = name;
	}

	public EmailAddress(String address) {
		super();
		this.address = address;
	}
	
	public EmailAddress() {
		super();		
	}

	public InternetAddress toInternetAddress() throws MessagingException
	{
	    InternetAddress address = null;
	
	    try
	    {
	        address = new InternetAddress(this.address);
	
	        // check name input
	        if (Is.empty(this.name))
	        {
	            this.name = this.address;
	        }
	
	        // check charset input.
	        if (Is.empty(this.charset))
	        {
	            address.setPersonal(this.name);
	        }
	        else
	        {
	            // canonicalize the charset name and make sure
	            // the current platform supports it.
	            Charset set = Charset.forName(this.charset);
	            address.setPersonal(this.name, set.name());
	        }
	
	        // run sanity check on new InternetAddress object; if this fails
	        // it will throw AddressException.
	        address.validate();
	    }
	    catch (AddressException e)
	    {
	        throw new MessagingException(e);
	    }
	    catch (UnsupportedEncodingException e)
	    {
	        throw new MessagingException(e);
	    }
	    return address;
}


	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCharset() {
		return charset;
	}
	public void setCharset(String charset) {
		this.charset = charset;
	}
	
	@Override
	public String toString() {
		
		return this.name+"<"+this.address+"> "+this.charset ;
	}
	
}