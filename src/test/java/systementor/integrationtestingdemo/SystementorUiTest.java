package systementor.integrationtestingdemo;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("ui")
public class SystementorUiTest {

    private WebDriver driver;
    private WebDriverWait wait;


    @BeforeEach
    void setUp(){
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");



        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @AfterEach
    void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }



    @Test
    void clickShouldTakeUsToAboutUs() {

        driver.get("https://systementor.se");

        WebElement theCompany = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//*[@id=\"site-nav\"]/ul/li[1]/details/summary")));

        theCompany.click();

        WebElement aboutUs = wait.until(ExpectedConditions
                .elementToBeClickable(By.linkText("Om oss")));


        aboutUs.click();


        wait.until(ExpectedConditions.urlContains("/omoss/foretaget"));

        assertTrue(driver.getCurrentUrl().contains("/omoss/foretaget"));




    }









}
