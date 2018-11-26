package geometry;
public class emptyTriangle3 
{
	public static void main(String[] args) 
	{
		for(int j = 0; j < 7; j++)
		{
			System.out.print('\n');
			for(int i = 3; i > -1; i--)
				if(i == j | i == 6 - j | i == j - j)
					System.out.print("* ");
				else System.out.print("  ");
		}
	}
}