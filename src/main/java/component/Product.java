package component;

import org.openqa.selenium.*;

public class Product {

    private final WebElement webElement;
    private final String name;
    private final Integer price;

    public Product(WebElement webElement) {
        super();
        this.webElement = webElement;
        this.name = this.webElement.findElement(By.xpath(".//*[@class=\"product-name\"]")).getText().split("-")[0];
        this.price = Integer.valueOf(this.webElement.findElement(By.xpath(".//*[@class=\"product-price\"]")).getText());
    }

    public String getName() {
        return this.name;
    }

    public Integer getPrice() {
        return this.price;
    }

    public Integer getTotalPrice() {
        return this.price * getQuantity();
    }

    public Integer getQuantity() {
        return Integer.valueOf(this.webElement.findElement(By.xpath(".//*[@class=\"quantity\"]")).getAttribute("value"));
    }

    public void addToCart() {
        this.webElement.findElement(By.xpath(".//*[@class=\"product-action\"]")).click();
    }


    public void setQuantity(int quantity) throws InvalidArgumentException {
        if (quantity < 1) {
            throw new InvalidArgumentException("Quantity must be greater than 0");
        }
        while (quantity > getQuantity()) {
            this.webElement.findElement(By.xpath(".//*[@class=\"increment\"]")).click();
        }
        while (quantity < getQuantity()) {
            this.webElement.findElement(By.xpath(".//*[@class=\"decrement\"]")).click();
        }
    }

}
