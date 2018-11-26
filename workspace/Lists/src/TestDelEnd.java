import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)

public class TestDelEnd
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

	public TestDelEnd(EList AList)
	{
		obj = AList;
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_0()
	{
		int[] mas = {};
		obj.init(mas);
		obj.delEnd();
	}

	@Test
	public void test_1()
	{
		int[] mas = { 4 };
		obj.init(mas);
		int[] exp = {};
		int ex = obj.delEnd();
		int[] res = obj.toArray();
		assertArrayEquals(res, exp);
		assertEquals(4, ex);
	}

	@Test
	public void test_2()
	{
		int[] mas = { 2, 5 };
		obj.init(mas);
		int[] exp = { 2 };
		int ex = obj.delEnd();
		int[] res = obj.toArray();
		assertArrayEquals(res, exp);
		assertEquals(5, ex);
	}

	@Test
	public void test_many()
	{
		int[] mas = { 5, 8, 3, 1, 4, 6, 5 };
		obj.init(mas);
		int[] exp = { 5, 8, 3, 1, 4, 6 };
		int ex = obj.delEnd();
		int[] res = obj.toArray();
		assertArrayEquals(res, exp);
		assertEquals(5, ex);
	}

}