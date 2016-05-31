package gui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.DefaultEditorKit.CopyAction;
import javax.swing.undo.UndoManager;

import java.awt.event.*;
import java.awt.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.UndoManager;

public class EditMenu extends JMenu
{
    private JMenu editMenu;
    
    private JTextArea sourceCode;
    
    protected UndoManager undoManager = new UndoManager();
    
    public EditMenu(JTextArea sourceCode)
    {
    	sourceCode.getDocument().addUndoableEditListener(
    	        new UndoableEditListener() {
    	            public void undoableEditHappened(UndoableEditEvent e) {
    	              undoManager.addEdit(e.getEdit());
    	            }
    	          });
    	
        editMenu=new JMenu("Edit");
        editMenu.add(getEditMenuItem("Undo",new DefaultEditorKit.CopyAction()));
        editMenu.add(getEditMenuItem("Redo",new DefaultEditorKit.CopyAction()));
        editMenu.add(getEditMenuItem("Cut",new DefaultEditorKit.CutAction()));
        editMenu.add(getEditMenuItem("Copy",new DefaultEditorKit.CopyAction()));
        editMenu.add(getEditMenuItem("Paste",new DefaultEditorKit.PasteAction()));   
    }
    
    private JMenuItem getEditMenuItem(final String name, Action action)
    {
        JMenuItem editMenuItem=new JMenuItem(name);
        
        if(name.equals("Undo"))
        {
        	editMenuItem.addActionListener(new ActionListener() {
        	      public void actionPerformed(ActionEvent e) {
        	        try {
        	          undoManager.undo();
        	        } catch (CannotRedoException cre) {
        	          cre.printStackTrace();
        	        }
        	      }
        	    });
        }
        else if(name.equals("Redo"))
        {
        	editMenuItem.addActionListener(new ActionListener() {
        	      public void actionPerformed(ActionEvent e) {
        	        try {
        	          undoManager.redo();
        	        } catch (CannotRedoException cre) {
        	          cre.printStackTrace();
        	        }
        	      }
        	    });
        }
        else
        {
        	editMenuItem=new JMenuItem(action);
            editMenuItem.setText(name);
        }

        return editMenuItem;
    }
	
	public JMenu getMenu()
	{
	    return editMenu;
	}

}
