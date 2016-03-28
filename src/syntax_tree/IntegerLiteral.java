package syntax_tree;
import interpreter.*;

public class IntegerLiteral extends Exp
{
	private String string;
	
	public IntegerLiteral(String string)
	{
		this.string=string;
	}

	public String getString() 
	{
		return string;
	}

	public void setString(String string) 
	{
		this.string = string;
	}
	
	public int eval()
	{
		return Integer.parseInt(string);
	}

	public int accept(Visitor v)
	{
		return v.visit(this);
	}
	
	
	
}
