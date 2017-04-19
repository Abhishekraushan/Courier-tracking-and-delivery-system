package beans;

import junit.framework.Test;
import junit.framework.TestSuite;

public class beansTest {

	public static Test suite() {
		TestSuite suite = new TestSuite(beansTest.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(CustomerTest.class);
		suite.addTestSuite(TrackTest.class);
		suite.addTestSuite(UserTest.class);
		//$JUnit-END$
		return suite;
	}

}
