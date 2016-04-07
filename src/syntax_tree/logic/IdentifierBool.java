package syntax_tree.logic;
import symbol_table.*;

public class IdentifierBool extends LogicExp
{
	private String string;
	private LookupTable symbolTable;
	
	public IdentifierBool(String string , LookupTable symbolTable)
	{
		this.string=string;
		this.symbolTable=symbolTable;
		
	}
	
	@Override
	public boolean eval() 
	{
		
       	if(symbolTable.containsKey(string))
		{
		      String val=symbolTable.getValue(string);
		      if(val.equals("true"))
		      {
		    	  return true;
		      }
		      else
		      {
		    	  return false; 
		      }
		    	  
		}
       	else
       	{
       		return false;
       	}
	}

}
