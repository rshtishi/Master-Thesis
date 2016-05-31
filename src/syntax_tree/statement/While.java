package syntax_tree.statement;

import java.util.*;
import syntax_tree.logic.LogicExp;

public class While extends Statement
{
	private LogicExp cond;
	private ArrayList<Statement> stmtArray;
	
	public While(LogicExp cond,ArrayList<Statement> stmtArray)
	{
		this.cond=cond;
		this.stmtArray=stmtArray;
	}

	@Override
	public void eval() 
	{
		while(cond.eval())
		{
			ListIterator< Statement> iterator=stmtArray.listIterator();
			while(iterator.hasNext())
			{
				iterator.next().eval();
			}
		}
	}
	
	
}
