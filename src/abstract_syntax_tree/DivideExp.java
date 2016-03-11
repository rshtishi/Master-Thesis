package abstract_syntax_tree;

public class DivideExp extends Exp
{
	private Exp e1,e2;
	
	public DivideExp(Exp e1,Exp e2)
	{
		this.e1=e1;
		this.e2=e2;
	}
	
	public int eval()
	{
		return e1.eval()/e2.eval();
	}
}
