package br.com.primarr.msg.email;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.mail.Email;

import br.com.primarr.msg.AbstractMessage;

public class EmailTemplate extends AbstractMessage {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4032778969712321523L;
	
	private Map<String, EmailAddress> toMap = new HashMap<String, EmailAddress>();
	private Map<String, EmailAddress> ccMap = new HashMap<String, EmailAddress>();
	private Map<String, EmailAddress> bccMap = new HashMap<String, EmailAddress>();
	private Map<String, EmailAddress> replyToMap = new HashMap<String, EmailAddress>();	
	private EmailAddress fromAddress = new EmailAddress();
	private EmailAddress bounceAddress = new EmailAddress();
	private SmtpServer smtpServer = null;	
	private String subject;
	private String subjectKey;
	private String subjectBundle = "EmailSubject";
	private String charset = "UTF=8";
	
	private String mailListName = null;//this if for opt out control. When sending the email the mailList will be check for opt out configuration
	private String addressResponsibleForMailList = null;
	
	public EmailTemplate() {
		
	}
	
	private Log logger()
	{
		return LogFactory.getLog(EmailTemplate.class);
	}
	
	public boolean hasSmtpServer()
	{
		return smtpServer != null;
	}
	
	public void setAddTo(EmailAddress emailAddress)
	{
		toMap.put(emailAddress.getAddress(), emailAddress);
	}
	
	public void setAddCc(EmailAddress emailAddress)
	{
		ccMap.put(emailAddress.getAddress(), emailAddress);
	}
	
	public void setAddBcc(EmailAddress emailAddress)
	{
		bccMap.put(emailAddress.getAddress(), emailAddress);
	}
	
	public void setAddReplyTo(EmailAddress emailAddress)
	{
		replyToMap.put(emailAddress.getAddress(), emailAddress);
	}

		
	public void setAddTo(String emailAddress)
	{
		toMap.put(emailAddress, new EmailAddress(emailAddress));
	}
	
	public void setAddCc(String emailAddress)
	{
		ccMap.put(emailAddress, new EmailAddress(emailAddress));
	}
	
	public void setAddBcc(String emailAddress)
	{
		bccMap.put(emailAddress, new EmailAddress(emailAddress));
	}
	
	public void setAddReplyTo(String emailAddress)
	{
		replyToMap.put(emailAddress, new EmailAddress(emailAddress));
	}

	public void setFromAddress(String emailAddress)
	{
		this.fromAddress = new EmailAddress(emailAddress);
	}
	
	public void setBounceAddress(String emailAddress)
	{
		this.bounceAddress = new EmailAddress(emailAddress);
	}
	
	
	
	public Map<String, EmailAddress> getToMap() {
		return toMap;
	}

	public void setToMap(Map<String, EmailAddress> toMap) {
		this.toMap = toMap;
	}

	public Map<String, EmailAddress> getCcMap() {
		return ccMap;
	}

	public void setCcMap(Map<String, EmailAddress> ccMap) {
		this.ccMap = ccMap;
	}

	public Map<String, EmailAddress> getBccMap() {
		return bccMap;
	}

	public void setBccMap(Map<String, EmailAddress> bccMap) {
		this.bccMap = bccMap;
	}

	public Map<String, EmailAddress> getReplyToMap() {
		return replyToMap;
	}

	public void setReplyToMap(Map<String, EmailAddress> replyToMap) {
		this.replyToMap = replyToMap;
	}

	public EmailAddress getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(EmailAddress fromAddress) {
		this.fromAddress = fromAddress;
	}

	public EmailAddress getBounceAddress() {
		return bounceAddress;
	}

	public void setBounceAddress(EmailAddress bounceAddress) {
		this.bounceAddress = bounceAddress;
	}

	public SmtpServer getSmtpServer() {
		return smtpServer;
	}

