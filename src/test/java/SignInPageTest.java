import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SignInPageTest {
    private WebDriver driver;
    private SignInPage signInPage;

    @Before
    public void setUp(){
//Указал путь нахождения драйвера
        System.setProperty("webdriver.chromedriver.driver", "D:\\chromedriver_win32\\chromedriver.exe");

//Инициализировал драйвер, проставил ожидание в 15 сек., окно браузера во весь экран, переход на главную страницу GitHub
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/login");
//Создаем объект страницы и передали конструктору драйвер
        signInPage = new SignInPage(driver);
    }

//Проверка получения ошибки после ввода неверного логина и пароля на странице LogInPage
    @Test
    public void incorrectLogin(){
        String signInPageTextTitle = signInPage.getHeaderText();
        Assert.assertEquals("Текст заголовка страницы не совпадает с ожидаемым результатом!" ,"Sign in to GitHub", signInPageTextTitle);
        signInPage.loginIsInvalidCreeds("petya", "shishkin");
        String textError = signInPage.getErrorText();
        Assert.assertEquals("Incorrect username or password.", textError);
    }

//Проверка клика по ссылке Create an account
    @Test
    public void createAcc(){
        SignUpPage signUpPage = signInPage.clickCreateAcc();
        signUpPage.waitEnterToEmail();
        String textTitle = signUpPage.getTextTitle();
        Assert.assertTrue("Текст заголовка страницы не совпадает с ожидаемым результатом!", textTitle.contains("Welcome to GitHub!"));
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
