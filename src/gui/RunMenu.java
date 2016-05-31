package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.PipedInputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringReader;

import javax.swing.*;

import compiler.ParseException;
import compiler.Rando;

public class RunMenu extends JMenu
{
    private JMenu runMenu;
    private Rando parser;
    private JTextArea viewFile;
    private JTextArea viewResult;
    
    private final PipedInputStream inPipe = new PipedInputStream();
    private final PipedInputStream outPipe = new PipedInputStream();
    
    PrintWriter inWriter;


    
    public RunMenu(JTextArea viewFile, JTextArea viewResult)
    {
    	this.viewFile=viewFile;
    	this.viewResult=viewResult;
        runMenu=new JMenu("Run");
        runMenu.add(getRunMenuItem("Run")); 
        runMenu.add(getRunMenuItem("Clear"));
    }
    
    private JMenuItem getRunMenuItem(final String name)
    {
        JMenuItem runMenuItem=new JMenuItem(name);
        runMenuItem.addActionListener(
                                     new ActionListener()
                                     {
                                         public void actionPerformed(ActionEvent event)
                                         {
                                             switch(name)
                                             {
                                             	case "Run":
                                             		runMenuAction();
                                             		break;
                                             	case "Clear":
                                             		clearMenuAction();
                                             		break;
                                             }
                                         }
                                     }
        );
        
        return runMenuItem;
    }
	
	public JMenu getMenu()
	{
	    return runMenu;
	}//end getMenu
	
	public void clearMenuAction()
	{
		viewResult.setText("");
	}
	
	public void setViewResult(JTextArea viewResult)
	{
		this.viewResult=viewResult;
	}
	
	public void runMenuAction() 
	{
		StringReader reader = new StringReader(viewFile.getText());
		//parser = new Rando(reader);
		
		
	int x=0;
  
     try
     {
 
        
    	 if( parser == null )
    		 parser = new Rando(reader);
    	 else
    		 Rando.ReInit( reader);
    	 
    	 Rando.Start();
    	 System.out.println();
    	 Rando.ReInit( reader); 
    
     }
     catch (Exception e)
     {
       System.out.println("Error.");
       System.out.println(e.getMessage());
       Rando.ReInit( reader);     
     }
 
		

	}//end runMenuAction
	
	

}
