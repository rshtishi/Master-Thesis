package syntax_tree.statement;

import syntax_tree.math.*;
import symbol_table.*;
import syntax_tree.logic.*;

public class Print extends Statement
{
	private Object value;
	private String type;
	private LookupTable symbolTable;
	
	public Print(String value,String type,LookupTable symbolTable)
	{
		this.value=value;
		this.type=type;
		this.symbolTable=symbolTable;
	}
	
	public Print(String value)
	{
		this.value=value;
	}
	
	public Print(MathExp value)
	{
		this.value=value;
	}
	
	public Print(LogicExp value)
	{
		this.value=value;
	}


	public void eval() 
	{
		if(value instanceof String)
		{
			String val=(String) value;
			if(type=="Identifier")
			{
				if(symbolTable.containsKey(val))
				{
					if(symbolTable.getType(val).equals("String"))
						System.out.print(symbolTable.getValue(val).replace("'", ""));
					else
						System.out.print(symbolTable.getValue(val));
				}
				else
				{
					System.out.print("null");
				}
			}
			else
			{
				value=(String) value;
				value=((String) value).replace("'", "");
				System.out.print(value);
			}
		}
		else if(value instanceof MathExp)
		{
			value=(MathExp) value;
			System.out.print(((MathExp) value).eval());
		}
		else if(value instanceof LogicExp)
		{
			value=(LogicExp) value;
			System.out.print(((LogicExp) value).eval());
		}
	}

}
