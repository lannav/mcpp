package TestNGtests;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestSet
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
		obj.set(9, 4);
	}

	@Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "Lists")
	public void test_ex_lo(EList obj)
	{
		int[] mas = { 5, 8, 3, 1, 4, 6, 5 };
		obj.init(mas);
		obj.set(-6, 1);
	}

	@Test(dataProvider = "Lists")
	public void test_0(EList obj)
	{
		int[] mas = {};
		obj.init(mas);
		obj.set(0, 2);
		int[] exp = { 2 };
		int[] res = obj.toArray();
		assertEquals(exp, res);
	}

	@Test(dataProvider = "Lists")
	public void test_1(EList obj)
	{
		int[] mas = { 4 };
		obj.init(mas);
		obj.set(0, 1);
		int[] exp = { 1 };
		int[] res = obj.toArray();
		assertEquals(exp, res);
	}

	@Test(dataProvider = "Lists")
	public void test_2(EList obj)
	{
		int[] mas = { 2, 5 };
		obj.init(mas);
		obj.set(1, 1);
		int[] exp = { 2, 1 };
		int[] res = obj.toArray();
		assertEquals(exp, res);
	}

	@Test(dataProvider = "Lists")
	public void test_many_st(EList obj)
	{
		int[] mas = { 5, 8, 3, 1, 4, 6, 5 };
		obj.init(mas);
		obj.set(0, 7);
		int[] exp = { 7, 8, 3, 1, 4, 6, 5 };
		int[] res = obj.toArray();
		assertEquals(exp, res);
	}

	@Test(dataProvider = "Lists")
	public void test_many_en_size(EList obj)
	{
		int[] mas = { 5, 8, 3, 1, 4, 6, 5 };
		obj.init(mas);
		obj.set(7, 7);
		int[] exp = { 5, 8, 3, 1, 4, 6, 5, 7 };
		int[] res = obj.toArray();
		assertEquals(exp, res);
	}

	@Test(dataProvider = "Lists")
	public void test_many_en(EList obj)
	{
		int[] mas = { 5, 8, 3, 1, 4, 6, 5 };
		obj.init(mas);
		obj.set(6, 7);
		int[] exp = { 5, 8, 3, 1, 4, 6, 7 };
		int[] res = obj.toArray();
		assertEquals(exp, res);
	}

	@Test(dataProvider = "Lists")
	public void test_many_md(EList obj)
	{
		int[] mas = { 5, 8, 3, 1, 4, 6, 5 };
		obj.init(mas);
		obj.set(4, 7);
		int[] exp = { 5, 8, 3, 1, 7, 6, 5 };
		int[] res = obj.toArray();
		assertEquals(exp, res);
	}

}