package func;
import static org.junit.Assert.*;

import org.junit.Test;

public class DayOfWeekTest 
{
	@Test
	public void test() 
	{
		String a = function.week(4);
		assertEquals("четверг", a);
	}
	@Test (expected = IllegalArgumentException.class)
	public void test1() 
	{
		function.week(8);
	}
	@Test (expected = IllegalArgumentException.class)
	public void test2() 
	{
		function.week(-1);
	}

}
