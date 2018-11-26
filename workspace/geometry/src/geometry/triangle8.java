package geometry;
public class triangle8 
{
	public static void main(String[] args) 
	{
		for(int i = 6; i > -1; i--)
		{
			for(int j = 0; j < 7; j++)
				if(i <= j)
					System.out.print("* ");
				else System.out.print("  ");
			System.out.print('\n');
		}
	}
}