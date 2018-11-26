package charAndString;

import static org.junit.Assert.*;

import org.junit.Test;

public class intToStrTest 
{
	@Test
	public void int_to_str_8921387() 
	{
		String res = block2.int_to_str(8921387);
		assertEquals(res, "8921387");
	}
	@Test
	public void int_to_str_0() 
	{
		String res = block2.int_to_str(0);
		assertEquals(res, "0");
	}
	@Test
	public void int_to_str_509() 
	{
		String res = block2.int_to_str(509);
		assertEquals(res, "509");
	}

}
