package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Driver;
import utils.Log;


public class BeforeAfter {
    public WebDriver driver = Driver.getChromeDriver();

    @BeforeAll
    public void setUp(){
        Log.info("Открываем страницу авторизации");
        driver.get("http://a.testaddressbook.com/sign_in");

        Log.info("Проверяем, что открылась нужная страница");
        String pageTitle = driver.getTitle();
        Assertions.assertEquals("Address Book - Sign In", pageTitle, "Вы зашли не на ту страницу");

        //сделать отдельный класс для залогивания, что бы создать группы автотестов
        Log.info("Входим в учетную запись");
        driver.findElement(By.id("session_email")).sendKeys("Leha148@gmail.com");
        driver.findElement(By.name("session[password]")).sendKeys("Defender198605");
        driver.findElement(By.cssSelector("input[value='Sign in']")).click();

        Log.info("Заходим на страницу добовления адреса");
        driver.findElement(By.xpath("//a[@data-test='addresses']")).click();
                

    }

    @AfterAll
    public void tearDown(){
        Log.info("Выходим из аккаунта");
        driver.findElement(By.cssSelector("a[data-test='sign-out']")).click();
        driver.quit();

    }
            

}
