package PlaywrightSessios;
import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;
public class PlaywrightBasics {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		LaunchOptions lp = new LaunchOptions();
		lp.setChannel("chrome");
		//lp.setChannel("msedge");
		//lp.setChannel("firefox");
		lp.setHeadless(false);
		//Browser browser= playwright.firefox().launch(lp);
		Browser browser= playwright.chromium().launch(lp);
		Page page =browser.newPage();
		page.navigate("https://www.amazon.com/");
		String PageTitle = page.title();
		String URL = page.url();
		System.out.println(PageTitle);
		System.out.println(URL);
		
		//PlayWright by default runs in the headless mode.
		
		browser.close();
		playwright.close();
	}

}
