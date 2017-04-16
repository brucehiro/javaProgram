package tw.edu.bio.thu;

public class Java20170404_2_9x9 {

	public static void main(String[] args) {
		int i = 1;
		int j = 2;
		int k = 0;
		int line = 0;
		int result = 0;
		
		for(k=0; k < 2; k++)
		{	
			for(i = 1; i < 10; i++)
			{
				for(j = 2;j <= 5; j++)
				{
					line = j+4*k;
					result = line*i;
					System.out.print(line + "*" + i + "=" + result + "\t");
				}
			
				System.out.println("");
			}
		
			System.out.println("");
			

		}

	}
}
