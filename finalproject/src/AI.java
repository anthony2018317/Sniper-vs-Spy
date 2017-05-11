import java.util.*;
public class AI 
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
}