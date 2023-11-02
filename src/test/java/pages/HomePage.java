package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.Field;
import java.util.List;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(how=How.ID, using="pincodeInput")
    private WebElement pincode;

    @FindBy(how=How.XPATH, using="//ul[@class='pincode-widget_pincode-list__ACLIQ']/li")
    private WebElement option;

    @FindBy(how=How.XPATH, using="//button[text()='START SHOPPING']")
    private WebElement start_shopping_btn;

    @FindBy(how=How.XPATH,using="//span[@class='header_title__Q14Kw']")
    private WebElement pincode_homepage;

    @FindBys({
            @FindBy(how=How.XPATH,using="//a")
    })
    private List<WebElement> link;

    public void click_webelement(String locator){
        Field field;
        try {
            field = this.getClass().getDeclaredField(locator);
            field.setAccessible(true);
            WebElement ele = (WebElement) field.get(this);
            ele.click();
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void senddata(String locator,String data){
        Field field;
        try{
            field = this.getClass().getDeclaredField(locator);
            field.setAccessible(true);
            WebElement ele = (WebElement)field.get(this);
            ele.sendKeys(data);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }


    public WebElement getPincode() {
        return pincode;
    }

    public WebElement getOption() {
        return option;
    }

    public WebElement getStart_shopping_btn() {
        return start_shopping_btn;
    }

    public WebElement getPincode_homepage() {
        return pincode_homepage;
    }

    public List<WebElement> getLink() {
        return link;
    }
}
