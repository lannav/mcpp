import static org.junit.Assert.*;

import org.junit.Test;

public class testTestTest {

	@Test
	public void test() 
	{
		BS_Tree_Linked tr = new BS_Tree_Linked();
		int[] ini = {5,3,4,1,2,6,8,7,9,0};
		tr.init(ini);
	//	tr.del(4);
		BS_Tree_Linked tr1 = new BS_Tree_Linked();
		tr1.init(ini);
		assertTrue(tr.equals(tr1));
	}

}
