package hwConv;

import static org.junit.Assert.*;

import org.junit.Test;

public class fourTest 
{
	@Test
	public void kar1() 
	{
	double a = four.kar(43);
	assertEquals(215.0, a, 0.001);
	}
	@Test (expected = IllegalArgumentException.class)
	public void kar2() 
	{
	four.kar(-95);
	}
	@Test
	public void grn1() 
	{
	double a = four.grn(52);
	assertEquals(802.36, a, 0.001);
	}
	@Test (expected = IllegalArgumentException.class)
	public void grn2() 
	{
	four.grn(-95);
	}
	@Test
	public void drh1() 
	{
	double a = four.drh(70);
	assertEquals(39.508, a, 0.001);
	}
	@Test (expected = IllegalArgumentException.class)
	public void drh2() 
	{
	four.drh(-95);
	}
	@Test
	public void unc1() 
	{
	double a = four.unc(25);
	assertEquals(0.88175, a, 0.001);
	}
	@Test (expected = IllegalArgumentException.class)
	public void unc2() 
	{
	four.unc(-95);
	}
	@Test
	public void myt1() 
	{
	double a = four.myt(86);
	assertEquals(26539.6, a, 0.001);
	}
	@Test (expected = IllegalArgumentException.class)
	public void myt2() 
	{
	four.myt(-95);
	}

}
