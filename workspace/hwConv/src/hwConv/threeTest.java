package hwConv;

import static org.junit.Assert.*;

import org.junit.Test;

public class threeTest 
{
	@Test
	public void gil1() 
	{
	double a = three.gil(73);
	assertEquals(513.847, a, 0.001);
	}
	@Test (expected = IllegalArgumentException.class)
	public void gil2() 
	{
	three.gil(-95);
	}
	@Test
	public void pin1() 
	{
	double a = three.pin(44);
	assertEquals(77.44, a, 0.001);
	}
	@Test (expected = IllegalArgumentException.class)
	public void pin2() 
	{
	three.pin(-95);
	}
	@Test
	public void kva1() 
	{
	double a = three.kva(28);
	assertEquals(24.64, a, 0.001);
	}
	@Test (expected = IllegalArgumentException.class)
	public void kva2() 
	{
	three.kva(-95);
	}
	@Test
	public void gal1() 
	{
	double a = three.gal(81);
	assertEquals(17.82, a, 0.001);
	}
	@Test (expected = IllegalArgumentException.class)
	public void gal2() 
	{
	three.gal(-95);
	}
	@Test
	public void bar1() 
	{
	double a = three.bar(30);
	assertEquals(0.18, a, 0.001);
	}
	@Test (expected = IllegalArgumentException.class)
	public void bar2() 
	{
	three.bar(-95);
	}

}
