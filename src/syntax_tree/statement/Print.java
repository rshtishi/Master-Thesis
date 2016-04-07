package syntax_tree.statement;

import syntax_tree.math.*;
import syntax_tree.logic.*;

public class Print extends Statement
{
	private Object value;
	
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
			value=(String) value;
			value=((String) value).replace("'", "");
			System.out.print(value);
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
