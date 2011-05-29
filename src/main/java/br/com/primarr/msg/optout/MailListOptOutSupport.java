package br.com.primarr.msg.optout;


public abstract class MailListOptOutSupport extends AbstractOptOutSupport {

	private String mailListName;
	
	public MailListOptOutSupport() {
		
	}

	public String getMailListName() {
		return mailListName;
	}

	public void setMailListName(String mailListName) {
		this.mailListName = mailListName;
	}
	
}
