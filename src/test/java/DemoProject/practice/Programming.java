package DemoProject.practice;

import java.util.HashMap;
import java.util.Scanner;

import org.testng.annotations.Test;
public class Programming {

		@Test
		public void swaptwostrings()
		{
		String s1="Manohar";
		String s2="Kokkerigedda";
		s1=s1+s2;
		s2=s1.substring(0,s1.length()-s2.length());
		s1=s1.substring(s2.length());
		System.out.println("S1 String is "+s1);
		System.out.println("S2 String is "+s2);
		}
		@Test
		//series with Sum of the previous two numbers
		public void fibanacciSeries()
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter fibanacci number:");
			int fiblength=sc.nextInt();
			int n[]=new int[fiblength];
			n[0]=0;
			n[1]=1;
			for(int i=2;i<fiblength;i++)
			{
			n[i]=n[i-1]+n[i-2];
			}
			for(int i=0;i<fiblength;i++)
			{
			System.out.println(n[i]);
			}
		}
		@Test
		//Sum of the Cubes of each digit is equal to Number 
		public void ArmStrong()
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter InputNumber:");
			int n=sc.nextInt();
			int temp=n;
			int sum=0;
			int r;
			while(n>0)
			{
				r=n%10;
				sum=sum+(r*r*r);
				n=n/10;
			}
			if(sum==temp)
			{
				System.out.println("ArmStrong");
			}
			else
			{
				System.out.println("Not a ArmStrong");
			}
		}
		//Write a Program to print sum of the digits of an Integer
		@Test
		public void sumOfdigitsOfInteger()
		{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Number:");
		int n=sc.nextInt();
		int r,sum=0;
		while(n>0)
		{
			r=n%10;
			n=n/10;
			sum=sum+r;
		}
		System.out.println("Sum is"+sum);
		}
		//Write a Java Program to check if a number is prime or not
		//A prime number is a number which is divisible by 1 and itself.
		@Test
		public void checkPrime()
		{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Number:");
		int n=sc.nextInt();
		if(n==2)
		{
			System.out.println("2 is a even Prime Number");	
		}
		if(n<2)
		{
			System.out.println("Not a Prime Number");
		}
		else if(n>2)
		{
			if(n%2>0)
			{
			System.out.println("Prime Number");
			}
			else
			{
				System.out.println("Not a Prime Number");	
			}
		}
		}
		@Test
		public void countNoofCharsInString()
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the inputString:");
			String inputString=sc.next();
			HashMap<Character,Integer> hashmap=new HashMap();
			char[] strArray=inputString.toCharArray();
			for(char c:strArray)
			{
				if(hashmap.containsKey(c))
				{
					hashmap.put(c,hashmap.get(c)+1);
				}
				else
				{
					hashmap.put(c,1);
				}
			}
			System.out.println(hashmap);
			
		}
		
		//Write a Program to find duplicates of a Given String
		@Test
		public void swapTwoNumbers()
		{
			int a=25;int b=34;
			System.out.println("Before the Value of a is "+a);
			System.out.println("Before the Value of b is "+b);
			a=a+b;
			b=a-b;
			a=a-b;
			System.out.println("After the Value of a is "+a);
			System.out.println("After the Value of b is "+b);
		}
		@Test
		public void reverseanArray()
		{
			char[] s= {'a','e','d','e','f'};
			for(int i=s.length-1;i>=0;i--)
			{
				System.out.println(s[i]);
			}
		}
}