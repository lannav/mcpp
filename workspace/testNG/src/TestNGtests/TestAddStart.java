package TestNGtests;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestAddStart
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
		obj.addStart(9);
		int[] exp = { 9 };
		int[] res = obj.toArray();
		int expSize = 1;
		int resSize = obj.size();
		assertEquals(res, exp);
		assertEquals(expSize, resSize);
	}

	@Test(dataProvider = "Lists")
	public void test_1(EList obj)
	{
		int[] mas = { 4 };
		obj.init(mas);
		obj.addStart(9);
		int[] exp = { 9, 4 };
		int[] res = obj.toArray();
		int expSize = 2;
		int resSize = obj.size();
		assertEquals(res, exp);
		assertEquals(expSize, resSize);
	}

	@Test(dataProvider = "Lists")
	public void test_2(EList obj)
	{
		int[] mas = { 2, 5 };
		obj.init(mas);
		obj.addStart(9);
		int[] exp = { 9, 2, 5 };
		int[] res = obj.toArray();
		int expSize = 3;
		int resSize = obj.size();
		assertEquals(res, exp);
		assertEquals(expSize, resSize);
	}

	@Test(dataProvider = "Lists")
	public void test_many(EList obj)
	{
		int[] mas = { 5, 8, 3, 1, 4, 6, 5 };
		obj.init(mas);
		obj.addStart(9);
		int[] exp = { 9, 5, 8, 3, 1, 4, 6, 5 };
		int[] res = obj.toArray();
		int expSize = 8;
		int resSize = obj.size();
		assertEquals(res, exp);
		assertEquals(expSize, resSize);
	}

}