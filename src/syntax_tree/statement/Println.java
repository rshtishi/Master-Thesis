package syntax_tree.statement;

import syntax_tree.math.*;
import syntax_tree.logic.*;

public class Println extends Statement
{
	private Object value;
	
	public Println(String value)
	{
		this.value=value;
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
			value=(String) value;
			value=((String) value).replace("'", "");
			System.out.println(value);
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
