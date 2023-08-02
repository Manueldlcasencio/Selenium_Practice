import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_001_Registration_Functionality {
    ChromeDriver driver;

    @BeforeMethod
    public void startBrowser(){
        driver = new ChromeDriver();
        driver.get("https://thetestingworld.com/testings/");
    }

    @Test
    public void tc001() {
        driver.findElement(By.name("fld_username")).sendKeys("Cool User");
    }
}
