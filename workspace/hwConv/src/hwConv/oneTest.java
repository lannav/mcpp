package hwConv;

import static org.junit.Assert.*;

import org.junit.Test;

public class oneTest 
{
	@Test
	public void far1() 
	{
	double a = one.far(10);
	assertEquals(50, a, 0.001);
	}
	@Test
	public void far2() 
	{
	double a = one.far(0);
	assertEquals(32, a, 0.001);
	}
	@Test (expected = IllegalArgumentException.class)
	public void far3() 
	{
	one.far(-274);
	}
	@Test
	public void kel1() 
	{
	double a = one.kel(5);
	assertEquals(278, a, 0.001);
	}
	@Test
	public void kel2() 
	{
	double a = one.kel(0);
	assertEquals(273, a, 0.001);
	}
	@Test (expected = IllegalArgumentException.class)
	public void kel3() 
	{
	one.kel(-274);
	}
	@Test
	public void delil1() 
	{
	double a = one.delil(7);
	assertEquals(139.5, a, 0.001);
	}
	@Test
	public void delil2() 
	{
	double a = one.delil(0);
	assertEquals(150, a, 0.001);
	}
	@Test (expected = IllegalArgumentException.class)
	public void delil3() 
	{
	one.delil(-274);
	}
	@Test
	public void reomur1() 
	{
	double a = one.reomur(3);
	assertEquals(2.4, a, 0.001);
	}
	@Test
	public void reomur2() 
	{
	double a = one.reomur(0);
	assertEquals(0, a, 0.001);
	}
	@Test (expected = IllegalArgumentException.class)
	public void reomur3() 
	{
	one.reomur(-274);
	}
}
