import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class StartAFreePage {
//Добавил переменную с драйвером
    private WebDriver driver;

//Добавил конструктор
    public StartAFreePage(WebDriver driver) {
        this.driver = driver;
    }

//Добавил элемент для примера по xpath
    private By textTitle = By.xpath("//h1[contains(text(), 'Pick')]");


//Добавил метод получения текста элемента
    public String getTextTitle(){
        return driver.findElement(textTitle).getText();
    }
}
