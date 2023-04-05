import java.util.Scanner;

public class CheckPrime 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int no = sc.nextInt();
		int counter=0;
		System.out.println("Enter a no to check prime ");
		for (int i=2;i<no-1;i++)
		{
			if (no%i==0)
			{
				counter++;
			}
			
		}
		if (counter>0)
		{
			System.out.println(+no+ "is not prime");
			
		}
		else 
		{
			System.out.println("no is prime");
		}
		sc.close();
	}
}
