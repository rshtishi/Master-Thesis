package syntax_tree;
import  interpreter.*;

public abstract  class Exp 
{
	public abstract int eval();
	
	public abstract int accept(Visitor v);
}
