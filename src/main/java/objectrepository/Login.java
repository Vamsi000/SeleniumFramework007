package com.crm.objectrepository;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.genericlib.FileLib;
/**
 * 
 * @author Vamsi
 *
 */
public class Login
{
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	
	public WebElement getUsernameEdit()
	{
		return usernameEdt;
		
	}
	public WebElement getPasswordEdit()
	{
		return passwordEdt;
		
	}
	public WebElement getLoginBtn()
	{
		return loginBtn;
		
	}
	
	/*Business libraries*/
	public void loginToApp(String username,String password)
	{
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
	public void loginToApp() throws Throwable
	{
		//FileLib f=new FileLib();
		Properties pobj=FileLib.getPropertyFileObject();
		usernameEdt.sendKeys(pobj.getProperty("username"));
		passwordEdt.sendKeys(pobj.getProperty("password"));
		loginBtn.click();
	}
	
	
}
