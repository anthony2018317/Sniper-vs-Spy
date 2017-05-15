import java.util.*;
public class Sniper
{
	private Position pos;
	private final int radius=15; //placeholder
	
	public boolean isInRange(ArrayList<Position> positions)
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
	
	private boolean isInRange(Position position)
	{
		double x=position.getX()-pos.getX();
		double y=position.getY()-pos.getY();
		double distance=Math.sqrt(x*x+y*y);
		if(distance<radius)
		{
			return true;
		}
		return false;
	}
	
	public void update(Position p)
	{
		pos=p;
	}
}

