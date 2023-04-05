package base1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotation {
	
	int i=0;
	@Test
	public void testCase1()
	{
	
		System.out.println("testCase"+i);
	}
	
	@Test
	public void testCase2()
	{
		i++;
		System.out.println("testcase"+i);
	}
	
	@BeforeTest
	public void beforeTest()
	{
		i++;
		System.out.println("before test ");
	}
	
	@AfterTest
	public void AfterTest()
	{
		System.out.println("After Test ");		
	}
	
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("Before class");
	}

	@AfterClass
	public void afterClass()
	{
		System.out.println("After class");
	}
}

