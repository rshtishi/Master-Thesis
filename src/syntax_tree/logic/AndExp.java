package syntax_tree.logic;

import interpreter.Visitor;

public class AndExp extends LogicExp
{
	LogicExp e1;
	LogicExp e2;
	
	public AndExp(LogicExp e1,LogicExp e2)
	{
		this.e1=e1;
		this.e2=e2;
	}

	public boolean eval() 
	{
		return e1.eval() && e2.eval();
	}



}
