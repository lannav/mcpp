package oneDimArrays;
import static org.junit.Assert.*;

import org.junit.Test;

public class sumNechetTest 
{
	@Test (expected = IllegalArgumentException.class)
	public void arr_ex_null() 
	{
		int[] a = null;
		arr.numNechet(a);
	}
	@Test (expected = IllegalArgumentException.class)
	public void arr_ex_0() 
	{
		int[] a = {};
		arr.numNechet(a);
	}
	@Test
	public void arr_1() 
	{
		int[] a = {7};
		int sum = arr.numNechet(a);
		assertEquals(1, sum);
	}
	@Test
	public void arr_2() 
	{
		int[] a = {8,2};
		int sum = arr.numNechet(a);
		assertEquals(0, sum);
	}
	@Test
	public void arr_many() 
	{
		int[] a = {8,2,3,5,7,9,6};
		int sum = arr.numNechet(a);
		assertEquals(4, sum);
	}

}
