package geometry;
public class emptyTriangle1 
{
	public static void main(String[] args) 
	{
		for(int i = 3; i > -1; i--)
		{
			System.out.print('\n');
			for(int j = 0; j < 7; j++)
				if(i == j | i == 6 - j | i == j - j)
					System.out.print("* ");
				else System.out.print("  ");
		}
	}
}