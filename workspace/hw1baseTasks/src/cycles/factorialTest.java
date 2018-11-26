package cycles;
import static org.junit.Assert.*;

import org.junit.Test;

public class factorialTest 
{
	@Test
	public void fact_5() 
	{
		int n = cycle.fact(5);
		assertEquals(120, n);
	}
	
	@Test
	public void fact_0() 
	{
		int n = cycle.fact(0);
		assertEquals(0, n);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void Ex_m2() 
	{
		cycle.fact(-2);
	}

}
