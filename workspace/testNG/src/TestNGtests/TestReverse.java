package TestNGtests;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestReverse
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
	public void test_0(EList obj)
	{
		int[] mas = {};
		obj.init(mas);
		obj.reverse();
		int[] exp = {};
		int[] res = obj.toArray();
		assertEquals(res, exp);
	}

	@Test(dataProvider = "Lists")
	public void test_1(EList obj)
	{
		int[] mas = { 4 };
		obj.init(mas);
		obj.reverse();
		int[] exp = { 4 };
		int[] res = obj.toArray();
		assertEquals(res, exp);
	}

	@Test(dataProvider = "Lists")
	public void test_2(EList obj)
	{
		int[] mas = { 6, 5 };
		obj.init(mas);
		obj.reverse();
		int[] exp = { 5, 6 };
		int[] res = obj.toArray();
		assertEquals(res, exp);
	}

	@Test(dataProvider = "Lists")
	public void test_many_chet(EList obj)
	{
		int[] mas = { 5, 8, 3, 1, 4, 6, 5, 9 };
		obj.init(mas);
		obj.reverse();
		int[] exp = { 9, 5, 6, 4, 1, 3, 8, 5 };
		int[] res = obj.toArray();
		assertEquals(res, exp);
	}

	@Test(dataProvider = "Lists")
	public void test_many_nechet(EList obj)
	{
		int[] mas = { 5, 8, 3, 1, 4, 6, 5 };
		obj.init(mas);
		obj.reverse();
		int[] exp = { 5, 6, 4, 1, 3, 8, 5 };
		int[] res = obj.toArray();
		assertEquals(res, exp);
	}

}