package br.com.primarr.msg;

import java.util.List;

public interface MassMessageDataHandler
{
	/**
	 * Pega mensagens de um tipo definido de uma fonte dependente da aplica��o. 
	 * Por exemplo, pode retornar e-mails salvos em um banco de dados que est�o agendados para envio  
	 * 
	 * @return
	 */
	public List<Message> getMessages();

	/**
	 * Salva mensagens que foram enviadas para que elas n�o sejam reenviadas
	 * @param messages
	 */
	public void saveMessagesSent(List<Message> messages);
}
