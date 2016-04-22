package test.statement.print;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringReader;

import org.junit.Before;
import org.junit.Test;

import compiler.ParseException;
import compiler.Rando;

public class PrintBooleanExp {

	Rando parser;
		
	@Before
	public void setUp() throws Exception {
		StringReader reader = new StringReader("Shkruaj [($a==1==1) ose (a==a)]");
		parser=new Rando(reader);
	}
	

	@Test
	public void test() throws ParseException
	{
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        parser.print();
        assertEquals("true", outContent.toString());
		
	}

}
