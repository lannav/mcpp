import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)

public class TestSmoke
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

	public TestSmoke(EList AList)
	{
		obj = AList;
	}

	@Test
	public void test_null()
	{
		int[] mas = null;
		obj.init(mas);
		int[] exp = {};
		int[] res = obj.toArray();
		assertArrayEquals(res, exp);
		int sizeRs = obj.size();
		assertEquals(0, sizeRs);
		String strRs = obj.toString();
		assertEquals("", strRs);
		obj.clear();
		int[] clRs = obj.toArray();
		assertArrayEquals(exp, clRs);
	}

	@Test
	public void test_0()
	{
		int[] mas = {};
		obj.init(mas);
		int[] exp = {};
		int[] res = obj.toArray();
		assertArrayEquals(res, exp);
		int sizeRs = obj.size();
		assertEquals(0, sizeRs);
		String strRs = obj.toString();
		assertEquals("", strRs);
		obj.clear();
		int[] clRs = obj.toArray();
		int[] ex = {};
		assertArrayEquals(ex, clRs);
	}

	@Test
	public void test_1()
	{
		int[] mas = { 4 };
		obj.init(mas);
		int[] exp = { 4 };
		int[] res = obj.toArray();
		assertArrayEquals(res, exp);
		int sizeRs = obj.size();
		assertEquals(1, sizeRs);
		String strRs = obj.toString();
		assertEquals("4", strRs);
		obj.clear();
		int[] clRs = obj.toArray();
		int[] ex = {};
		assertArrayEquals(ex, clRs);
	}

	@Test
	public void test_2()
	{
		int[] mas = { 7, 2 };
		obj.init(mas);
		int[] exp = { 7, 2 };
		int[] res = obj.toArray();
		assertArrayEquals(res, exp);
		int sizeRs = obj.size();
		assertEquals(2, sizeRs);
		String strRs = obj.toString();
		assertEquals("7 2", strRs);
		obj.clear();
		int[] clRs = obj.toArray();
		int[] ex = {};
		assertArrayEquals(ex, clRs);
	}

	@Test
	public void test_many_nechet()
	{
		int[] mas = { 4, 5, 7, 1, 3, 9, 8 };
		obj.init(mas);
		int[] exp = { 4, 5, 7, 1, 3, 9, 8 };
		int[] res = obj.toArray();
		assertArrayEquals(res, exp);
		int sizeRs = obj.size();
		assertEquals(7, sizeRs);
		String strRs = obj.toString();
		assertEquals("4 5 7 1 3 9 8", strRs);
		obj.clear();
		int[] clRs = obj.toArray();
		int[] ex = {};
		assertArrayEquals(ex, clRs);
	}

	@Test
	public void test_many_chet()
	{
		int[] mas = { 4, 5, 7, 1, 3, 9, 8, 2 };
		obj.init(mas);
		int[] exp = { 4, 5, 7, 1, 3, 9, 8, 2 };
		int[] res = obj.toArray();
		assertArrayEquals(res, exp);
		int sizeRs = obj.size();
		assertEquals(8, sizeRs);
		String strRs = obj.toString();
		assertEquals("4 5 7 1 3 9 8 2", strRs);
		obj.clear();
		int[] clRs = obj.toArray();
		int[] ex = {};
		assertArrayEquals(ex, clRs);
	}

}