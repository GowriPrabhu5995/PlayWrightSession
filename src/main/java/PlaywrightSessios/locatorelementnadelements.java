package PlaywrightSessios;
import com.microsoft.playwright.*;
import java.lang.*;

//git import java.lang.reflect.Method;
import java.util.List;
public class locatorelementnadelements  {

    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext=browser.newContext();
        Page page=browserContext.newPage();
        page.navigate("https://www.orangehrm.com/en/30-day-free-trial");
       // Thread.sleep(3000);
      Locator contactSales = page.locator("text=Contact Sales").last();
        contactSales.click();
        Locator countryoptions = page.locator("//select/option");
        int count=page.locator("//select/option").count();
        System.out.println("Total number of dropdown options are: "+count);

        //Method 1:
        for(int i=0;i<count;i++){
            String optiontext=page.locator("//select/option").nth(i).textContent();
            System.out.println(optiontext);
        }


        //Method 2:git commit

           List<String> countryOptionText = countryoptions.allTextContents();
           for(String text : countryOptionText){
               System.out.println(text);
           }

browserContext.close();
browser.close();
playwright.close();

    }
}
