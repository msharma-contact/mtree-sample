import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonPageTest {

	WebDriver driver ;
	String url="https://www.amazon.com/";

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
	}



	@Test
	public void test_ValidatePrice() throws InterruptedException {
		driver.findElement(By.cssSelector("input#twotabsearchtextbox")).sendKeys("qa testing for beginners");
		driver.findElement(By.cssSelector("input#nav-search-submit-button")).click();
		String wholePrice=driver.findElement(By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']//div[@data-index=3]//span[@class='a-price']//span[@class='a-price-whole']")).getText();
		String fractionPrice=driver.findElement(By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']//div[@data-index=3]//span[@class='a-price']//span[@class='a-price-fraction']")).getText();
		fractionPrice="."+fractionPrice;
		Float actualPrice=Float.parseFloat(wholePrice)+Float.parseFloat(fractionPrice);
		driver.findElement(By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']//div[@data-index=3]")).click();
		String nextPagePrice =driver.findElement(By.cssSelector("span#newBuyBoxPrice")).getText();
		nextPagePrice=nextPagePrice.replaceAll("['$']","");
		Float nextPageFloatPrice=Float.parseFloat(nextPagePrice);
		Assert.assertEquals(actualPrice, nextPageFloatPrice);
		driver.findElement(By.cssSelector("input#add-to-cart-button")).click();
		Thread.sleep(3000);
		String proceedCheckoutPrice= driver.findElement(By.xpath("//span[@class='ewc-subtotal-amount']")).getText();	
		proceedCheckoutPrice=proceedCheckoutPrice.replaceAll("['$']", "");
		Float proceedCheckOutPriceFloat =Float.parseFloat(proceedCheckoutPrice);
		Assert.assertEquals(actualPrice, proceedCheckOutPriceFloat);


	}
	@AfterMethod()
	public void tearDown() {
		driver.close();
	}
}
