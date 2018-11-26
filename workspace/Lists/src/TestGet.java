import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)

public class TestGet
{
	private EList obj = null;

	@Parameters(name = "List{index}")
	public static Collection<Object[]> ALists()
	{
		return Arrays.asList(new Object[][] { 
			{ new AList0() }, 
			{ new AList1() }, 
			{ new AList2() }, 
			{ new LList1() }, 
			{ new LList2() } 
			});
	}

	public TestGet(EList AList)
	{
		obj = AList;
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_ex_hi()
	{
		int[] mas = { 5, 8, 3, 1, 4, 6, 5 };
		obj.init(mas);
		obj.get(9);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_ex_lo()
	{
		int[] mas = { 5, 8, 3, 1, 4, 6, 5 };
		obj.init(mas);
		obj.get(-6);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_0()
	{
		int[] mas = {};
		obj.init(mas);
		obj.get(0);
	}

	@Test
	public void test_1()
	{
		int[] mas = { 4 };
		obj.init(mas);
		int res = obj.get(0);
		assertEquals(4, res);
	}

	@Test
	public void test_2()
	{
		int[] mas = { 2, 5 };
		obj.init(mas);
		int res = obj.get(1);
		assertEquals(5, res);
	}

	@Test
	public void test_many_st()
	{
		int[] mas = { 5, 8, 3, 1, 4, 6, 5 };
		obj.init(mas);
		int res = obj.get(0);
		assertEquals(5, res);
	}

	@Test
	public void test_many_en()
	{
		int[] mas = { 5, 8, 3, 1, 4, 6, 7 };
		obj.init(mas);
		int res = obj.get(6);
		assertEquals(7, res);
	}

	@Test
	public void test_many_md()
	{
		int[] mas = { 5, 8, 3, 1, 4, 6, 5 };
		obj.init(mas);
		int res = obj.get(3);
		assertEquals(1, res);
	}

}