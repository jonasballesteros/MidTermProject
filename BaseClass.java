package android;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import pageObjects.android.FormPage;

public class BaseClass {
	
	AppiumDriverLocalService service;
	FormPage FormPage;
	protected AndroidDriver driver;
	ExtentReports extent;
	ExtentTest test;
	// this is a test
	
	@BeforeTest
	public void startServerwithApp() throws IOException {
		Properties prop=new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\config\\data.properties");
		prop.load(fis);
		String ipAddress=prop.getProperty("ipAddress");
		String portNo=prop.getProperty("port");
		String deviceName=prop.getProperty("AndroidDeviceName");
		
		service=new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\COLLABERA.DIGITAL\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress(ipAddress).usingPort(Integer.parseInt(portNo)).build();
		service.start();
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName(deviceName);
		
		options.setCapability("appium:autoGrantPermissions",true);
	//	options.setCapability("appium:appWaitActivity","in.amazon.android.activity.FirstLaunchActivity");
		options.setApp("C:\\Users\\COLLABERA.DIGITAL\\eclipse-workspace\\MidtermProject\\src\\main\\resources\\appUsed\\General-Store (2).apk");
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		

		FormPage=new FormPage(driver);
		
	}
	@BeforeClass
	public void configReports() {
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Android Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Jonas");
		test =extent.createTest("Click on View and scroll to WebView test");
	}
	@AfterClass
	public void closeReport() {
		extent.flush();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
		service.stop();
	}

}
