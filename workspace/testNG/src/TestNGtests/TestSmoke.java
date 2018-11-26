package TestNGtests;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestSmoke
{
	@DataProvider
	public Object[][] Lists()
	{
		return new Object[][]
		{ 
			{ new AList0() }, 
			{ new AList1() }, 
			{ new AList2() }, 
			{ new LList1() } 
		};
	}

	@Test(dataProvider = "Lists")
	public void test_null(EList obj)
	{
		int[] mas = null;
		obj.init(mas);
		int[] exp = {};
		int[] res = obj.toArray();
		assertEquals(res, exp);
		int sizeRs = obj.size();
		assertEquals(0, sizeRs);
		String strRs = obj.toString();
		assertEquals("", strRs);
		obj.clear();
		int[] clRs = obj.toArray();
		assertEquals(exp, clRs);
	}

	@Test(dataProvider = "Lists")
	public void test_0(EList obj)
	{
		int[] mas = {};
		obj.init(mas);
		int[] exp = {};
		int[] res = obj.toArray();
		assertEquals(res, exp);
		int sizeRs = obj.size();
		assertEquals(0, sizeRs);
		String strRs = obj.toString();
		assertEquals("", strRs);
		obj.clear();
		int[] clRs = obj.toArray();
		int[] ex = {};
		assertEquals(ex, clRs);
	}

	@Test(dataProvider = "Lists")
	public void test_1(EList obj)
	{
		int[] mas = { 4 };
		obj.init(mas);
		int[] exp = { 4 };
		int[] res = obj.toArray();
		assertEquals(res, exp);
		int sizeRs = obj.size();
		assertEquals(1, sizeRs);
		String strRs = obj.toString();
		assertEquals("4", strRs);
		obj.clear();
		int[] clRs = obj.toArray();
		int[] ex = {};
		assertEquals(ex, clRs);
	}

	@Test(dataProvider = "Lists")
	public void test_2(EList obj)
	{
		int[] mas = { 7, 2 };
		obj.init(mas);
		int[] exp = { 7, 2 };
		int[] res = obj.toArray();
		assertEquals(res, exp);
		int sizeRs = obj.size();
		assertEquals(2, sizeRs);
		String strRs = obj.toString();
		assertEquals("7 2", strRs);
		obj.clear();
		int[] clRs = obj.toArray();
		int[] ex = {};
		assertEquals(ex, clRs);
	}

	@Test(dataProvider = "Lists")
	public void test_many_nechet(EList obj)
	{
		int[] mas = { 4, 5, 7, 1, 3, 9, 8 };
		obj.init(mas);
		int[] exp = { 4, 5, 7, 1, 3, 9, 8 };
		int[] res = obj.toArray();
		assertEquals(res, exp);
		int sizeRs = obj.size();
		assertEquals(7, sizeRs);
		String strRs = obj.toString();
		assertEquals("4 5 7 1 3 9 8", strRs);
		obj.clear();
		int[] clRs = obj.toArray();
		int[] ex = {};
		assertEquals(ex, clRs);
	}

	@Test(dataProvider = "Lists")
	public void test_many_chet(EList obj)
	{
		int[] mas = { 4, 5, 7, 1, 3, 9, 8, 2 };
		obj.init(mas);
		int[] exp = { 4, 5, 7, 1, 3, 9, 8, 2 };
		int[] res = obj.toArray();
		assertEquals(res, exp);
		int sizeRs = obj.size();
		assertEquals(8, sizeRs);
		String strRs = obj.toString();
		assertEquals("4 5 7 1 3 9 8 2", strRs);
		obj.clear();
		int[] clRs = obj.toArray();
		int[] ex = {};
		assertEquals(ex, clRs);
	}

}