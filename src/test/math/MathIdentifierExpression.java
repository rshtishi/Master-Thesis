package test.math;

import static org.junit.Assert.*;

import java.io.StringReader;

import org.junit.Before;
import org.junit.Test;

import compiler.ParseException;
import compiler.Rando;
import syntax_tree.math.MathExp;

public class MathIdentifierExpression {

	Rando parser;
	
	@Before
	public void setUp() throws Exception {
		StringReader reader = new StringReader("(a+1)*2");
		parser=new Rando(reader);
	}
	

	@Test
	public void test() throws ParseException
	{
		MathExp e=parser.mathExp();
		assertEquals(2,e.eval());
	}

}
