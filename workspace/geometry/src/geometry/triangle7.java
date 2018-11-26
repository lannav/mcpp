package geometry;
public class triangle7 
{
	public static void main(String[] args) 
	{
		for(int i = 0; i < 7; i++)
		{
			System.out.print('\n');
			for(int j = 0; j < 7; j++)
				if(i == 6 - j | i == 5 - j | i == 4 - j | i == 3 - j | i == 2 - j | i == 1 - j | i == 0)
					System.out.print("* ");
				else System.out.print("  ");
		}
	}
}