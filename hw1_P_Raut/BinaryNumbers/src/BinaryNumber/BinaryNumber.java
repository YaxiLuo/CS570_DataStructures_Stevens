package BinaryNumber;
import java.util.Arrays;
import java.lang.String;
import java.math.*;
import java.util.*;
public class BinaryNumber {
	private int data[];
	private boolean overflow;
	
	public BinaryNumber(int length) 
	{
		data=new int[length];
		
	
	}
	
	
	
	public BinaryNumber(String str) {
		int n1=str.length();
		data = new int[n1];
		for(int i=0;i<n1;i++)
		{
			int value= Character.getNumericValue(str.charAt(i));
			data[i] = value;
		}
	}
	
	
	private String reverse(String input) {
		char[] a=input.toCharArray();
		int left,right=0;
		for(left=0;left<right;left++,right--)
		{
			char ter=a[left];
			a[left]=a[right];
			a[right]=ter;
		}
		return String.valueOf(a);
		
	}
	public int getLength()
	{
		return data.length;
	}
	 public int digit(int index)
	  {
	 
		return data[index];
	 
	 
	  }
	 
	private void rellocate(int amount)
	{
		data=new int[data.length+amount];
		
	}
	public void shiftR(int amount)
	{
		rellocate(amount);
		for(int i=0;i<data.length;i++)
		{
			int[] copy=Arrays.copyOf(data,amount);
			//System.out.println("\nNew array after modifications");
			/*for(int j=0;i<copy.length;j++) {
				System.out.println(copy[j]+ "");
			
		}*/
		
		}
	}
	public static int add( int BinaryNumber, int aBinaryNumber)
	{
	int i=1,carry=0;
	int sum=0;
	while(BinaryNumber>0||aBinaryNumber>0||carry>0)
	{
		int digit1=BinaryNumber%10;
		BinaryNumber=BinaryNumber/10;
		
		int digit2=aBinaryNumber%10;
		aBinaryNumber=aBinaryNumber/10;
		
		int digit=digit1+digit2+carry;
	carry=digit/2;
	digit=digit%2;
	sum=sum+digit*i;
	i=i*10;
	
	}
      return sum;
	}
	
	public String toString() {
		String s = "";
		for( int i : data)
			s=s+i;
		return s;
	}
	
	public int toDecimal()
	{
		//int decimal=Integer.parseInt(data,2);
		int sum=0;
		for(int i=0;i<data.length;i++)
		{
			sum +=(data[i]*(Math.pow(2, i)));
		}
		return sum;
		
	}
	public boolean clearOverflow()
	{
	return overflow = false;	
	}
	
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		BinaryNumber b=new BinaryNumber(4);
		BinaryNumber b1=new BinaryNumber("1011");
		
		System.out.println(b);
		System.out.println(b1);
		System.out.println(b1.getLength());
		System.out.println(b1.digit(0));
		System.out.println(b1.toDecimal());
	    b1.shiftR(3);
	    System.out.println(b1);
	    System.out.println("Enter first Binary Number:");
	    int n1=sc.nextInt();
	    System.out.println("Enter first Binary Number:");
	    int n2=sc.nextInt();
	    int sum=add(n1,n2);
	    System.out.println("Sum of Both binary Numbers="+sum);
	    System.out.println(b1.toString());
	  
		
	}
			

}
