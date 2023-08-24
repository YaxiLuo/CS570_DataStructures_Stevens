package Maze;

public class PairInt {

	private int x;
	private int y;
	
	public PairInt(int x, int y)
	{
		this.x=x;
		this.y=y;
	}
	public int getX()
	{
		return x;
		
	}
	public int getY()
	{
		return y;
	}
	public void SetX(int x)
	{
		this.x=x;
	}
	public void SetY(int y)
	{
		this.y=y;
	}
	public boolean equals (Object p)
	{
		PairInt pi= (PairInt)p;
		if(pi.x==this.x && pi.y== this.y)
		{
			return true;
		}
		return false;
	}
	public String toString()
	{
		return "("+x+","+y+")";
	}
	public PairInt copy()
	{
		return new PairInt(x,y);
	}
}
