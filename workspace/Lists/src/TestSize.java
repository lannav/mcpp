import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)

public class TestSize
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

	public TestSize(EList AList)
	{
		obj = AList;
	}

	@Test
	public void test_0()
	{
		int[] mas = {};
		obj.init(mas);
		int exp = 0;
		int res = obj.size();
		assertEquals(res, exp);
	}

	@Test
	public void test_1()
	{
		int[] mas = { 4 };
		obj.init(mas);
		int exp = 1;
		int res = obj.size();
		assertEquals(res, exp);
	}

	@Test
	public void test_2()
	{
		int[] mas = { 2, 5 };
		obj.init(mas);
		int exp = 2;
		int res = obj.size();
		assertEquals(res, exp);
	}

	@Test
	public void test_many()
	{
		int[] mas = { 5, 8, 3, 1, 4, 6, 5 };
		obj.init(mas);
		int exp = 7;
		int res = obj.size();
		assertEquals(res, exp);
	}

}