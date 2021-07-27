package test;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import utils.Log;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AddressBook extends BeforeAfter{

    @Test
    @Order(1)
    @DisplayName("Тест для проверки добовление нового адреса")
    public void add(){
        Log.info("Нажимаем на кнопку создания адреса");
        driver.findElement(By.xpath("//a[@data-test='create']")).click();

        Log.info("Вводим фамилию");
        driver.findElement(By.id("address_first_name")).sendKeys("Gusenkov");

        Log.info("Вводим имя");
        driver.findElement(By.name("address[last_name]")).sendKeys("Aleksey");

        Log.info("Вводим первый адрес");
        driver.findElement(By.id("address_street_address")).sendKeys("Voroshilova 17/13");

        Log.info("Вводим второй адрес");
        driver.findElement(By.name("address[address2]")).sendKeys("Timiryazeva 38/2");

        Log.info("Вводим город");
        driver.findElement(By.id("address_city")).sendKeys("Krasnopolie");

        Log.info("Из всплывающего списка выбираем Калифорнию");
        driver.findElement(By.cssSelector("option[value='CA']")).click();

        Log.info("Вводим индекс");
        driver.findElement(By.id("address_zip_code")).sendKeys("213561");

        Log.info("В радиобатоне выбираем США");
        driver.findElement(By.xpath("//input[@value='us']")).click();

        Log.info("Вводим датурождения");
        driver.findElement(By.name("address[birthday]")).sendKeys("05.10.1986");

        Log.info("Выбираем цвет");
        driver.findElement(By.id("address_color")).sendKeys("#B00C0C");

        Log.info("Вводим сколько полны хлет");
        driver.findElement(By.cssSelector("input[id='address_age']")).sendKeys("34");

        Log.info("Вводим адрес сайта");
        driver.findElement(By.name("address[website]")).sendKeys("http://krajkx.by");

        Log.info("Добовляем картинку");
        driver.findElement(By.id("address_picture")).sendKeys("C:\\test\\1.png");

        Log.info("Вводим номер телефона");
        driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("+375255123070");

        Log.info("В радиобатоне выбираем Climbing");
        driver.findElement(By.id("address_interest_climb")).click();

        Log.info("В поле Note вводим слово Frend");
        driver.findElement(By.name("address[note]")).sendKeys("Frend");

        Log.info("Нажимаем кнопку создания адреса");
        driver.findElement(By.xpath("//input[@name='commit']")).click();

        Log.info("Проверяем фамилию после добовления новой записи");
        String FirstName = driver.findElement(By.xpath("//span[@data-test='first_name']")).getText();
        Assertions.assertEquals("Gusenkov", FirstName, "Неверная фамилия");

        Log.info("Проверяем имя после добовления новой записи");
        String LastName = driver.findElement(By.xpath("//span[@data-test='last_name']")).getText();
        Assertions.assertEquals("Aleksey", LastName, "Неверное имя");
    }

    @Test
    @Order(2)
    @DisplayName("Тест для проверки редоктирования адреса")
    public void edit(){
        Log.info("Нажимаем на кнопку редактировать");
        driver.findElement(By.cssSelector("a[data-test='edit']")).click();

        Log.info("Чистим поле Фамилия и пишим новую фамилию");
        driver.findElement(By.id("address_first_name")).clear();
        driver.findElement(By.id("address_first_name")).sendKeys("Vasilkov");

        Log.info("Чистим поле State и указываем новый город");
        driver.findElement(By.id("address_city")).clear();
        driver.findElement(By.id("address_city")).sendKeys("Los Angeles");

        Log.info("Убираем галочку с Climbing и нажимаем на Dancing");
        driver.findElement(By.id("address_interest_climb")).click();
        driver.findElement(By.id("address_interest_dance")).click();

        Log.info("Нажимаем на кнопку Update Address");
        driver.findElement(By.cssSelector("input[data-disable-with='Update Address']")).click();

        Log.info("Проверяем фамилию после редактирования записи");
        String FirstName = driver.findElement(By.xpath("//span[@data-test='first_name']")).getText();
        Assertions.assertEquals("Vasilkov", FirstName, "Неверная фамилия");
    }

    @Test
    @Order(3)
    @DisplayName("Тест для проверки удаления аккаунта")
    public void destroy(){
        Log.info("Переходим на страницу с адресами");
        driver.findElement(By.cssSelector("a[data-test='addresses']")).click();

        Log.info("Нажимаем кнопку Destroy");
        driver.findElement(By.xpath("//a[contains(text(),'Destroy')]")).click();

        Log.info("Подтверждаем действие в всплывающем окне");
        driver.switchTo().alert().accept();// нажимает "OK" ввсплывающем окне


 

    }
}
