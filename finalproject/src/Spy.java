import java.util.*;
public class Spy extends Bot{
	
	private final int stepsPerPress = 5;
	
	public Spy()
	{
		super(new Position(0,0));
	}
	
	public void act(String keyPressed, int param2)
	{
		
	}
	
	public Position getNextPosition(int direction)
	{
		return new Position(0,0);
		}
	
	public ArrayList<Objective> touchObjective(ArrayList<Objective> objectives)
	{
		return new ArrayList<Objective>();
	}
}
