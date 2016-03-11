package abstract_syntax_tree;

public class NegativeExp extends Exp
{
	private Exp e1;
	
	public NegativeExp(Exp e1)
	{
		this.e1=e1;
	}
	
	public int eval()
	{
		return -e1.eval();
	}
}
