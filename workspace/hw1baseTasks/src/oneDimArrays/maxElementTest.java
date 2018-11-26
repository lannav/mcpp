package oneDimArrays;
import static org.junit.Assert.*;

import org.junit.Test;

public class maxElementTest 
{
	@Test (expected = IllegalArgumentException.class)
	public void arr_ex_null() 
	{
		int[] a = null;
		arr.max(a);
	}
	@Test (expected = IllegalArgumentException.class)
	public void arr_ex_0() 
	{
		int[] a = {};
		arr.max(a);
	}
	@Test
	public void arr_1() 
	{
		int[] a = {8};
		int max = arr.max(a);
		assertEquals(8, max);
	}
	@Test
	public void arr_2() 
	{
		int[] a = {8,3};
		int max = arr.max(a);
		assertEquals(8, max);
	}
	@Test
	public void arr_many() 
	{
		int[] a = {8,2,3,5,7,9,6};
		int max = arr.max(a);
		assertEquals(9, max);
	}

}
