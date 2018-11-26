package cycles;
import static org.junit.Assert.*;

import org.junit.Test;

public class simpleTest 
{
	@Test
	public void simp_2() 
	{
		char c = cycle.simple(2);
		assertEquals('+', c);
	}
	@Test
	public void simp_10() 
	{
		char c = cycle.simple(10);
		assertEquals('-', c);
	}
	@Test (expected = IllegalArgumentException.class)
	public void Ex_m5() 
	{
		cycle.simple(-5);
	}

}
