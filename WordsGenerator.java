/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package boggle;

import java.util.ArrayList;

/**
 *
 * @author piverma
 */
public class WordsGenerator 
{
    private ArrayList<String> words = new ArrayList<String>();
    String[][] grid = null;
    Box[] box = null;
    Dictionary check;
    
    public WordsGenerator(GridGenerator gridgen)
    {
        box = gridgen.getBoxes();
        grid = gridgen.getGrid();
        check = new Dictionary();
        try
        {
			check.loadFromFile("C:\\Users\\subprabhakar\\Desktop\\boggle\\SowPodsLarge.txt");
        }
        catch(Exception e) 
        { 
        	System.out.println(e.getMessage());
        }
    }
    
    public ArrayList<String> generate()
    {
    	//TODO: Update 4 with grid.length. scared of doing it right now.
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                sequence(i, j, grid[i][j]);       
            }
        }
        return words;
    }
    
    private Box[] getNeighbours(int r,int c)
    {
        return box[(((r+1)*4)-(4-(c+1))-1)].neighbours();
    }
    
    private void sequence(int i, int j, String input)
    {
        String oldInput;
        int p, q;
        if (words.contains(input))
        {
            return;
        }
        switch(check.contains(input))
        {
            case Dictionary.NOMATCH:
                return;
            case Dictionary.VALIDWORD:
                words.add(input);
                return;
            case Dictionary.PARTOFWORD:
                break;
            case Dictionary.BOTH:
                words.add(input);
                break;
        }
     
        Box[] neighbours = getNeighbours(i,j);
        
        for(Box b:neighbours)
        {
            p = b.getRow() - 1;
            q = b.getColumn() - 1;
            if ((p >= 0 && p < 4) && (q >= 0 && q < 4) && !grid[p][q].contains("."))
            {
                oldInput = input + grid[p][q];
                grid[p][q] += ".";
                sequence(p, q, oldInput);
                grid[p][q] = new Character(grid[p][q].charAt(0)).toString();
            }
        }
    }
}
