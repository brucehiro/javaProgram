package tw.edu.bio.thu;

public class Java20170404_1 {

	public static void main(String[] args) {
		int a = 10; int b = 3;
		
		if(a-- >= 10 && b++ <= 3)
		{
			System.out.println("ok " + " a: " + a + " b: " + b);
		}
		else
		{
			System.out.println("xx" + "a: " + a + " b: " + b);
		}
		
		int c = 10; int d = 3;
		
		if(--c >= 10 && ++b <= 3)
		{
			System.out.println("ok " + "c: " + c + " d: " + d);
		}
		else
		{
			System.out.println("xx " + "c: " + c + " d: " + d);
		}
	}

}
