package test.logic;

import static org.junit.Assert.*;

import java.io.StringReader;

import org.junit.Before;
import org.junit.Test;

import compiler.ParseException;
import compiler.Rando;
import syntax_tree.logic.LogicExp;

public class LogicIdentifierExpression {

	Rando parser;
	
	@Before
	public void setUp() throws Exception {
		StringReader reader = new StringReader("1==1 dhe  ('a'>'b' ose 2<4) dhe a>-1 ose a>=b dhe false=$e");
		parser=new Rando(reader);
	}
	

	@Test
	public void test() throws ParseException
	{
		LogicExp e=parser.logicExp();
		assertEquals(true,e.eval());
	}

}
