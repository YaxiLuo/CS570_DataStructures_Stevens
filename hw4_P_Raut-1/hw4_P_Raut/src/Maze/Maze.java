package Maze;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Stack;


public class Maze implements GridColors  {

    /** The maze */
    private TwoDimGrid maze;

    public Maze(TwoDimGrid m) {
        maze = m;
    }

    /** Wrapper method. */
    public boolean findMazePath() {
    	 return findMazePath(0, 0); // (0, 0) is the start point.
    }


    public boolean findMazePath(int x, int y) {
    	
    	int r=maze.getNRows();
    	int c=maze.getNCols();
    	//if x <0 or y < 0 or > matrix size return false
    	if(x<0 || y<0 || x>=c || y>=r )
    	{
    	return false;
    }
    	//if the cell is not in path then return false
    	else if(maze.getColor(x,y)!=NON_BACKGROUND)
      {
	     return false;
      }
    	//if the cell is the last cell then set color to green and return true
      else if(x==c-1 && y==r-1)
      {
    	  maze.recolor(x,y,PATH);
    	  return true;
    	  
      }
       // All other cells will be set to path color(green) as they are present in selected path using recursion
      else {
    	  maze.recolor(x,y,PATH);
    	  if(findMazePath(x-1,y) || findMazePath(x+1,y) || findMazePath(x,y-1) || findMazePath(x,y+1))
    	  {
    		  return true;
    	  }
    	  else
    	  {
    		  //recolor to temp color (black) and return false
    		  maze.recolor(x,y,TEMPORARY);
    		  return false;
    	  }
      }
}
    //Problem 2 to solve recursively to extend problem 1
    public ArrayList<ArrayList<PairInt>> findAllMazePaths(int x, int y)
    { 
    	 ArrayList <ArrayList<PairInt>> result = new ArrayList<>(); // successful path recorded
    	 Stack <PairInt> trace= new Stack<>(); // trace current path
    	 findMazePathStackBased(0,0,result,trace);
    	 return result;
    	
    }
    public void findMazePathStackBased(int x,int y, ArrayList <ArrayList<PairInt>>result,Stack<PairInt>trace)
    {
    	int c=maze.getNCols(); // get columns 
    	int r=maze.getNRows(); // get rows
    	//check if coordinates are in bound of matrix x and y <0 and > matrix size
    	if(x<0 || y<0 ||x>c-1 || y>r-1 || (!maze.getColor(x,y).equals(NON_BACKGROUND))) {
    		return;
    		
    	}
    	//if the given x and y coordinates are end points
    	else if(x==c-1 && y==r-1)
    	{
    		PairInt lastnode=new PairInt(x,y); // x,y
    		//add to stack
    		trace.push(lastnode);
    		ArrayList<PairInt> all=new ArrayList<>();
    		//add stack to arraylist all
    		all.addAll(trace);
    		result.add(all);
    		//pop the stack after visiting it
    		trace.pop();
    		// recolor to non background so  as to revisit stack
    		maze.recolor(x,y,NON_BACKGROUND);
    		return;
    		
    	}
    	else
    	{
    		//create pairInt object that can be pushed to stack
    		PairInt lastnode= new PairInt(x,y); //x,y
    		trace.push(lastnode);
    		maze.recolor(x,y,PATH);
    		//recursion to visit nearby paths
    		findMazePathStackBased(x-1,y,result,trace);
    		findMazePathStackBased(x+1,y,result,trace);
    		findMazePathStackBased(x,y-1,result,trace);
    		findMazePathStackBased(x,y+1,result,trace);
    		maze.recolor(x, y, NON_BACKGROUND);
    		trace.pop();
    		return;
    	}
    }
    // 3rd problem statement: to return shortest path in the list of paths 
    public ArrayList<PairInt> findMazePathMin(int x, int y)
    {
    int index=0;
    // intitalize minimum to maximum value
    int minimum =Integer.MAX_VALUE;
    ArrayList<ArrayList<PairInt>> shortPath= new ArrayList<>();
    shortPath= findAllMazePaths(x,y);
    for(int i=0;i<shortPath.size();i++)
    {
    	int temporary=minimum;
    	minimum=Math.min(minimum, shortPath.get(i).size());
    	if(temporary!=minimum)
    	{
    		index=i;
    	}
    }
    //if no elements found return empty
    if(shortPath.size()==0)
    	return new ArrayList<PairInt>();
    return shortPath.get(index);
    }
    		
   
    public void resetTemp() {
        maze.recolor(TEMPORARY, BACKGROUND);
    }
 

 
    public void restore() {
        resetTemp();
        maze.recolor(PATH, BACKGROUND);
        maze.recolor(NON_BACKGROUND, BACKGROUND);
    }
    
}

