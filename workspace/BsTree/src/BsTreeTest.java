import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)

public class BsTreeTest 
{
	private Tree tr = null;

	@Parameters(name = "Tree{index}")
	public static Collection<Object[]> Trees()
	{
		return Arrays.asList(new Object[][] { 
			{ new BsTree() }, 
			{ new BS_Tree_Linked() } 
			});
	}

	public BsTreeTest(Tree tr)
	{
		this.tr = tr;
	}
	
	@Test
	public void init_null() 
	{

		int[] ini = null;
		tr.init(ini);
		int[] exp = {};
		assertArrayEquals(exp, tr.toArray());
	}
	@Test
	public void init_0() 
	{

		int[] ini = {};
		tr.init(ini);
		int[] exp = {};
		assertArrayEquals(exp, tr.toArray());
	}
	@Test
	public void init_1() 
	{

		int[] ini = {4};
		tr.init(ini);
		int[] exp = {4};
		assertArrayEquals(exp, tr.toArray());
	}
	@Test
	public void init_2() 
	{

		int[] ini = {5,8};
		tr.init(ini);
		int[] exp = {5,8};
		assertArrayEquals(exp, tr.toArray());
	}
	@Test
	public void init_many() 
	{

		int[] ini = {50,25,11,7,34,18,70,90,28,65,35,64,66,89,91};
		tr.init(ini);
		int[] exp = {7,11,18,25,28,34,35,50,64,65,66,70,89,90,91};
		assertArrayEquals(exp, tr.toArray());
	}
	@Test
	public void size_0() 
	{

		int[] ini = {};
		tr.init(ini);
		int exp = 0;
		assertEquals(exp, tr.size());
	}
	@Test
	public void size_1() 
	{

		int[] ini = {5};
		tr.init(ini);
		int exp = 1;
		assertEquals(exp, tr.size());
	}
	@Test
	public void size_2() 
	{

		int[] ini = {5,8};
		tr.init(ini);
		int exp = 2;
		assertEquals(exp, tr.size());
	}
	@Test
	public void size_many() 
	{

		int[] ini = {50,25,11,7,34,18,70,90,28,65,35,64,66,89,91};
		tr.init(ini);
		int exp = 15;
		assertEquals(exp, tr.size());
	}
	@Test
	public void add_0() 
	{

		int[] ini = {};
		tr.init(ini);
		tr.add(7);
		int[] exp = {7};
		assertArrayEquals(exp, tr.toArray());
	}
	@Test
	public void add_1() 
	{

		int[] ini = {5};
		tr.init(ini);
		tr.add(7);
		int[] exp = {5,7};
		assertArrayEquals(exp, tr.toArray());
	}
	@Test
	public void add_2() 
	{

		int[] ini = {5,8};
		tr.init(ini);
		tr.add(7);
		int[] exp = {5,7,8};
		assertArrayEquals(exp, tr.toArray());
	}
	@Test
	public void add_many() 
	{

		int[] ini = {50,25,11,34,18,70,90,28,65,35,64,66,89,91};
		tr.init(ini);
		tr.add(7);
		int[] exp = {7,11,18,25,28,34,35,50,64,65,66,70,89,90,91};
		assertArrayEquals(exp, tr.toArray());
	}
	@Test
	public void nodes_0() 
	{

		int[] ini = {};
		tr.init(ini);
		int exp = 0;
		assertEquals(exp, tr.nodes());
	}
	@Test
	public void nodes_1() 
	{

		int[] ini = {5};
		tr.init(ini);
		int exp = 0;
		assertEquals(exp, tr.nodes());
	}
	@Test
	public void nodes_2() 
	{

		int[] ini = {5,8};
		tr.init(ini);
		int exp = 1;
		assertEquals(exp, tr.nodes());
	}
	@Test
	public void nodes_many() 
	{

		int[] ini = {50,25,11,7,34,18,70,90,28,65,35,64,66,89,91};
		tr.init(ini);
		int exp = 7;
		assertEquals(exp, tr.nodes());
	}
	@Test
	public void leaves_0() 
	{

		int[] ini = {};
		tr.init(ini);
		int exp = 0;
		assertEquals(exp, tr.leaves());
	}
	@Test
	public void leaves_1() 
	{

		int[] ini = {5};
		tr.init(ini);
		int exp = 1;
		assertEquals(exp, tr.leaves());
	}
	@Test
	public void leaves_2() 
	{

		int[] ini = {5,8};
		tr.init(ini);
		int exp = 1;
		assertEquals(exp, tr.leaves());
	}
	@Test
	public void leaves_many() 
	{

		int[] ini = {50,25,11,7,34,18,70,90,28,65,35,64,66,89,91};
		tr.init(ini);
		int exp = 8;
		assertEquals(exp, tr.leaves());
	}
	@Test
	public void hight_0() 
	{

		int[] ini = {};
		tr.init(ini);
		int exp = 0;
		assertEquals(exp, tr.height());
	}
	@Test
	public void hight_1() 
	{

		int[] ini = {5};
		tr.init(ini);
		int exp = 1;
		assertEquals(exp, tr.height());
	}
	@Test
	public void hight_2() 
	{

		int[] ini = {5,8};
		tr.init(ini);
		int exp = 2;
		assertEquals(exp, tr.height());
	}
	@Test
	public void hight_many() 
	{

		int[] ini = {50,25,11,7,34,18,70,90,28,65,35,64,66,89,91};
		tr.init(ini);
		int exp = 4;
		assertEquals(exp, tr.height());
	}
	@Test
	public void midth_0() 
	{

		int[] ini = {};
		tr.init(ini);
		int exp = 0;
		assertEquals(exp, tr.width());
	}
	@Test
	public void midth_1() 
	{

		int[] ini = {5};
		tr.init(ini);
		int exp = 1;
		assertEquals(exp, tr.width());
	}
	@Test
	public void midth_2() 
	{

		int[] ini = {5,8};
		tr.init(ini);
		int exp = 1;
		assertEquals(exp, tr.width());
	}
	@Test
	public void midth_many() 
	{

		int[] ini = {50,25,11,7,34,18,70,90,28,65,35,64,66,89,91};
		tr.init(ini);
		int exp = 8;
		assertEquals(exp, tr.width());
	}
	@Test
	public void toString_0() 
	{

		int[] ini = {};
		tr.init(ini);
		String exp = "";
		assertEquals(exp, tr.toString());
	}
	@Test
	public void toString_1() 
	{

		int[] ini = {5};
		tr.init(ini);
		String exp = "5, ";
		assertEquals(exp, tr.toString());
	}
	@Test
	public void toString_2() 
	{

		int[] ini = {5,8};
		tr.init(ini);
		String exp = "5, 8, ";
		assertEquals(exp, tr.toString());
	}
	@Test
	public void toString_many() 
	{

		int[] ini = {50,25,11,7,34,18,70,90,28,65,35,64,66,89,91};
		tr.init(ini);
		String exp = "7, 11, 18, 25, 28, 34, 35, 50, 64, 65, 66, 70, 89, 90, 91, ";
		assertEquals(exp, tr.toString());
	}
	@Test
	public void toArray_0() 
	{

		int[] ini = {};
		tr.init(ini);
		int[] exp = {};
		assertArrayEquals(exp, tr.toArray());
	}
	@Test
	public void toArray_1() 
	{

		int[] ini = {5};
		tr.init(ini);
		int[] exp = {5};
		assertArrayEquals(exp, tr.toArray());
	}
	@Test
	public void toArray_2() 
	{

		int[] ini = {5,8};
		tr.init(ini);
		int[] exp = {5,8};
		assertArrayEquals(exp, tr.toArray());
	}
	@Test
	public void toArray_many() 
	{

		int[] ini = {50,25,11,7,34,18,70,90,28,65,35,64,66,89,91};
		tr.init(ini);
		int[] exp = {7,11,18,25,28,34,35,50,64,65,66,70,89,90,91};
		assertArrayEquals(exp, tr.toArray());
	}
	@Test(expected = IllegalArgumentException.class)
	public void del_0() 
	{

		int[] ini = {};
		tr.init(ini);
		tr.del(5);
	}
	@Test
	public void del_1() 
	{

		int[] ini = {5};
		tr.init(ini);
		tr.del(5);
		int[] exp = {};
		assertArrayEquals(exp, tr.toArray());
	}
	@Test
	public void del_2() 
	{

		int[] ini = {5,8};
		tr.init(ini);
		tr.del(5);
		int[] exp = {8};
		assertArrayEquals(exp, tr.toArray());
	}
	@Test
	public void del_many() 
	{

		int[] ini = {50,25,11,7,34,18,70,90,28,65,35,64,66,89,91};
		tr.init(ini);
		tr.del(7);
		int[] exp = {11,18,25,28,34,35,50,64,65,66,70,89,90,91};
		assertArrayEquals(exp, tr.toArray());
	}
}
