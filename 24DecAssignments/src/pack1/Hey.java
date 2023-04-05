package pack1;

class Oops 
{
	int x = 12;
	public static void add()
	{
		System.out.println("in oops add mehtos");
	}
}

class Hey extends Oops
{
	public static void main(String[] args) 
	{
		Oops.add();
		Oops  o = new Oops();
		System.out.println(" vlau is "+o.x);
		
	}
	
	
	


}