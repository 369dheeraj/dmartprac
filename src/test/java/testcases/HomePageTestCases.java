package testcases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class HomePageTestCases extends Startup {
    HomePage hp = null;
    @Test(description = "To verify search by pincode", priority = -1)
    public void searchByPincode() throws InterruptedException {
        hp = new HomePage(driver);
        hp.click_webelement("pincode");
        hp.senddata("pincode","400706");
        hp.click_webelement("option");
        hp.click_webelement("start_shopping_btn");
        Thread.sleep(5000);
        Assert.assertEquals(hp.getPincode_homepage().getText(),"400706");
    }

    @Test(description = "To check link on the home page", priority=0)
    public void checkValidLink(){
       List<WebElement> links = hp.getLink();
       HttpURLConnection con;
       int respCode=0;
       String url;
       for(WebElement link:links){
          url=link.getAttribute("href");
          System.out.println(url);
           try {
               con=(HttpURLConnection)(new URL(url).openConnection());
               con.setRequestMethod("HEAD");
               con.connect();
               respCode=con.getResponseCode();
               if(respCode == 200){
                   System.out.println(" URL is working --> "+url);
               }else{
                   System.out.println(" URL is not working --> "+url);
               }
               con.disconnect();
           } catch (MalformedURLException e) {
               e.printStackTrace();
           } catch (IOException e) {
               e.printStackTrace();
           }

       }
    }
}
