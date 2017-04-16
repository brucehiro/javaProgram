package tw.edu.bio.thu;

import javax.swing.JOptionPane;

public class Java20170404_3_PrimeNumber {

	public static void main(String[] args) {
		boolean[] Number = new boolean[1001];
		int input;
		
		input = Integer.parseInt(JOptionPane.showInputDialog("Input a number:"));
		
		for(int i = 2; i <= input; i++)
		{
			if(Number[i] == false)
			{
				for(int j = i+1; j <= input; j++)
				{
					if(j % i == 0)
					{
						Number[j] = true;
					}
				}
			}
		}
		
		for(int i = 1; i <= input; i++)
		{
			if(i == 1)
			{
				System.out.printf("%4d ",i);
			}
			else if(Number[i] == false)
			{
				System.out.printf("%4d*",i);
			}
			else
			{
				System.out.printf("%4d ",i);
			}
			
			if(i % 10 == 0)
			{
				System.out.println("");
			}
			
		}

	}

}
