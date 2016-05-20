/**
 * Created by xiaokaiwang on 02/28/16.
 */

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.WebDriver;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTests {
    /**
     * As a user,
     * I would like to log into Stack Overflow using username and password
     * So that I can use extra features of the website
     * @author xwang
     */
    static WebDriver driver = new HtmlUnitDriver();




    // start at login page for every tests
    @Before
    public void setUp()throws Exception{

        driver.get("https://www.reddit.com");


    }

    // Given a valid username and a valid password of reddit
    // When user uses the above username and password to login
    // Then the user is logged in
    @Test
    public void fTestValidUsernameAndPassword() throws Exception{


        driver.findElement(By.name("user")).clear();
        driver.findElement(By.name("user")).sendKeys("cs1632testtesttest");
        driver.findElement(By.name("passwd")).clear();
        driver.findElement(By.name("passwd")).sendKeys("cs1632test");
        WebElement loginButton = driver.findElement(By.className("btn"));
        loginButton.click();

        assertFalse(isElementPresent(By.name("user")));
        assertFalse(isElementPresent(By.name("passwd")));
        driver.findElement(By.linkText("logout")).click();
        driver.navigate().refresh();



    }

    // Given an invalid username and a valid password
    // When user uses the above username and password to login
    // Then the user is not logged in
    @Test
    public void aTestInValidUsernameAndValidPassword() throws Exception{


        driver.findElement(By.name("user")).clear();
        driver.findElement(By.name("user")).sendKeys("invalid");
        driver.findElement(By.name("passwd")).clear();
        driver.findElement(By.name("passwd")).sendKeys("cs1632test");
        WebElement loginButton = driver.findElement(By.className("btn"));
        loginButton.click();

        WebElement resetPw = driver.findElement(By.linkText("reset password"));
        assertTrue(resetPw.isDisplayed());
        assertTrue(isElementPresent(By.name("user")));
        assertTrue(isElementPresent(By.name("passwd")));

        driver.navigate().refresh();


    }

    // Given a valid username and an invalid password,
    // When user uses the above username and password to login,
    // Then the user is not logged in.

    @Test
    public void bTestValidUsernameAndInValidPassword() throws Exception{


        driver.findElement(By.name("user")).clear();
        driver.findElement(By.name("user")).sendKeys("cs1632testtesttest");
        driver.findElement(By.name("passwd")).clear();
        driver.findElement(By.name("passwd")).sendKeys("invalid");
        WebElement loginButton = driver.findElement(By.className("btn"));
        loginButton.click();
        driver.navigate().refresh();
        WebElement resetPw = driver.findElement(By.linkText("reset password"));
        assertTrue(resetPw.isDisplayed());
        assertTrue(isElementPresent(By.name("user")));
        assertTrue(isElementPresent(By.name("passwd")));
        driver.navigate().refresh();
    }

    // Given no username or password,
    // When user attempts to login without username and password,
    // Then the user is not logged in.

    @Test
    public void cTestNoUsernameAndPassword() throws Exception{



        driver.findElement(By.name("user")).clear();
        driver.findElement(By.name("user")).sendKeys("");
        driver.findElement(By.name("passwd")).clear();
        driver.findElement(By.name("passwd")).sendKeys("");
        WebElement loginButton = driver.findElement(By.className("btn"));
        loginButton.click();
        driver.navigate().refresh();
        WebElement resetPw = driver.findElement(By.linkText("reset password"));
        assertTrue(resetPw.isDisplayed());
        assertTrue(isElementPresent(By.name("user")));
        assertTrue(isElementPresent(By.name("passwd")));
        driver.navigate().refresh();
    }

    // Given a username as “Admin” and a password as “Admin” too,
    // When user uses the above username and password to login,
    // Then the user is not logged in.

    @Test
    public void dTestAdmin() throws Exception{


        driver.findElement(By.name("user")).clear();
        driver.findElement(By.name("user")).sendKeys("Admin");
        driver.findElement(By.name("passwd")).clear();
        driver.findElement(By.name("passwd")).sendKeys("Admin");
        WebElement loginButton = driver.findElement(By.className("btn"));
        loginButton.click();
        driver.navigate().refresh();
        WebElement resetPw = driver.findElement(By.linkText("reset password"));
        assertTrue(resetPw.isDisplayed());
        assertTrue(isElementPresent(By.name("user")));
        assertTrue(isElementPresent(By.name("passwd")));
        driver.navigate().refresh();
    }

    // Given no username and a password as “cs1632test”,
    // When user uses the above username and password to login,
    // Then the user is not logged in.

    @Test
    public void eTestNoUsername() throws Exception{


        driver.findElement(By.name("user")).clear();
        driver.findElement(By.name("user")).sendKeys("");
        driver.findElement(By.name("passwd")).clear();
        driver.findElement(By.name("passwd")).sendKeys("cs1632test");
        WebElement loginButton = driver.findElement(By.className("btn"));
        loginButton.click();
        driver.navigate().refresh();
        WebElement resetPw = driver.findElement(By.linkText("reset password"));
        assertTrue(resetPw.isDisplayed());
        assertTrue(isElementPresent(By.name("user")));
        assertTrue(isElementPresent(By.name("passwd")));
        driver.navigate().refresh();
    }




    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }



}
