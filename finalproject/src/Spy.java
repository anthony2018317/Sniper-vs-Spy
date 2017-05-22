import java.util.*;
public class Spy extends Bot{
	
	private final int stepsPerPress;
	private Position pos;
	private Position tempPos;

	
	public Spy(Position p, stepsPerPress)
	{
		pos=p;
		stepsPerPress = 5;
		tempPos = pos;
	}
	
	public void setPosition(Position newPos)
	{
		pos=newPos;
	}
	
	public void act(char key)
	{
		if(key == 'w')
		{
			// to move 'up', decrease y
			pos.setY(pos.getY()-stepsPerPress);
		}
		else if(key == 'a')
		{
			tempPos.setY(pos.getY() + stepsPerPress);
			if(Grid.isInBounds(tempPos))
			{
				pos.setY(pos.getY()+stepsPerPress;
			}
			else
			{
				return;
			}
		}
		else if(key == 's')
		{
			//xPos--;
		}
		else if(key == 'd')
		{
			//yPos++;
		}
	}
	
	
	public boolean touchObjective(ArrayList<Objective> objectives)
	{
		if(//Spy is touching Objective)
			{
				return true;
			}
		return false;
	}
	
}

