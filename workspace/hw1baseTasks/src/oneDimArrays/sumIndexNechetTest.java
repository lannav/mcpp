package oneDimArrays;
import static org.junit.Assert.*;

import org.junit.Test;

public class sumIndexNechetTest 
{
	@Test (expected = IllegalArgumentException.class)
	public void arr_ex_null() 
	{
		int[] a = null;
		arr.sumNI(a);
	}
	@Test (expected = IllegalArgumentException.class)
	public void arr_ex_0() 
	{
		int[] a = {};
		arr.sumNI(a);
	}
	@Test
	public void arr_1() 
	{
		int[] a = {8};
		int sum = arr.sumNI(a);
		assertEquals(0, sum);
	}
	@Test
	public void arr_2() 
	{
		int[] a = {8,3};
		int sum = arr.sumNI(a);
		assertEquals(3, sum);
	}
	@Test
	public void arr_many() 
	{
		int[] a = {8,2,3,5,7,9,6};
		int sum = arr.sumNI(a);
		assertEquals(16, sum);
	}

}
