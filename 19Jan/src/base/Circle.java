package base;

class Circle 
{
	private double radius;
	private String colour;

	Circle(double r)
	{
		radius = r;
		colour = "Red";
	}
	
	public Circle(double radius, String colour)
	{
		this.radius=radius;
		this.colour=colour;
	}
	public Circle(String string, double d) 
	{
		
	}

	public String toString() 
	{
		   return "Circle[radius=" + radius + " colour=" + colour + "]";
	}
	
	
	void setColour(String colour)
	{
		this.colour=colour;
	}
	
	double getArea()
	{
		return radius*radius*Math.PI;
	}
	
	double getRadius()
	{
		return radius;
	}
	
	String getColour()
	{
		return colour;
	}

}
