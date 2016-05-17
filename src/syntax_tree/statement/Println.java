package syntax_tree.statement;

import syntax_tree.math.*;
import symbol_table.*;
import syntax_tree.logic.*;

public class Println extends Statement
{
	private Object value;
	private String type;
	private LookupTable symbolTable;
	
	public Println(String value)
	{
		this.value=value;
	}
	
	public Println(String value,String type,LookupTable symbolTable)
	{
		this.value=value;
		this.type=type;
		this.symbolTable=symbolTable;
	}
	
	public Println(MathExp value)
	{
		this.value=value;
	}
	
	public Println(LogicExp value)
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
			System.out.println();
		}
		else if(value instanceof MathExp)
		{
			value=(MathExp) value;
			System.out.println(((MathExp) value).eval());
		}
		else if(value instanceof LogicExp)
		{
			value=(LogicExp) value;
			System.out.println(((LogicExp) value).eval());
		}
	}

}
