package tw.edu.bio.thu;

public class Java20170405_bike {

	public static void main(String[] args) {
		Class_bike b1 = new Class_bike();
		System.out.println(b1.getSpeed());
		System.out.println(b1.getColor());
		
		Class_bike b2 = new Class_bike(10);
		System.out.println(b2.getSpeed());
		System.out.println(b2.getColor());
		
		Class_bike b3 = new Class_bike(10,"black");
		System.out.println(b3.getSpeed());
		System.out.println(b3.getColor());

	}

}
