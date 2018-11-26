package geometry;
public class triangle4 
{
	public static void main(String[] args) 
	{
		for(int j = 0; j < 7; j++)
		{
			System.out.print('\n');
			for(int i = 3; i > -1; i--)
				switch(i)
				{
				case 0: System.out.print("* "); break;
				case 1: if(j > 0 && j < 6) System.out.print("* "); else System.out.print("  "); break;
				case 2: if(j > 1 && j < 5) System.out.print("* "); else System.out.print("  "); break;
				case 3: if(j == 3) System.out.print("* "); else System.out.print("  "); break;
					
				}
		}
	}
}