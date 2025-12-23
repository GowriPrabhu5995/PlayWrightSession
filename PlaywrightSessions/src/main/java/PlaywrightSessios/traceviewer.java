package PlaywrightSessios;

import java.nio.file.Paths;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.options.AriaRole;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class traceviewer {
    public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		LaunchOptions lp = new LaunchOptions();
		//ylp.setChannel("chrome");
		//lp.setChannel("msedge");
		//lp.setChannel("firefox");
		lp.setHeadless(false);
		//Browser browser= playwright.firefox().launch(lp);
		Browser browser= playwright.chromium().launch(lp);
		BrowserContext context = browser.newContext();
		context.tracing().start(new Tracing.StartOptions()
        .setScreenshots(true)
        .setSnapshots(true)
        .setSources(true));
     
		Page page = context.newPage();   // ✅ CORRECT

		page.navigate("https://www.amazon.com/");
		String PageTitle = page.title();
		String URL = page.url();
		System.out.println(PageTitle);
		System.out.println(URL);
	   assertThat(page.getByRole(AriaRole.NAVIGATION, new Page.GetByRoleOptions().setName("Primary"))).isVisible();

    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Hello, sign in Account & Lists")).click();
   assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Amazon"))).isVisible();

    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Create a free business account")).click();
   // assertThat(page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("Amazon Business"))).isVisible();

    page.getByTestId("businessEmail-test-id").click();
    page.getByTestId("businessEmail-test-id").fill("test@123");
    page.getByTestId("submit-email").click();
    page.navigate("https://www.amazon.com/");
       
		
context.tracing().stop(new Tracing.StopOptions()
  .setPath(Paths.get("trace.zip")));

  
browser.close();
		
		//PlayWright by default runs in the headless mode.
		
		// browser.close();
		// playwright.close();
	 

	}
}
