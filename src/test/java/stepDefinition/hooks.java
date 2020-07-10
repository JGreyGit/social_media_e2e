package stepDefinition;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.driveFactory;

public class hooks {
	@Before
	public void before()
	{ driveFactory.initializeDriver(); }

//
//    @After
//    public void after()
//    {
//        driverFactory.driver.close();
//        driverFactory.driver = null;
//
//    }
}


