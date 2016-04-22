package syntax_tree.statement;

import symbol_table.*;
import syntax_tree.math.*;
import syntax_tree.logic.*;

public class Assign extends Statement
{
	private String id;
	private Object val;
	private String type;
	private LookupTable symbolTable;
	
	public Assign(String id, Object val,LookupTable symbolTable)
	{
		this.id=id;
		this.val=val;
		this.symbolTable=symbolTable;
	}
	
	public Assign(String id, Object val,String type,LookupTable symbolTable)
	{
		this.id=id;
		this.val=val;
		this.symbolTable=symbolTable;
		this.type=type;
	}

	@Override
	public void eval() 
	{
		if(val instanceof String)
		{
			String value=(String) val;
			String typ="String";
		
			if(type.equals("Identifier"))
			{
				String idValue;
				String idType;
				if(symbolTable.containsKey(value))
				{
					idType=symbolTable.getType(value);
					idValue=symbolTable.getValue(value);
				}
				else
				{
					idValue="0";
					idType="Number";
				}
				//System.out.println(idValue);
				//System.out.println(idType);
				symbolTable.put(id, new Symbol(idValue,idType));
			}
			else if(type.equals("String"))
			{
				value=value.replace("'", "");
				//System.out.println(value);
				//System.out.println(typ);
				symbolTable.put(id, new Symbol(value,typ));
			}
			
		}
		else if(val instanceof MathExp)
		{
			MathExp value=(MathExp) val;
			String v=""+value.eval();
			String typ="Number";
			//System.out.println(v);
			//System.out.println(typ);
			symbolTable.put(id, new Symbol(v,typ));
		}
		else if(val instanceof LogicExp)
		{
			LogicExp value=(LogicExp) val;
			String v=""+value.eval();
			String typ="Boolean";
			//System.out.println(value.eval());
			symbolTable.put(id, new Symbol(v,typ));
		}
	}

}
