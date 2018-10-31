package com.crm.genericlib;



import org.testng.Assert;

public class Validation 
{
	public String Verifying(String actual,String expected)
	{
		try
		{
		 Assert.assertEquals(actual, expected);
		 return "pass";
		}
		catch(AssertionError rv)
		{
			return "fail";
		}
	}
}
