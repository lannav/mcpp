import java.util.ArrayList;

public class Unlock 
{
	ArrayList<ArrayList<Integer>> ways = new ArrayList<ArrayList<Integer>>();
	int limit = 10;
	
	public Unlock(Fridge fr)
	{
		action(fr, limit);
		print();
	}
	
	private void action(Fridge fr, int lvl)
	{
//		if(fr.check())
//		{
//			ways.add(fr.hist);
//			return;
//		}
		
		if(lvl == 0 || fr.check())
			return;
		
		for(int i = 0; i < 16; i++)
		{
			if(fr.hist.contains(i))
			{
				continue;
			}
	//		System.out.println(fr.toString());
			Fridge clone = (Fridge) fr.clone();
			clone.turn(i);
			
			if(clone.check())
			{
				ways.add(clone.hist);
				continue;
			}
			action(clone, lvl - 1);
		}
	}

	private void print() 
	{
		for(ArrayList<Integer> al:ways)
			System.out.println(al.toString());
		System.out.println(ways.size());
	}
}
