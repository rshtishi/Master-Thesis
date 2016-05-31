package syntax_tree.statement;

import java.util.ArrayList;
import java.util.ListIterator;

public class Start extends Statement
{
    ArrayList<Statement> statementArray=null;
    
    public Start(ArrayList<Statement> statementArray)
    {
    	this.statementArray=statementArray;
    }

	@Override
	public void eval() 
	{
		ListIterator< Statement> iterator=statementArray.listIterator();
		while(iterator.hasNext())
			iterator.next().eval();
	}
}
