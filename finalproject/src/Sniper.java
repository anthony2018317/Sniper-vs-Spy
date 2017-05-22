
import java.util.*;
public class Sniper implements Actor
{
	private Position pos;
	private final int radius=15; //placeholder
	private int numBullets;
	
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
	public boolean isTouching(Position p)
	{
		return true;
	}
	
	public void update(Position p)
	{
		pos=p;
	}
	public int getNumBullets()
	{
		return numBullets;
	}
	public void shoot()
	{
		numBullets--;
	}
	public Position getPosition()
	{
		return pos;
	}
	public boolean isAlive()
	{
		return true;
	}
}
	
