import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

//Создал класс, т.к. после метода clickSignUp мы попадаем на страницу SignUp

public class SignUpPage {
//Добавил переменную с драйвером
    private WebDriver driver;

//Добавил конструктор
    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

//Добавил элементы по xpath
    private By signIn = By.xpath("//a[contains(text(), 'Sign in')]");
    private By eMailField = By.xpath("//input[@type=\"email\"]");
    private By continueButton = By.xpath("//button[@data-continue-to=\"password-container\"]");
    private By textTitle = By.xpath("//span[@data-target ='typing-effect.content']");
    private By errorText = By.xpath("//p[@class=\"mb-0\"]");
    private By gitButton = By.xpath("//a[@aria-label=\"Homepage\"]");
    private By textEmail = By.xpath("//label[@for=\"email\"]");


//Написал методы работы с элементами
//Метод клика по Sign in
    public SignInPage clickSignIn(){
        driver.findElement(signIn).click();
        return new SignInPage(driver);
    }

//Метод клика по кнопке Git
    public MainPage clickGitButton(){
        driver.findElement(gitButton).click();
        return new MainPage(driver);
    }

//Метод ввода значений в поле eMail
    public SignUpPage eMailCreeds(String eMail){
        driver.findElement(eMailField).sendKeys(eMail);
        return this;
    }

//Метод ввода невалидных значений в поле eMail + клик Continue
    public SignUpPage invalidEMail(String mail){
        this.eMailCreeds(mail);
        driver.findElement(continueButton).click();
        return new SignUpPage(driver);
    }

//Метод проверки текста заголовка окна ввода eMail(вернет текст)
    public String getTextTitle(){
        return driver.findElement(textTitle).getText();
    }

//Метод получения текста ошибки ввода невалидного eMail
    public String getErrorText(){
        return driver.findElement(errorText).getText();
    }

//Метод явного ожидания элемента Enter your email
    public void waitEnterToEmail(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(textEmail));
    }

}


