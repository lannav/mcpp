package geometry;
public class emptyTriangle6 
{
	public static void main(String[] args) 
	{
		for(int j = 0; j < 7; j++)
		{
			System.out.print('\n');
			for(int i = 0; i < 7; i++)
				if(j == 0 | j == i | i == 6)
					System.out.print("* ");
				else System.out.print("  ");
		}
	}
}