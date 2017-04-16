package tw.edu.bio.thu;

public class Class_bike {
	private double speed;
	private String color = new String();
	
	Class_bike()
	{
		this(0);
	}
	Class_bike(int speed)
	{
		this(1.0*speed,"White");
	}
	Class_bike(double speed, String color)
	{
		this.speed = speed;
		this.color = color;
	}
	
	double getSpeed()
	{
		return speed;
	}
	
	String getColor()
	{
		return color;
	}
}
