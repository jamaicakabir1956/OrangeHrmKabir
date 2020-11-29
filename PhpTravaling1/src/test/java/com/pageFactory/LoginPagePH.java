package com.pageFactory;
	
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.How;
	import org.openqa.selenium.support.PageFactory;

	public class LoginPagePH {

		WebDriver driver;

		public LoginPagePH(WebDriver driver) { // c consector
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

		@FindBy(how = How.XPATH, using = "//*[@name='username']")
		private WebElement username;

		@FindBy(how = How.XPATH, using = "//*[@name='password']")
		private WebElement password;

		public WebElement getUsername() {
			return username;
		}

		public void setUsername(WebElement username) {
			this.username = username;
		}

		public WebElement getPassword() {
			return password;
		}

		public void setPassword(WebElement password) {
			this.password = password;
		}


}