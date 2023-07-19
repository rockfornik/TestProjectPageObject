import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

//Класс был написан для примера работоспособности выполнения
public class Main {
    static WebDriver driver;

    public static void main(String[] args) {
////Указал путь к драйверу
//        System.setProperty("webdriver.chromedriver.driver", "D:\\chromedriver_win32\\chromedriver.exe");
//
////Инициализировал драйвер, проставил ожидание в 15 сек., окно браузера во весь экран, перешел на страницу GitHub
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//        driver.get("https://github.com/");
//
//
//
////Объект главной страницы MainPage
//        MainPage mainPage = new MainPage(driver);
////Инициализация класса с помощью PageFactory
////        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
//
////Выполнил метод попытки регистрации с неверным eMail, наведение на кнопки, после клик по кнопке SignUp
//        mainPage.registration("dfdfsf");
//        mainPage.moveToProduct();
//        mainPage.pause(1000);
//        mainPage.moveToOpenSource();
//        mainPage.pause(1000);
//        mainPage.moveToSolutions();
//        mainPage.pause(1000);
//        mainPage.clickSignUp();
//
//
////Объект страницы SignUpPage
////        SignUpPage signUpPage = new SignUpPage(driver);
////Инициализация класса с помощью PageFactory
//        SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);
////Выполнил метод ожидания элемента, после чего попытка регистрации с неверным Mail и проверка тектса сообщения ошибки
//        signUpPage.waitEnterToEmail();
//        signUpPage.eMailCreeds("4646+56+");
//        System.out.println(signUpPage.getErrorText());

    }
}
