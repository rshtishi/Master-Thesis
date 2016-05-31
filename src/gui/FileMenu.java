package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.*;

public class FileMenu extends JMenu
{
    private JMenu fileMenu;
    private JTextArea viewFile;
    private File file = null;
    
    public static int ext=0;
    
    public FileMenu(JTextArea viewFile)
    {
    	this.viewFile=viewFile;
        fileMenu=new JMenu("File");
        fileMenu.add(getFileMenuItem("New"));
        fileMenu.add(getFileMenuItem("Open"));
        fileMenu.add(getFileMenuItem("Save"));
        fileMenu.add(getFileMenuItem("Exit"));   
    }
    
    private JMenuItem getFileMenuItem(final String name)
    {
        JMenuItem fileMenuItem=new JMenuItem(name);
        fileMenuItem.addActionListener(
                                     new ActionListener()
                                     {
                                         public void actionPerformed(ActionEvent event)
                                         {
                                             switch(name)
                                             {
                                             	case "New":
                                             		newMenuAction();
                                             		break;
                                             	case "Open":
													try 
													{
														openMenuAction();
													} 
													catch (IOException e) 
													{
														e.printStackTrace();
													}
                                             		break;
                                             	case "Save":
                                             		saveMenuAction();
                                             		break;
                                             	case "Exit":
                                             		exitMenuAction();
                                             		break;
                                             }
                                         }
                                     }
        );
        
        return fileMenuItem;
    }
	
	public JMenu getMenu()
	{
	    return fileMenu;
	}//end getMenu
	
	public void newMenuAction()
	{
		ext++;
		String fileName="Untitled_"+ext+".txt";
		String userHomeFolder = System.getProperty("user.home");
		file= new File(System.getProperty("user.home")+"\\"+fileName);
		
		  PrintWriter pw = null;

		  try {
		     FileWriter fw = new FileWriter(file, false);
		     pw = new PrintWriter(fw);
		     pw.println("");
		  } catch (IOException e) {
		     e.printStackTrace();
		  } finally {
		     if (pw != null) {
		        pw.close();
		     }
		  }
		
		JOptionPane.showMessageDialog(null,System.getProperty("user.home")+"\\"+fileName+" was succesfully created.");
		
	}//end newMenuAction
	
	public void openMenuAction() throws IOException
	{
		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showOpenDialog(null); //replace null with your swing container
		
		if(returnVal == JFileChooser.APPROVE_OPTION)  
		{
		  file = chooser.getSelectedFile();    
		}
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line = in.readLine();
		viewFile.setText("");
		while(line != null)
		{
		  viewFile.append(line + "\n");
		  line = in.readLine();
		}
	}//end openMenuAction
	
	public void saveMenuAction()
	{
		  PrintWriter pw = null;

		  try {
		     FileWriter fw = new FileWriter(file, false);
		     pw = new PrintWriter(fw);
		     pw.println(viewFile.getText());
		  } catch (IOException e) {
		     e.printStackTrace();
		  } finally {
		     if (pw != null) {
		        pw.close();
		     }
		  }
		  
		  JOptionPane.showMessageDialog(null,"File saved succcessfully!!!");
	}//end saveMenuAction
	
	private void exitMenuAction()
	{
		System.exit(0);
	}


}
