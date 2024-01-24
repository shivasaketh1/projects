package OnlineBanking;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;

public class LoginPage extends JFrame implements ActionListener {
	JLabel label1,label2,label3;
	JTextField field;
	JPasswordField field2;
	JButton button,button2,button3;
	LoginPage(){
	ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("bank.png"));
	Image image=icon.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
	ImageIcon icon2=new ImageIcon(image);
	JLabel jLabel=new JLabel(icon2);
	jLabel.setBounds(350, 10, 100, 100);
	add(jLabel);
	label1 =new JLabel("WELCOM TO ATM");
	label1.setForeground(Color.WHITE);
	label1.setFont(new Font("AvantGarde",Font.BOLD,38));
	label1.setBounds(230, 125,450, 40);
	add(label1);
	
	label2 =new JLabel("Card No :");
	label2.setForeground(Color.WHITE);
	label2.setFont(new Font("Ralway",Font.BOLD, 28));
	label2.setBounds(150, 190, 375, 30);
	add(label2);
	field=new JTextField(15);
	field.setBounds(325, 190, 230, 30);
	field.setFont(new FontUIResource("Arial",Font.BOLD,14));
	add(field);
	
	label3 =new JLabel("PIN No :");
	label3.setForeground(Color.WHITE);
	label3.setFont(new Font("Ralway",Font.BOLD, 28));
	label3.setBounds(150, 250, 375, 30);
	add(label3);
	field2=new JPasswordField(15);
	field2.setBounds(325, 250, 230, 30);
	field2.setFont(new FontUIResource("Arial",Font.BOLD,14));
	add(field2);
	
	button =new JButton("SIGN IN");
	button.setFont(new Font("Arial", Font.BOLD, 14));
	button.setForeground(Color.WHITE);
	button.setBackground(Color.BLACK);
	button.setBounds(300, 300, 100, 30);
	button.addActionListener(this);
	add(button);
	button2 =new JButton("CLEAR");
	button2.setFont(new Font("Arial", Font.BOLD, 14));
	button2.setForeground(Color.WHITE);
	button2.setBackground(Color.BLACK);
	button2.setBounds(450, 300, 100, 30);
	button2.addActionListener(this);
	add(button2);
	button3 =new JButton("SIGN UP");
	button3.setFont(new Font("Arial", Font.BOLD, 14));
	button3.setForeground(Color.WHITE);
	button3.setBackground(Color.BLACK);
	button3.setBounds(300, 350, 250, 30);
	button3.addActionListener(this);
	add(button3);
	
	ImageIcon icon3=new ImageIcon(ClassLoader.getSystemResource("card.png"));
	Image image2=icon3.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
	ImageIcon icon4=new ImageIcon(image2);
	JLabel jLabel2=new JLabel(icon4);
	jLabel2.setBounds(620, 350, 100, 100);
	add(jLabel2);
	ImageIcon icon5=new ImageIcon(ClassLoader.getSystemResource("backbg.png"));
	Image image3=icon5.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
	ImageIcon icon6=new ImageIcon(image3);
	JLabel jLabel3=new JLabel(icon6);
	jLabel3.setBounds(0, 0,850, 480);
	add(jLabel3);
	
	
		
	setLayout(null);
		setSize(850,480);
		setLocation(100,100);
		setVisible(true);
		
	}
public static void main(String[] args) {
	new LoginPage();
}
@Override
public void actionPerformed(ActionEvent e) {
	  if(e.getSource()==button) {
		  
	  }else if(e.getSource()==button2) {
		  field.setText("");
		  field2.setText("");
		  
	  }else if(e.getSource()==button3) {
		  
	  }
}
}
