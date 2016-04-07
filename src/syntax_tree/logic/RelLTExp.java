package syntax_tree.logic;

import symbol_table.*;

public class RelLTExp extends LogicExp
{
	private String s1;
	private String s2;
	private String t1;
	private String t2;
	private LookupTable symbolTable;
	
	public RelLTExp(String s1,String t1,String s2,String t2)
	{
		this.s1=s1;
		this.s2=s2;
		this.t1=t1;
		this.t2=t2;
	}
	
	public RelLTExp(String s1,String t1,String s2,String t2,LookupTable symbolTable)
	{
		this.s1=s1;
		this.s2=s2;
		this.t1=t1;
		this.t2=t2;
		this.symbolTable=symbolTable;
	}

	@Override
	public boolean eval() 
	{
		if(t1=="Number" && t2=="Number")
		{
			return Integer.parseInt(s1)<Integer.parseInt(s2);
		}//end Number Number
		else if(t1=="String" && t2=="String")
		{
			int flag=s1.compareTo(s2);
			if(flag<0)
				return true;
			else
				return false;
		}//end String String
		else if(t1.equals("Identifier") && t2.equals("Identifier"))
		{
			
			String type1,val1,type2,val2;
			
	       	if(symbolTable.containsKey(s1))
			{
	       		 type1=symbolTable.getType(s1);
				 val1=symbolTable.getValue(s1);
			}
	       	else
	       	{
	       		type1="Number";
	       		val1="0";
	       	}
	       	
	       	if(symbolTable.containsKey(s2))
			{
	       		 type2=symbolTable.getType(s2);
				 val2=symbolTable.getValue(s2);
			}
	       	else
	       	{
	       		type2="Number";
	       		val2="0";
	       	}
	       	
	       	if(type1.equals("Number") && type2.equals("Number"))
	       	{
	       		return Integer.parseInt(val1)<Integer.parseInt(val2);
	       	}
	       	else if(type1.equals("String") && type2.equals("String"))
	       	{
				int flag=val1.compareTo(val2);
				if(flag<0)
					return true;
				else
					return false;
	       	}
	       	else
	       	{
	       		return false;
	       	}
		
		}//end Identifier Identifier
		else if(t1.equals("Identifier") && t2.equals("Number"))
		{
			String type1,val1;
			
	       	if(symbolTable.containsKey(s1))
			{
	       		 type1=symbolTable.getType(s1);
				 val1=symbolTable.getValue(s1);
			}
	       	else
	       	{
	       		type1="Number";
	       		val1="0";
	       	}
	       
	       	if(type1.equals("Number"))
	       	{
	       		return Integer.parseInt(val1)<Integer.parseInt(s2);
	       	}
	       	else
	       	{
		       	return false;
	       	}

		}//end Identifier Number
		else if(t1.equals("Number") && t2.equals("Identifier"))
		{
			String type2,val2;
			
	       	if(symbolTable.containsKey(s2))
			{
	       		 type2=symbolTable.getType(s2);
				 val2=symbolTable.getValue(s2);
			}
	       	else
	       	{
	       		type2="Number";
	       		val2="0";
	       	}
	       
	       	if(type2.equals("Number"))
	       	{
	       		return Integer.parseInt(s1)<Integer.parseInt(val2);
	       	}
	       	else
	       	{
		       	return false;
	       	}
		} //end Number Identifier
		else if(t1.equals("Identifier") && t2.equals("String"))
		{
			String type1,val1;
			
	       	if(symbolTable.containsKey(s1))
			{
	       		 type1=symbolTable.getType(s1);
				 val1=symbolTable.getValue(s1);
			}
	       	else
	       	{
	       		type1="Number";
	       		val1="0";
	       	}
	       
	       	if(type1.equals("String"))
	       	{
	       		String val2=s2.replace("'","");
				int flag=val1.compareTo(val2);
				if(flag<0)
					return true;
				else
					return false;
	       	}
	       	else
	       	{
		       	return false;
	       	}
		} //end Identifier String Identifier
		else if(t1.equals("String") && t2.equals("Identifier"))
		{
			String type2,val2;
			
	       	if(symbolTable.containsKey(s2))
			{
	       		 type2=symbolTable.getType(s2);
				 val2=symbolTable.getValue(s2);
			}
	       	else
	       	{
	       		type2="Number";
	       		val2="0";
	       	}
	       
	       	if(type2.equals("String"))
	       	{
	       		String val1=s1.replace("'","");
				int flag=val1.compareTo(val2);
				if(flag<0)
					return true;
				else
					return false;
	       	}
	       	else
	       	{
		       	return false;
	       	}
		}//end String Identitifier
		else
		{
			return false;
		}
		

	}//end eval
	
	
}
