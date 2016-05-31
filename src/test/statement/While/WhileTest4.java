package test.statement.While;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringReader;

import org.junit.Before;
import org.junit.Test;

import compiler.ParseException;
import compiler.Rando;

public class WhileTest4 
{

	Rando parser;
	
	@Before
	public void setUp() throws Exception 
	{
		StringReader reader = new StringReader("Fillim a=0  Gjersa (a<2) Bej Fillim  b=0 Gjersa(b<2) Bej Fillim Shkruaj b b=b+1 Fund  a=a+1 Fund Fund");
		parser=new Rando(reader);
	}
	

	@Test
	public void test() throws ParseException
	{
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        parser.Start();
        assertEquals("0101", outContent.toString());
	}
	

}
