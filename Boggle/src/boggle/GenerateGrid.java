package boggle;

import java.util.Random;

public class GenerateGrid {
    String[] alphabets;
    String[][] grid;
    public GenerateGrid(){
    	alphabets = new String[]{"A","B","c","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    	grid = new String[4][4];
    }
    public String[][] fillGrid(){
    	for (int i = 0; i < 4;i++){
    		for(int j = 0;j < 4;j++){
    			Random randomizer = new Random();
    			grid[i][j] = alphabets[randomizer.nextInt(26)];
    		}
    	}
        
    	return grid;
    }
  }
