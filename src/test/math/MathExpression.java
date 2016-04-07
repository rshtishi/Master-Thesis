package test.math;

import static org.junit.Assert.*;

import java.io.Reader;
import java.io.StringReader;

import org.junit.Before;
import org.junit.Test;

import compiler.*;
import syntax_tree.math.*;

public class MathExpression {
	
	Rando parser;
	
	@Before
	public void setUp() throws Exception {
		StringReader reader = new StringReader("(1+1)*2+6/(2+1)");
		parser=new Rando(reader);
	}
	

	@Test
	public void test() throws ParseException
	{
		MathExp e=parser.mathExp();
		assertEquals(6,e.eval());
	}



}
