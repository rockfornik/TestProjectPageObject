import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Создал класс, т.к. после метода clickSignIn мы попадаем на страницу логина

public class SignInPage {
//Добавил переменную с драйвером
    private WebDriver driver;

//Добавил конструктор
    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

//Добавил элементы по xpath
    private By userName = By.xpath("//input[@name=\"login\"]");
    private By password = By.xpath("//input[@name=\"password\"]");
    private By signInButton = By.xpath("//input[@name=\"commit\"]");
    private By forgotPassword = By.xpath("//a[text()=\"Forgot password?\"]");
    private By createAnAccount = By.xpath("//a[text()=\"Create an account\"]");
    private By headerPage = By.xpath("//div[contains(@class, 'auth-form-header')]");
    private By error = By.xpath("//div[@id=\"js-flash-container\"]");


//Добавил методы, которые позволяют работать с элементами
//Метод ввода имени пользователя
    public SignInPage typeUserName(String name){
        driver.findElement(userName).sendKeys(name);
        return this;
    }

//Метод ввода пароля пользователя
    public SignInPage typePassword(String pass){
        driver.findElement(password).sendKeys(pass);
        return this;
    }

//Метод клика по кнопке Sign in c неправильным логином
//Метод вернет не этот же объект LoginPage, а новый и вернет в него драйвер(driver)
    public SignInPage loginIsInvalidCreeds(String name, String pass){
        this.typeUserName(name);
        this.typePassword(pass);
        driver.findElement(signInButton).click();
        return new SignInPage(driver);
    }

//Метод получения текста заголовка
//Метод возвращает строку(String), т.е. текст заголовка
    public String getHeaderText(){
        return driver.findElement(headerPage).getText();
    }

//Метод получения текста ошибки неверного ввода
    public String getErrorText(){
        return driver.findElement(error).getText();
    }

//Метод клика по ссылке createAnAccount
    public SignUpPage clickCreateAcc(){
        driver.findElement(createAnAccount).click();
        return new SignUpPage(driver);
    }
}
