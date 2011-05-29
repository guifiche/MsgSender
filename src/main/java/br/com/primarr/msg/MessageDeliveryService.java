package br.com.primarr.msg;


public interface MessageDeliveryService {

	/**
	 * Efectivelly sends the message defined by the template
	 * @param emailTemplate
	 */
	public void sendMessage(Message message);
	
	/**
	 * Verifica se a {@link Message} é suportada por este serviço 
	 * @param message
	 * @return
	 */
	public boolean isSupported(Message message);
	
	/**
	 * 
	 * @return full class name
	 */
	public String getDefaultDeliveryServiceKey();
	
}
