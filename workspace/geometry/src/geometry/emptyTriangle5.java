package geometry;
public class emptyTriangle5 
{
	public static void main(String[] args) 
	{
		for(int i = 0; i < 7; i++)
		{
			System.out.print('\n');
			for(int j = 0; j < 7; j++)
				if(j == 0 | j == i | i == 6)
					System.out.print("* ");
				else System.out.print("  ");
		}
	}
}