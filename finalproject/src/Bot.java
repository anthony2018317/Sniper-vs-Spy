
public class Bot
{
	private Position pos;
	private int speedRating;
	private final int xSize;
	private final int ySize;
	public Bot(Position p)
	{
		pos=p;
		xSize=40; //placeholder
	    ySize=40; //placeholder
	}
	public void act()
	{
		//call methods
		int n=6;
	}
	public int getXsize()
	{
		return xSize;
	}
	public int getYsize()
	{
		return ySize;
	}
	public Position getPosition()
	{
		return pos;
	}
	
	
	public boolean isTouching(Position p)
	{
		Position topLeft=new Position(pos.getX()-xSize/2, pos.getY()+ySize/2);
		Position botRight=new Position(pos.getX()+xSize/2, pos.getY()-ySize/2);
		if(p.getX()>topLeft.getX() &&p.getX()<botRight.getX())
		{
			if(p.getY()>botRight.getY() &&p.getY()<topLeft.getY())
			{
				return true;
			}
		}
		return false;
	}
	
	
	
}
