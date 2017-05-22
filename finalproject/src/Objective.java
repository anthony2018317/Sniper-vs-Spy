import java.util.*;
public class Objective implements Actor
{ 
	private boolean reached;
	private ArrayList<Position> positions; //clockwise from left top radius
	private int radiusTop= 25;
	private final int Xsize = 50;
	private final int Ysize = 50;
	private Position pos;
	
	public Objective(Position position)
	{
		pos = position;
		reached=false;
	}
	public boolean isReached()
	{
		return reached;
	}
	public Position getPosition()
	{
		return pos;
	}
	public boolean isAlive()
	{
		return true;
	}
	public boolean isTouching(Position p)
	{
		int xleft=pos.getX()-Xsize/2-15;
		int xright=pos.getX()+Xsize/2+15;
		int ybottom=pos.getY()-Ysize/2-15;
		int ytop=pos.getY()+Ysize/2+15;
		if(p.getX()>xleft&&p.getX()<xright&&p.getY()>ybottom&&p.getY()<ytop)
		{
			reached=true;
			return true;
		}
		return false;
	}
}

