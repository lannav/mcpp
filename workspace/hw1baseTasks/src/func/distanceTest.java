package func;
import static org.junit.Assert.*;

import org.junit.Test;

public class distanceTest 
{
	@Test
	public void rast_2m5m43() 
	{
		int[] a = {2,-5};
		int[] b = {-4,3};
		double c = function.rast(a, b);
		assertEquals(10, c, 0.001);
	}
	@Test
	public void rast_5533() 
	{
		int[] a = {5,5};
		int[] b = {3,3};
		double c = function.rast(a, b);
		assertEquals(2.828, c, 0.001);
	}

}
