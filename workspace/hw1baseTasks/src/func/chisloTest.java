package func;

import static org.junit.Assert.*;

import org.junit.Test;

public class chisloTest 
{

	@Test
	public void ch_999mrd() 
	{
		long a = function.stroka("��������� ��������� ������ ���������� ��������� ��������� ������ ��������� ��������� ��������� ������ ����� ��������� ��������� ������");
		assertEquals(999999999999L, a);
	}
	@Test
	public void ch_0() 
	{
		long a = function.stroka("����");
		assertEquals(0, a);
	}
	@Test
	public void ch_312579134() 
	{
		long a = function.stroka("������ ���������� ��������� ������� ��������� ������ ����� ��� �������� ������");
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
