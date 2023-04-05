package pack1;
import java.util.Scanner;
public class waterCharge 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int usage = sc.nextInt();
		if (usage>0)
		{	
			if (usage<500)
			{
				System.out.println("No cost");
			}
			else if (usage>=500 && usage<=1000)
			{
				System.out.println("water bill is "+4*usage);
			}
			else if(usage>1000)
			{
				System.out.println("water bill is "+7*usage);
			}
		}
		else 
		{
			System.out.println("invalid input");
		}
	
		sc.close();
	}	
}
