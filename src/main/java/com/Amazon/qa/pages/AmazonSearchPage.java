package com.Amazon.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.Amazon.qa.testBase.TestBase;

public class AmazonSearchPage  extends TestBase{
	
	public static float actualPrice;
	public static float nextPagePrice;
	public static float proceedCheckOutPrice;
	@FindBy(css="input#twotabsearchtextbox")
	WebElement txtSearch;
	
	@FindBy(css="input#nav-search-submit-button")
	WebElement btnSubmit;
	
	@FindBy(xpath="//div[@class='s-main-slot s-result-list s-search-results sg-row']//div[@data-index=1]//span[@class='a-price']//span[@class='a-price-whole']")
	WebElement elementWholePrice;
	
	@FindBy(xpath="//div[@class='s-main-slot s-result-list s-search-results sg-row']//div[@data-index=1]//span[@class='a-price']//span[@class='a-price-fraction']")
	WebElement elementFractionPrice;
	
	@FindBy(xpath="//div[@class='s-main-slot s-result-list s-search-results sg-row']//div[@data-index=1]")
	WebElement elementSelectOption;
	
	@FindBy(css="span#newBuyBoxPrice")
	WebElement nextPagePriceSpan;
	
	@FindBy(css="input#add-to-cart-button")
	WebElement btnAddToCart;
	
	@FindBy(xpath="//span[@class='ewc-subtotal-amount']")
	WebElement proceedCheckOutPriceSpan;
	
	public AmazonSearchPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	/*public String verifytest_ValidatePrice() {
		txtSearch.sendKeys("qa testing for beginners");
		btnSubmit.click();
		
		String wholePrice = elementWholePrice.getText();
		String fractionPrice = elementFractionPrice.getText();
		fractionPrice="."+fractionPrice;
		 actualPrice=Float.parseFloat(wholePrice)+Float.parseFloat(fractionPrice);
		elementSelectOption.click();
		
		String nextPagePrice = nextPagePriceSpan.getText();
		nextPagePrice=nextPagePrice.replaceAll("['$']","");
		Float nextPageFloatPrice = Float.parseFloat(nextPagePrice);
		//Assert.assertEquals(actualPrice, nextPageFloatPrice);
		btnAddToCart.click();
		
		String proceedCheckoutPrice= proceedCheckOutPriceSpan.getText();	
		proceedCheckoutPrice=proceedCheckoutPrice.replaceAll("['$']", "");
		Float proceedCheckOutPriceFloat =Float.parseFloat(proceedCheckoutPrice);
		//Assert.assertEquals(actualPrice, proceedCheckOutPriceFloat);
		
		//***********************************************************
		return driver.getTitle();
	}*/
	
	public void verifytest_ValidatePrice() {
		
		txtSearch.sendKeys("qa testing for beginners paperback");
		btnSubmit.click();
		
		String strWholePrice = elementWholePrice.getText();
		String strFractionPrice = elementFractionPrice.getText();
		strFractionPrice="."+strFractionPrice;
		actualPrice=Float.parseFloat(strWholePrice)+Float.parseFloat(strFractionPrice);
		elementSelectOption.click();
		
		String strNextPagePrice = nextPagePriceSpan.getText();
		strNextPagePrice=strNextPagePrice.replaceAll("['$']","");
		nextPagePrice = Float.parseFloat(strNextPagePrice);		
		btnAddToCart.click();
		
		String strProceedCheckoutPrice= proceedCheckOutPriceSpan.getText();	
		strProceedCheckoutPrice=strProceedCheckoutPrice.replaceAll("['$']", "");
		proceedCheckOutPrice =Float.parseFloat(strProceedCheckoutPrice);
		
		
	}
	
}
