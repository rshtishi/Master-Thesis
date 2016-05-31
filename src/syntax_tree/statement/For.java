package syntax_tree.statement;

import java.util.ArrayList;
import java.util.ListIterator;

import symbol_table.LookupTable;
import symbol_table.Symbol;
import syntax_tree.logic.LogicExp;
import syntax_tree.math.MathExp;

public class For extends Statement
{
	Statement assignStmt=null;
	Statement incrementStmt=null;
	LogicExp forEval=null;
	ArrayList<Statement> statementArray=null;

	
	
	public For(Statement assignStmt,LogicExp forEval,ArrayList<Statement> statementArray,Statement incrementStmt)
	{
		this.assignStmt=assignStmt;
		this.forEval=forEval;
		this.statementArray=statementArray;
		this.incrementStmt=incrementStmt;
	}


	@Override
	public void eval() 
	{
		assignStmt.eval();
		while(forEval.eval())
		{
			ListIterator< Statement> iterator=statementArray.listIterator();
			while(iterator.hasNext())
			{
				iterator.next().eval();
				
			}
			incrementStmt.eval();
		}
		
	}//end eval
	


}//end For
