/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package boggle;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author piverma
 */
public class Boggle 
{

    /**
     * @param args the command line arguments
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException 
    {
        GridGenerator gridGenerator = new GridGenerator();
        //String[][] grid=gridGenerator.getGrid();
        WordsGenerator wordsGenerator = new WordsGenerator(gridGenerator);
        ArrayList<String> words;
        words = wordsGenerator.generate();
        System.out.println("Grid::");
        gridGenerator.display();
        
        for (int i = 0; i < words.size(); i++)
        {
            System.out.println(words.get(i));
        }
        
        System.out.print(words.size() + " words\r\n");
    }
}
