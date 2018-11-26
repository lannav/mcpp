import static org.junit.Assert.*;

import org.junit.Test;

public class test 
{
	@Test
	public void toArray_many() 
	{
		BsTree tr = new BsTree();
		int[] ini = {50,25,11,7,34,18,70,90,28,65,35,64,66,89,91};
		tr.init(ini);
		int[] exp = {7,11,18,25,28,34,35,50,64,65,66,70,89,90,91};
		int[] res = tr.toArray();
		for(int i = 0; i < 15; i++)
		System.out.print(res[i]+" ");
		assertArrayEquals(exp, tr.toArray());
	}
}
