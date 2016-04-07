package interpreter;
import symbol_table.*;
import syntax_tree.math.*;


public class Interpreter implements Visitor
{

	@Override
	public int visit(PlusExp e) 
	{
		return e.getE1().accept(this)+e.getE2().accept(this);
	}

	@Override
	public int visit(MinusExp e) 
	{
		return e.getE1().accept(this)-e.getE2().accept(this);
	}

	@Override
	public int visit(MulExp e) 
	{
		return e.getE1().accept(this)*e.getE2().accept(this);
	}

	@Override
	public int visit(DivExp e) 
	{
		return e.getE1().accept(this)/e.getE2().accept(this);
	}

	@Override
	public int visit(PositiveExp e) 
	{
		return e.getE1().accept(this);
	}

	@Override
	public int visit(ModExp e) 
	{
		return e.getE1().accept(this)%e.getE2().accept(this);
	}

	@Override
	public int visit(NegativeExp e) 
	{
		return -e.getE1().accept(this);
	}

	@Override
	public int visit(IdentifierMath e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int visit(IntegerLiteral e) 
	{
		return Integer.parseInt(e.getString());
	}


	
}
