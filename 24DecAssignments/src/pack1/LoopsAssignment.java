package pack1;
import java.util.Scanner;
public class LoopsAssignment
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your No");
		int n = sc.nextInt();
		System.out.println("Entered No is"+n);
		int sum=0;
		for (int i=0;i<n+1;i++)
		{
			sum = sum+i;
		}
		System.out.println("The sum is"+sum);
		sc.close();
	}
}
