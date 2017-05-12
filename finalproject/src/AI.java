import java.util.*;
public class AI implements Actor
{
	private ArrayList<Objective> objectiveList;
	private ArrayList<Bot> botList;
	public AI(ArrayList<Bot> bots)
	{
		for(Bot bot: bots)
		{
			botList.add(bot);
		}
	}
	public void updateObjectives(ArrayList<Objective> objectives)
	{
		for(Objective obj: objectives)
		{
			objectiveList.add(obj);
		}
	}
	public void act(Position p1, Position p2, int p3)
	{
		for(Bot bot: botList)
		{
			bot.act();
		}
	}
}