package syntax_tree;
import interpreter.*;

public class NegativeExp extends MathExp
{
	private MathExp e1;
	
	public NegativeExp (MathExp e1)
	{
		this.e1=e1;
	}

	public MathExp getE1() 
	{
		return e1;
	}

	public void setE1(MathExp e1) 
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
