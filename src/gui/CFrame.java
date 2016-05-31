package gui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.Arrays;
import java.util.List;

public class CFrame extends JFrame
{
    private JMenuBar menuBar;
    private FileMenu fileMenu;
    private EditMenu editMenu;
    private RunMenu runMenu;
    private WindowMenu windowMenu;
    private HelpMenu helpMenu;
    
    private JTextArea viewFile=new JTextArea();
    private JTextArea viewResult=new JTextArea(); 
    
    private JPanel viewFilePanel;
    private JPanel viewResultPanel;
    
    protected UndoManager undoManager = new UndoManager();
    
    // 1. create the pipes
    PipedInputStream inPipe = new PipedInputStream();
    PipedInputStream outPipe = new PipedInputStream();
    
    public CFrame() throws IOException
    {
    	super.setTitle("Rando Editor");
    	menuBar=new JMenuBar();
    	fileMenu=new FileMenu(viewFile);
    	editMenu=new EditMenu(viewFile);
    	runMenu=new RunMenu(viewFile,viewResult);
    	windowMenu=new WindowMenu(this);
    	helpMenu=new HelpMenu();
    	
    	menuBar.add(fileMenu.getMenu());
    	menuBar.add(editMenu.getMenu());
    	menuBar.add(runMenu.getMenu());
    	menuBar.add(windowMenu.getMenu());
    	menuBar.add(helpMenu.getMenu());
    	
    	super.setJMenuBar(menuBar);
    	super.setLayout(new BorderLayout());
    	
    	super.add(getViewFilePanel(),BorderLayout.CENTER);

		super.add(getViewResultPanel(),BorderLayout.SOUTH);
	
    	
    }
    
    private JPanel getViewFilePanel()
    {
    	JScrollPane scrollPane=new JScrollPane(viewFile);
    	JPanel panel=new JPanel();
    	panel.setLayout(new GridLayout(1,1));
    	panel.add(scrollPane);
    	panel.setBorder( new TitledBorder( new EtchedBorder(),"Kodi"));
    	return panel;
    }//end getViewFilePanel
    
    private JPanel getViewResultPanel() throws IOException
    {
        // 2. set the System.in and System.out streams
        System.setIn(inPipe);
        System.setOut(new PrintStream(new PipedOutputStream(outPipe), true));
        PrintWriter inWriter = new PrintWriter(new PipedOutputStream(inPipe), true);
        
    	viewResult=console(outPipe, inWriter);
    	viewResult.setRows(10);
    	runMenu.setViewResult(viewResult);
    	JScrollPane scrollPane=new JScrollPane(viewResult);
    	JPanel panel=new JPanel();
    	panel.setLayout(new GridLayout(1,1));
    	panel.add(scrollPane);
    	panel.setBorder(new TitledBorder( new EtchedBorder(),"Rezultati"));
    	return panel;
    }//end getViewResultPanel
    
    public static JTextArea console(final InputStream out, final PrintWriter in) {
        final JTextArea area = new JTextArea();

        // handle "System.out"
        new SwingWorker<Void, String>() {
            @Override protected Void doInBackground() throws Exception {
                Scanner s = new Scanner(out);
                while (s.hasNextLine()) publish(s.nextLine() + "\n");
                return null;
            }
            @Override protected void process(List<String> chunks) {
                for (String line : chunks) area.append(line);
            }
        }.execute();

        // handle "System.in"
        area.addKeyListener(new KeyAdapter() {
            private StringBuffer line = new StringBuffer();
            @Override public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (c == KeyEvent.VK_ENTER) {
                    in.println(line);
                    line.setLength(0); 
                } else if (c == KeyEvent.VK_BACK_SPACE) { 
                    line.setLength(line.length() - 1); 
                } else if (!Character.isISOControl(c)) {
                    line.append(e.getKeyChar());
                }
            }
        });

        return area;
    }
    
 
 
}// end CFrame Class
