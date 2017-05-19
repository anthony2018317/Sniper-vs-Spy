import java.util.*;
public class Objective
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
	public boolean isTouching(ArrayList<Position> positions)
	{
		for(Position p: positions)
		{
			if(isTouchingCircle(p)||isTouchingTrapezoid(p))
			{
				reached=true;
				return true;
			}
		}
		return false; 
	}
	private boolean isTouchingCircle(Position p)
	{
		double x=p.getX()-pos.getX();
		double y=p.getY()-pos.getY();
		double distance=Math.sqrt(x*x+y*y);
		if(distance<radiusTop)
		{
			return true;
		}
		return false;
	}
	private boolean isTouchingTrapezoid(Position p)
	{
		double x=p.getX();
		double y=p.getY();
		if(y>)
	}	
}
