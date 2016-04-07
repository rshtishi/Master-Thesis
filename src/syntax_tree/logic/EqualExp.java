package syntax_tree.logic;

public class EqualExp extends LogicExp
{
	private LogicExp l1;
	private LogicExp l2;
	
	public EqualExp(LogicExp l1,LogicExp l2)
	{
		this.l1=l1;
		this.l2=l2;
	}

	@Override
	public boolean eval() 
	{
		return l1.eval()==l2.eval();
	}
	

}
