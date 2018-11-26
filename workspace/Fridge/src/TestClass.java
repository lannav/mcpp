
public class TestClass 
{
	public static void main(String[] args)
	{
		Fridge fr = new Fridge();
		boolean[][] ini = { {true, true,  false,  false}, 
			       {false,  true, false, true}, 
			       {true,  true, true, false}, 
			       {false,  false,  true,  false}};
		fr.init(ini);
		System.out.println(fr.toString());
		
//		fr.turn(5);
		fr.open();
//		System.out.println(fr.toString());
		
	}
	
}
