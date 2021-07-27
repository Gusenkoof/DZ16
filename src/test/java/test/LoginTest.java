package test;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Driver;
import utils.Log;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginTest{

    private WebDriver driver = Driver.getChromeDriver();

    @Test
    @DisplayName("Тест для проверки входа и выхода из аккаунта")
    public void login(){

        Log.info("Открываем страницу авторизации");
        driver.get("http://a.testaddressbook.com/sign_in");

        Log.info("Проверяем, что открылась нужная страница");
        String pageTitle = driver.getTitle();
        Assertions.assertEquals("Address Book - Sign In", pageTitle, "Вы зашли не на ту страницу");

        Log.info("Входим в учетную запись");
        driver.findElement(By.id("session_email")).sendKeys("Leha148@gmail.com");
        driver.findElement(By.name("session[password]")).sendKeys("Defender198605");
        driver.findElement(By.cssSelector("input[value='Sign in']")).click();

        Log.info("Выходим из аккаунта");
        driver.findElement(By.cssSelector("a[data-test='sign-out']")).click();
        driver.quit();
    }

}
