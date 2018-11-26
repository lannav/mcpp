package TestNGtests;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestAddPos
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
	public void test_ex_hi(EList obj)
	{
		int[] mas = { 5, 8, 3, 1, 4, 6, 5 };
		obj.init(mas);
		obj.addPos(8, 9);
	}

	@Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "Lists")
	public void test_ex_lo(EList obj)
	{
		int[] mas = { 5, 8, 3, 1, 4, 6, 5 };
		obj.init(mas);
		obj.addPos(-1, 9);
	}

	@Test(dataProvider = "Lists")
	public void test_0(EList obj)
	{
		int[] mas = {};
		obj.init(mas);
		obj.addPos(0, 9);
		int[] exp = { 9 };
		int[] res = obj.toArray();
		assertEquals(res, exp);
	}

	@Test(dataProvider = "Lists")
	public void test_1(EList obj)
	{
		int[] mas = { 4 };
		obj.init(mas);
		obj.addPos(0, 9);
		int[] exp = { 9, 4 };
		int[] res = obj.toArray();
		assertEquals(res, exp);
	}

	@Test(dataProvider = "Lists")
	public void test_2(EList obj)
	{
		int[] mas = { 2, 5 };
		obj.init(mas);
		obj.addPos(1, 9);
		int[] exp = { 2, 9, 5 };
		int[] res = obj.toArray();
		assertEquals(res, exp);
	}

	@Test(dataProvider = "Lists")
	public void test_many_st(EList obj)
	{
		int[] mas = { 5, 8, 3, 1, 4, 6, 5 };
		obj.init(mas);
		obj.addPos(0, 9);
		int[] exp = { 9, 5, 8, 3, 1, 4, 6, 5 };
		int[] res = obj.toArray();
		assertEquals(res, exp);
	}

	@Test(dataProvider = "Lists")
	public void test_many_en(EList obj)
	{
		int[] mas = { 5, 8, 3, 1, 4, 6, 5 };
		obj.init(mas);
		obj.addPos(7, 9);
		int[] exp = { 5, 8, 3, 1, 4, 6, 5, 9 };
		int[] res = obj.toArray();
		assertEquals(res, exp);
	}

	@Test(dataProvider = "Lists")
	public void test_many_md(EList obj)
	{
		int[] mas = { 5, 8, 3, 1, 4, 6, 5 };
		obj.init(mas);
		obj.addPos(3, 9);
		int[] exp = { 5, 8, 3, 9, 1, 4, 6, 5 };
		int[] res = obj.toArray();
		assertEquals(res, exp);
	}

}