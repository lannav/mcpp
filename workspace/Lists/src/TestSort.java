import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)

public class TestSort
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

	public TestSort(EList AList)
	{
		obj = AList;
	}

	@Test
	public void test_0()
	{
		int[] mas = {};
		obj.init(mas);
		obj.sort();
		int[] exp = {};
		int[] res = obj.toArray();
		assertArrayEquals(res, exp);
	}

	@Test
	public void test_1()
	{
		int[] mas = { 4 };
		obj.init(mas);
		obj.sort();
		int[] exp = { 4 };
		int[] res = obj.toArray();
		assertArrayEquals(res, exp);
	}

	@Test
	public void test_2()
	{
		int[] mas = { 6, 5 };
		obj.init(mas);
		obj.sort();
		int[] exp = { 5, 6 };
		int[] res = obj.toArray();
		assertArrayEquals(res, exp);
	}

	@Test
	public void test_many_chet()
	{
		int[] mas = { 5, 8, 3, 1, 4, 6, 5, 9 };
		obj.init(mas);
		obj.sort();
		int[] exp = { 1, 3, 4, 5, 5, 6, 8, 9 };
		int[] res = obj.toArray();
		assertArrayEquals(res, exp);
	}

	@Test
	public void test_many_nechet()
	{
		int[] mas = { 5, 8, 3, 1, 4, 6, 5 };
		obj.init(mas);
		obj.sort();
		int[] exp = { 1, 3, 4, 5, 5, 6, 8 };
		int[] res = obj.toArray();
		assertArrayEquals(res, exp);
	}

}