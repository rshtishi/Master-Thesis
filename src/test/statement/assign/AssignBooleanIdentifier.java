package test.statement.assign;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringReader;

import org.junit.Before;
import org.junit.Test;

import compiler.ParseException;
import compiler.Rando;

public class AssignBooleanIdentifier 
{
	Rando parser;
	
	@Before
	public void setUp() throws Exception {
		StringReader reader = new StringReader("Fillim c=[true] d=$c Shkruaj [$d]  Fund");
		parser=new Rando(reader);
	}
	

	@Test
	public void test() throws ParseException
	{
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        parser.Start();
        assertEquals("true", outContent.toString());
		
	}
}
