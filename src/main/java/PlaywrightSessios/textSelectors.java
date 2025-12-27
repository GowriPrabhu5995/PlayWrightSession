package PlaywrightSessios;
import com.microsoft.playwright.*;

public class textSelectors {
public static void main(String[] args) {
   Playwright playwright = Playwright.create();
   Browser browser =playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
  BrowserContext browsercontext = browser.newContext();
Page page =browsercontext.newPage();
page.navigate("https://www.orangehrm.com/en/30-day-free-trial");
page.locator("text=Book a Free Demo").last().click();
System.out.println("Clicked on Book a Free Demo link");
Locator privacyPolicyLink = page.locator("text=Privacy Policy");

for(int i=0; i<privacyPolicyLink.count(); i++) {
    String linkText = privacyPolicyLink.nth(i).textContent();
   if(linkText.contains("Service Privacy Policy")) {
       privacyPolicyLink.nth(i).click();
       System.out.println("Clicked on Service Privacy Policy link");
       break;
   }

  
   
} 

BrowserContext browsercontext1 = browser.newContext();
Page page1 =browsercontext1.newPage();
page1.navigate("https://demo.opencart.com/en-gb?route=account/login");
String newCustomerText = page1.locator("h2:has-text(\"New Customer\") + p").textContent();
System.out.println("Extracted new customer text" + newCustomerText);

String YourStoreText = page1.locator("text=Your Store").textContent();
System.out.println("Extracted your store text" + YourStoreText);
 
page1.locator("form input: has-text('Login')").click();
System.out.println("Clicked on Login button");

browsercontext.close();
browser.close(); 
playwright.close();

}

}

