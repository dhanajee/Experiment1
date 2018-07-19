import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.filechooser.*;
import java.awt.Component;
 
public class MenuExp extends JFrame {
public JFileChooser fc;

    public MenuExp() {
         
        setTitle("MyNotepad");
        setSize(500, 500);

	JTextArea TextArea = new JTextArea();
	TextArea.setSize(250,300);   
	TextArea.setBounds(10,15,300,400);

	JScrollPane scroll = new JScrollPane (TextArea);
    	scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

	TextArea.setLineWrap(true);
	TextArea.setVisible(true);

	
        // Creates a menubar for a JFrame
        JMenuBar menuBar = new JMenuBar();
         
        // Add the menubar to the frame
        setJMenuBar(menuBar);
	add(TextArea);
	add(scroll);
        
        // Define and add two drop down menu to the menubar
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
	JMenu formatMenu = new JMenu("Format");
	JMenu viewMenu = new JMenu("View");
	JMenu helpMenu = new JMenu("Help");

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
	menuBar.add(formatMenu);
        menuBar.add(viewMenu);
        menuBar.add(helpMenu);
         
        // Create and add simple menu item to one of the drop down menu
        JMenuItem newAction = new JMenuItem("New");
        JMenuItem openAction = new JMenuItem("Open");
	JMenuItem saveAction = new JMenuItem("Save");
	JMenuItem saveasAction = new JMenuItem("Save As");
	JMenuItem printAction = new JMenuItem("Print");
        JMenuItem exitAction = new JMenuItem("Exit");
        JMenuItem cutAction = new JMenuItem("Cut");
        JMenuItem copyAction = new JMenuItem("Copy");
        JMenuItem pasteAction = new JMenuItem("Paste");
	JMenuItem undoAction = new JMenuItem("Undo");
	JMenuItem findAction = new JMenuItem("Find");
	JMenuItem replaceAction = new JMenuItem("Replace");
	JMenuItem selectallAction = new JMenuItem("Select All");
	JMenuItem fontAction = new JMenuItem("Font");
	JMenuItem statusbarAction = new JMenuItem("Status Bar");
	JMenuItem viewhelpAction = new JMenuItem("View Help");
	JMenuItem aboutAction = new JMenuItem("About");

         
        // Create and add CheckButton as a menu item to one of the drop down
        // menu
        JCheckBoxMenuItem checkAction = new JCheckBoxMenuItem("Check Action");

        // Create and add Radio Buttons as simple menu items to one of the drop
        // down menu
        JRadioButtonMenuItem radioAction1 = new JRadioButtonMenuItem("Radio Button1");
        JRadioButtonMenuItem radioAction2 = new JRadioButtonMenuItem("Radio Button2");

        // Create a ButtonGroup and add both radio Button to it. Only one radio
        // button in a ButtonGroup can be selected at a time.

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioAction1);
        bg.add(radioAction2);

        fileMenu.add(newAction);
        fileMenu.add(openAction);
	fileMenu.add(saveAction);
	fileMenu.add(saveasAction);
	fileMenu.add(printAction);
        fileMenu.add(checkAction);
	fileMenu.add(newAction);

        fileMenu.addSeparator();

        fileMenu.add(exitAction);

        editMenu.add(cutAction);
        editMenu.add(copyAction);
        editMenu.add(pasteAction);
	editMenu.add(undoAction);
	editMenu.add(findAction);
	editMenu.add(replaceAction);
	editMenu.add(selectallAction);

        editMenu.addSeparator();

        editMenu.add(radioAction1);
        editMenu.add(radioAction2);

	formatMenu.add(fontAction);

	viewMenu.add(statusbarAction);

	helpMenu.add(viewhelpAction);

	helpMenu.addSeparator();	

	helpMenu.add(aboutAction);


        exitAction.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent arg0) 
	    {
                System.out.println("You have clicked on the exit menu item");
		System.exit(0);
            }
	
    });

	newAction.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent arg0) 
	    {
                TextArea.setText("");
            }
	
    });

	openAction.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent arg0){

	try{
        //Handle open button action.
        if (arg0.getSource() == openAction) {
            int returnVal = fc.showOpenDialog(MenuExp.this);
            }

	}//end of try block

	catch(Exception e){

	System.out.println(e);
	}//end of catch block



	}
});


	saveAction.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent arg0) 
	    {
                System.out.println("You have clicked on the save menu item");
            }
	
    });

	saveasAction.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent arg0) 
	    {
                System.out.println("You have clicked on the save as menu item");
            }
	
    });

	printAction.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent arg0) 
	    {
                System.out.println("You have clicked on the print menu item");
            }
	
    });

	cutAction.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent arg0) 
	    {
                System.out.println("You have clicked on the cut menu item");
            }
	
    });

	copyAction.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent arg0) 
	    {
                System.out.println("You have clicked on the copy menu item");
            }
	
    });
	
	pasteAction.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent arg0) 
	    {
                System.out.println("You have clicked on the paste menu item");
            }
	
    });

	undoAction.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent arg0) 
	    {
                System.out.println("You have clicked on the undo menu item");
            }
	
    });

	findAction.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent arg0) 
	    {
                System.out.println("You have clicked on the find menu item");
            }
	
    });

	replaceAction.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent arg0) 
	    {
                System.out.println("You have clicked on the replace menu item");
            }
	
    });

	selectallAction.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent arg0) 
	    {
                System.out.println("You have clicked on the select all menu item");
            }
	
    });

	aboutAction.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent arg0) 
	    {
                System.out.println("You have clicked on the about menu item");

		about objabout=new about();
            }
	
    });
}

	public static void main(String[] args) {

        MenuExp me = new MenuExp();
        me.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        me.setVisible(true);
}
}