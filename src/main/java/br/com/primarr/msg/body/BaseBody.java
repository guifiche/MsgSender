package br.com.primarr.msg.body;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import br.com.primarr.msg.utils.Is;

public class BaseBody implements MessageBody, ParameterizedContent {

		
	/**
	 * 
	 */
	private static final long serialVersionUID = -8821400934750383528L;

	public BaseBody() {
		
	}
	
	public BaseBody(Map<String, Object> parameters) {
		super();
		this.parameters = parameters;
	}
	
	protected Map<String, Object> parameters = null;
	
	public boolean hasParameters()
	{
		return !Is.empty(parameters);
	}

	public Map<String, Object> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, Object> parameters) {
		this.parameters = parameters;
	}
	
	public void insertParameter(String key, Object value)
	{
		if(this.parameters == null)	
			this.parameters = new HashMap<String, Object>();
		
		this.parameters.put(key, value);
	}
	
	public void removeParameter(String key){
		if(this.parameters != null)
			this.parameters.remove(key);
	}
}
