import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestAddEnd.class, TestAddPos.class, TestAddStart.class, TestClear.class, TestDelEnd.class,
		TestDelPos.class, TestDelStart.class, TestGet.class, TestHalfReverse.class, TestInit.class, TestMax.class,
		TestMaxPos.class, TestMin.class, TestMinPos.class, TestReverse.class, TestSet.class, TestSize.class,
		TestSort.class, TestToArray.class, TestToString.class, TestSmoke.class })
public class AllTests {

}
