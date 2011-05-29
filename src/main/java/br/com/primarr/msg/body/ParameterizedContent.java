package br.com.primarr.msg.body;

import java.util.Map;

public interface ParameterizedContent {
	
	public boolean hasParameters();
	
	public Map<String, Object> getParameters();
	
	public void setParameters(Map<String, Object> parameters);
	
	public void insertParameter(String key, Object value);
	
	public void removeParameter(String key);

}
