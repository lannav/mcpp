import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)

public class TestDelPos
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

	public TestDelPos(EList AList)
	{
		obj = AList;
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_hi()
	{
		int[] mas = { 5, 8, 3, 1, 4, 6, 5 };
		obj.init(mas);
		obj.delPos(8);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_lo()
	{
		int[] mas = { 5, 8, 3, 1, 4, 6, 5 };
		obj.init(mas);
		obj.delPos(-2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_0()
	{
		int[] mas = {};
		obj.init(mas);
		obj.delPos(0);
	}

	@Test
	public void test_1()
	{
		int[] mas = { 4 };
		obj.init(mas);
		int[] exp = {};
		int ex = obj.delPos(0);
		int[] res = obj.toArray();
		assertArrayEquals(res, exp);
		assertEquals(4, ex);
	}

	@Test
	public void test_2()
	{
		int[] mas = { 2, 5 };
		obj.init(mas);
		int[] exp = { 5 };
		int ex = obj.delPos(0);
		int[] res = obj.toArray();
		assertArrayEquals(res, exp);
		assertEquals(2, ex);
	}

	@Test
	public void test_many_st()
	{
		int[] mas = { 5, 8, 3, 1, 4, 6, 5 };
		obj.init(mas);
		int[] exp = { 8, 3, 1, 4, 6, 5 };
		int ex = obj.delPos(0);
		int[] res = obj.toArray();
		assertArrayEquals(res, exp);
		assertEquals(5, ex);
	}

	@Test
	public void test_many_en()
	{
		int[] mas = { 5, 8, 3, 1, 4, 6, 7 };
		obj.init(mas);
		int[] exp = { 5, 8, 3, 1, 4, 6 };
		int ex = obj.delPos(6);
		int[] res = obj.toArray();
		assertArrayEquals(res, exp);
		assertEquals(7, ex);
	}

	@Test
	public void test_many_md()
	{
		int[] mas = { 5, 8, 3, 1, 4, 6, 5 };
		obj.init(mas);
		int[] exp = { 5, 8, 3, 4, 6, 5 };
		int ex = obj.delPos(3);
		int[] res = obj.toArray();
		assertArrayEquals(res, exp);
		assertEquals(1, ex);
	}

}