package oneDimArrays;
import static org.junit.Assert.*;

import org.junit.Test;

public class indexMinTest 
{
	@Test (expected = IllegalArgumentException.class)
	public void arr_ex_null() 
	{
		int[] a = null;
		arr.minIndex(a);
	}
	@Test (expected = IllegalArgumentException.class)
	public void arr_ex_0() 
	{
		int[] a = {};
		arr.minIndex(a);
	}
	@Test
	public void arr_1() 
	{
		int[] a = {8};
		int min = arr.minIndex(a);
		assertEquals(0, min);
	}
	@Test
	public void arr_2() 
	{
		int[] a = {8,3};
		int min = arr.minIndex(a);
		assertEquals(1, min);
	}
	@Test
	public void arr_many() 
	{
		int[] a = {8,9,3,5,7,2,6};
		int min = arr.minIndex(a);
		assertEquals(5, min);
	}
}
