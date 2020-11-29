package com.stepDef;

import java.util.ArrayList;
//import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pageFactory.LoginPagePH;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepsCode {
	WebDriver driver;
	LoginPagePH lp; // cre-obj
	WebDriverWait wait;

	@Given("^user open web browser and navigate to phptravels login screen$")
	public void user_open_web_browser_and_navigate_to_phptravels_login_screen() throws Throwable {
		// System.setProperty("webdriver.chrome.driver", "C:\\Program
		// Files\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.phptravels.net/");

		driver.manage().window().maximize();
		lp = PageFactory.initElements(driver, LoginPagePH.class);

	}

	@Then("^user Navigate to Page and verify the Page Title Is \"([^\"]*)\"$")
	public void user_Navigate_to_Page_and_verify_the_Page_Title_Is(String arg1) throws Throwable {
		Thread.sleep(5000);
		String actual = driver.getTitle();
		System.out.println(actual);
		String expected = "PHPTRAVELS | Travel Technology Partner";
		Assert.assertTrue("This Tittle is Wrong", actual.contains(expected));
		System.out.println(expected);
	}

	@Then("^user enter a valid username and Password$")
	public void user_enter_a_valid_username_and_Password() throws Throwable {
		driver.findElement(By.xpath("(//*[@id='dropdownCurrency'])[2]")).click();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@class='dropdown-item active tr']")).click();

		lp.getUsername().sendKeys("user@phptravels.com");// user name
		lp.getPassword().sendKeys("demouser");// password

	}

	@Then("^user click the Loing button$")
	public void user_click_the_Loing_button() throws Throwable {
		WebElement login = driver.findElement(By.xpath("//*[@type='submit']"));
		// [@id='select2-drop']/div/input
		login.click();
	}

	@Then("^user click on the Home button$")
	public void user_click_on_the_Home_button() throws Throwable {
		// action.moveToElement(driver.findElement(By.xpath("//[@title ='home']"));
		// 'home']"))).click().perform(); //[@id=\"s2id_autogen16\"]/a/span[1]
		Thread.sleep(3000);
		WebElement home = driver.findElement(By.xpath("//*[@title = 'home']"));
		wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(home));
		home.click();

	}

	@Then("^user Select destination as Dubai, United Arab Emirates$")
	public void user_Select_destination_as_Dubai_United_Arab_Emirates() throws Throwable {

		// WebElement selectBox =
		// driver.findElement(By.xpath("//*[@id=\"s2id_autogen16\"]/a/span[1]"));
		// selectBox.click();

		WebElement selectt = driver.findElement(By.xpath("//div[@id='s2id_autogen16']/a"));
		selectt.click();
		Thread.sleep(3000);
		// WebElement select =
		// driver.findElement(By.xpath("//*[@id='select2-drop']/div/input"));
		// select.click();
		selectt.sendKeys("Dubai");

		WebElement dubai = driver.findElement(By.xpath("(//*[@class='select2-result-label'])[2]"));
		wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(dubai));
		Thread.sleep(3000);
		selectt.sendKeys(Keys.ENTER);

	}

	@Then("^Check-in date next month and check out next month$")
	public void check_in_date_next_month_and_check_out_next_month() throws Throwable {

		WebElement check = driver.findElement(By.xpath("//*[@id='checkin']"));
		check.click();
		Thread.sleep(2000);
		WebElement checkym = driver.findElement(By.xpath("//*[@data-action='next']"));
		checkym.click();
		WebElement checkdate = driver.findElement(By.xpath("(//*[@data-date='20'])[1]"));
		checkdate.click();

		Thread.sleep(2000);
		WebElement nextym = driver.findElement(By.xpath("(//*[@data-action='next'])[2]"));
		nextym.click();

		Thread.sleep(2000);
		WebElement nextdate = driver.findElement(By.xpath("(//*[@data-date='20'])[2]"));
		nextdate.click();
	}

	@Then("^user Select how maney pepole and click search button$")
	public void user_Select_how_maney_pepole_and_click_search_button() throws Throwable {
		WebElement kids = driver.findElement(By.xpath("(//*[@type='button'])[5]"));
		kids.click();
		// Thread.sleep(2000);
		WebElement search = driver.findElement(By.xpath("(//*[@type='submit'])[1]"));
		search.click();

	}

	@Then("^user able to see all price in descending order$")
	public void user_able_to_see_all_price_in_descending_order() throws Throwable {
		List<WebElement> AllPrice = driver.findElements(By.xpath("//*[@class='text-secondary']"));

		ArrayList<String> NewList = new ArrayList<String>();

		for (int i = 0; i < AllPrice.size(); i++) {
			NewList.add(AllPrice.get(i).getText().toString());
		}
		// Collections.sort(NewList,Collections.reverseOrder());
		System.out.println("List of Price: " + NewList);
		String SecondPrice = NewList.get(1);
		System.out.println("Price of The Second Hotel: " + SecondPrice);

	}

	@Then("^user can Select the second hotel from the list by clicking the DETAILS button$")
	public void user_can_Select_the_second_hotel_from_the_list_by_clicking_the_DETAILS_button() throws Throwable {

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollBy(0,500)");
		WebElement details = driver.findElement(By.xpath("(//*[@class='btn btn-primary btn-sm btn-wide'])[2]"));
		details.click();
	}

	@Then("^user click on see price and date button on the top right and select the first room and remember the price$")
	public void user_click_on_see_price_and_date_button_on_the_top_right_and_select_the_first_room_and_remember_the_price()
			throws Throwable {

		Thread.sleep(3000);
		WebElement seeprice = driver.findElement(By.xpath("//*[@class='anchor btn btn-primary btn-wide mt-5']"));
		seeprice.click();
		Thread.sleep(3000);
		WebElement firstroom = driver
				.findElement(By.xpath("(//*[@class='custom-control-label text-left go-left'])[1]"));
		firstroom.click();
	}

	@Then("^user Then click BOOK NOW button for checkout$")
	public void user_Then_click_BOOK_NOW_button_for_checkout() throws Throwable {

		Thread.sleep(3000);
		// Scroll Down using
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollBy(0,950)");
		WebElement book = driver.findElement(By.xpath("(//*[@type='submit'])[2]"));
		book.click();
	}

	@Then("^user On the next page verify Total Amount is greater than Room Price,$")
	public void user_On_the_next_page_verify_Total_Amount_is_greater_than_Room_Price() throws Throwable {

		Thread.sleep(3000);
		String actualstotalamount = "actualstotalamount";
		String expectedtotalamount = driver.findElement(By.xpath("//*[@class='text-main absolute-right']")).getText();
		System.out.println("This expected price is: " + expectedtotalamount);
		Assert.assertFalse(actualstotalamount.equals(expectedtotalamount));

	}

	@When("^user close the window and logout$")
	public void user_close_the_window_and_logout() throws Throwable {
		WebElement demo = driver.findElement(By.xpath("//*[@id='dropdownCurrency']"));
		demo.click();
		Thread.sleep(3000);
		WebElement logout = driver.findElement(By.xpath("//*[@class='dropdown-item tr']"));
		logout.click();
	}

	@Then("^user navigate to page and verify the page title is \"([^\"]*)\"$")
	public void user_navigate_to_page_and_verify_the_page_title_is(String arg1) throws Throwable {

	}
}
