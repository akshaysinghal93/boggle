package boggle;

import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GridGenerator 
{
    Box [] box;
    String [][]grid;
    Dice []dices;
    int sideLength;
    
    public GridGenerator()
    {
        this(4);
        
    }
    
    public GridGenerator(int sideLength)
    {
        box = new Box[16];
        for(int i=0;i<16;i++)
            box[i] = new Box();
    	this.sideLength = sideLength;
    	int numOfCells = sideLength * sideLength;
    	dices = new Dice[numOfCells];
    	grid = new String[sideLength][sideLength];
    	
    	for(int i = 0; i < numOfCells; i++)
    	{
    		dices[i] = new Dice(diceFaces[i]);
    		dices[i].roll();
    	}
        try {
            fillGrid();
        } catch (IOException ex) {
            Logger.getLogger(GridGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void fillGrid() throws IOException
    {
        int index=0;
        
    	for (int i = 0; i < sideLength;i++)
    	{
    		for(int j = 0;j < sideLength;j++)
    		{
    			grid[i][j] = "" + dices[i * sideLength + j].getTop();
                        
                        box[index].load(i+1,j+1);
                        
                        box[index].loadNeighbours();
                        index++;
    		}
    	}
    }
    public void display()
    {
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                System.out.print(" "+grid[i][j]);
            }
            System.out.println("");
        }
    }
    
    public String[][] getGrid()
    {
    	return grid;
    }
    public Box[] getBoxes()
    {
        return box;
    }
    
    public static final String []diceFaces = { "aaeegn", "elrtty", "aoottw", "abbjoo", "ehrtvw", "cimotv", "distty", "eiosst", "delrvy", "achops", "humnqu", "eeinsu", "eeghnw", "affkps", "hlnnrz", "deilrx" };
  }
