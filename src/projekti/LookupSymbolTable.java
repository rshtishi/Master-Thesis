package projekti;

import java.util.HashMap;
import java.util.Map;

public class LookupSymbolTable implements LookupTable
{
      private Map<String,Symbol> varList;
      
      public LookupSymbolTable()
      {
    	  varList=new HashMap<String,Symbol>();
      }

	public void put(String id, Symbol s) 
	{	
		varList.put(id, s);
	}

	public String getValue(String id) 
	{
		Symbol s =varList.get(id);
		return s.getValue();
	}


	public String getType(String id) 
	{
		Symbol s=varList.get(id);
		return s.getType();
	}

	
	public boolean containsKey(String id) 
	{
		return varList.containsKey(id) ;
	}
      
      
      

}