	public void setSmtpServer(SmtpServer smtpServer) {
		this.smtpServer = smtpServer;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
	/**
	 * Gets the baseName of the bundle where the email template subject is defined. 
	 * The default value is EmailSubject
	 * @return
	 */
	public String getSubjectBundle() {
		return subjectBundle;
	}

	/**
	 * Sets the baseName of the bundle where the email template subject is defined. 
	 * The default value is EmailSubject
	 * @param subjectBundle
	 */
	public void setSubjectBundle(String subjectBundle) {
		this.subjectBundle = subjectBundle;
	}

	/**
	 * i18n key for the subject. When defined takes precedence over subject  
	 * @return
	 */
	public String getSubjectKey() {
		return subjectKey;
	}

	public void setSubjectKey(String subjectKey) {
		this.subjectKey = subjectKey;
	}

	public EmailBody getEmailBody() {
		return (EmailBody)getBody();
	}
	
	public Email getEmail()
	{
		Email email = getEmailBody().getEmail(getLocale());
		
		populateTo(email);
		populateBcc(email);
		populateCc(email);
		populateReplyTo(email);		
		populateBounceAddress(email);		
		populateFromAddress(email);
		populateSubject(email);		
		populateSmtp(email);
 		populateCharset(email);
 		
		return email;
	}
	
	private void populateCharset(Email email){
		if(getCharset() != null && "".equals(getCharset()))
			email.setCharset(getCharset());
	}
	
	private void populateSmtp(Email email)
	{
		 
		email.setSSL(this.smtpServer.isSsl());
		email.setTLS(this.smtpServer.isTls());
		email.setSmtpPort(this.smtpServer.getPort());
		email.setSslSmtpPort(String.valueOf(this.smtpServer.getSslPort()));
		
		email.setHostName(this.smtpServer.getHostAddress());
		
		if(this.smtpServer.isAuthenticate())
		{
			email.setAuthentication(this.smtpServer.getUsername(), this.smtpServer.getPassword());
		}
		
		if(this.smtpServer.isPopBeforeSmtp())
		{
			email.setPopBeforeSmtp(this.smtpServer.isPopBeforeSmtp(), this.smtpServer.getHostAddress(), this.smtpServer.getUsername(), this.smtpServer.getPassword());
		}
	}
	
	private void populateSubject(Email email)
	{
		if(getSubjectKey() != null && !getSubjectKey().equals(""))
		{
			try
			{
				ResourceBundle bundle =  ResourceBundle.getBundle(getSubjectBundle(), (getLocale() == null ? Locale.getDefault(): getLocale()));
				email.setSubject(bundle.getString(getSubjectKey()));
			}
			catch (MissingResourceException e)
			{
				email.setSubject(getSubjectKey());
			}
		}
		else
		{
			email.setSubject(getSubject());
		}
		
	}
	
	private void populateBounceAddress(Email email)
	{
		email.setBounceAddress(getBounceAddress().getAddress());
	}
	
	private void populateFromAddress(Email email)
	{
		EmailAddress addr = getFromAddress();
		try{
						
			email.setFrom(addr.getAddress(), addr.getName(), addr.getCharset());
		}
		catch (Exception e){
			
			if(logger().isErrorEnabled())
				logger().error("Cannot add email: "+addr, e);
		}
	}
	
	private void populateReplyTo(Email email)
	{
		Iterator<EmailAddress> it = getReplyToMap().values().iterator();
		while(it.hasNext())
		{	
			EmailAddress addr = it.next();
			try{
				email.addReplyTo(addr.getAddress(), addr.getName(), addr.getCharset());
			}
			catch (Exception e){
				
				if(logger().isErrorEnabled())
					logger().error("Cannot add email: "+addr, e);
			}
		}
	}
	
	private void populateTo(Email email)
	{
		Iterator<EmailAddress> it = getToMap().values().iterator();
		while(it.hasNext())
		{	
			EmailAddress addr = it.next();
			try{
				email.addTo(addr.getAddress(), addr.getName(), addr.getCharset());
			}
			catch (Exception e){
				
				if(logger().isErrorEnabled())
					logger().error("Cannot add email: "+addr, e);
			}
		}
	}
	
	private void populateBcc(Email email)
	{
		Iterator<EmailAddress> it = getBccMap().values().iterator();
		while(it.hasNext())
		{	
			EmailAddress addr = it.next();
			try{
				email.addBcc(addr.getAddress(), addr.getName(), addr.getCharset());
			}
			catch (Exception e){
				
				if(logger().isErrorEnabled())
					logger().error("Cannot add email: "+addr, e);
			}
		}
	}
	
	private void populateCc(Email email)
	{
		Iterator<EmailAddress> it = getCcMap().values().iterator();
		while(it.hasNext())
		{	
			EmailAddress addr = it.next();
			try{
				email.addCc(addr.getAddress(), addr.getName(), addr.getCharset());
			}
			catch (Exception e){
				
				if(logger().isErrorEnabled())
					logger().error("Cannot add email: "+addr, e);
			}
		}
	}

	public boolean hasBodyParameters() {
		return getEmailBody().hasParameters();
	}

	public void insertBodyParameter(String key, Object value) {
		getEmailBody().insertParameter(key, value);
	}

	public void removeBodyParameter(String key) {
		getEmailBody().removeParameter(key);
	}

	public String getMailListName() {
		return mailListName;
	}

	/**
	 * Sets the mail list name that this emailTemplate belongs. This allow opt out support
	 * @param mailListName
	 */
	public void setMailListName(String mailListName) {
		this.mailListName = mailListName;
	}

	public String getAddressResponsibleForMailList() {
		return addressResponsibleForMailList;
	}

	/**
	 * Set the email address that will represent the sender when opt out sender support is enabled
	 * @param addressResponsibleForMailList
	 */
	public void setAddressResponsibleForMailList(
			String addressResponsibleForMailList) {
		this.addressResponsibleForMailList = addressResponsibleForMailList;
	}
	
	/**
	 * @return {@link MailService}.class.getName();
	 */
	@Override
	public String getDefaultDeliveryServiceKey(){
		return MailService.class.getName();
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}
}
