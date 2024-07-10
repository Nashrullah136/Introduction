import component.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class TestUsingComponent {

    public List<Product> products = new ArrayList<>();

    public TestUsingComponent(WebDriver driver) {
        List<org.openqa.selenium.WebElement> products = driver.findElements(By.xpath("//*[@class='product']"));
        for(org.openqa.selenium.WebElement product : products){
            this.products.add(new Product(product));
        }
    }

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise");
        TestUsingComponent t = new TestUsingComponent(driver);
        for (Product p : t.products) {
            System.out.println(p.getName());
            System.out.println(p.getQuantity());
            p.setQuantity(4);
            System.out.println(p.getQuantity());
            p.addToCart();
            System.out.println(p.getTotalPrice());
        }
    }

}