package com.ckSeleniumDemo.SeleniumDemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class DemoTest {
  @Test
  public void testCase01() {
	  
	  System.out.println("Maven Example");
  }
  @BeforeTest
  public void beforeTest() {
	  System.out.println("Before Test Example");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("After Test Example");
  }

}
