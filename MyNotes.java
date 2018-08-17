import java.io.*;
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
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.UndoManager;


/**
 * This is an open source code to create a notepad similar application which will 
 * allow the user to jot down quik notes about events.
 * MenuExp - MyNotes is the base class for the project.
 * It will be linked to an event generator which will trigger this class.
 * state information includes:
 * <ul>
 * <li>The Main Menu as defined in nearly all applications
 * <li>A Menu for File that will include the open, save, save as, etc.
 * <li>The blank space to jot down notes.
 * <li>Menus for change fonts, search and about.
 * </ul>
 * <p>
 * MenuExp is to be developed under the open source licence
 * there is no limitations and cost to be paid by the author
 * or anyone who wish to use the code.
 * Please email for information about the development updates
 * The author can review the changes and subject to approval 
 * a new version can thus be uploaded.
  */

public class MyNotes extends JFrame {
public JFileChooser fc;
public JFontChooser jfonchoo;
public String currentfile="";
public UndoManager undo;




    public MyNotes() {
        fc=new JFileChooser();
        jfonchoo = new JFontChooser();

        setTitle("MyNotes");
        setSize(600, 600);

        JTextArea TextArea = new JTextArea();
        TextArea.setSize(500,500);   
        TextArea.setBounds(10,15,300,400);

        JScrollPane scroll = new JScrollPane (TextArea);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        TextArea.setLineWrap(true);
        TextArea.setVisible(true);


        undo = new UndoManager();
            TextArea.getDocument().addUndoableEditListener(
                new UndoableEditListener() 
                {
                    public void undoableEditHappened(UndoableEditEvent e)
                    {
                        undo.addEdit(e.getEdit());
                    }
                });
    
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
        JMenu helpMenu = new JMenu("Help");

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(formatMenu);
        menuBar.add(helpMenu);
         
        // Create and add simple menu item to one of the drop down menu
        JMenuItem newAction = new JMenuItem("New");
        JMenuItem openAction = new JMenuItem("Open");
        JMenuItem saveAction = new JMenuItem("Save");
        JMenuItem saveasAction = new JMenuItem("Save As");
        JMenuItem exitAction = new JMenuItem("Exit");
        JMenuItem cutAction = new JMenuItem("Cut");
        JMenuItem copyAction = new JMenuItem("Copy");
        JMenuItem pasteAction = new JMenuItem("Paste");
        JMenuItem undoAction = new JMenuItem("Undo");
        JMenuItem findAction = new JMenuItem("Find");
        JMenuItem selectallAction = new JMenuItem("Select All");
        JMenuItem fontAction = new JMenuItem("Font");
        JMenuItem viewhelpAction = new JMenuItem("View Help");
        JMenuItem aboutAction = new JMenuItem("About");

         
        // Create and add CheckButton as a menu item to one of the drop down
        // menu
        JCheckBoxMenuItem checkAction = new JCheckBoxMenuItem("Check Action");

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioAction1);
        bg.add(radioAction2);

        fileMenu.add(newAction);
        fileMenu.add(openAction);
        fileMenu.add(saveAction);
        fileMenu.add(saveasAction);
        fileMenu.add(checkAction);
        fileMenu.add(newAction);

        fileMenu.addSeparator();

        fileMenu.add(exitAction);

        editMenu.add(cutAction);
        editMenu.add(copyAction);
        editMenu.add(pasteAction);
        editMenu.add(undoAction);
        editMenu.add(findAction);
        editMenu.add(selectallAction);

        editMenu.addSeparator();

        editMenu.add(radioAction1);
        editMenu.add(radioAction2);

