package dao;

import junit.framework.Test;
import junit.framework.TestSuite;

public class DaoTest {

	public static Test suite() {
		TestSuite suite = new TestSuite(DaoTest.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(HubManagerDAOTest.class);
		//suite.addTestSuite(TrackingDAOTest.class);
		suite.addTestSuite(UserDAOTest.class);
		//$JUnit-END$
		return suite;
	}

}