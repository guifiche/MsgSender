package br.com.primarr.msg;

import java.io.Serializable;
import java.util.List;

public interface MassMessageDeliveryService extends Serializable {

	/**
	 * Envia mensagens em massa
	 * @param message
	 */
	public void sendMessages(List<Message> message);
}
