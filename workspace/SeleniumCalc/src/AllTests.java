import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import Edge.Edge;
import FF.Firefox;

@RunWith(Suite.class)
@SuiteClasses({ Chrome.class, Edge.class, Firefox.class })
public class AllTests {

}
