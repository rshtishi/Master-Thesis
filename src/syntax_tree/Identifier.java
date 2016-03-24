package syntax_tree;

import symbol_table.*;
import interpreter.*;

public class Identifier  extends MathExp
{
	private String string;
	private LookupTable table;
	
	public Identifier(String string,LookupTable table)
	{
		this.string=string;
		this.table=table;
	}

	public String getString() 
	{
		return string;
	}

	public void setString(String string) 
	{
		this.string = string;
	}

	public LookupTable getTable() 
	{
		return table;
	}

	public void setTable(LookupTable table) 
	{
		this.table = table;
	}

	@Override
	public int eval() 
	{
       	if(table.containsKey(string))
		{
		      String val=table.getValue(string);
		      return Integer.parseInt(val);
		}
		else
		{
		      return 0;
		}
	}

	@Override
	public int accept(Visitor v) 
	{
		return v.visit(this);
	}


	
}
