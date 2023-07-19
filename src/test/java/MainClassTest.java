import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

//В этом классе написаны все основные тесты проекта
public class MainClassTest {
    //Инициализируем драйвер
    private WebDriver driver;
    private MainPage mainPage;

//Написание методов
//@Before - метод setUp, который будет вызываться перед выполнением теста
    @Before
    public void setUp(){
//Указал путь нахождения драйвера
        System.setProperty("webdriver.chromedriver.driver", "D:\\chromedriver_win32\\chromedriver.exe");

//Инициализировал драйвер, проставил ожидание в 15 сек., окно браузера во весь экран, переход на главную страницу GitHub
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/");
//Создаем объект главной страницы и передали конструктору драйвер
        mainPage = new MainPage(driver);
    }

//Проверка, что по клику на SignIn мы действительно попадаем на нужную страницу(с помощью проверки заголовка страницы)
    @Test
    public void signIn(){
//Создал объект класса LoginPage, проверки перехода по клику SignIn на страницу loginPage
        SignInPage signInPage = mainPage.clickSignIn();
//Создал переменную заголовка и вызвал метод получения заголовка страницы
        String headText = signInPage.getHeaderText();
//Проверка, что текст заголовка соответствует заданному тексту
        Assert.assertEquals("Текст заголовка страницы не совпадает с ожидаемым результатом!" ,"Sign in to GitHub", headText);
    }

//Проверка, что по клику на кнопку SignUp с неправильными вводными, мы проверяем, что приходит ошибка
    @Test
    public void registerFailTest(){
//Создали объект класса SignUpPage, кликнув по SignUp, заполним поля и сравним текст полученной ошибки
        SignUpPage signUpPage = mainPage.clickSignUp();
        signUpPage.waitEnterToEmail();
        signUpPage.eMailCreeds("565465");
        String error = signUpPage.getErrorText();
        Assert.assertEquals("Текст ошибки не совпадает с ожидаемым результатом!","Email is invalid or already taken", error);
    }

//Проверка перехода по кликам на кнопки за счет получения текста заголовка страницы
    @Test
    public void clickSignUpPage(){
       SignUpPage signUpPage = mainPage.clickSignUpForGit();
       signUpPage.waitEnterToEmail();
       String signUpPageTextTitle = signUpPage.getTextTitle();
       Assert.assertTrue("Текст заголовка страницы не совпадает с ожидаемым результатом!" , signUpPageTextTitle.contains("Welcome to GitHub!"));
       SignInPage signInPage = signUpPage.clickSignIn();
       String  loginPageTextTitle = signInPage.getHeaderText();
       Assert.assertEquals("Текст заголовка страницы не совпадает с ожидаемым результатом!" ,"Sign in to GitHub", loginPageTextTitle);
    }

//Метод проверки перехода по клику на страницу покупки триала
    @Test
    public void trialPage(){
        StartAFreePage startAFreePage = mainPage.clickStartTrial();
        String textTitle = startAFreePage.getTextTitle();
        Assert.assertEquals("Текст заголовка страницы не совпадает с ожидаемым результатом!", "Pick your trial plan", textTitle);
    }

////Метод проверки перехода по клику на страницу Pricing
    @Test
    public void pricingPage(){
        PricingPage pricingPage = mainPage.clickPricing();
        String title1 = pricingPage.getTitle1();
        String title2 = pricingPage.getTitle2();
        Assert.assertEquals("Текст заголовка страницы не совпадает с ожидаемым результатом!", "Get the complete developer platform.", title1);
        Assert.assertEquals("Текст заголовка страницы не совпадает с ожидаемым результатом!", "How often do you want to pay?", title2);
    }

//Проверка отображения элемента при наведении курсора на Product
    @Test
    public void productMove(){
        boolean product = mainPage.displayedProduct();
        Assert.assertTrue("Объект не отображается!", product);
    }

//Проверка отображения элемента при наведении курсора на Solutions
    @Test
    public void solutionsMove(){
        boolean solutions = mainPage.displayedSolutions();
        Assert.assertTrue("Объект не отображается!", solutions);
    }

//Проверка отображения элемента при наведении курсора на Open Source
    @Test
    public void openSourceMove(){
        boolean openSource = mainPage.displayedOpenSource();
        Assert.assertTrue("Объект не отображается!", openSource);
    }

//@After - метод, который будет выполняться после выполнения каждого теста(будем закрывать браузер)
    @After
    public void tearDown(){
        driver.quit();
    }

}
