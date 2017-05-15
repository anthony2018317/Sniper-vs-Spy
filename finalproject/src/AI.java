
import java.util.*;
public class AI implements Actor
{
	private ArrayList<Bot> botList;
	private int speedRating;
	public AI(int numBots, Grid gr)
	{
		for(int i=0; i<numBots; i++)
		{
			Position p=selectRandomPosition(gr);
			Bot b= new Bot(p , (int) (Math.random()*11)+2);
			boolean same=false;
			for(Bot bot: botList)
			{
				if( p.equals(bot.getPosition()))
				{
					same=true;
				}
			}
			if(same)
			{
				i--;
			}
			else
			{
				botList.add(b);
			}
		}
	}
	private Position selectRandomPosition(Grid gr)
	{
		int x=gr.getXLength();
		int y=gr.getYLength();
		int newX=(int)(Math.random()*x);
		int newY=(int)(Math.random()*y);
		return new Position(newX, newY);
	}

	public void act(Position p1, Position p2, int p3)
	{
		for(Bot bot: botList)
		{
			bot.act();
		}
	}
}




