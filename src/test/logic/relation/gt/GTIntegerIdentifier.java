package test.logic.relation.gt;

import static org.junit.Assert.*;

import java.io.StringReader;

import org.junit.Before;
import org.junit.Test;

import compiler.ParseException;
import compiler.Rando;
import syntax_tree.logic.LogicExp;

public class GTIntegerIdentifier {

	Rando parser;
	
	@Before
	public void setUp() throws Exception {
		StringReader reader = new StringReader("1>a");
		parser=new Rando(reader);
	}
	

	@Test
	public void test() throws ParseException
	{
		LogicExp e=parser.relation();
		assertEquals(true,e.eval());
	}

}
