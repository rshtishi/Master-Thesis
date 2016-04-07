package syntax_tree.logic;

public class JustExp  extends LogicExp
{
	private LogicExp l1;
	
	public JustExp(LogicExp L1)
	{
		this.l1=l1;
	}

	@Override
	public boolean eval() 
	{
		return l1.eval();
	}
	
	
}
