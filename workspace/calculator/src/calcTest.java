import static org.junit.Assert.*;

import org.junit.Test;

public class calcTest 
{
	@Test
	public void test1() 
	{
	int res = calc.clc(5, 8, '+');
	assertEquals(13, res);
	}
	@Test
	public void test2() 
	{
	int res = calc.clc(5, 0, '*');
	assertEquals(0, res);
	}
	@Test
	public void test3() 
	{
	int res = calc.clc(25, 5, '/');
	assertEquals(5, res);
	}
	@Test
	public void test4() 
	{
	int res = calc.clc(7, 5, '-');
	assertEquals(2, res);
	}
	@Test (expected = IllegalArgumentException.class)
	public void test5() 
	{
	calc.clc(7, 0, '/');
	}
	@Test (expected = IllegalArgumentException.class)
	public void test6() 
	{
	calc.clc(8, 4, 'a');
	}

}
