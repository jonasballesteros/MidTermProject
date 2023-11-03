package android;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import pageObjects.android.FormPage;
import utils.AndroidActions;



public class LaunchApplication extends BaseClass {

	@Test
	public void launchApp() throws MalformedURLException {
		
		
	// This is for login and validation	
		FormPage.clickOnElement(FormPage.countrydropdown);
		AndroidActions.scollToText("Philippines");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		FormPage.clickOnElement(FormPage.philippines);
		FormPage.clickOnElement(FormPage.male);
		FormPage.clickOnElement(FormPage.letsshop);
		FormPage.getText(FormPage.errormessage);
		FormPage.name.sendKeys("Jonas");
		FormPage.clickOnElement(FormPage.letsshop);
		FormPage.validateIfDisplayedTrue(FormPage.toolbar);
		
	// This is inside Product list	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
		
		String procart ="Air Jordan 1 Mid SE";
		
	if (procart == "Air Jordan 4 Retro"){
		FormPage.clickOnElement(FormPage.addtocart1);
	}
	else {
		System.out.println("Not Air Jordan 4 Retro ");
	}
	
	if (procart == "Air Jordan 1 Mid SE") {
		FormPage.clickOnElement(FormPage.addtocart2);	
	}
	else {
		System.out.println("Not Air Jordan 1 Mid SE ");
	}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		FormPage.clickOnElement(FormPage.cart);
		
		String finalproduct = FormPage.getText(FormPage.checkout);
		
		if (finalproduct == procart) {
			System.out.println(finalproduct);
		}
		else {
			System.out.println("Not the Same");
		}
					
	
	}
	
}
