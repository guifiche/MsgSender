package br.com.primarr.msg;

import java.io.Serializable;
import java.util.Locale;

import br.com.primarr.msg.body.MessageBody;

public interface Message extends Serializable
{
	/**
	 * 
	 * @return corpo da mensagem, geralmente contendo texto, mas em diferentes formatos (HTML, 140 characteres, etc) 
	 */
	public MessageBody getBody();
	
	/**
	 * 
	 * @return prioridade da mensagem na fila de envio
	 */
	public MessagePriority getPriority();
	
	/**
	 * Determina o Locale a ser usado para 118n
	 * @return 
	 */
	public Locale getLocale();
	
	/**
	 * 
	 * @return chave que identifica qual {@link MessageDeliveryService} deve ser usado no envio desta mensagem.
	 */
	public String getDeliveryServiceKey();
	
	/**
	 * 
	 * @return true se a mensagem foi envida
	 */
	public boolean isSent();
	
	/**
	 * 
	 * @return true se ocorreu falha no envio
	 */
	public boolean isFailed();
	
	/**
	 * Define se o envio da mensagem falhou
	 * @param failed
	 * @return
	 */
	public void setFailed(boolean failed);
	
	/**
	 * Identificador da mensagem definida pela aplicação que gerou a mensagem para envio. Serve para rastreamento da mensagem pela aplicação que a utiliza.
	 * Não é obrigatória para o envio de uma mensagem. 
	 * @return identificador da mensagem
	 */
	public MessageId getId();
	
}
