import java.util.ArrayList;

public class Fridge implements Cloneable 
{

	public ArrayList<Integer> hist = new ArrayList<Integer>();
	public boolean fr[][] = new boolean[4][4];
	
	public void init(boolean[][] ini)
	{
		for(int i = 0; i < 16; i++)
			fr[i/4][i%4] = ini[i/4][i%4];
	}
	
	public void open()
	{
		new Unlock(this);
	}

	public void turn(int j) 
	{
		for(int i = 0; i < 4; i++)
		{
			fr[j/4][i] = !fr[j/4][i];
			fr[i][j%4] = !fr[i][j%4];
		}
		fr[j/4][j%4] = !fr[j/4][j%4];
		hist.add(j);
	}

	public boolean check() 
	{
		for(int i = 0; i < 16; i++)
		{
			if(!fr[i/4][i%4])
			return false;
		}
		return true;
	}
	
	@Override
	public Object clone()
	{
		Fridge clone = new Fridge();
		clone.init(fr);
		for(Integer i:hist)
			clone.hist.add(i);
		return clone;
	}
	
	@Override
	public String toString()
	{
		String result = "";
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 4; j++)
				result += fr[i][j] + " ";
			result += "\n";
		}
		return result;
	}

}
