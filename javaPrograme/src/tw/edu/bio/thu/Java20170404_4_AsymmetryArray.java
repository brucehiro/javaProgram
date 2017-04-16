package tw.edu.bio.thu;

public class Java20170404_4_AsymmetryArray {

	public static void main(String[] args) {
		int[][] a;
		a = new int[2][];
		a[0] = new int []{1,2,3};
		a[1] = new int []{4,5};
		
		for(int i = 0; i < a.length; i++)
		{
			for(int j = 0; j < a[i].length; j++)
			{
				System.out.printf("%d ",a[i][j]);
			}
			
			System.out.println("");
		}

	}

}
