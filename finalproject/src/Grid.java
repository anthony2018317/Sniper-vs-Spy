import java.util.*;
public class Grid 
{
	private int xSize;
	private int ySize;
	private ArrayList<Objective> objectives;
	private UI gooey;
	private final int timeLimit;
	private AI ai;
	private Spy spy;
	private Sniper sniper;
	
	public Grid(int xsize, int ysize)
	{
		timeLimit = 180;
		xSize = xsize;
		ySize = ysize;
	}
	public void repaint(Position mouseMovedTo)
	{
		if(isInBounds(mouseMovedTo))
		{
			sniper.update(mouseMovedTo);
		}
		else
		{
			sniper.update(new Position(xSize-1, ySize-1));
		}
	}
	public void repaint(Position mouseClickedAt, Position mouseMovedTo, char keyPressed)
	{
		repaint(mouseMovedTo);
		if(!mouseClickedAt.equals(mouseMovedTo))
		{
			repaint(mouseClickedAt);
		}
		SpyMove(keyPressed);
		ai.act();
		
		boolean[] wins=checkWin();
		if(wins[0]==true)
		{
			update()
		}
	}
	private void update(boolean[] wins)
	{
		gooey.set(sniper, sniper.getPosition(), true);
		if(spy.isDead()==false)
		{
			gooey.set(spy, spy.getPosition(), false);
		}
		else
		{
			gooey.set(spy, spy.getPosition(), true);
		}
		
		if(wins[0]==true)
		{
			gooey.endGame();
		}
		if(wins[1]==true)
		{
			gooey.spyWin(true);
		}
		if(wins[1]==false)
		{
			gooey.spyWin(false);
		}
	}
	//first element is true if game over, second if spy wins
	public boolean[] checkWin()
	{
		boolean[] winArr=new boolean[2];
		winArr[0]=true;
		if(gooey.getTime()>timeLimit) //should be in GUI? 
		{
			winArr[1]=false;
			return winArr;
		}
		if(spy.isDead()==true)
		{
			winArr[1]=false;
			return winArr;
		}
		if(sniper.getBulletNum()==0)
		{
			winArr[1]=true;
			return winArr;
		}
		boolean reached=true;
		for (Objective obj: objectives)
		{
			if(obj.isReached()==false)
			{
				reached=false;
			}
		}
		if(reached==true)
		{
			winArr[1]=true;
			return winArr;
		}
		winArr[0]=false;
		winArr[1]=false;
		return winArr;
	}
	public void shoot()  //more than one bot shot?
	{
		
		if(sniper.isInRange(spy.getContactPos()))
		{
			spy.shoot();
			gooey.set(spy, false)
		}
		if(ai.shoot(sniper)!=null)
		{
			gooey.set(ai.shoot(sniper), false);
		}
	}
	
	private void SpyMove(char keyPressed)
	{
		spy.getNextPosition(keyPressed);
		gooey.updatePosition(spy, spy.getPosition());
	}
	public void instantiate()
	{
		ai=new AI(17, this);
		//Maze maze=new maze();
		Objective obj1= new Objective(new Position(50, 50));
		Objective obj2=new Objective(new Position(8500, 50));
		Objective obj3=new Objective(new Position(8000, 50));
		Objective obj4=new Objective(new Position(8500, 8000));
		spy=new Spy(randomPosition(50, 50, 9000, 9000), ai.getAvgSpeedRating());
		sniper=new Sniper(new Position(5000, 5000));
		objectives.add(obj1);
		objectives.add(obj2);
		objectives.add(obj3);
		objectives.add(obj4);
	}
	
	private Position randomPosition(int boundx1, int boundy1, int boundx2, int boundy2)
	{
		int x=(int)(Math.Random()*(boundx2-boundx1)+boundx1);
		int y=(int)(Math.Random()*(boundy2-boundy1)+boundy1);
		return new Position(x, y);
	}
	
	public boolean isInBounds(Position pos)
	{
		return true;
	}
	public int getXLength()
	{
		return xSize;
	}
	public int getYLength()
	{
		return ySize;
	}	
}

