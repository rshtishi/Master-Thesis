package syntax_tree.statement;

import java.util.*;
import symbol_table.*;
import syntax_tree.math.*;
import syntax_tree.logic.*;

public class Else  extends Statement
{
	int position=0;
	LogicExp cond;
	ArrayList<LogicExp> condArray=null;
	ArrayList<Statement> stmtArray;
	
	public Else( ArrayList<Statement> stmtArray, ArrayList<LogicExp> condArray)
	{
		this.stmtArray=stmtArray;
		this.condArray=condArray;
	}

	@Override
	public void eval() 
	{
		
		if(condArray!=null)
		{
			boolean flag=true;
			ListIterator<LogicExp > condIterator=condArray.listIterator();
			while(condIterator.hasNext())
			{				
 				boolean val=condIterator.next().eval();
				
				if(val==true)
				{
					flag=false;
					break;
				}
			}//end while
			
			if(flag==true)
			{
				
				ListIterator< Statement> iterator=stmtArray.listIterator();
				while(iterator.hasNext())
				{
					iterator.next().eval();
				}
					
			
			}//end if flag
			
		}
		
		
	}//end eval
	
	
	

}
