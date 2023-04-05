package module3;

public class Checkprime 
{

	public static void main(String[] args) 
	{
		int primeCheck=3;
		int counter=0;
		for(int i=2;i<primeCheck-1;i++)
		{
			if(primeCheck%i==0)
			{
				counter++;
			}
		}
		if(counter>0)
		{
			System.out.println("no is not prime");
		}
		else 
			System.out.println("no is prime");
		
	}
	
}
