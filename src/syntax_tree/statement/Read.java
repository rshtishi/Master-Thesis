package syntax_tree.statement;
import java.util.Scanner;

import javax.swing.JOptionPane;

import symbol_table.*;

public class Read extends Statement
{
	
	private String id;
	private LookupTable symbolTable;
	private Scanner jin;
	
	//Metoda qe do te kontrolloje per 
	public static boolean isNumeric(String str)
	{
	  return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
	}
	
	public Read(String id,Scanner jin,LookupTable symbolTable)
	{
		this.id=id;
		this.symbolTable=symbolTable;
		this.jin=jin;
	}

	public void eval() 
	{
		  //String value=jin.next();
		  String value=JOptionPane.showInputDialog(null,"Ndryshorja "+id);
		  String type;
		  if(value.equals("true") || value.equals("false") )
		  {
			  type="Boolean";
		  }
		  else if(isNumeric(value))
		  {
		    type="Number";
		  }
		  else
		  {
		    type="String";
		  }
		  
		  symbolTable.put(id,new Symbol(value,type)); 
	}
	
}
