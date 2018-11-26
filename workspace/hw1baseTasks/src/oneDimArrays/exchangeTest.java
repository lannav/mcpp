package oneDimArrays;
import static org.junit.Assert.*;

import org.junit.Test;

public class exchangeTest 
{
	@Test (expected = IllegalArgumentException.class)
	public void arr_ex_null() 
	{
		int[] a = null;
		arr.exchange(a);
	}
	@Test (expected = IllegalArgumentException.class)
	public void arr_ex_0() 
	{
		int[] a = {};
		arr.exchange(a);
	}
	@Test
	public void arr_1() 
	{
		int[] a = {8};
		a = arr.exchange(a);
		int[] res = {8};
		assertArrayEquals(a, res);
	}
	@Test
	public void arr_2() 
	{
		int[] a = {8,3};
		a = arr.exchange(a);
		int[] res = {3,8};
		assertArrayEquals(a, res);
	}
	@Test
	public void arr_many_nechet() 
	{
		int[] a = {8,9,3,5,7,2,6};
		a = arr.exchange(a);
		int[] res = {7,2,6,5,8,9,3};
		assertArrayEquals(a, res);
	}
	@Test
	public void arr_many_chet() 
	{
		int[] a = {8,9,3,7,2,6};
		a = arr.exchange(a);
		int[] res = {7,2,6,8,9,3};
		assertArrayEquals(a, res);
	}

}
