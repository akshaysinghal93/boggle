package boggle;

import java.util.Random;

public class GridGenerator 
{
    String [][]grid;
    Dice []dices;
    int sideLength;
    
    public GridGenerator()
    {
    	this(4);
    }
    
    public GridGenerator(int sideLength)
    {
    	this.sideLength = sideLength;
    	int numOfCells = sideLength * sideLength;
    	dices = new Dice[numOfCells];
    	grid = new String[sideLength][sideLength];
    	
    	for(int i = 0; i < numOfCells; i++)
    	{
    		dices[i] = new Dice(diceFaces[i]);
    		dices[i].roll();
    	}
    	fillGrid();
    }
    
    private void fillGrid()
    {
    	for (int i = 0; i < sideLength;i++)
    	{
    		for(int j = 0;j < sideLength;j++)
    		{
    			grid[i][j] = "" + dices[i * sideLength + j].getTop();
    		}
    	}
    }
    
    public String[][] getGrid()
    {
    	return grid;
    }
    
    public static final String []diceFaces = { "aaeegn", "elrtty", "aoottw", "abbjoo", "ehrtvw", "cimotv", "distty", "eiosst", "delrvy", "achops", "humnqu", "eeinsu", "eeghnw", "affkps", "hlnnrz", "deilrx" };
  }
