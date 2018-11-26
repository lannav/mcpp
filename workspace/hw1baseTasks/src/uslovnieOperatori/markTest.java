package uslovnieOperatori;
import static org.junit.Assert.*;

import org.junit.Test;

public class markTest 
{
	
	@Test
	public void mark_0() 
	{
		char res = operat.mark(0);
		assertEquals('F', res);
	}

	@Test
	public void mark_10() 
	{
		char res = operat.mark(10);
		assertEquals('F', res);
	}

	@Test
	public void mark_19() 
	{
		char res = operat.mark(19);
		assertEquals('F', res);
	}

	@Test
	public void mark_20() 
	{
		char res = operat.mark(20);
		assertEquals('E', res);
	}

	@Test
	public void mark_30() 
	{
		char res = operat.mark(30);
		assertEquals('E', res);
	}

	@Test
	public void mark_39() 
	{
		char res = operat.mark(39);
		assertEquals('E', res);
	}

	@Test
	public void mark_40() 
	{
		char res = operat.mark(40);
		assertEquals('D', res);
	}

	@Test
	public void mark_50() 
	{
		char res = operat.mark(50);
		assertEquals('D', res);
	}

	@Test
	public void mark_59() 
	{
		char res = operat.mark(59);
		assertEquals('D', res);
	}

	@Test
	public void mark_60() 
	{
		char res = operat.mark(60);
		assertEquals('C', res);
	}

	@Test
	public void mark_70() 
	{
		char res = operat.mark(70);
		assertEquals('C', res);
	}

	@Test
	public void mark_74() 
	{
		char res = operat.mark(74);
		assertEquals('C', res);
	}

	@Test
	public void mark_75() 
	{
		char res = operat.mark(75);
		assertEquals('B', res);
	}

	@Test
	public void mark_80() 
	{
		char res = operat.mark(80);
		assertEquals('B', res);
	}

	@Test
	public void mark_89() 
	{
		char res = operat.mark(89);
		assertEquals('B', res);
	}

	@Test
	public void mark_90() 
	{
		char res = operat.mark(90);
		assertEquals('A', res);
	}

	@Test
	public void mark_95() 
	{
		char res = operat.mark(95);
		assertEquals('A', res);
	}
	
	@Test
	public void mark_100() 
	{
		char res = operat.mark(100);
		assertEquals('A', res);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void Ex_m5() 
	{
		operat.mark(-5);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void Ex_108() 
	{
		operat.mark(108);
	}
}
