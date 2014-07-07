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
    Dictionary check;
    int[][] move = new int[][] {{1, 0}, {0, 1}, {1, 1}, {0, -1}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}};
    
    public WordsGenerator(String gridofcharacters[][])
    {
        grid = gridofcharacters;
        check = new Dictionary();
        try
        {
			check.loadFromFile("boggle/SowPodsLarge.txt");
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
        for (int k = 0; k < 8; k++)
        {
            p = i + move[k][0];
            q = j + move[k][1];
            if ((p >= 0 && p < 4) && (q >= 0 && q < 4) && !grid[p][q].contains("."))
            {
                oldInput = input + grid[p][q];
                grid[p][q] += ".";
                sequence(p, q, oldInput);
                grid[p][q] = "" + grid[p][q].charAt(0);
            }
        }
    }
}
