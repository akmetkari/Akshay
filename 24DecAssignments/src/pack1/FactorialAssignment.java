package pack1;

import java.util.Scanner;

public class FactorialAssignment 
{
	public static void main(String[] args) 
	{

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your No");
		int n = sc.nextInt();
		int Fact =1;
		for(int i=1;i<=n;i++)
		{
			Fact = Fact*i;
			
		}	
		System.out.println("The factorial is "+Fact);
	
		sc.close();
	}
	
}

