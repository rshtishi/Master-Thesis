package abstract_syntax_tree;
import symbol_table.*;

public class Identifier  extends Exp
{
	private String s;
	private LookupTable table;
	
	public Identifier(String s,LookupTable table)
	{
		this.s=s;
		this.table=table;
	}
	
	public int eval()
	{
       	if(table.containsKey(s))
		{
		      String val=table.getValue(s);
		      return Integer.parseInt(val);
		}
		else
		{
		      return 0;
		}
		
	}
}
