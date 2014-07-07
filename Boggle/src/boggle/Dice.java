package boggle;

import java.util.Random;

public class Dice
{
	char [] sides;
	int top;
	
	public Dice(String faces)
	{
		sides = new char[6];
		for(int i = 0; i < 6; i++)
		{
			sides[i] = faces.charAt(i);
		}
		
		top = 0;
	}
	
	public void roll()
	{
		Random randomizer = new Random();
		top = randomizer.nextInt(6);
	}
	
	public char getTop()
	{
		return sides[top];
	}
}
