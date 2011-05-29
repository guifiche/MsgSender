package br.com.primarr.msg;

import java.io.Serializable;

public class MessagePriority implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2324626404855631106L;
	private int m_Priority;
	private MessagePriority(int p_Priority)
	{
		m_Priority = p_Priority;
	}
	public int getPriority()
	{
		return m_Priority;
	}

	public static MessagePriority VERY_LOW = new MessagePriority(0);
	public static MessagePriority LOW = new MessagePriority(25);
	public static MessagePriority NORMAL = new MessagePriority(50);
	public static MessagePriority HIGH = new MessagePriority(75);
	public static MessagePriority VERY_HIGH = new MessagePriority(100);
}
