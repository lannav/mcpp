package func;

import static org.junit.Assert.*;

import org.junit.Test;

public class PropisTest 
{

	@Test
	public void ch_0() 
	{
		String a = function.fxz(0);
		assertEquals("ноль", a);
	}
	@Test
	public void ch_999mrd() 
	{
		String a = function.fxz(999999999999L);
		assertEquals(" девятьсот девяносто девять миллиардов девятьсот девяносто девять миллионов девятьсот девяносто девять тысяч девятьсот девяносто девять", a);
	}
	@Test
	public void ch_312579134() 
	{
		String a = function.fxz(312579134);
		assertEquals(" триста двенадцать миллионов пятьсот семьдесят девять тысяч сто тридцать четыре", a);
	}
	@Test (expected = IllegalArgumentException.class)
	public void Ex_m10() 
	{
		function.fxz(-10);
	}
	@Test (expected = IllegalArgumentException.class)
	public void Ex_bil() 
	{
		function.fxz(1000000000000L);
	}

}
