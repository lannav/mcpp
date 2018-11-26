package charAndString;

import static org.junit.Assert.*;

import org.junit.Test;

public class doubleToStrTest 
{
	@Test
	public void double_to_str_8921387() 
	{
		String res = block2.double_to_str(99.98);
		assertEquals(res, "99.98");
	}
	@Test
	public void double_to_str_0() 
	{
		String res = block2.double_to_str(0.1);
		assertEquals(res, "0.1");
	}
	@Test
	public void double_to_str_509() 
	{
		String res = block2.double_to_str(5.9846515);
		assertEquals(res, "5.9846515");
	}

}
