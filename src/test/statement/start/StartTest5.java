package test.statement.start;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringReader;

import org.junit.Before;
import org.junit.Test;

import compiler.ParseException;
import compiler.Rando;

public class StartTest5 {
	
	Rando parser;
	
	@Before
	public void setUp() throws Exception {
		StringReader reader = new StringReader("Fillim Lexo a Nqs(a==1) Atehere Per i=1 Deri 3 Hapi 1 Bej Shkruaj 1 "
				+ "PerndrysheNqs (a==2) Atehere Fillim i=1 Gjersa(i<=3) Bej Fillim  Shkruaj 1 i=i+1 Fund Fund "
				+ "PerndrysheNqs (a==3) Atehere Fillim i=1 Bej Fillim Shkruaj 1 i=i+1 Fund Gjersa(i<=3) Fund"
				+ " Perndryshe Shkruaj 111  Fund");
		parser=new Rando(reader);
	}
	

	@Test
	public void test() throws ParseException
	{
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        parser.Start();
        System.setIn(System.in);
        assertEquals("111", outContent.toString().trim());
	}

}
