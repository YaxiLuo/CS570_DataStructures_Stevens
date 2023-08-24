package hw6_P_Raut;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class Anagrams{
	final Integer[] primes;
	Map<Character,Integer>letterTable;
	Map<Long,ArrayList<String>> anagramTable;
	
	public Anagrams()
	{
		primes=new Integer[] {2,3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61,
				 67, 71, 73, 79, 83, 89, 97, 101};
		buildLetterTable();
		anagramTable=new HashMap<Long,ArrayList<String>>();

	}
	/*This method should be invoked by the constructor for the class Anagrams and should build 
the hash table letterTable*/
	private void buildLetterTable()
	{
		letterTable=new HashMap<Character,Integer>();
		letterTable.put('a', 2);
		letterTable.put('b', 3);
		letterTable.put('c', 5);
		letterTable.put('d', 7);
		letterTable.put('e', 11);
		letterTable.put('f', 13);
		letterTable.put('g', 17);
		letterTable.put('h', 19);
		letterTable.put('i', 23);
		letterTable.put('j', 29);
		letterTable.put('k', 31);
		letterTable.put('l', 37);
		letterTable.put('m', 41);
		letterTable.put('n', 43);
		letterTable.put('o', 47);
		letterTable.put('p', 53);
		letterTable.put('q', 59);
		letterTable.put('r', 61);
		letterTable.put('s', 67);
		letterTable.put('t', 71);
		letterTable.put('u', 73);
		letterTable.put('v', 79);
		letterTable.put('w', 83);
		letterTable.put('x', 89);
		letterTable.put('y', 97);
		letterTable.put('z', 101);
		
	}
	/*This method should compute the hash code of the string s passed as argument, and 
should add this word to the hash table anagramTable.*/
	public void addWord(String s)
	{
		long l=myHashCode(s);
		ArrayList <String>t;
		ArrayList <String> t1=new ArrayList<String>();
		t=anagramTable.get(l);
		if(t!=null)
		{
			t.add(s);
		}
		else if(t==null)
		{
			t1.add(s);
			anagramTable.put(l, t1);
		}
		
	}
	/*This method, given a string s, should compute its hash code. A requirement for myHashCode
is that all the anagrams of a word should receive the same hash code*/
	private Long myHashCode(String s)
	{
		Long p=1L;
		int i,val;
		char a;
		int n=s.length();
		for(i=0;i<n;i++)
		{	
			a=s.charAt(i);
			val=letterTable.get(a);
			p=p*val;
		}
		
		return p;
	}
	/*The main method is processFile which receives the name of a text file containing words, one 
per line, and builds the hash table anagramTable.*/
	private void processFile(String s) throws IOException
	{
		FileInputStream fstream = new FileInputStream( s );
		BufferedReader br = new BufferedReader ( new InputStreamReader( fstream ));
	    String strLine ;
		while (( strLine = br. readLine ()) != null ) {
		 this.addWord ( strLine );
		}
		 br.close ();
		}
	/*This method should return the entries in the anagramTable that have the largest number of 
anagrams. It returns a list of them since there may be more than one list of anagrams 
with a maximal size. */
	private ArrayList<Map.Entry<Long,ArrayList<String>>> getMaxEntries()
	{
		ArrayList<Map.Entry<Long,ArrayList<String>>> a=new ArrayList<Map.Entry<Long,ArrayList<String>>>();
		int max=0;
		for(Map.Entry<Long,ArrayList<String>> entry: anagramTable.entrySet())
		{	
			
			if(entry.getValue().size()>max)
			{
			a.clear();
			max=entry.getValue().size();
			a.add(entry);
			}
			
			else if(entry.getValue().size()<max)
			{
				continue;
			}
			
			else if(entry.getValue().size()==max)
			{
				a.add(entry);
			}
			
			
		}
		
		return a;
	}
	public static void main(String[] args)
	{
		Anagrams an=new Anagrams();
		final  long  startTime = System.nanoTime ();
		try
		{
			an.processFile("words_alpha.txt");
		}
		catch (IOException  e1) 
		{
			e1.printStackTrace ();
		}
		ArrayList <Map.Entry <Long ,ArrayList <String >>> maxEntries = an.getMaxEntries ();
		final  long  estimatedtime = System.nanoTime () - startTime;
		final  double  seconds = (( double) estimatedtime /1000000000);
		System.out.println("Elapsed Time= "+ seconds );
	 
		int n=maxEntries.size();
		for(int i=0;i<n;i++)
		{
			Map.Entry<Long,ArrayList<String>> entry=maxEntries.get(i);
			System.out.println("Key of Max Anagram= "+entry.getKey());
			System.out.println("List of Max Anagrams="+entry.getValue());
		}
		
		System.out.println("Length of the list of max anagrams= "+maxEntries.get(0).getValue().size());
		
	}
	}
	
	
	
