package syntax_tree;

public class NotExp 
{
	LogicExp e1;
	
	public NotExp(LogicExp e1,LogicExp e2)
	{
		this.e1=e1;
	}

	public boolean eval() 
	{
		return !e1.eval();
	}
}