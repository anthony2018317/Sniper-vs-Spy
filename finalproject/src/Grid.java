import java.util.*;
public class Grid 
{
	private int xSize;
	private int ySize;
	private ArrayList<Actor> actors;
	private UI gooey;
	private final int timeLimit;
	public Grid(int xsize, int ysize)
	{
		timeLimit = 180;
		xSize = xsize;
		ySize = ysize;
		actors = new ArrayList<Actor>();
	}
	public void repaint(Position mouseClickedAt)
	{
		if(isValid(mouseClickedAt))
		{
			Sniper.
		}
	}
	public void repaint(Position mouseClickedAt, Position secondMouseLoc, int keypressed)
	{
		
	}
	public boolean checkWin(Actor a)
	{
		return true;
	}
	private Bot shoot(Position pos)
	{
		return new Bot(new Position(5, 6));
	}
	private void SniperMove(Position newLoc)
	{
		
	}
	private void SpyMove(int keyPressed)
	{
		
	}
	public void instantiate()
	{
		AI ai=new AI(17, this);
		
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

