import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Amazon.qa.pages.AmazonSearchPage;
import com.Amazon.qa.testBase.TestBase;
import org.testng.Assert;

public class AmazonPageTestPOM extends TestBase {

	AmazonSearchPage objAmazonSearchPage;
	
	public  AmazonPageTestPOM() {
		
	}

	@BeforeMethod
	public void setUp() throws FileNotFoundException {
		initialization();
		objAmazonSearchPage = new AmazonSearchPage();
		
	}
	
	@Test
	  public void verifyPrice() {
		 objAmazonSearchPage.verifytest_ValidatePrice();
		 Assert.assertEquals(AmazonSearchPage.actualPrice, AmazonSearchPage.nextPagePrice,"Actual price and Next Page price does not match");
		 Assert.assertEquals(AmazonSearchPage.actualPrice, AmazonSearchPage.proceedCheckOutPrice,"Actual price and proceed to check out page price does not match");
		
	  }
	
	@AfterMethod
	  public void tearDown() {
		  driver.close();
	  }
}
