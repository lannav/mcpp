package func;

import static org.junit.Assert.*;

import org.junit.Test;

public class chisloTest 
{

	@Test
	public void ch_999mrd() 
	{
		long a = function.stroka("девятьсот девяносто девять миллиардов девятьсот девяносто девять миллионов девятьсот девяносто девять тысяч девятьсот девяносто девять");
		assertEquals(999999999999L, a);
	}
	@Test
	public void ch_0() 
	{
		long a = function.stroka("ноль");
		assertEquals(0, a);
	}
	@Test
	public void ch_312579134() 
	{
		long a = function.stroka("триста двенадцать миллионов пятьсот семьдесят девять тысяч сто тридцать четыре");
		assertEquals(312579134L, a);
	}
	/*@Test (expected = IllegalArgumentException.class)
	public void Ex_m10() 
	{
		function.fxz(-10);
	}
	@Test (expected = IllegalArgumentException.class)
	public void Ex_bil() 
	{
		function.fxz(1000000000000L);
	}*/


}
