package pageObjects.android;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.AndroidActions;

public class FormPage extends AndroidActions{
	AndroidDriver driver;
	public FormPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	public WebElement countrydropdown;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	public WebElement name;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioMale")
	public WebElement male;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	public WebElement letsshop;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Products']")
	public WebElement toolbar;
	
	@AndroidFindBy(xpath="//android.widget.Toast[@text='Please enter your name']")
	public WebElement errormessage;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Philippines']")
	public WebElement philippines;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Air Jordan 4 Retro']")
	public WebElement product1;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Air Jordan 1 Mid SE']")
	public WebElement product2;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Nike Blazer Mid '77']")
	public WebElement product3;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Converse All Star']")
	public WebElement product4;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Air Jordan 9 Retro']")
	public WebElement product5;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Jordan 6 Rings']")
	public WebElement product6;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Jordan Lift Off']")
	public WebElement product7;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='LeBron Soldier 12']")
	public WebElement product8;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='PG 3']")
	public WebElement product9;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Nike SFB Jungle']")
	public WebElement product10;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[2]")
	public WebElement addtocart1;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[2]")
	public WebElement addtocart2;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	public WebElement cart;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productName")
	public WebElement checkout;
	
	
	
	
	
	
	
	
	
	 
	
	public void clickOnElement(WebElement ele) {
		ele.click();
	}
	
	public void sendKeys(WebElement ele) {
		ele.sendKeys("");
	}	
	
	public void navigateBack() {
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
	public String getText(WebElement ele) {
		return ele.getText();
	}
	
	public void validateIfDisplayedTrue(WebElement ele) {
		Assert.assertTrue(ele.isDisplayed());
		System.out.println("Element is displayed");
	}
	public void validateIfDisplayedFalse(WebElement ele) {
		Assert.assertFalse(ele.isDisplayed());
		System.out.println("Element is not displayed");
	}
	

		
		
	}


