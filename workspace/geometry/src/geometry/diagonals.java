package geometry;
public class diagonals
{
	public static void main(String[] args) 
	{
		for(int j = 0; j < 7; j++)
		{
			System.out.print('\n');
			for(int i = 0; i < 7; i++)
				if(i == j | i == 6 - j)
					System.out.print("* ");
				else System.out.print("  ");
		}
	}
}