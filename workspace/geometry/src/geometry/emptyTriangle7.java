package geometry;
public class emptyTriangle7 
{
	public static void main(String[] args) 
	{
		for(int i = 0; i < 7; i++)
		{
			System.out.print('\n');
			for(int j = 0; j < 7; j++)
				if(i == 6 | j == 6 | i == 6 - j)
					System.out.print("* ");
				else System.out.print("  ");
		}
	}
}