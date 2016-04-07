package syntax_tree.logic;

public class NotExp 
{
	LogicExp l1;
	
	public NotExp(LogicExp l1)
	{
		this.l1=l1;
	}

	public boolean eval() 
	{
		return !l1.eval();
	}
}
