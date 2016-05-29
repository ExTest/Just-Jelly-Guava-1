package testngExamples;

import org.testng.annotations.Test;

import wrappers.CommonWrappers;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeSuite;

public class TestngAnnotations{
  @Test
  public void f() {
  }
  @BeforeTest
  public void beforeTest() {
	  System.out.println("I am in Before Test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("I am in Before Suite");
  }

}
