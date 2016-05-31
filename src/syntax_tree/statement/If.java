package syntax_tree.statement;

import java.util.*;
import symbol_table.*;
import syntax_tree.math.*;
import syntax_tree.logic.*;

public class If  extends Statement
{
	int position=0;
	LogicExp cond;
	ArrayList<LogicExp> condArray=null;
	ArrayList<Statement> stmtArray;
	
	
	public If(LogicExp cond, ArrayList<Statement> stmtArray)
	{
		this.cond=cond;
		this.stmtArray=stmtArray;
	}
	
	public If(LogicExp cond, ArrayList<Statement> stmtArray, ArrayList<LogicExp> condArray, int position )
	{
		this.cond=cond;
		this.stmtArray=stmtArray;
		this.condArray=condArray;
		this.position=position;
	}

	@Override
	public void eval() 
	{
		if(condArray==null)
		{
			if(cond.eval()==true)
			{
				ListIterator< Statement> iterator=stmtArray.listIterator();
				while(iterator.hasNext())
				{
					iterator.next().eval();
				}
				
			}//end if
		}
		else
		{
			boolean flag=true;
			List<LogicExp> partCondArray=condArray.subList(0, position);
			ListIterator<LogicExp > partCondIterator=partCondArray.listIterator();
			while(partCondIterator.hasNext())
			{				
 				boolean val=partCondIterator.next().eval();
				
				if(val==true)
				{
					flag=false;
					//break;
				}
			}//end while
			
			
			
			
			if(flag==true)
			{
				if(cond.eval()==true)
				{
					ListIterator< Statement> iterator=stmtArray.listIterator();
					while(iterator.hasNext())
					{
						iterator.next().eval();
					}
					
				}//end if
			}//end if flag
			
 
		}//end else
		
	}// end eval 

}
