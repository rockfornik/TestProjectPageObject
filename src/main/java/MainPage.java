import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

//Класс с элементами главной страницы Github
public class MainPage {
//Добавил переменную с драйвером
    private WebDriver driver;
    private Actions actions;

    //Добавил конструктор
    public MainPage(WebDriver driver) {
        this.actions = new Actions(driver);
        this.driver = driver;
    }
//Сначала на главной странице описал по xpath элементы взаимодействия
    private By productButton = By.xpath("//*[@class=\"d-lg-flex list-style-none\"]/li[1]");
    private By solutionsButton = By.xpath("//*[@class=\"d-lg-flex list-style-none\"]/li[2]");
    private By openSourceButton = By.xpath("//*[@class=\"d-lg-flex list-style-none\"]/li[3]");
    private By pricingButton = By.xpath("//header[@role=\"banner\"]/div/div[2]/div/nav/ul/li[4]");
    private By signInButton = By.xpath("//*[contains(text(), 'Sign in')]");
    private By signUpButton = By.xpath("//header[@role=\"banner\"]/div/div[2]/div/div/a");
    private By searchOrJumpTo = By.xpath("//*[contains(text(), 'Search or')]");
    private By emailAddress = By.xpath("//input[@placeholder=\"Email address\"]");
    private By signUpForGitButton = By.xpath("//form[@data-turbo=\"false\"]/div/button");
    private By startTrialButton = By.xpath("//div[@class=\"d-flex flex-column flex-md-row\"]/a");
    private By titlePage = By.xpath("//h1[contains(@class, 'h0-mktg')]");
    private By moveSecurityButton = By.xpath("//div[contains(text(), 'Security')]");
    private By moveEducationButton = By.xpath("//a[contains(text(), 'Education')]");
    private By moveTopicsButton = By.xpath("//a[contains(text(), 'Topics')]");


//После создал метод взаимодействия, например click
//Далее, создал классы страниц, с которыми можно взаимодействовать в дальнейшем после клика
//Вместо void добавил класс этой страницы, вернул(return) объект LoginPage и передал туда драйвер(driver)
    public SignInPage clickSignIn(){
        driver.findElement(signInButton).click();
        return new SignInPage(driver);
    }

//Аналогично с предыдущим методом поступил с методом clickSignUp
    public SignUpPage clickSignUp(){
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }

//Т.к. по нажатию этой кнопки перебросит так же на страницу SignUp, сделал метод, который возвращает SignUpPage
    public SignUpPage clickSignUpForGit(){
        driver.findElement(signUpForGitButton).click();
        return new SignUpPage(driver);
    }

//Создал метод клика по кнопке StartTrial, вернул объект StartAFreePage и передал туда драйвер(driver)
    public StartAFreePage clickStartTrial(){
        driver.findElement(startTrialButton).click();
        return new StartAFreePage(driver);
    }

//Добавил метод клика по кнопке pricingButton, вернул объект PricingPage и передал туда драйвер(driver)
    public PricingPage clickPricing(){
        driver.findElement(pricingButton).click();
        return new PricingPage(driver);
    }

//Метод получения заголовка страницы
    public String titlePage(){
        return driver.findElement(titlePage).getText();
    }

//Добавил методы взаимодействия с полями, т.к. после взаимодействия они не переносят нас на другую страницу, буду возвращать MainPage
//После заполнения поля, вернул данную страницу(return this;)
    public MainPage typeSearchOr(String searchText){
        driver.findElement(searchOrJumpTo).sendKeys(searchText);
        return this;
    }

//По аналогии с предыдущим методом, написал метод заполнения поля Email
    public MainPage typeEmail(String eMail){
        driver.findElement(emailAddress).sendKeys(eMail);
        return this;
    }

//Добавил методы наведения курсора на кнопку Product;
    public void moveToProduct(){
        WebElement product = driver.findElement(productButton);
        actions.moveToElement(product).build().perform();
    }

//Добавил методы наведения курсора на кнопку Solutions;
    public void moveToSolutions(){
        WebElement solutions = driver.findElement(solutionsButton);
        actions.moveToElement(solutions).build().perform();
    }

//Добавил методы наведения курсора на кнопку OpenSource;
    public void moveToOpenSource(){
        WebElement openSource = driver.findElement(openSourceButton);
        actions.moveToElement(openSource).build().perform();
    }

//Добавил метод ввода значений в поле регистрации и клика по кнопке. Метод возвращает страницу SignUp, принимает eMail, который передаётся в метод класса typeEmail.
//Добавил метод клика по кнопке и вернул SignUpPage, которому передал driver
    public MainPage registration(String eMail) {
        this.typeEmail(eMail);
        this.clickSignUpForGit();
        return this;
    }

//Метод проверки наведения курсора и отображения объектов на дисплее Product
    public Boolean displayedProduct(){
        this.moveToProduct();
        this.pause(1000);
        WebElement product = driver.findElement(moveSecurityButton);
        return product.isDisplayed();
    }

//Метод проверки наведения курсора и отображения объектов на дисплее Solutions
    public Boolean displayedSolutions(){
        this.moveToSolutions();
        this.pause(1000);
        WebElement solutions = driver.findElement(moveEducationButton);
        return solutions.isDisplayed();
    }

//Метод проверки наведения курсора и отображения объектов на дисплее Solutions
    public Boolean displayedOpenSource(){
        this.moveToOpenSource();
        this.pause(1000);
        WebElement openSource = driver.findElement(moveTopicsButton);
         return openSource.isDisplayed();
    }

//Добавил метод, который делает паузу, что бы визуально увидеть результат, например наведения курсора на элемент
    public void pause (int mls){
        try {
            Thread.sleep(mls);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
