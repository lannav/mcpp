package TestNGtests;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDelEnd
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
	public void test_0(EList obj)
	{
		int[] mas = {};
		obj.init(mas);
		obj.delEnd();
	}

	@Test(dataProvider = "Lists")
	public void test_1(EList obj)
	{
		int[] mas = { 4 };
		obj.init(mas);
		int[] exp = {};
		int ex = obj.delEnd();
		int[] res = obj.toArray();
		assertEquals(res, exp);
		assertEquals(4, ex);
	}

	@Test(dataProvider = "Lists")
	public void test_2(EList obj)
	{
		int[] mas = { 2, 5 };
		obj.init(mas);
		int[] exp = { 2 };
		int ex = obj.delEnd();
		int[] res = obj.toArray();
		assertEquals(res, exp);
		assertEquals(5, ex);
	}

	@Test(dataProvider = "Lists")
	public void test_many(EList obj)
	{
		int[] mas = { 5, 8, 3, 1, 4, 6, 5 };
		obj.init(mas);
		int[] exp = { 5, 8, 3, 1, 4, 6 };
		int ex = obj.delEnd();
		int[] res = obj.toArray();
		assertEquals(res, exp);
		assertEquals(5, ex);
	}

}