/*
 * Created on 24/01/2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package br.com.primarr.msg.email;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * @author tarik
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Autenticador extends Authenticator {

	private String username;
	private String password;
	
	/**
	 */
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 */
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 */
	public PasswordAuthentication getPasswordAuthentication() {
	    return new PasswordAuthentication(username, password);
	  }
}
