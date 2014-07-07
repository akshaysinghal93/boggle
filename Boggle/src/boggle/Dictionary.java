package boggle;

import java.util.*;
import java.io.*;

public class Dictionary
{
	Node root = null;
	
	public Dictionary()
	{
		root = new Node(null);
	}
	
	public void add(String str)
	{
		Node parentNode = null;
		Node iterator = root;
		str = str.toLowerCase();
		
		int length = str.length();
		for(int i = 0; i < length; i++)
		{
			parentNode = iterator;
			iterator = iterator.get(str.charAt(i));
			if(iterator == null)
			{
				iterator = new Node(parentNode);
				parentNode.add(str.charAt(i), iterator);
			}
		}
		iterator.setValid(true);
	}
	
	public void addAll(Collection<String> words)
	{
		//TODO: This functionality will be implemented later.
	}
	
	/**********************************
	 * one word per line.             *
	 **********************************/
	public void loadFromFile(String filename) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
		String word = br.readLine();
		while(word != null)
		{
			add(word);
			word = br.readLine();
		}
	}
	
	public int contains(String word)
	{
		Node iterator = root;
		int length = word.length();
		
		word = word.toLowerCase();
		
		for(int i = 0; i < length; i++)
		{
			iterator = iterator.get(word.charAt(i));
			if(iterator == null)
			{
				return NOMATCH;
			}
		}
		
		int retVal = 0;
		if (iterator.isValid())
		{
			retVal |= VALIDWORD;
		}
		
		if(!iterator.isLeaf())
		{
			retVal |= PARTOFWORD;
		}
		
		return retVal;
	}
	
	public static final int NOMATCH = 0;
	public static final int VALIDWORD = 1;
	public static final int PARTOFWORD = 2;
	public static final int BOTH = 3;
	
	public static void main(String []args)
	{
		Dictionary dic = new Dictionary();
		try{
			dic.loadFromFile("boggle/SowPodsLarge.txt");
		}
		catch(Exception e) { System.out.println(e.getMessage());}
		dic.add("shashi");
		dic.add("shrinath");
		dic.add("saumya");
		dic.add("piyush");
		
		System.out.println(dic.contains("shashik"));
		System.out.println(dic.contains("hello"));
		System.out.println(dic.contains("sh"));
		System.out.println(dic.contains("asdjs"));
		System.out.println(dic.contains("saumya"));
	}
	
	class Node
	{
		Node []children = null;
		Node parent;
		boolean validWord;
		
		public Node(Node parent)
		{
			children = new Node[26];
			this.parent = parent;
			validWord = false;
		}
		
		public void setValid(boolean validWord)
		{
			this.validWord = validWord;
		}
		
		public boolean isValid()
		{
			return validWord;
		}
		
		public void add(char ch, Node n)
		{
			children[char2Num(ch)] = n;
		}
		
		public Node get(char ch)
		{
			return children[char2Num(ch)];
		}
		
		public boolean isLeaf()
		{
			for(Node child : children)
			{
				if(child != null)
				{
					return false;
				}
			}
			return true;
		}
		
		private int char2Num(char ch)
		{
			for(int i = 0; i < Dictionary.alphabets.length; i++)
			{
				if(ch == Dictionary.alphabets[i])
					return i;
			}
			return -1;
		}
	}
	private static char []alphabets = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
}
