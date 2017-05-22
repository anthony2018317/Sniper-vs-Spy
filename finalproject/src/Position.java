
public class Position 
{
	private int x;
	private int y;
	public Position(int xLoc, int yLoc)
	{
		x = xLoc;
		y = yLoc;
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public void setX(int newX);
	{
		x = newX;
	}
	public void setY(int newY)
	{
		y = newY;
	}
	public boolean equals(Position pos)
	{
		return (pos.getX()==x&&pos.getY()==y);
	}
}

