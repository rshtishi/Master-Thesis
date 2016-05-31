package syntax_tree.logic;

import symbol_table.LookupTable;
import symbol_table.Symbol;
import syntax_tree.math.*;

public class ForEval extends LogicExp
{
	String id;
	MathExp limit;
	LookupTable symbolTable=null;
	String step;
	
	public ForEval(String id,MathExp limit,LookupTable symbolTable,String step)
	{
		this.id=id;
		this.limit=limit;
		this.symbolTable=symbolTable;
		this.step=step;
	}

	@Override
	public boolean eval() 
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
	 	
	 	int lim=limit.eval();
	 	int v=Integer.parseInt(val);

	 	
	 	boolean flag=false;
	 	
	 	if(type.equals("Number"))
	 	{
	 		flag=(v<=lim);
	 	}
	 	else
	 	{
	 		flag=false;
	 	}
	 	
		return flag;
		
	}// end eval
	
	

}//end ForEval
