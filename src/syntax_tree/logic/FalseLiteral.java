package syntax_tree.logic;

public class FalseLiteral  extends LogicExp
{

	@Override
	public boolean eval() 
	{
		return false;
	}

}
