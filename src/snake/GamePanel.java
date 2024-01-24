package snake;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener{
  static final int screen_width=600;
  static final int screen_height=600;
  static final int unit_size=25;
  static final int game_units=(screen_width*screen_height)/unit_size;
  static final int delay=100;
  final int x[]=new int [game_units];
  final int y[]=new int [game_units];
  int bodyParts=6;
  int applesEaten;
  int applex;
  int appley;
  char direction = 'R';
  boolean running = false;
  Timer timer;
  Random random;
  
	public GamePanel() {
		random = new Random();
		this.setPreferredSize(new Dimension(screen_width,screen_height));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(new MykeyAdapter());
		startGame();
	
}
public void startGame() {
	newApple();
	running =true;
	timer = new Timer(delay, this);
	timer.start();
}
public void paintComponent(Graphics g) {
	super.paintComponent(g);
	draw(g);
}
public void draw(Graphics g) {
	if(running) {
//	for(int i=0;i<screen_height/unit_size;i++) {
//		g.drawLine(i*unit_size, 0, i*unit_size,screen_height );
//		g.drawLine(0, i*unit_size, screen_width,i*unit_size );
//	}
	g.setColor(Color.red);
	g.fillOval(applex, appley, unit_size, unit_size);
	for(int i=0;i<bodyParts;i++) {
		if(i==0) {
			g.setColor(Color.green);
			g.fillRect(x[i], y[i], unit_size, unit_size);
		}else {
			g.setColor(new Color(45,100,0));
			g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
			g.fillRect(x[i], y[i], unit_size, unit_size); 
		}
	}
	g.setColor(Color.red);
	  g.setFont(new Font("Ink Free", Font.BOLD, 40));
	  FontMetrics metrics= getFontMetrics(g.getFont());
	  g.drawString("Score: "+applesEaten, (screen_width-metrics.stringWidth("Score: "+applesEaten))/2,g.getFont().getSize());
	}else {
		gameOver(g);
	}
}
public void move() {
	for(int i=bodyParts;i>0;i--) {
		x[i]=x[i-1];
		y[i]=y[i-1];
	}
	switch (direction) {
	case 'U': 
		y[0]=y[0]-unit_size;
		break;
	case 'D': 
		y[0]=y[0]+unit_size;
		break;
	case 'L': 
		x[0]=x[0]-unit_size;
		break;
	case 'R': 
		x[0]=x[0]+unit_size;
		break;
	}
	
}
public void newApple() {
	applex= random.nextInt((int)(screen_width/unit_size))*unit_size;
	appley= random.nextInt((int)(screen_height/unit_size))*unit_size;
}
public void checkApple() {
	if((x[0]==applex)&&(y[0])==appley) {
		bodyParts++;
		applesEaten++;
		newApple();
	}
}
public void checkCollisions() {
	for(int i=bodyParts;i>0;i--) {
		if((x[0]==x[i])&& (y[0]==y[i])) {
			running=false;
		}
	}
	if(x[0]<0) {
		running=false;
	}
	if(x[0]>screen_width) {
		running=false;
	}
	if(y[0]<0) {
		running=false;
	}
	if(y[0]>screen_height) {
		running=false;
	}
	if(!running) {
		timer.stop(); 
	}
	
}
public void gameOver(Graphics g) {
	g.setColor(Color.red);
	  g.setFont(new Font("Ink Free", Font.BOLD, 40));
	  FontMetrics metrics1= getFontMetrics(g.getFont());
	  g.drawString("Score: "+applesEaten, (screen_width-metrics1.stringWidth("Score: "+applesEaten))/2,g.getFont().getSize());
  g.setColor(Color.red);
  g.setFont(new Font("Ink Free", Font.BOLD, 75));
  FontMetrics metrics2= getFontMetrics(g.getFont());
  g.drawString("Game Over", (screen_width-metrics2.stringWidth("Game Over"))/2,screen_height/2);
}
@Override
public void actionPerformed(ActionEvent e) {
	if(running) {
		move();
		checkApple();
		checkCollisions();
	}
	repaint();
	
}
public class MykeyAdapter extends KeyAdapter{
	 public void keyPressed(KeyEvent e) {
		 switch(e.getKeyCode()) {
		 case KeyEvent.VK_LEFT: 
				if(direction != 'R') {
					direction='L';
				}
				break;
			case KeyEvent.VK_RIGHT: 
				if(direction != 'L') {
					direction='R';
				}
				break;
			case KeyEvent.VK_UP: 
				if(direction != 'D') {
					direction='U';
				}
				break;
			case KeyEvent.VK_DOWN: 
				if(direction != 'U') {
					direction='D';
				}
				break;
		 }
		
	 }
}
}
