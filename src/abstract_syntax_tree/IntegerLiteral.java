package abstract_syntax_tree;

public class IntegerLiteral  extends Exp
{
	private String s;
	
	public IntegerLiteral(String s)
	{
		this.s=s;
	}
	
	public int eval()
	{
		return Integer.parseInt(s);
	}
}
