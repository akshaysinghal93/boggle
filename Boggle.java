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
public class Boggle 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        GridGenerator gridGenerator = new GridGenerator();
        String[][] grid=gridGenerator.getGrid();
        WordsGenerator wordsGenerator = new WordsGenerator(grid);
        ArrayList<String> words;
        words = wordsGenerator.generate();
        
        for (int i = 0; i < words.size(); i++)
        {
            System.out.println(words.get(i));
        }
        
        System.out.print(words.size() + " words\r\n");
    }
}
