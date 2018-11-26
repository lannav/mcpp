package charAndString;

import static org.junit.Assert.*;

import org.junit.Test;

public class strToIntTest 
{
	@Test
	public void test_85278962() 
	{
		int a = block2.str_to_int("85278962");
		assertEquals(a, 85278962);
	}
	@Test
	public void test_0() 
	{
		int a = block2.str_to_int("0");
		assertEquals(a, 0);
	}
	@Test
	public void test_8527() 
	{
		int a = block2.str_to_int("8527");
		assertEquals(a, 8527);
	}

}
