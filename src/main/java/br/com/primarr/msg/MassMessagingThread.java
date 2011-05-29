package br.com.primarr.msg;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Usada para pegar uma lista de mensagens e enviá-las em massa.
 * A thread usa {@link MassMessageDataHandler} para pegar as mensagens e salvá-las depois do envio.
 * A thread usa {@link MassMessageDeliveryService} para enviar as mensagens de fato.
 * 
 * @author Fiche
 *
 */
public class MassMessagingThread extends Thread {
	
	private MassMessageDataHandler massMessageDataHandler;
	private MassMessageDeliveryService deliveryService;
	private long sleepTime = 30*1000;
	
	private static Log logger = LogFactory.getLog(MassMessagingThread.class);
	
	public MassMessagingThread(){
		
	}

	public void run()
	{
		boolean hasMessages = false;
		
		while (true)
		{
			try
			{
				if(!hasMessages)
					sleep(getSleepTime());
				
				List<Message> messages = getMassMessageDataHandler().getMessages();
				if(!messages.isEmpty())
				{
					getDeliveryService().sendMessages(messages);
					getMassMessageDataHandler().saveMessagesSent(messages);
					hasMessages = true;
				}
				else
					hasMessages = false;
			}
			catch (Exception e)
			{
				if(logger.isErrorEnabled())
					logger.error("Erro no ciclo de envio de mensagens.", e);
			}
		}
	}

	public MassMessageDeliveryService getDeliveryService() {
		return deliveryService;
	}

	public void setDeliveryService(MassMessageDeliveryService deliveryService) {
		this.deliveryService = deliveryService;
	}

	public MassMessageDataHandler getMassMessageDataHandler() {
		return massMessageDataHandler;
	}

	public void setMassMessageDataHandler(MassMessageDataHandler massMessageDataHandler)
	{
		this.massMessageDataHandler = massMessageDataHandler;
	}

	public long getSleepTime() {
		return sleepTime;
	}

	/**
	 * 
	 * @param sleepTime tempo em milisegundos que a thread dorme entre os ciclos de envio.
	 */
	public void setSleepTime(long sleepTime) {
		this.sleepTime = sleepTime;
	}
}
