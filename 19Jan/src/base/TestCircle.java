package base;

import java.util.Scanner;

public class TestCircle
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int ar[][] = new int[a][b];
		for (int i=0;i<a;i++)
		{
			for (int j=0;j<b;j++)
			{
				ar[i][j] = sc.nextInt();
				
			}
		}
		
		for (int i=0;i<a;i++)
		{
			for (int j=0;j<b;j++)
			{
				System.out.println("The vl is "+ar[i][j]);
				
			}
		}
		
		
		sc.close();
		
		
	}	

}
