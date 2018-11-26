package geometry;
public class emptyTriangle4 
{
	public static void main(String[] args) 
	{
		for(int j = 0; j < 7; j++)
		{
			System.out.print('\n');
			for(int i = 0; i < 4; i++)
				if(i == j | i == 6 - j | i == j - j)
					System.out.print("* ");
				else System.out.print("  ");
		}
	}
}