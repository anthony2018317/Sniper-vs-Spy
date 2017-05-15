import java.util.*;
public class Grid 
{
	private int xSize;
	private int ySize;
	private ArrayList<Actor> actors;
	private ArrayList<Objective> objectives;
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
		if(isInBounds(mouseClickedAt))
		{
			//Sniper.
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
		return new Bot(new Position(5, 6), 7);
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
		//Maze maze=new maze();
		Objective obj1= new Objective(new Position(50, 50));
		Objective obj2=new Objective(new Position(8500, 50));
		Objective obj3=new Objective(new Position(8000, 50));
		Objective obj4=new Objective(new Position(8500, 8000));
		Spy spy=new Spy();
		Sniper sniper=new Sniper(new Position(5000, 5000));
		actors.add(ai);
		objectives.add(obj1);
		objectives.add(obj2);
		objectives.add(obj3);
		objectives.add(obj4);
		actors.add(spy);
		actors.add(sniper);
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

