package gui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.event.*;
import java.awt.*;


public class WindowMenu extends JMenu
{
	private JMenu windowMenu;
	private CFrame frame;
	
    public WindowMenu(CFrame frame)
    {
    	this.frame=frame;
        windowMenu=new JMenu("Window");
        windowMenu.add(getWindowMenuItem("Small"));
        windowMenu.add(getWindowMenuItem("Medium"));
        windowMenu.add(getWindowMenuItem("Large"));
        windowMenu.add(getWindowMenuItem("Full Screen"));   
    }
    
 




	private JMenuItem getWindowMenuItem(final String name)
    {
        JMenuItem windowMenuItem=new JMenuItem(name);
        windowMenuItem.addActionListener(
                                     new ActionListener()
                                     {
                                         public void actionPerformed(ActionEvent event)
                                         {
                                             switch(name)
                                             {
                                             	case "Small":
                                             		setActionSmall();
                                             		break;
                                             	case "Medium":
                                             		setActionMedium();
                                             		break;
                                             	case "Large":
                                             		setActionLarge();
                                             		break;
                                             	case "Full Screen":
                                             		setActionFullSceen();
                                             		break;
                                             }
                                         }
                                     }
        );
        
        return windowMenuItem;
    }
	
	public void setActionSmall()
	{
		frame.setSize(400,400);
	}
	
	public void setActionMedium()
	{
		frame.setSize(600,600);
	}
	
	public void setActionLarge()
	{
		frame.setSize(800,800);
	}
	
	public void setActionFullSceen()
	{
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
	}
	
	public JMenu getMenu()
	{
	    return windowMenu;
	}

}
