package br.com.primarr.msg.email;

import java.io.Serializable;

public class SmtpServer implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1784963847633234288L;
	private String hostAddress;
	private String username;
	private String password;
	private int port = 25;
	private int sslPort = 465;
	private boolean ssl = false;
	private boolean tls = false;
	private boolean authenticate = true;
	private boolean popBeforeSmtp = false;
	
	public SmtpServer(){
		
	}

	public SmtpServer(String hostAddress, String username, String password) {
		super();
		this.hostAddress = hostAddress;
		this.username = username;
		this.password = password;
	}

	public String getHostAddress() {
		return hostAddress;
	}

	public void setHostAddress(String hostAddress) {
		this.hostAddress = hostAddress;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isSsl() {
		return ssl;
	}

	public void setSsl(boolean ssl) {
		this.ssl = ssl;
	}

	public boolean isTls() {
		return tls;
	}

	public void setTls(boolean tls) {
		this.tls = tls;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getSslPort() {
		return sslPort;
	}

	public void setSslPort(int sslPort) {
		this.sslPort = sslPort;
	}

	public boolean isAuthenticate() {
		return authenticate;
	}

	/**
	 * Enable smtp authentication. Default is true.
	 * Authenticate and PopBeforeSmtp are independent. To disable any authentication type both must be false.
	 * @param authenticate
	 */
	public void setAuthenticate(boolean authenticate) {
		this.authenticate = authenticate;
	}

	public boolean isPopBeforeSmtp() {
		return popBeforeSmtp;
	}

	/**
	 * Enable "pop3 before smtp" authentication it will use the same host, username and password as for smtp.
	 * The default e false.
	 * Authenticate and PopBeforeSmtp are independent. To disable any authentication type both must be false.  
	 * @param popBeforeSmtp
	 */
	public void setPopBeforeSmtp(boolean popBeforeSmtp) {
		this.popBeforeSmtp = popBeforeSmtp;
	}

		
}
