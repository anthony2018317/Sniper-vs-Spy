import java.awt.*;          // access to Container
import java.awt.event.*;    // access to WindowAdapter, WindowEvent
import javax.swing.*;       // access to JFrame and JComponents
import javax.swing.Timer;
import java.util.*;

public class UI implements ActionListener
{
	private Grid gr;
	private JFrame frame;
	private Image boti;
	private Image deadBot;
	private Image sniperi;
	private Image objectivei;
	//private Image Maze;
	private ArrayList<Actor> actors;
	private javax.swing.Timer timer;
	//private javax.swing.Timer sniperTimer;
	//private javax.swing.Timer gameTimer;
	private boolean pressed;
	private char keyPressed;
	private int time;
	private Position clicked;
	private Position movedTo;
	private JMenu menu;
	private JFrame winnerFrame;
	
	public static void main(String[] args)
	{
		UI gui=new UI();
		
	}
	
	public UI()
	{
		frame=new JFrame("Sniper vs. Spy");
		Container container=frame.getContentPane();
		frame.addKeyListener( new KeyHandler());
        frame.addMouseListener( new MouseClickHandler());
        frame.addWindowListener(new java.awt.event.WindowAdapter() 
        {
            public void windowClosing(WindowEvent evt) 
            {
                System.exit(0);
            }
	    });
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //from stackOverflow
        Dimension windowSize=new Dimension((int)(0.85*screenSize.getWidth()),(int)(0.85*screenSize.getHeight()));
        frame.setSize( windowSize);     // width=500, height=400
        actors=new ArrayList<Actor>();
        gr=new Grid((int)(0.85*screenSize.getWidth()),(int)(0.85*screenSize.getHeight()), this);
        //classloader?
        ImageIcon botIcon=new ImageIcon("bot.gif");
        ImageIcon sniperIcon=new ImageIcon("sniper.gif");
        ImageIcon objectiveIcon=new ImageIcon("objective.gif");
        ImageIcon deadBotIcon=new ImageIcon("deadBot.gif");
        //ImageIcon mazeIcon=new ImageIcon("maze.gif");
        boti=botIcon.getImage();
        sniperi=sniperIcon.getImage();
        objectivei=objectiveIcon.getImage();
        deadBot=deadBotIcon.getImage();
        frame.setVisible(true);
        //sniperTimer=new javax.swing.Timer(10, this);
        //sniperTimer.start();
        //gameTimer=new javax.swing.Timer(1000, this);
        timer=new javax.swing.Timer(10, this);
        timer.start();
        //bulletcounts, objectives reached, time JPanels
	}
	public void actionPerformed(ActionEvent evt)
	{
		if(evt.getSource()==timer)
		{
			time++;
			if(time%2==0)
			{
				gr.repaint(clicked, movedTo, keyPressed);
				if(pressed==false)
				{
					keyPressed= '\u0000';
				}
			}
			else
			{
				gr.repaint(movedTo);
			}
			return;
		}
	}
	public int getTime()
	{
		return time/100;
	}
	public void addActor(Actor actor)
	{
		actors.add(actor);
	}	
	public void Paint(Graphics g)
	{
		for(Actor actor: actors)
		{
			if(actor instanceof Sniper)
			{
				g.drawImage(sniperi, actor.getPosition().getX(), actor.getPosition().getY(), frame);
			}
			if(actor instanceof Objective)
			{
				g.drawImage(objectivei, actor.getPosition().getX(), actor.getPosition().getY(), frame);
			}
			if(actor instanceof Bot && actor.isAlive()==true)
			{
				g.drawImage(boti, actor.getPosition().getX(), actor.getPosition().getY(), frame);
			}
			else if(actor instanceof Bot)
			{
				g.drawImage(deadBot, actor.getPosition().getX(), actor.getPosition().getY(), frame);
			}
		}
	}
	public void repaint()
	{
		frame.repaint();
	}
	
	public void endGame(Actor winner)
	{
		timer.stop();
		if(winner instanceof Spy)
		{
			winnerFrame=new JFrame("Spy Wins");
			winnerFrame.setLayout(new FlowLayout());
			winnerFrame.setSize(300, 100);
			//add image?
			winnerFrame.add(new JLabel("Game over: Spy Wins!"));
			JPanel buttons=new JPanel();
			buttons.setLayout(new BoxLayout());
			buttons.add(new Button(""));
			
		}
		if(winner instanceof Sniper)
		{
			winnerFrame=new JFrame("Sniper Wins");
			winnerFrame.setLayout(new FlowLayout());
			//add image?
			winnerFrame.add(new JTextArea("Game over: Sniper Wins!"));
		}
	}
	
	private class KeyHandler implements KeyListener
	{	
		public void keyPressed(KeyEvent event)
		{
			keyPressed=event.getKeyChar();
			pressed=true;
			
		}
		public void keyReleased (KeyEvent event )
        {
			pressed=false;
        }
        public void keyTyped (KeyEvent event )
        {
        }
	}
	 private class MouseClickHandler extends MouseAdapter
	    {
	        public void mouseClicked ( MouseEvent event )
	        {
	        	clicked=new Position(event.getX(), event.getY());
	        }
	        public void mouseMoved(MouseEvent event)
	        {
	        	movedTo=new Position(event.getX(), event.getY());
	        }
	    } 
}