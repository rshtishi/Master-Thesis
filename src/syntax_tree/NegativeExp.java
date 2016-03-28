package syntax_tree;
import interpreter.*;

public class NegativeExp extends Exp
{
	private Exp e1;
	
	public NegativeExp (Exp e1)
	{
		this.e1=e1;
	}

	public Exp getE1() 
	{
		return e1;
	}

	public void setE1(Exp e1) 
	{
		this.e1 = e1;
	}
	
	public int eval()
	{
		return -e1.eval();
	}

	@Override
	public int accept(Visitor v) 
	{
		return  v.visit(this);
	}


	
	
}
