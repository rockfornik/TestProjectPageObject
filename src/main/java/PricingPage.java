import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PricingPage {
//Добавил переменную с драйвером
    private WebDriver driver;

//Добавил конструктор
    public PricingPage(WebDriver driver) {
        this.driver = driver;
    }

//Добавил для примера элементы по xpath
    private By textTitle1 = By.xpath("//h1[@class=\"h2-mktg\"]");
    private By textTitle2 = By.xpath("//h2[@class=\"h6-mktg mb-3\"]");


//Добавил метод получения текста заголовка1
    public String getTitle1(){
        return driver.findElement(textTitle1).getText();
    }

//Добавил метод получения текста заголовка2
    public String getTitle2(){
        return driver.findElement(textTitle2).getText();
    }
}
