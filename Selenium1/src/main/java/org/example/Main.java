package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");
        driver.manage().window().maximize();

        WebElement element = driver.findElement(By.id("W0wltc"));
            element.click();

        WebElement searchBar = driver.findElement(By.id("APjFqb"));
            searchBar.sendKeys("Selenium");
            searchBar.submit();

//        WebElement seleniumImg = driver.findElement(By.cssSelector("img[style='width: 178px; height: 186px; margin-left: 0px; margin-right: 0px; margin-top: 0px;']"));
//            seleniumImg.click();

        WebElement square = driver.findElement(By.xpath("//*[@id=\"gbwa\"]/div/a"));
            square.click();

        driver.switchTo().frame(driver.findElement(By.name("app"))); //Change to different html inside the html.
        driver.findElement(By.xpath("//a[@data-pid='8']")).click();
        driver.switchTo().defaultContent();

//        driver.quit();
    }
}