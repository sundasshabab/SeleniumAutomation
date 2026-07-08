package com.configuration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ClickClaimMenu {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            driver.get("https://opensource-demo.orangehrmlive.com/");

            // Login
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")))
                    .sendKeys("Admin");

            driver.findElement(By.name("password"))
                    .sendKeys("admin123");

            driver.findElement(By.xpath("//button[@type='submit']")).click();

            // Wait for dashboard to load completely
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//span[text()='Dashboard']")
            ));

            // Click Claim menu (more stable locator using sidebar link)
            WebElement claimMenu = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//a[contains(@href,'claim')]//span")
                    )
            );

            claimMenu.click();

            System.out.println("Claim menu clicked successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // driver.quit();
        }
    }
}


