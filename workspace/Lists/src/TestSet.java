import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)

public class TestSet
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

	public TestSet(EList AList)
	{
		obj = AList;
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_ex_hi()
	{
		int[] mas = { 5, 8, 3, 1, 4, 6, 5 };
		obj.init(mas);
		obj.set(9, 4);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_ex_lo()
	{
		int[] mas = { 5, 8, 3, 1, 4, 6, 5 };
		obj.init(mas);
		obj.set(-6, 1);
	}

	@Test
	public void test_0()
	{
		int[] mas = {};
		obj.init(mas);
		obj.set(0, 2);
		int[] exp = { 2 };
		int[] res = obj.toArray();
		assertArrayEquals(exp, res);
	}

	@Test
	public void test_1()
	{
		int[] mas = { 4 };
		obj.init(mas);
		obj.set(0, 1);
		int[] exp = { 1 };
		int[] res = obj.toArray();
		assertArrayEquals(exp, res);
	}

	@Test
	public void test_2()
	{
		int[] mas = { 2, 5 };
		obj.init(mas);
		obj.set(1, 1);
		int[] exp = { 2, 1 };
		int[] res = obj.toArray();
		assertArrayEquals(exp, res);
	}

	@Test
	public void test_many_st()
	{
		int[] mas = { 5, 8, 3, 1, 4, 6, 5 };
		obj.init(mas);
		obj.set(0, 7);
		int[] exp = { 7, 8, 3, 1, 4, 6, 5 };
		int[] res = obj.toArray();
		assertArrayEquals(exp, res);
	}

	@Test
	public void test_many_en_size()
	{
		int[] mas = { 5, 8, 3, 1, 4, 6, 5 };
		obj.init(mas);
		obj.set(7, 7);
		int[] exp = { 5, 8, 3, 1, 4, 6, 5, 7 };
		int[] res = obj.toArray();
		assertArrayEquals(exp, res);
	}

	@Test
	public void test_many_en()
	{
		int[] mas = { 5, 8, 3, 1, 4, 6, 5 };
		obj.init(mas);
		obj.set(6, 7);
		int[] exp = { 5, 8, 3, 1, 4, 6, 7 };
		int[] res = obj.toArray();
		assertArrayEquals(exp, res);
	}

	@Test
	public void test_many_md()
	{
		int[] mas = { 5, 8, 3, 1, 4, 6, 5 };
		obj.init(mas);
		obj.set(4, 7);
		int[] exp = { 5, 8, 3, 1, 7, 6, 5 };
		int[] res = obj.toArray();
		assertArrayEquals(exp, res);
	}

}