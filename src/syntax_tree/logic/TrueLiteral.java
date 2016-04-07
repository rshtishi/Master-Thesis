package syntax_tree.logic;

public class TrueLiteral extends LogicExp
{

	@Override
	public boolean eval() 
	{
		return true;
	}

}
