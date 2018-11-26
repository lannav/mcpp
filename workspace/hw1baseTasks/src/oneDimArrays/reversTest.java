package oneDimArrays;
import static org.junit.Assert.*;

import org.junit.Test;

public class reversTest 
{
	@Test (expected = IllegalArgumentException.class)
	public void arr_ex_null() 
	{
		int[] a = null;
		arr.revers(a);
	}
	@Test (expected = IllegalArgumentException.class)
	public void arr_ex_0() 
	{
		int[] a = {};
		arr.revers(a);
	}
	@Test
	public void arr_1() 
	{
		int[] a = {8};
		a = arr.revers(a);
		int[] rev = {8};
		assertArrayEquals(a, rev);
	}
	@Test
	public void arr_2() 
	{
		int[] a = {8,3};
		a = arr.revers(a);
		int[] rev = {3,8};
		assertArrayEquals(a, rev);
	}
	@Test
	public void arr_many_nechet() 
	{
		int[] a = {8,9,3,5,7,2,6};
		a = arr.revers(a);
		int[] rev = {6,2,7,5,3,9,8};
		assertArrayEquals(a, rev);
	}
	@Test
	public void arr_many_chet() 
	{
		int[] a = {9,3,7,2,6,7};
		a = arr.revers(a);
		int[] rev = {7,6,2,7,3,9};
		assertArrayEquals(a, rev);
	}
	
}
