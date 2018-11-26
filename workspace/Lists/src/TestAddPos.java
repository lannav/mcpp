import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)

public class TestAddPos
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

	public TestAddPos(EList AList)
	{
		obj = AList;
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_ex_hi()
	{
		int[] mas = { 5, 8, 3, 1, 4, 6, 5 };
		obj.init(mas);
		obj.addPos(8, 9);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_ex_lo()
	{
		int[] mas = { 5, 8, 3, 1, 4, 6, 5 };
		obj.init(mas);
		obj.addPos(-1, 9);
	}

	@Test
	public void test_0()
	{
		int[] mas = {};
		obj.init(mas);
		obj.addPos(0, 9);
		int[] exp = { 9 };
		int[] res = obj.toArray();
		assertArrayEquals(res, exp);
	}

	@Test
	public void test_1()
	{
		int[] mas = { 4 };
		obj.init(mas);
		obj.addPos(0, 9);
		int[] exp = { 9, 4 };
		int[] res = obj.toArray();
		assertArrayEquals(res, exp);
	}

	@Test
	public void test_2()
	{
		int[] mas = { 2, 5 };
		obj.init(mas);
		obj.addPos(1, 9);
		int[] exp = { 2, 9, 5 };
		int[] res = obj.toArray();
		assertArrayEquals(res, exp);
	}

	@Test
	public void test_many_st()
	{
		int[] mas = { 5, 8, 3, 1, 4, 6, 5 };
		obj.init(mas);
		obj.addPos(0, 9);
		int[] exp = { 9, 5, 8, 3, 1, 4, 6, 5 };
		int[] res = obj.toArray();
		assertArrayEquals(res, exp);
	}

	@Test
	public void test_many_en()
	{
		int[] mas = { 5, 8, 3, 1, 4, 6, 5 };
		obj.init(mas);
		obj.addPos(7, 9);
		int[] exp = { 5, 8, 3, 1, 4, 6, 5, 9 };
		int[] res = obj.toArray();
		assertArrayEquals(res, exp);
	}

	@Test
	public void test_many_md()
	{
		int[] mas = { 5, 8, 3, 1, 4, 6, 5 };
		obj.init(mas);
		obj.addPos(2, 9);
		int[] exp = { 5, 8, 9, 3, 1, 4, 6, 5 };
		int[] res = obj.toArray();
		assertArrayEquals(res, exp);
	}
	@Test
	public void test_many_md1()
	{
		int[] mas = { 5, 8, 3, 1, 4, 6, 5 };
		obj.init(mas);
		obj.addPos(4, 9);
		int[] exp = { 5, 8, 3, 1, 9, 4, 6, 5 };
		int[] res = obj.toArray();
		assertArrayEquals(res, exp);
	}

}