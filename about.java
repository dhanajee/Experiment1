import javax.swing.*;
import java.awt.*;

// About Menu to be displayed when the about menu is clicked.

public class about
{

	public about()
	{
		JFrame frame=new JFrame("About MyNotes");

		frame.add(new TextArea("MyNotes \njdk-8u162-windows-x64\n©Dhanajee J..All rights reserved\n 2018"));
		frame.setVisible(true);
		frame.setSize(400,350);
	}
}