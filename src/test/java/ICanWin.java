
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ICanWin {
  @Test
  public void creatingPaste() {

    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://pastebin.com/");


    String titleText = "helloweb";
    WebElement postTitle = waitForElementLocatedBy(driver, By.xpath("//*[@id='postform-name']"));
    postTitle.sendKeys(titleText);

    String areaText = "Hello from WebDriver";
    WebElement postFormText = waitForElementLocatedBy(driver,By.xpath("//*[@id='postform-text']"));
    postFormText.sendKeys(areaText);

    WebElement postExpirationTimeList =
        waitForElementLocatedBy(driver,By.xpath("//*[@id='select2-postform-expiration-container']"));
    postExpirationTimeList.click();

    WebElement postExpirationTimeValue =
        waitForElementLocatedBy(driver,(By.xpath("/html/body/span[2]/span/span[2]/ul/li[3]")));
    postExpirationTimeValue.click();

    WebElement createNewPaste =
        waitForElementLocatedBy(driver,By.xpath("//*[@id='w0']/div[5]/div[1]/div[8]/button"));
    createNewPaste.click();

    WebElement pasteTextArea =
        waitForElementLocatedBy(driver,By.xpath("//*[@class = 'textarea']"));
    String resultValue = pasteTextArea.getText();
    System.out.println("Result value in the text area: " +resultValue);
    Assert.assertTrue(resultValue.contains(areaText), "Result value is not the same as entered!");

    driver.quit();
  }
  public static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
    return new WebDriverWait(driver, 20)
        .until(ExpectedConditions.presenceOfElementLocated(by));
  }
}