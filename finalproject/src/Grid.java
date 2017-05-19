import java.util.*;
public class Grid 
{
	private int xSize;
	private int ySize;
	private UI gooey;
	private final int timeLimit;
	private AI ai;
	private Spy spy;
	private Sniper sniper;
	private ArrayList<Objective> objectives;
	
	public Grid(int xsize, int ysize, UI gui)
	{
		timeLimit = 120;
		xSize = xsize;
		ySize = ysize;
		gooey=gui;
		instantiate();
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
		if((!mouseClickedAt.equals(mouseMovedTo))&&(mouseClickedAt!=null))
		{
			repaint(mouseClickedAt);
		}
		if(mouseClickedAt!=null)
		{
			shoot();
		}
		SpyMove(keyPressed);
		ai.act();
		boolean[] wins=checkWin();
		update(wins);
	}
	private void update(boolean[] wins)
	{
		gooey.setActor(sniper, sniper.getPosition(), true);
		if(spy.isDead()==true)
		{
			gooey.setActor(spy, spy.getPosition(), false);
		}
		else
		{
			gooey.setActor(spy, spy.getPosition(), true);
		}
		ArrayList<Bot> aiList=ai.getAI();
		for(Bot bot: aiList)
		{
			if(!bot.isDead())
			{
				gooey.setActor(bot, bot.getPosition(), true);
			}
			else
			{
				gooey.setActor(bot, bot.getPosition(), false);
			}
		}
		if(wins[0]==true)
		{
			gooey.endGame();
			if(wins[1]==true)
			{
				gooey.spyWin(true);
			}
			if(wins[1]==false)
			{
				gooey.spyWin(false);
			}
		}
	}
	//first element is true if game over, second if spy wins
	public boolean[] checkWin()
	{
		boolean[] winArr=new boolean[2];
		winArr[0]=true;
		if(gooey.getTime()>timeLimit) 
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
		}
		if(ai.shoot(sniper)!=null)
		{
			ai.shoot(sniper);
		}
	}
	
	private void SpyMove(char keyPressed)
	{
		spy.getNextPosition(keyPressed);
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
		gooey.addActor(spy, spy.getPosition(), true);
		gooey.addActor(sniper, sniper.getPosition(), true);
		for(Objective obj: objectives)
		{
			gooey.addActor(obj, obj.getPosition(), true);
		}
		ArrayList<Bot> aiList=ai.getAI();
		for(Bot bot: aiList)
		{
			gooey.addActor(bot, bot.getPosition(), true);
		}
	}
	
	private Position randomPosition(int boundx1, int boundy1, int boundx2, int boundy2)
	{
		int x=(int)(Math.random()*(boundx2-boundx1)+boundx1);
		int y=(int)(Math.random()*(boundy2-boundy1)+boundy1);
		return new Position(x, y);
	}
	
	public boolean isInBounds(Position p)
	{
		return p.getX()<xSize && p.getY()<ySize;
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

