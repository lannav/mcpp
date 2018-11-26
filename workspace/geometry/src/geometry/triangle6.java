package geometry;
public class triangle6 
{
	public static void main(String[] args) 
	{
		for(int i = 0; i < 7; i++)
		{
			System.out.print('\n');
			for(int j = 0; j < 7; j++)
				if(i == j | i == j + 1 | i == j + 2 | i == j + 3 | i == j + 4 | i == j + 5 | i == j + 6)
					System.out.print("* ");
				else System.out.print("  ");
		}
	}
}