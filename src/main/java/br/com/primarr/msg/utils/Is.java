package br.com.primarr.msg.utils;

import java.util.Collection;

/**
 * @author Guilherme Fiche
 *
 */
public class Is
{
    
    public static boolean empty(String str)
    {
        if(str != null)
        {   
        	return "".equals(str.trim());
        }
        else return true;
    }
    
    public static boolean empty(Object obj)
    {
        if(obj != null)
        {            
            return false;            
        }
        else return true;
    }
    
    public static boolean empty(Collection collection)
    {
        if(collection == null)
        {            
            return true;            
        }
        else if(collection.isEmpty())
        {
            return true;
        }
        else return false;
            
    } 
}
