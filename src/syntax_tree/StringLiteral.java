package syntax_tree;
import interpreter.*;

public class StringLiteral extends MathExp 
{
	private String string;
	
	public StringLiteral(String string)
	{
		this.string=string;
	}

	@Override
	public int eval() 
	{

		return 0;
	}

	@Override
	public int accept(Visitor v) 
	{
		return v.visit(this);
	}
	


}
