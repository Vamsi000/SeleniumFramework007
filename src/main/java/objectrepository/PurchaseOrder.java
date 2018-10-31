package com.crm.objectrepository;
/**
 * 
 * @author Vamsi
 *
 */

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PurchaseOrder
{
	@FindBy(xpath="//img[@alt='Create Purchase Order...']")
	private WebElement createPurchaseOrder;
	
	public WebElement getCreatePurchaseOrder()
	{
		return createPurchaseOrder;
	}
	
	
}

