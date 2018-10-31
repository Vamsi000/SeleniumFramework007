package com.crm.objectrepository;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.crm.createpurchaseorder.CreatePurchase;
import com.crm.genericlib.BaseClass;
import com.crm.genericlib.FileLib;
import com.crm.genericlib.Validation;
/**s
 * 
 * @author Vamsi
 *
 */
public class CreatingNewPurchaseOrderWithOutData extends BaseClass
{
	
	

//	@Test
//	public void CreatingNewPurchaseOrderWithOut() throws Throwable
//	{	
//		HomePage hp=PageFactory.initElements(driver, HomePage.class);
//		Actions ac=new Actions(driver);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		/*performing action on more dropdown*/
//		ac.moveToElement(hp.getMoreDropDown()).perform();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		hp.getPurchaseLink().click();
//
//		PurchaseOrder po=PageFactory.initElements(driver, PurchaseOrder.class);
//		po.getCreatePurchaseOrder().click();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		ClickingOnCreatePO cocp=PageFactory.initElements(driver,ClickingOnCreatePO.class);
//		cocp.getClickOnSave().click();
//		String actual=cocp.getAlertMsg();
//		cocp.getAlertAccept();
//		String exp=FileLib.getExcelData("sheet1", 1, 0);
//		Validation v=PageFactory.initElements(driver, Validation.class);
//		String msg=v.Verifying(actual, exp);
//		System.out.println(msg);
//		
//		
//	}
	@Test
	public void creatingPurchaseOrder() throws FileNotFoundException
	{
		
		HomePage hp=PageFactory.initElements(driver, HomePage.class);
		Actions ac=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		/*performing action on more dropdown*/
		ac.moveToElement(hp.getMoreDropDown()).perform();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		hp.getPurchaseLink().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//
		PurchaseOrder po=PageFactory.initElements(driver, PurchaseOrder.class);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//po.getCreatePurchaseOrder().click();
		po.getCreatePurchaseOrder().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		ClickingOnCreatePO cocp=PageFactory.initElements(driver,ClickingOnCreatePO.class);
		cocp.getSubjectField().sendKeys(FileLib.getExcelData("Sheet1", 4, 0));
		cocp.getVendorName().click();
		Set<String> se=driver.getWindowHandles();
		
		Iterator<String> it=se.iterator();
		String pa=it.next();
		String ca=it.next();
		driver.switchTo().window(ca);
		driver.manage().window().maximize();
		cocp.getSelectVendorName().click();
		driver.switchTo().window(pa);
		
		cocp.getClickOnBill().sendKeys(FileLib.getExcelData("Sheet1", 4, 2));
		cocp.getClickOnShipping().sendKeys(FileLib.getExcelData("Sheet1", 4, 1));
		cocp.getClickOnItem().click();
		Set<String> sem=driver.getWindowHandles();
		
			Iterator<String> ite=sem.iterator();
			String pac=ite.next();
			String cac=ite.next();
			
			driver.switchTo().window(cac);
		cocp.getClickOnItemName().click();
		driver.switchTo().window(pac);
		cocp.getClickOnQuantity().sendKeys(FileLib.getExcelData("Sheet1", 4, 3));
		cocp.getEnterOnList().sendKeys(FileLib.getExcelData("Sheet1", 4, 4));
		cocp.getClickOnSave().click();
		
	}
}
