package libraryMath;

import static org.junit.Assert.*;

import org.junit.Test;

public class gaubitsaTest 
{
	@Test
	public void test1() 
	{
	double a = function.rastRad(0,1.5);
	assertEquals(a, 0.0, 0.001);
	}
	@Test
	public void test2() 
	{
	double a = function.rastRad(36,0);
	assertEquals(a, 0.0, 0.001);
	}
	@Test
	public void test3() 
	{
	double a = function.rastRad(36,0.84);
	assertEquals(a, 10.132, 0.001);
	}
	@Test (expected = IllegalArgumentException.class)
	public void test4() 
	{
	function.rastRad(30,3);
	}
	@Test (expected = IllegalArgumentException.class)
	public void test5() 
	{
	function.rastRad(32,-1);
	}
	@Test (expected = IllegalArgumentException.class)
	public void test6() 
	{
	function.rastRad(-57,0.55);
	}
	@Test
	public void test10() 
	{
	double a = function.rastGrad(0,35);
	assertEquals(a, 0.0, 0.001);
	}
	@Test
	public void test20() 
	{
	double a = function.rastGrad(42,0);
	assertEquals(a, 0.0, 0.001);
	}
	@Test
	public void test30() 
	{
	double a = function.rastGrad(38, 39);
	assertEquals(a, 11.109, 0.001);
	}
	@Test (expected = IllegalArgumentException.class)
	public void test40() 
	{
	function.rastGrad(30, 98);
	}
	@Test (expected = IllegalArgumentException.class)
	public void test50() 
	{
	function.rastGrad(32,-20);
	}
	@Test (expected = IllegalArgumentException.class)
	public void test60() 
	{
	function.rastGrad(-57,65);
	}

}
