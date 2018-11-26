package charAndString;

import static org.junit.Assert.*;

import org.junit.Test;

public class strToDouble 
{
	@Test
	public void test_85278962() 
	{
		double a = block2.str_to_double("8527.8962");
		assertEquals(a, 8527.8962, 0.00001);
	}
	@Test
	public void test_0() 
	{
		double a = block2.str_to_double("0");
		assertEquals(a, 0, 0.00001);
	}
	@Test
	public void test_8527() 
	{
		double a = block2.str_to_double("85.27");
		assertEquals(a, 85.27, 0.00001);
	}

}
