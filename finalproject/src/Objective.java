
import java.util.*;
public class Objective
{ 
	private boolean reached;
	private ArrayList<Position> positions; //clockwise from left top radius
	private int radiusTop= 25;
	private int radiusBottom=15;
	private final int Xsize = 50;
	private final int Ysize = 50;
	
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
			if(isTouching(p)==true)
			{
				return true;
			}
		}
		return false; 
	}
	
	private boolean isTouching(Position p)
	{
		int x1=p.getX();
		int y1=p.getY();
		int x2=pos.getX();
	}
	
	private boolean isTouchingBottomCircle(Position p)
	{
		
	}
	private boolean isTouchingTrapezoid(Position p)
	{
		
	}	
	private boolean isTouchingTopCircle(Position p)
	{
		
	}

}
