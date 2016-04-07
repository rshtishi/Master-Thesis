package syntax_tree.logic;

public class InEqualExp extends LogicExp
{
	private LogicExp l1;
	private LogicExp l2;
	
	public InEqualExp(LogicExp l1,LogicExp l2)
	{
		this.l1=l1;
		this.l2=l2;
	}

	@Override
	public boolean eval() 
	{
		return false;
	}
	
}
