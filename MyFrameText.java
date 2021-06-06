package team_12;

import javax.swing.JFrame;
import java.awt.Color;

//產生主介面
public class MyFrameText {
	public static void main(String[] args) {

		MyFrame myFrame = new MyFrame();
		myFrame.getContentPane().setBackground( Color.WHITE );
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setSize(1000, 600); // set frame size
		myFrame.setVisible(true); // display frame
	
	}
} // end class public class MyFrameText
