package Complexity;
import java.math.*;
public class Complexity {
	//method to implement O(n)
	 public  static void method0(int n)
	{
		 int counter=0;
		for (int i=0;i<n;i++)
		{
			System.out.println("Operation "+counter);
			//System.out.print("\n");
			counter++;
		}
	}
	 //method to implement O(n^n)
	 public static void method1(int n)
	 {
		 int counter=0;
		 for(int i=0;i<n;i+=1)
		 {
			 for(int j=0;j<n;j++)
			 {
				 System.out.println("Operation "+counter);
				 //System.out.print("\n");
				 counter++;
			 }
			 
		 }
	 }
	 // method to implement O(n^3)
	 public static void method2(int n)
	 {
		 int counter=0;
		 for(int i=0;i<n;i++)
		 {
			 for (int j=0;j<n;j++)
			 {
				 for(int k=0;k<n;k++)
				 {
					 System.out.println("Operation "+counter);
					 //System.out.print("\n");
					 counter++;
				 }
				
			 }
		 }
		 
	 }
	 //method to implement O(log n)
	 public static void method3(int n)
	 {
		 int counter=0;
		 for(int i=1;i<n;i*=2)
		 {
			 System.out.println("Operation "+counter);
			 counter++;
			 
		 }
		  
	 }
	 //method to implement O(nlogn)
	 public static void method4(int n)
	 {
		 int counter=0;
		 for(int i=0;i<n;i++)
		 {
			 for(int j=1;j<i;j*=2)
			 {
				 System.out.println("Operation "+counter);
				 counter++;
			 }
		 }
	 }
	 //method to implement O(log(logn))
	 public static void method5(int n)
	 {
		 int counter=1;
		 for ( int i=2;i<=n;i=(int) Math.pow(i,counter))
		 {
			 System.out.println("Operation "+counter);
			 counter++;
		 }
	 }
	 //method to implement O(2^n)
	 public static int method6(int n)
	 {
		 
		 if(n<=1)
		 
			 return n;
		 
		 else
			return method6(n-1)+method6(n-2);
		 
		
	 }
	 public static void main(String args[])
	 {
		 Complexity obj=new Complexity();
		 Complexity obj1=new Complexity();
		 Complexity obj2=new Complexity();
		 Complexity obj3=new Complexity();
		 Complexity obj4=new Complexity();
		 Complexity obj5=new Complexity();
		 //Complexity obj6=new Complexity();
	     obj.method0(4);
	     obj1.method1(4);
		 obj2.method2(4);
		 obj3.method3(4);
		 obj4.method4(4);
		 obj5.method5(4);
		 System.out.println(method6(4));
		 
	 }
}
