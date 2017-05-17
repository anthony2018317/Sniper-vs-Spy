
public class Bot 
{
	private Position pos;
	private int speedRating;
	private final int xSize;
	private final int ySize;
	private boolean state;
	public Bot(Position p, int speed)
	{
		pos=p;
		xSize=40; //placeholder
	    ySize=40; //placeholder
	    speedRating=speed;
	    state=true;
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
	public void shoot()
	{
		state=false;
	}

	public boolean isDead()
	{
		return state;
	}
	public int getDirectionTowards(Position p)
	{
		int x1=getPosition().getX();
		int x2=p.getX();
		int y1=getPosition().getY();
		int y2=p.getY();
		int x=x2-x1;
		int y=y2-y1; 
		int angle;
		return 2;
	}
	public ArrayList<Position> getContactPos()
	{
		int angle=getDirectionTowards();
		//if 0-90, send right and top side, if 90-180 top and left, if 180-270, left and bottom, if 270-360, bottom and right
		return new ArrayList<Position>();
	}
}
