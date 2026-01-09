package PlaywrightSessios;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class frameHandel {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browsercontext = browser.newContext();
        Page page =browsercontext.newPage();
        page.navigate("https://www.londonfreelance.org/courses/frames/index.html");
       
        // ----> this or the belowString frameText = page.frameLocator("frame[name='main']").locator("h2").textContent();
        String frameText = page
    .frameLocator("[name=\"main\"]")
    .getByRole(
        AriaRole.HEADING,
        new FrameLocator.GetByRoleOptions()
            .setName("Title bar (top.html)")
    )
    .textContent();

System.out.println(frameText);

        System.out.println("Extracted text from frame: " + frameText);

       

    }
    }


