import java.util.*;
public class AI
{
	private ArrayList<Bot> botList;
	private int avgSpeedRating;
	public AI(int numBots, Grid gr)
	{
		int sr=0;
		for(int i=0; i<numBots; i++)
		{
			Position p=selectRandomPosition(gr);
			sr+=(int) ((Math.random()*11)+2);
			Bot b= new Bot(p , sr);
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
		avgSpeedRating=sr/numBots;
	}
	private Position selectRandomPosition(Grid gr)
	{
		int x=gr.getXLength();
		int y=gr.getYLength();
		int newX=(int)(Math.random()*x);
		int newY=(int)(Math.random()*y);
		return new Position(newX, newY);
	}

	public void act()
	{
		for(Bot bot: botList)
		{
			bot.act();
		}
	}
	public Bot shoot(Sniper s)
	{
		Bot b=null;
		for(Bot bot: botList)
		{
			if(s.isInRange(bot.getContactPos()))
			{
				bot.shoot();
				b=bot;
			}
		}
		return b;
	}
	public int getAvgSpeedRating()
	{
		return avgSpeedRating;
	}
	public ArrayList<Position> getPositions()
	{
		ArrayList<Position> positions=new ArrayList<Position>();
		for(Bot bot: botList)
		{
			positions.add(bot.getPosition());
		}
		return positions;
	}
	public ArrayList<Bot> getAI()
	{
		return botList;
	}
}

