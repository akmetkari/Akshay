package pack1;

public class Car 
{
	public static void main(String[] args) 
	{
		Tata t = new Tata();
		t.name();
		
	}
	
	
	void name()
	{
		System.out.println("Car name is ");
	}
	
	void engineOn()
	{
		
	}
	
}


class Tata extends Car
{
	

}