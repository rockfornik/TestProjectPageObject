import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SignUpPageTest {
    private WebDriver driver;
    private SignUpPage signUpPage;

    @Before
    public void setUp(){
        //Указал путь нахождения драйвера
        System.setProperty("webdriver.chromedriver.driver", "D:\\chromedriver_win32\\chromedriver.exe");

//Инициализировал драйвер, проставил ожидание в 15 сек., окно браузера во весь экран, переход на главную страницу GitHub
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/signup?source=login");
//Создаем объект страницы и передали конструктору драйвер
        signUpPage = new SignUpPage(driver);
    }

//Проверка перехода на главную страницу по кнопке гит
    @Test
    public void gitButton(){
        MainPage mainPage = signUpPage.clickGitButton();
        String titleMainPage = mainPage.titlePage();
        Assert.assertEquals("Текст заголовка не совпадает с шаблоном!", "Let’s build from here", titleMainPage);
    }

//Проверка ввода неверного eMail и вывода ошибки
    @Test
    public void incorrectEMail(){
        signUpPage.waitEnterToEmail();
        signUpPage.eMailCreeds("asdgfsdg");
        String error = signUpPage.getErrorText();
        Assert.assertEquals("Текст ошибки не совпадает с шаблоном!", "Email is invalid or already taken", error);
    }

//Проверка клика по кнопке SignIn и перехода на страницу
    @Test
    public void clickSignIn(){
        SignInPage signInPage = signUpPage.clickSignIn();
        String titlePage = signInPage.getHeaderText();
        Assert.assertEquals("Текст заголовка не совпадает с шаблоном!", "Sign in to GitHub", titlePage);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
