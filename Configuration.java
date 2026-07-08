package com.configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.github.javafaker.Faker;


public class Configuration {
	// WebDriver ka static variable bana rahe hain browser control ke liye
	public static WebDriver driver;
	// Faker library ka object bana rahe hain fake data generate karne ke liye (Pakistan locale ke sath)
	public static Faker faker = new Faker(new Locale("en-PAK"));
	// Logger initialize kar rahe hain logging ke liye
	public static Logger logs = Logger.getLogger(Configuration.class.getName());
	// ExtentReports ka object report generation ke liye
	public static ExtentReports extent;
	// ExtentTest ka object test steps log karne ke liye
	public static ExtentTest loggers;


	// Yeh method class shuru hone se pehle chalega
	@BeforeClass
	public void browser() {
		// Report ki location set kar rahe hain user directory mein output folder ke andar index.html file mein
		ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/output/index.html");
		// Report document ka title "Automation Report" set kar rahe hain
		spark.config().setDocumentTitle("Automation Report");
		// Report ka naam "Sundas" set kar rahe hain
		spark.config().setReportName("Sundas");
		// ExtentReports ka naya instance bana rahe hain
		extent = new ExtentReports();
		// Spark reporter ko extent reports ke sath attach kar rahe hain
		extent.attachReporter(spark);
		// System info add kar rahe hain, Reporter ka naam
		extent.setSystemInfo("Reporter: ", "Sundas");
		// System info add kar rahe hain, Environment ka naam
		extent.setSystemInfo("Environment: ", "Testing Evnrionment");
		// Chrome driver initialize kar rahe hain browser kholne ke liye
		driver=new ChromeDriver();
		// Log mein info likh rahe hain ke browser initialize ho gaya
		logs.info("Browser initialization");
		// Browser window ko maximize kar rahe hain
		driver.manage().window().maximize();
		// Automation test store ki website open kar rahe hain
		driver.get("https://automationteststore.com/");
		
	}
	// Yeh ek test method hai
	@Test
	public void demotest()
	{
		// Current date aur time le rahe hain
		LocalDateTime now = LocalDateTime.now();
		// Current day nikal rahe hain
		String day = now.getDayOfWeek().toString();
		// Current time format kar rahe hain
		String time = now.format(DateTimeFormatter.ofPattern("dd | MMM | yyyy : HH:mm:ss"));
		//DateTimeFormatter formatter =
            //    DateTimeFormatter.ofPattern("EEEE, dd MMM yyyy HH:mm:ss");
		
		// Report mein "confirguration" naam ka test create kar rahe hain
		loggers = extent.createTest("confirguration" + day + time)
				// Test category mein din (day) add kar rahe hain
				.assignCategory(day)
				// Test category mein waqt (time) add kar rahe hain
				.assignCategory(time);
		// Report mein info log kar rahe hain ke configuration file initialize ho rahi hai
		loggers.log(Status.INFO, "initializing confirguratin file");
		}
	// Yeh method sab tests khatam hone ke baad chalega
	@AfterSuite
	public void EntReport() {
		// Report ko save aur write kar rahe hain
		extent.flush();
	}
}
