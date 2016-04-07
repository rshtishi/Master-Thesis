package interpreter;
import syntax_tree.math.*;

public interface Visitor 
{
	public int visit(PlusExp e);
	
	public int visit(MinusExp e);
	
	public int visit(MulExp e);
	
	public int visit(DivExp e);
	
	public int visit(PositiveExp e);
	
	public int visit(ModExp e);
	
	public int visit(NegativeExp e);
	
	public int visit(IdentifierMath e);
	
	public int visit(IntegerLiteral e);
	
}
