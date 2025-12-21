package PlaywrightSessios;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class browsercontext {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context1 = browser.newContext();
         Page p1 = context1.newPage();
         p1.navigate("https://amazon.com/");
         p1.fill("#twotabsearchtextbox", "laptop");
            p1.click("#nav-search-submit-button");
            BrowserContext context2 = browser.newContext();
            Page p2 = context2.newPage();
            p2.navigate("https://www.flipkart.com/");
           //p2.click("span[role=\"button\"]");
           p2.fill("input[placeholder='Search for Products, Brands and More']", "laptop");
    }
}

//NOTES:-
// What is BrowserContext in Playwright?


/*BrowserContext is an isolated browser session inside a single browser instance.
 👉 Think of it like an Incognito window.
  Same browser process
 Separate cookies, cache, local storage, session
 No data shared between contexts unless you allow it*/

 /*Simple Analogy (Easy to Remember)
Real World	                 Playwright
Chrome Browser	               Browser
Incognito Window	           BrowserContext
Tab inside Incognito           Page*/

/*Browser
 ├── Context 1 (User A)
 │     ├── Page 1
 │     └── Page 2
 └── Context 2 (User B)
       └── Page 1               */



