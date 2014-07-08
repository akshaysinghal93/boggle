/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package boggle;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author subprabhakar
 */

public class Box {
    
    private int row;
    private int col;
    private Box neighbours[];
    
    private String getNeighbours() throws FileNotFoundException, IOException
    {
        FileReader fr = new FileReader("C:\\Users\\subprabhakar\\Desktop\\boggle\\combinations.txt");
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        String neighStr="";
        line = br.readLine();
        while(line != null)
        {
            if(Integer.parseInt(new Character(line.charAt(0)).toString()) == row && Integer.parseInt(new Character(line.charAt(1)).toString()) == col)
            {
                neighStr = line;
                neighStr = line.substring(3);
                
                line=null;
            }
            line = br.readLine();
        }
        
        return neighStr;
    }
    public void load(int r,int c)
    {
        row = r;
        col = c;
    }
    
    public void loadNeighbours() throws IOException 
    {
        int index=0;
        
        String neighStr = getNeighbours();
        String neighArray[] = neighStr.split(":");        
        this.neighbours = new Box[neighArray.length];
        for(int i=0;i<neighArray.length;i++)
        {
            this.neighbours[i] = new Box();
        }
        
        for(String neighbour:neighArray)
        {
            neighbours[index].load(Integer.parseInt(new Character(neighbour.charAt(0)).toString()),Integer.parseInt(new Character(neighbour.charAt(1)).toString()));
            index++;
        }
        
    }
    public void showNeighbours()
    {
        for(Box ne:neighbours)
        {
            System.out.println(ne.row+" - "+ne.col);
        }
    }
    
    public int getRow()
    {
        return this.row;
    }
    public int getColumn()
    {
        return this.col;
    }
    
    public Box[] neighbours()
    {
        return this.neighbours;
    }
}
