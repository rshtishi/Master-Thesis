package syntax_tree;
import interpreter.*;

public class ModExp extends MathExp
{
	private MathExp e1;
	private MathExp e2;
	
	public ModExp(MathExp e1,MathExp e2)
	{
		this.e1=e1;
		this.e2=e2;
	}

	public MathExp getE1() 
	{
		return e1;
	}

	public void setE1(MathExp e1) 
	{
		this.e1 = e1;
	}

	public MathExp getE2() 
	{
		return e2;
	}

	public void setE2(MathExp e2) 
	{
		this.e2 = e2;
	}
	
	public int eval()
	{
		return e1.eval()%e2.eval();
	}


	@Override
	public int accept(Visitor v) 
	{
		return v.visit(this);
	}
	
	
}
