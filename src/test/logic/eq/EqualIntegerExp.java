package test.logic.eq;

import static org.junit.Assert.assertEquals;

import java.io.StringReader;

import org.junit.Before;
import org.junit.Test;

import compiler.ParseException;
import compiler.Rando;
import syntax_tree.logic.LogicExp;

public class EqualIntegerExp 
{
	Rando parser;
	
	@Before
	public void setUp() throws Exception {
		StringReader reader = new StringReader("1==1");
		parser=new Rando(reader);
	}
	

	@Test
	public void test() throws ParseException
	{
		LogicExp e=parser.relation();
		assertEquals(true,e.eval());
	}
}
