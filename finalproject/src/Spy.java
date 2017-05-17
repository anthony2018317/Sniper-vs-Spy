import java.util.*;
public class Spy extends Bot{
	
	private final int stepsPerPress;
	private Position pos; 
	
	public Spy(Position p, stepsPerPress)
	{
		pos=p;
	}
	
	public void act(String keyPressed, int param2)
	{
		
	}
	
	public Position getNextPosition(char key)
	{
		return new Position(0,0);
		}
	
	public ArrayList<Objective> touchObjective(ArrayList<Objective> objectives)
	{
		return new ArrayList<Objective>();
	}
	
}

