package TestNGtests;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestToString
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
		String exp = "";
		String res = obj.toString();
		assertEquals(exp, res);
	}

	@Test(dataProvider = "Lists")
	public void test_1(EList obj)
	{
		int[] mas = { 4 };
		obj.init(mas);
		String exp = "4";
		String res = obj.toString();
		assertEquals(exp, res);
	}

	@Test(dataProvider = "Lists")
	public void test_2(EList obj)
	{
		int[] mas = { 2, 5 };
		obj.init(mas);
		String exp = "2 5";
		String res = obj.toString();
		assertEquals(exp, res);
	}

	@Test(dataProvider = "Lists")
	public void test_many(EList obj)
	{
		int[] mas = { 5, 8, 3, 1, 4, 6, 5 };
		obj.init(mas);
		String exp = "5 8 3 1 4 6 5";
		String res = obj.toString();
		assertEquals(exp, res);
	}

}