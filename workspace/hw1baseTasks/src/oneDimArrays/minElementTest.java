package oneDimArrays;
import static org.junit.Assert.*;

import org.junit.Test;

public class minElementTest 
{
	@Test (expected = IllegalArgumentException.class)
	public void arr_ex_null() 
	{
		int[] a = null;
		arr.min(a);
	}
	@Test (expected = IllegalArgumentException.class)
	public void arr_ex_0() 
	{
		int[] a = {};
		arr.min(a);
	}
	@Test
	public void arr_1() 
	{
		int[] a = {8};
		int min = arr.min(a);
		assertEquals(8, min);
	}
	@Test
	public void arr_2() 
	{
		int[] a = {8,3};
		int min = arr.min(a);
		assertEquals(3, min);
	}
	@Test
	public void arr_many() 
	{
		int[] a = {8,2,3,5,7,2,6};
		int min = arr.min(a);
		assertEquals(2, min);
	}

}
