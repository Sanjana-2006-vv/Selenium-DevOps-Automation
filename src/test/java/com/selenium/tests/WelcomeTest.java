
package com.selenium.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WelcomeTest {

    @Test
    public void welcomeToDevOpsTest() {

        ChromeOptions options = new ChromeOptions();

        // Headless mode for GitHub Actions
        if (System.getenv("CI") != null) {
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
        }

        WebDriver driver = new ChromeDriver(options);

        try {

            System.out.println("================================");
            System.out.println("Welcome to DevOps");
            System.out.println("Selenium Test Started");
            System.out.println("================================");

            // Open website
            driver.get("https://example.com");

            // Get website title
            String actualTitle = driver.getTitle();

            System.out.println("Website Title: " + actualTitle);

            // Verify website title
            Assert.assertEquals(
                actualTitle,
                "Example Domain",
                "Website title does not match!"
            );

            System.out.println("Selenium Test Passed");

        } finally {

            // Close browser
            driver.quit();

        }
    }
}
