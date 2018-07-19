import javax.swing.*;
import java.awt.*;

public class about
{

	public about()
	{
		JFrame frame=new JFrame("About");

		frame.add(new TextArea("Menu Exp\njdk-8u162-windows-x64\n©Dhanajee J..All rights reserved\n31 March 2018"));
		frame.setVisible(true);
		frame.setSize(300,350);
	}
}