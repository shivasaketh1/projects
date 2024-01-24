package GUI;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatMenu {
public static void main(String[] args) {
	JMenuBar bar=new JMenuBar();
	
	JMenu menu=new JMenu("File");
	bar.add(menu);
	JMenu menu2=new JMenu("Help");
	bar.add(menu2);
	
	JMenuItem item=new JMenuItem("New File");
	menu.add(item);
	JMenuItem item2=new JMenuItem("Save as");
	menu.add(item2);
	
	JTextArea area=new JTextArea();
	
	JPanel jPanel=new JPanel();
	
	JLabel jLabel=new JLabel("Enter the Text");
	
	JTextField field=new JTextField(15);
	
	JButton button=new JButton("Send");
	JButton button2=new JButton("Reset");
	jPanel.add(jLabel);
	jPanel.add(field);
  jPanel.add(button);
  jPanel.add(button2);
	
	JFrame frame=new JFrame("Free Chat");
	frame.setSize(600,600);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	frame.getContentPane().add(BorderLayout.SOUTH,jPanel);
	frame.getContentPane().add(BorderLayout.NORTH,bar);
	frame.getContentPane().add(BorderLayout.CENTER,area);
	frame.setVisible(true);
}
}
