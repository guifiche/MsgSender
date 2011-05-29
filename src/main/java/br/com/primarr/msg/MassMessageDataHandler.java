package br.com.primarr.msg;

import java.util.List;

public interface MassMessageDataHandler
{
	/**
	 * Pega mensagens de um tipo definido de uma fonte dependente da aplicação. 
	 * Por exemplo, pode retornar e-mails salvos em um banco de dados que estão agendados para envio  
	 * 
	 * @return
	 */
	public List<Message> getMessages();

	/**
	 * Salva mensagens que foram enviadas para que elas não sejam reenviadas
	 * @param messages
	 */
	public void saveMessagesSent(List<Message> messages);
}
