package stepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddCustomerPage;
import pageObjects.AdminPage;

public class Step extends Base {

	@Given("^User Launch chrome Browsers$")
	public void user_launch_chrome_browsers() throws Exception {
	   System.setProperty("webdriver.chrome.driver", "E:\\Chrome_105\\chromedriver_win32\\chromedriver.exe");
	   driver=new ChromeDriver();
	   Thread.sleep(2000);
	   ad=new AdminPage(driver);
	}
	@When("User open URL {string}")
	public void user_open_url(String url) throws Exception {
	    driver.get(url);
	    driver.manage().window().maximize();
	    Thread.sleep(2000);
	}

	@When("User enter email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String email, String password) {
	   ad.setUsername(email);
	   ad.setPassword(password);
	}

	@When("User click on Login")
	public void user_click_on_login() {
	   ad.clickLogin();
	}
	
	@Then("Page title should be {string}")
	public void page_title_should_be(String title) throws Exception {
	   
		Assert.assertEquals(title, driver.getTitle());
		Thread.sleep(2000);
	}
	

	@When("close browser")
	public void close_browser() throws Exception {
		Thread.sleep(2000);
	   driver.quit();
	   
	}
	
	//add new customer
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
	 addCust=new AddCustomerPage(driver);
	 Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
	}

	@When("Click on customers menu")
	public void click_on_customers_menu() throws Exception {
	Thread.sleep(2000);
		addCust.clickOnCustomesMenu();
	}

	@When("Click on customers menu item")
	public void click_on_customers_menu_item() throws Exception {
		Thread.sleep(2000);

		addCust.clickOnCustomesMenuItem();
	}

	@When("Click on add new button")
	public void click_on_add_new_button() throws Exception {
	 addCust.clickOnAddNew();
		Thread.sleep(2000);

	}

	@Then("User can view add new customer page")
	public void user_can_view_add_new_customer_page() throws Exception {
		Thread.sleep(2000);

		Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws Exception {
		Thread.sleep(2000);

		addCust.SetEmail("Bali345@gmail.com");
		addCust.SetPassword("2345");
		addCust.SetFirstName("Bali");
		addCust.SetLastName("Raj");
		addCust.SetGender("Male");
		addCust.SetCompanyName("BalirajAutomationTraining");
		addCust.SetAdminContent("This for testing");
		Thread.sleep(2000);

	}

	@When("click on save button")
	public void click_on_save_button() {
	
		addCust.clickOnSave();
	}

	@Then("user can view confirmation msg {string}")
	public void user_can_view_confirmation_msg(String string) throws Exception {
	  Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully."));
		Thread.sleep(2000);

	}

	
	
}
