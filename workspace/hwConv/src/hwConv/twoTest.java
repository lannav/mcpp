package hwConv;

import static org.junit.Assert.*;

import org.junit.Test;

public class twoTest 
{
	@Test
	public void pletr1() 
	{
	double a = two.pletr(95);
	assertEquals(3.064, a, 0.001);
	}
	@Test (expected = IllegalArgumentException.class)
	public void pletr2() 
	{
	two.pletr(-1);
	}
	@Test
	public void mrMile1() 
	{
	double a = two.mrMile(49);
	assertEquals(0.026, a, 0.001);
	}
	@Test (expected = IllegalArgumentException.class)
	public void mrMile2() 
	{
	two.mrMile(-1);
	}
	@Test
	public void stad1() 
	{
	double a = two.stad(14);
	assertEquals(0.075, a, 0.001);
	}
	@Test (expected = IllegalArgumentException.class)
	public void stad2() 
	{
	two.stad(-1);
	}
	@Test
	public void furl1() 
	{
	double a = two.furl(73);
	assertEquals(0.362, a, 0.001);
	}
	@Test (expected = IllegalArgumentException.class)
	public void furl2() 
	{
	two.furl(-1);
	}
	@Test
	public void cheyn1() 
	{
	double a = two.cheyn(66);
	assertEquals(3.280, a, 0.001);
	}
	@Test (expected = IllegalArgumentException.class)
	public void cheyn2() 
	{
	two.cheyn(-1);
	}
}
