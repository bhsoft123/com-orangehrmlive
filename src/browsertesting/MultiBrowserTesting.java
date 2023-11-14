package browsertesting;

/*Project-2 - ProjectName : com-orangehrmlive
BaseUrl = https://opensource-demo.orangehrmlive.com/
1. Setup chrome browser.
2. Open URL.
3. Print the title of the page.
4. Print the current url.
5. Print the page source.
6. Click on ‘Forgot your password?’ link.
7. Print the current url.
8. Navigate back to the login page.
9. Refresh the page.
10. Enter the email to email field.
11. Enter the password to password field.
12. Click on Login Button.
13. Close the browser.*/


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowserTesting {
    static String browser = "Chrome";
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        //1. Setup browser
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }

        //2. Open Url
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //3.Print the title of the page
        System.out.println("Title of the page:" + driver.getTitle());
        //4.Print the current Url
        System.out.println("The current url: " + driver.getCurrentUrl());
        //5.Print the page source
        System.out.println("Page Source:" + driver.getPageSource());
        //6.Click on 'forgot your password link
        WebElement forgotPasswordLink = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']"));
        forgotPasswordLink.click();
        //7.Print the current Url
        driver.getCurrentUrl();
        //8.Navigate back to login page
        driver.navigate().to(baseUrl);
        //9. Refresh the page
        driver.navigate().refresh();
        //10.Enter the email to email field
        WebElement emailField = driver.findElement(By.name("username"));
        emailField.sendKeys("prime123@gmail.com");
        //11. Enter the password to password field
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("12345");
        //12. Click on Login Button
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        //13.Close the browser
        driver.quit();
    }}