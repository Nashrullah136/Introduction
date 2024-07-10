import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        WebElement frameElement = driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
        WebDriver frame = driver.switchTo().frame(frameElement);
        WebElement source = frame.findElement(By.xpath("//*[@id='draggable']"));
        WebElement destination = frame.findElement(By.xpath("//*[@id='droppable']"));
        Actions act = new Actions(driver);
        act.dragAndDrop(source, destination).click().perform();
    }
}