        formatMenu.add(fontAction);

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

// Added by Nowmish
    openAction.addActionListener(new ActionListener() {

    public void actionPerformed(ActionEvent arg0){

        //Handle open button action.
        if (arg0.getSource() == openAction) {
            int returnVal = fc.showOpenDialog(MyNotes.this);
            String textfromfile="";

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                System.out.println("getCurrentDirectory(): " + fc.getCurrentDirectory());
                System.out.println("getSelectedFile() : " + fc.getSelectedFile());      

                try{
                    FileInputStream fin=new FileInputStream(fc.getSelectedFile());
                    BufferedInputStream bin=new BufferedInputStream(fin);
                    int i;
                    while((i=bin.read())!=-1){
                        //System.out.print((char)i);
                        String temp = String.valueOf((char) i);
                        textfromfile = textfromfile + temp;
                    }
                    bin.close();
                    fin.close();
                    }catch(Exception e){System.out.println(e);}

                    System.out.println(textfromfile);
                    TextArea.setText(textfromfile);
                    currentfile=fc.getSelectedFile().toString();
                
            }
        }
    }
});


    saveAction.addActionListener(new ActionListener() {

    public void actionPerformed(ActionEvent arg0) 
        {
            try{
                FileOutputStream fout=new FileOutputStream(currentfile);
            
                BufferedOutputStream bout=new BufferedOutputStream(fout);
                String s=TextArea.getText();
                byte b[]=s.getBytes();
                bout.write(b);
                bout.flush();
                bout.close();
                fout.close();
            }
                catch(Exception e){System.out.println("success");}
        }
    
    });


    saveasAction.addActionListener(new ActionListener() {

    public void actionPerformed(ActionEvent arg0){

        fc.setDialogTitle("Specify a file to save");   
 
        int userSelection = fc.showSaveDialog(MyNotes.this);
 
        if (userSelection == JFileChooser.APPROVE_OPTION) {
        File fileToSave = fc.getSelectedFile();
        System.out.println("Save as file: " + fileToSave.getAbsolutePath());

        try{
              FileOutputStream fout=new FileOutputStream(fileToSave);
            
        BufferedOutputStream bout=new BufferedOutputStream(fout);
        String s=TextArea.getText();
        byte b[]=s.getBytes();
        bout.write(b);
        bout.flush();
        bout.close();
        fout.close();
            }
        catch(Exception e){System.out.println("success");}
    }
}
});

// End added by Nowmish
    cutAction.addActionListener(new ActionListener() {

    public void actionPerformed(ActionEvent arg0) 
        {
            TextArea.cut();
        }
    
    });

    copyAction.addActionListener(new ActionListener() {

    public void actionPerformed(ActionEvent arg0) 
        {
               TextArea.copy();
            }
    
    });
    
    pasteAction.addActionListener(new ActionListener() {

    public void actionPerformed(ActionEvent arg0) 
        {
                
                TextArea.paste();
            }
    
    });

    undoAction.addActionListener(new ActionListener() {

    public void actionPerformed(ActionEvent arg0) 
        {
            try {
               undo.undo();
            } catch (CannotRedoException cre) {
               cre.printStackTrace();
            }
        }
    });

    findAction.addActionListener(new ActionListener() {

    public void actionPerformed(ActionEvent arg0) 
        {
            if (arg0.getSource()==find) {
                FindWindow f = new FindWindow(this);
                String findText = f.getFindText();
                if (findText!="") { try {
                fo = new FindOption(findText, pane);
                }
                catch (NotFoundException ex) {
                    JOptionPane.showMessageDialog(null, ex.toString());
                }
                }
            }
        }
    
    });

   
    selectallAction.addActionListener(new ActionListener() {

    public void actionPerformed(ActionEvent arg0) 
        {
            pane.selectall();
        }               

    });

    fontAction.addActionListener(new ActionListener() {

    public void actionPerformed(ActionEvent arg0)
        {
                jfonchoo.showDialog(TextArea);
                TextArea.setFont(jfonchoo.getSelectedFont());
        }
    });


    aboutAction.addActionListener(new ActionListener() {

    public void actionPerformed(ActionEvent arg0) 
        {
                About abo = new About();
            }
    
    });
}

    public static void main(String[] args) {

        MyNotes mn = new MyNotes();
        mn.setDefaultLookAndFeelDecorated(true);
        mn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mn.setVisible(true);
}
}