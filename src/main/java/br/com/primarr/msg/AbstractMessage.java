package br.com.primarr.msg;

import java.util.Locale;

import org.apache.commons.httpclient.methods.GetMethod;

import br.com.primarr.msg.body.MessageBody;
import br.com.primarr.msg.body.TextBody;

public abstract class AbstractMessage implements Message {

	private MessageBody body;
	private MessagePriority priority = MessagePriority.NORMAL;
	private Locale locale = null;
	private String deliveryServiceKey;
	private boolean sent = false;
	private boolean failed = false;
	private MessageId id;
	
	public MessageBody getBody() {
		return body;
	}
	public void setBody(MessageBody body) {
		this.body = body;
	}
	
	public void setBody(String emailBody) {
		this.body = new TextBody(emailBody);
	}
	
	public MessagePriority getPriority() {
		return priority;
	}
	public void setPriority(MessagePriority priority) {
		this.priority = priority;
	}
	
	public Locale getLocale()
	{
		return locale;
	}
	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	
	public boolean hasLocale()
	{
		return locale != null;
	}
	
	public String getDeliveryServiceKey() {
		return deliveryServiceKey == null ? getDefaultDeliveryServiceKey() : deliveryServiceKey;
	}
	public void setDeliveryServiceKey(String deliveryServiceKey) {
		this.deliveryServiceKey = deliveryServiceKey;
	}
	
	/**
	 * Caso deliveryServiceKey é nulo, getDeliveryServiceKey retorna este método;
	 * @return
	 */
	public abstract String getDefaultDeliveryServiceKey();
	
	public boolean isSent() {
		return sent;
	}
	public void setSent(boolean sent) {
		this.sent = sent;
	}
	public MessageId getId() {
		return id;
	}
	public void setId(MessageId id) {
		this.id = id;
	}
	public boolean isFailed() {
		return failed;
	}
	public void setFailed(boolean failed) {
		this.failed = failed;
	}
	
	@Override
	public String toString() {
		if(getId() != null){
			return this.getClass().getName()+"[ "+getId()+" ] ";
		}
		return super.toString();
	}
}
