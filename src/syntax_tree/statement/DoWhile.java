package syntax_tree.statement;

import java.util.ArrayList;
import java.util.ListIterator;

import syntax_tree.logic.LogicExp;

public class DoWhile extends Statement 
{

	private LogicExp cond;
	private ArrayList<Statement> stmtArray;
	
	public DoWhile(LogicExp cond,ArrayList<Statement> stmtArray)
	{
		this.cond=cond;
		this.stmtArray=stmtArray;
	}
	
	@Override
	public void eval() 
	{
		do
		{
			ListIterator< Statement> iterator=stmtArray.listIterator();
			while(iterator.hasNext())
			{
				iterator.next().eval();
			}
		}
		while(cond.eval());
	}
	
	
	
}
