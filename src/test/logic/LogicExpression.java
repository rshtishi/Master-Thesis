package test.logic;

import static org.junit.Assert.assertEquals;

import java.io.StringReader;

import org.junit.Before;
import org.junit.Test;

import compiler.ParseException;
import compiler.Rando;
import syntax_tree.logic.LogicExp;

public class LogicExpression
{
	Rando parser;
	
	@Before
	public void setUp() throws Exception {
		StringReader reader = new StringReader("a>a ose true ");
		parser=new Rando(reader);
	}
	

	@Test
	public void testMathExp() throws ParseException
	{
		LogicExp e=parser.logicExp();
		assertEquals(true,e.eval());
	}
}
