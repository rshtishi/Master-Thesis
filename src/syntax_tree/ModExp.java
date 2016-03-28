package syntax_tree;
import interpreter.*;

public class ModExp extends Exp
{
	private Exp e1;
	private Exp e2;
	
	public ModExp(Exp e1,Exp e2)
	{
		this.e1=e1;
		this.e2=e2;
	}

	public Exp getE1() 
	{
		return e1;
	}

	public void setE1(Exp e1) 
	{
		this.e1 = e1;
	}

	public Exp getE2() 
	{
		return e2;
	}

	public void setE2(Exp e2) 
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
