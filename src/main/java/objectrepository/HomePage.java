package com.crm.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * 
 * @author Vamsi
 *
 */
public class HomePage
{
	@FindBy(xpath="//img[@src='themes/softed/images/menuDnArrow.gif']")
	private WebElement moreDropDown;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signoutBtn;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement goToAdmin;
	
	@FindBy(linkText="Purchase Order")
	private WebElement purchaseLink;
	
	public WebElement getGoTOAdmin()
	{
		return goToAdmin;
	}
	public WebElement getMoreDropDown()
	{
		return moreDropDown;
	}
	public WebElement getSignoutBtn()
	{
		return signoutBtn;
	}
	public WebElement getPurchaseLink()
	{
		return purchaseLink;
	}
	
	
	
}
