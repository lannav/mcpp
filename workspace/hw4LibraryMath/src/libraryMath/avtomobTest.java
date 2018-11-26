package libraryMath;

import static org.junit.Assert.*;

import org.junit.Test;

public class avtomobTest 
{
	@Test
	public void rast_211() 
	{
		int a = function.rast(10, 20, 1, 7);
		assertEquals(a, 211);
	}
	@Test
	public void rast_0() 
	{
		int a = function.rast(0, 0, 0, 0);
		assertEquals(a, 0);
	}
	@Test (expected = IllegalArgumentException.class)
	public void rast_ex_m10() 
	{
		function.rast(-10, 20, 1, 7);
	}
	@Test (expected = IllegalArgumentException.class)
	public void rast_ex_m20() 
	{
		function.rast(10, -20, 1, 7);
	}
	@Test (expected = IllegalArgumentException.class)
	public void rast_ex_m1() 
	{
		function.rast(10, 20, -1, 7);
	}
	@Test (expected = IllegalArgumentException.class)
	public void rast_ex_m7() 
	{
		function.rast(10, 20, 1, -7);
	}

}
