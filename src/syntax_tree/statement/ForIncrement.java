package syntax_tree.statement;

import symbol_table.LookupTable;
import symbol_table.Symbol;

public class ForIncrement extends Statement
{
	String step=null;
	LookupTable symbolTable=null;
	String id=null;
	
	public ForIncrement(String id, LookupTable symbolTable,String step)
	{
		this.id=id;
		this.symbolTable=symbolTable;
		this.step=step;
	}
	@Override
	public void eval() 
	{
		String type, val;
		int stepNum=Integer.parseInt(step);
		
	 	if(symbolTable.containsKey(id))
		{
       		 type=symbolTable.getType(id);
			 val=symbolTable.getValue(id);
		}
       	else
       	{
       		type="Number";
       		val="0";
       	}
	 	
	 	int v=Integer.parseInt(val);
	 	symbolTable.put(id, new Symbol(""+(v+stepNum),type));
	 	
		
	}

}
