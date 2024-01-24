package tictactoe;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class TicTacToe implements ActionListener{

	Random random=new Random();
	JFrame frame=new  JFrame();
	JPanel jPanel=new JPanel();
	JPanel botton_panel=new JPanel();
	JLabel textField=new JLabel();
	JButton bottons[]=new JButton[9];
	boolean player_first;
	
	TicTacToe(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		textField.setBackground(new Color(25,25,25));
		textField.setForeground(new Color(255,0,0));
		textField.setFont(new Font("ink free",Font.BOLD, 75));
		textField.setHorizontalAlignment(JLabel.CENTER);
		textField.setText("Tic Tac Toe");
		textField.setOpaque(true);
		
		botton_panel.setLayout(new GridLayout(3,3));
		botton_panel.setBackground(new Color(150,150,150 ));
		
		for(int i=0;i<9;i++) {
			bottons[i]=new JButton();
			botton_panel.add(bottons[i]);
			bottons[i].setFont(new Font("MV Boli",Font.BOLD,120));
			bottons[i].setFocusable(false);
			bottons[i].addActionListener(this);
		}
		
		jPanel.setLayout(new BorderLayout());
		jPanel.setBounds(0,0,600,100);
		jPanel.add(textField);
		frame.add(jPanel,BorderLayout.NORTH);
		frame.add(botton_panel);
		firstTurn();
	}
	
	
	public void firstTurn() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		if(random.nextInt(2)==0) {
			player_first=true;
			textField.setText("X turn");
		}else {
			player_first=false;
			textField.setText("O turn");
		}
	}

	public void actionPerformed(ActionEvent e) {
        for(int i=0;i<9;i++) {
        	if(e.getSource()==bottons[i]){
        		if(player_first) {
        			if(bottons[i].getText()=="") {
						bottons[i].setForeground(new Color(255,0,0));
						bottons[i].setText("X");
						player_first=false;
						textField.setText("O turn");
						check();
        			}
        		}else {
        			if(bottons[i].getText()=="") {
						bottons[i].setForeground(new Color(0,0,255));
						bottons[i].setText("O");
						player_first=true;
						textField.setText("X turn");
						check();
						
        			}
        		}
        	}
        }
		
	}


	private void check() {
		//Check X win condition
		if((bottons[0].getText()=="X")&&
				(bottons[1].getText()=="X")&&
				(bottons[2].getText()=="X")) {
			xWin(0,1,2);
		}    if((bottons[3].getText()=="X")&&
				(bottons[4].getText()=="X")&&
				(bottons[5].getText()=="X")) {
			xWin(3,4,5);
		}   if((bottons[6].getText()=="X")&&
				(bottons[7].getText()=="X")&&
				(bottons[8].getText()=="X")) {
			xWin(6,7,8);
		}   if((bottons[0].getText()=="X")&&
				(bottons[3].getText()=="X")&&
				(bottons[6].getText()=="X")) {
			xWin(0,3,6);
		}   if((bottons[1].getText()=="X")&&
				(bottons[4].getText()=="X")&&
				(bottons[7].getText()=="X")) {
			xWin(1,4,7);
		}   if((bottons[2].getText()=="X")&&
				(bottons[5].getText()=="X")&&
				(bottons[8].getText()=="X")) {
			xWin(2,5,8);
		}   if((bottons[0].getText()=="X")&&
				(bottons[4].getText()=="X")&&
				(bottons[8].getText()=="X")) {
			xWin(0,4,8);
		}    if((bottons[2].getText()=="X")&&
				(bottons[4].getText()=="X")&&
				(bottons[6].getText()=="X")) {
			xWin(2,4,6);
		}
		//Check O win conditions
		if((bottons[0].getText()=="O")&&
				(bottons[1].getText()=="O")&&
				(bottons[2].getText()=="O")) {
			OWin(0,1,2);
		}    if((bottons[3].getText()=="O")&&
				(bottons[4].getText()=="O")&&
				(bottons[5].getText()=="O")) {
			OWin(3,4,5);
		}   if((bottons[6].getText()=="O")&&
				(bottons[7].getText()=="O")&&
				(bottons[8].getText()=="O")) {
			OWin(6,7,8);
		}   if((bottons[0].getText()=="O")&&
				(bottons[3].getText()=="O")&&
				(bottons[6].getText()=="O")) {
			OWin(0,3,6);
		}   if((bottons[1].getText()=="O")&&
				(bottons[4].getText()=="O")&&
				(bottons[7].getText()=="O")) {
			OWin(1,4,7);
		}   if((bottons[2].getText()=="O")&&
				(bottons[5].getText()=="O")&&
				(bottons[8].getText()=="O")) {
			OWin(2,5,8);
		}   if((bottons[0].getText()=="O")&&
				(bottons[4].getText()=="O")&&
				(bottons[8].getText()=="O")) {
			OWin(0,4,8);
		}    if((bottons[2].getText()=="O")&&
				(bottons[4].getText()=="O")&&
				(bottons[6].getText()=="O")) {
			OWin(2,4,6);
		}
		
	}


	private void xWin(int i, int j, int k) {
		bottons[i].setBackground(Color.green);
		bottons[j].setBackground(Color.green);
		bottons[k].setBackground(Color.green);
		for(int a=0;a<9;a++) {
			bottons[a].setEnabled(false);
		}
		textField.setText("X wins");
	}


	private void OWin(int i, int j, int k) {
		bottons[i].setBackground(Color.green);
		bottons[j].setBackground(Color.green);
		bottons[k].setBackground(Color.green);
		for(int a=0;a<9;a++) {
			bottons[a].setEnabled(false);
		}
		textField.setText("O wins");
	}
	}
