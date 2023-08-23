package hellocucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;

class LoginToPage{
    private String _userName;
    private String _pass;
    WebDriver driver = new ChromeDriver();
    private String _currentTitle = driver.getCurrentUrl();
    
    public void LoadToPage(){
        driver.manage().window().maximize();
        driver.get("https://essdummy.formulatrix.com/");
        _currentTitle = driver.getTitle();
    }
    public void Login(){           
        driver.findElement(By.id("username")).sendKeys(_userName);
        driver.findElement(By.id("password")).sendKeys(_pass);
        driver.findElement(By.tagName("button")).click();
    }
    public void LoadReviewTaskPage(){
        driver.findElement(By.className("menuIcon")).click();
        // driver.findElement(By.xpath("//a[@href ='/review/ReviewTask']")).click(); 
    }
    public String GetTitlePage(){
        return _currentTitle;
    }

    public boolean SetUserName(String name, String pass){
        if(name != null && pass != null){
            this._userName = name;
            this._pass = pass;
            return true;
        }
        return false;
    }

}
public class StepDefinitions {
    LoginToPage login = new LoginToPage();
    @Given("the user is on the homepage")
    public void the_user_is_on_the_homepage() {
        login.LoadToPage();
    }
    @When("the user fill correct user {string} and password {string} and login")
    public void the_user_fill_correct_user_and_password_and_login(String string, String string2) {
        login.SetUserName(string, string2);
        login.Login();
    }
    @Then("the user should be directed to the login page")
    public void the_user_should_be_directed_to_the_login_page() {
        String title = login.GetTitlePage();
        assertEquals("Formulatrix Engineering Review System", title,"check");
    }


    // user go to review task page
    @Given("the user is already on the homepage")
    public void the_user_is_already_on_the_homepage() {
        String title = login.GetTitlePage();
        assertEquals("Formulatrix Engineering Review System", title, "check");
    }
    @When("the user click menu icon and choose review task menu")
    public void the_user_click_menu_icon_and_choose_review_task_menu() {
        login.GetTitlePage();        
    }
    @Then("the user should be directed to the review task page")
    public void the_user_should_be_directed_to_the_review_task_page() {
        login.GetTitlePage();
    }


}