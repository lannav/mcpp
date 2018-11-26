package oneDimArrays;

import static org.junit.Assert.*;

import org.junit.Test;

public class insertSortTestTest 
{

	@Test (expected = IllegalArgumentException.class)
	public void arr_ex_null() 
	{
		int[] a = null;
		arr.insert(a);
	}
	@Test (expected = IllegalArgumentException.class)
	public void arr_ex_0() 
	{
		int[] a = {};
		arr.insert(a);
	}
	@Test
	public void arr_1() 
	{
		int[] a = {8};
		a = arr.insert(a);
		int[] rev = {8};
		assertArrayEquals(a, rev);
	}
	@Test
	public void arr_2() 
	{
		int[] a = {8,3};
		a = arr.insert(a);
		int[] rev = {3,8};
		assertArrayEquals(a, rev);
	}
	@Test
	public void arr_many() 
	{
		int[] a = {8,9,3,5,7,2,6};
		a = arr.insert(a);
		int[] rev = {2,3,5,6,7,8,9};
		assertArrayEquals(a, rev);
	}

}