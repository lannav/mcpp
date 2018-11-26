package TestNGtests;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDelPos
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

	@Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "Lists")
	public void test_hi(EList obj)
	{
		int[] mas = { 5, 8, 3, 1, 4, 6, 5 };
		obj.init(mas);
		obj.delPos(8);
	}

	@Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "Lists")
	public void test_lo(EList obj)
	{
		int[] mas = { 5, 8, 3, 1, 4, 6, 5 };
		obj.init(mas);
		obj.delPos(-2);
	}

	@Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "Lists")
	public void test_0(EList obj)
	{
		int[] mas = {};
		obj.init(mas);
		obj.delPos(0);
	}

	@Test(dataProvider = "Lists")
	public void test_1(EList obj)
	{
		int[] mas = { 4 };
		obj.init(mas);
		int[] exp = {};
		int ex = obj.delPos(0);
		int[] res = obj.toArray();
		assertEquals(res, exp);
		assertEquals(4, ex);
	}

	@Test(dataProvider = "Lists")
	public void test_2(EList obj)
	{
		int[] mas = { 2, 5 };
		obj.init(mas);
		int[] exp = { 5 };
		int ex = obj.delPos(0);
		int[] res = obj.toArray();
		assertEquals(res, exp);
		assertEquals(2, ex);
	}

	@Test(dataProvider = "Lists")
	public void test_many_st(EList obj)
	{
		int[] mas = { 5, 8, 3, 1, 4, 6, 5 };
		obj.init(mas);
		int[] exp = { 8, 3, 1, 4, 6, 5 };
		int ex = obj.delPos(0);
		int[] res = obj.toArray();
		assertEquals(res, exp);
		assertEquals(5, ex);
	}

	@Test(dataProvider = "Lists")
	public void test_many_en(EList obj)
	{
		int[] mas = { 5, 8, 3, 1, 4, 6, 7 };
		obj.init(mas);
		int[] exp = { 5, 8, 3, 1, 4, 6 };
		int ex = obj.delPos(6);
		int[] res = obj.toArray();
		assertEquals(res, exp);
		assertEquals(7, ex);
	}

	@Test(dataProvider = "Lists")
	public void test_many_md(EList obj)
	{
		int[] mas = { 5, 8, 3, 1, 4, 6, 5 };
		obj.init(mas);
		int[] exp = { 5, 8, 3, 4, 6, 5 };
		int ex = obj.delPos(3);
		int[] res = obj.toArray();
		assertEquals(res, exp);
		assertEquals(1, ex);
	}

}