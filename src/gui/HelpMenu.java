package gui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.awt.*;

public class HelpMenu extends JMenu
{
	private JMenu helpMenu;
	
    public HelpMenu()
    {
        helpMenu=new JMenu("Help");
        helpMenu.add(getHelpMenuItem("Welcome"));
        helpMenu.add(getHelpMenuItem("Help Contents"));
        helpMenu.add(getHelpMenuItem("About Rando Compiler")); 
    }
    
    private JMenuItem getHelpMenuItem(final String name)
    {
        JMenuItem helpMenuItem=new JMenuItem(name);
        helpMenuItem.addActionListener(
                                     new ActionListener()
                                     {
                                         public void actionPerformed(ActionEvent event)
                                         {
                                             switch(name)
                                             {
                                             	case "Welcome":
                                             		  welcomeMenuAction();
                                             		break;
                                             	case "Help Contents":
                                             		  helpContentMenuAction() ;
                                             		break;
                                             	case "About Rando Compiler":
                                             		aboutMenuAction() ;
                                             		break;
                                             }
                                         }
                                     }
        );
        
        return helpMenuItem;
    }
	
	public JMenu getMenu()
	{
	    return helpMenu;
	}
	
	public void welcomeMenuAction() 
	{
		JFrame frame=new JFrame("Welcome");
        frame.setSize(700,500); 
        frame.setLocationRelativeTo(null ); // Center the frame
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        JTextArea textarea=new JTextArea();
        JScrollPane scrollPane=new JScrollPane(textarea);
		BufferedReader in = null;
		URL url = HelpMenu.class.getClassLoader().getResource("welcome");
		String filesPathAndName = url.getPath();
		try {
			in = new BufferedReader(new FileReader(new File(filesPathAndName)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String line = null;
		try {
			line = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		textarea.setText("");
		while(line != null)
		{
		  textarea.append(line + "\n");
		  try {
			line = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
        frame.add(scrollPane);
		
	}//end welcomeMenuAction
	
	public void aboutMenuAction() 
	{
		JFrame frame=new JFrame("About");
        frame.setSize(700,500); 
        frame.setLocationRelativeTo(null ); // Center the frame
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        JTextArea textarea=new JTextArea();
        JScrollPane scrollPane=new JScrollPane(textarea);
		BufferedReader in = null;
		URL url = HelpMenu.class.getClassLoader().getResource("about");
		String filesPathAndName = url.getPath();
		try {
			in = new BufferedReader(new FileReader(new File(filesPathAndName)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String line = null;
		try {
			line = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		textarea.setText("");
		while(line != null)
		{
		  textarea.append(line + "\n");
		  try {
			line = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
        frame.add(scrollPane);
		
	}//end helpContentsMenuAction
	
	
	public void helpContentMenuAction() 
	{
		JFrame frame=new JFrame("Help Contents");
        frame.setSize(700,500); 
        frame.setLocationRelativeTo(null ); // Center the frame
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        JTextArea textarea=new JTextArea();
        JScrollPane scrollPane=new JScrollPane(textarea);
		BufferedReader in = null;
		URL url = HelpMenu.class.getClassLoader().getResource("help_contents");
		String filesPathAndName = url.getPath();
		try {
			in = new BufferedReader(new FileReader(new File(filesPathAndName)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String line = null;
		try {
			line = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		textarea.setText("");
		while(line != null)
		{
		  textarea.append(line + "\n");
		  try {
			line = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
        frame.add(scrollPane);
		
	}//end helpContentsMenuAction
	
	
}
