package com.crm.objectrepository;

import org.hamcrest.Factory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.genericlib.BaseClass;

public class ClickingOnCreatePO 
{
	
	@FindBy(xpath="//input[@value='  Save  ']")
	private WebElement clickOnSave;
	
	@FindBy(name="subject")
	private WebElement subjectField;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement clickOnVendor;
	
	@FindBy(linkText="Mmt")
	private WebElement selectVendor;
	
	@FindBy(name="bill_street")
	private WebElement clickOnBill;
	
	@FindBy(name="ship_street")
	private WebElement clickOnShipping;
	
	@FindBy(xpath="//img[@src='themes/images/products.gif']")
	private WebElement clickOnItem;
	
	@FindBy(linkText="laptop")
	private WebElement clickOnItemName;
	
	@FindBy(name="qty1")
	private WebElement enterOnQuantity;
	
	@FindBy(name="listPrice1")
	private WebElement enterOnList;
	
	@FindBy(xpath="//span[contains(text()='laptops -  Purchase Order Information')]")
	private WebElement confirmationMsg;
	
	public WebElement getSelectVendorName()
	{
		return selectVendor;
	}
	public WebElement getConfirmationMSg()
	{
		return confirmationMsg;
	}
	
	public WebElement getEnterOnList()
	{
		return enterOnList;
	}
	
	public WebElement getClickOnQuantity()
	{
		return enterOnQuantity;
	}
	
	public WebElement getClickOnItemName()
	{
		return clickOnItemName;
	}
	
	public WebElement getClickOnItem()
	{
		return clickOnItem;
	}
	
	
	public WebElement getClickOnShipping()
	{
		return clickOnShipping;
	}
	
	public WebElement getClickOnBill()
	{
		return clickOnBill;
	}
	
	public WebElement getVendorName()
	{
		return clickOnVendor;
	}
	
	public WebElement getSubjectField()
	{
		 return subjectField;
	}
	
	public WebElement getClickOnSave()
	{
		return clickOnSave;
	}

	public String getAlertMsg()
	{
		Alert a1=BaseClass.driver.switchTo().alert();
		return a1.getText();
		
	}
	public void getAlertAccept()
	{
		Alert a1=BaseClass.driver.switchTo().alert();
		 a1.accept();
	}
}
