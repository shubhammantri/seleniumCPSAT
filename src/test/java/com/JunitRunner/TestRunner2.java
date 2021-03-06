package com.JunitRunner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner2 {
public static void main(String[] args) {
	Result result = JUnitCore.runClasses(com.tests.Test4.class,com.tests.Test3.class,com.tests.Test2.class);
	

	for (Failure failure : result.getFailures()) {
	   System.out.println(failure.toString());
	}
		
	System.out.println(result.wasSuccessful());
	}

} 