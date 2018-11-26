package cycles;
import static org.junit.Assert.*;

import org.junit.Test;

public class reversTest 
{
	@Test
	public void rev_pos() 
	{
	int a = cycle.revers(7896542);
	assertEquals(2456987, a);
	}
	@Test
	public void rev_0() 
	{
	int a = cycle.revers(0);
	assertEquals(0, a);
	}
	@Test
	public void rev_neg() 
	{
	int a = cycle.revers(-6876854);
	assertEquals(-4586786, a);
	}

}
