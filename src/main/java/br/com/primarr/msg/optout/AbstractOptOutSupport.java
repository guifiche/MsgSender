package br.com.primarr.msg.optout;

import java.io.Serializable;
/**
 * This class enables support for opting out mail lists and senders.
 * A concrete class must be implemented in order to provide a way to check 
 * if the receiver has opted out from receiving e-mails from the whole mail list or from a specific sender. 
 * E-mails with opt out support must be send through the MessagingManager
 * @author Guilherme Fiche
 *
 */
public abstract class AbstractOptOutSupport implements Serializable 
{	
	private boolean enableOptOut = true;
	private boolean enableSenderOptOut = false;
	
	public AbstractOptOutSupport() {
	}
	
	/**
	 * Concrete classes must implement this method. This is method is called by isOptedOut(String , String ) in order to make system specific queries.
	 * @param recieverEmail
	 * @param senderEmail - when enableSenderOptOut is false senderEmail will be null. Case enableSenderOptOut is true, senderEmail has the same value passed to isOptedOut
	 * @return
	 */
	protected abstract boolean checkIfReceiverHasOptedOut(String receiverEmail, String senderEmail);
	
	public boolean isOptedOut(String recieverEmail, String senderEmail)
	{
		if(enableOptOut)
		{
			return checkIfReceiverHasOptedOut(recieverEmail,enableSenderOptOut ? senderEmail : null); 
		}
		else
		{
			return false;
		}
	}

	public boolean isEnableSenderOptOut() {
		return enableSenderOptOut;
	}

	public void setEnableSenderOptOut(boolean enableSenderOptOut) {
		this.enableSenderOptOut = enableSenderOptOut;
	}

	public boolean isEnableOptOut() {
		return enableOptOut;
	}

	public void setEnableOptOut(boolean enableOptOut) {
		this.enableOptOut = enableOptOut;
	}
	
	
}
