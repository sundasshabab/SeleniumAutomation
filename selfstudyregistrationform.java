package com.configuration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class selfstudyregistrationform {

    @Test
    public void registrationFormTest() {

        WebDriver driver = new ChromeDriver();

        driver.get("https://automationteststore.com/index.php?rt=account/create");
        driver.manage().window().maximize();

        // First Name
        driver.findElement(By.id("AccountFrm_firstname")).sendKeys("Sundas");

        // Last Name
        driver.findElement(By.id("AccountFrm_lastname")).sendKeys("Shabab");

        // Email
        driver.findElement(By.id("AccountFrm_email")).sendKeys("sundas@test.com");

        // Telephone
        driver.findElement(By.id("AccountFrm_telephone")).sendKeys("1234567890");

        // Address
        driver.findElement(By.id("AccountFrm_address_1")).sendKeys("Lahore");

        // City
        driver.findElement(By.id("AccountFrm_city")).sendKeys("Lahore");

        // Postcode
        driver.findElement(By.id("AccountFrm_postcode")).sendKeys("54000");

        // =========================
        // Country Dropdown
        // =========================
        WebElement countryDropdown = driver.findElement(By.id("AccountFrm_country_id"));
        Select country = new Select(countryDropdown);

        // Select first valid option (skip index 0 if it's "Please Select")
        country.selectByIndex(1);

        // =========================
        // Region / State Dropdown
        // =========================
        WebElement regionDropdown = driver.findElement(By.id("AccountFrm_zone_id"));
        Select region = new Select(regionDropdown);
        

        // Select first valid option
        region.selectByIndex(2);

        // Login Name
        driver.findElement(By.id("AccountFrm_loginname")).sendKeys("sundas123");

        // Password
        driver.findElement(By.id("AccountFrm_password")).sendKeys("Password123");

        // Confirm Password
        driver.findElement(By.id("AccountFrm_confirm")).sendKeys("Password123");

        // Agree checkbox
        driver.findElement(By.id("AccountFrm_agree")).click();

        // Continue button
        driver.findElement(By.xpath("//button[@title='Continue']")).click();

        //driver.quit();
    }
}

