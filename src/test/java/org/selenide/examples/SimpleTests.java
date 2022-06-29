package org.selenide.examples;

import com.beust.jcommander.internal.Console;
import com.codeborne.selenide.junit.TextReport;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class SimpleTests {
  @Rule
  public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();


  private final PrintStream standardOut = System.out;
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

  @BeforeEach
  public void setUp() {
    System.setOut(new PrintStream(outputStreamCaptor));
  }
  private void print(String output) {
    System.out.println(output);
  }

  @Test
  public void test() {
    System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\jre1.8.0_331\\lib\\ext\\chromedriver.exe");
    ChromeDriver driver = new ChromeDriver();
    String user_name = "TSFirstLine";
    driver.get("https://erpdev.smart-consulting.ru/#/login/");
    //sleep(300000);
    boolean checkDownloadPage = true;
    while (checkDownloadPage) {
      if (!driver.findElement(By.cssSelector(".load-app-cache")).isDisplayed()) {
        checkDownloadPage = false;
      }
    }
    driver.findElement(By.id("auth-username")).sendKeys("TSFirstLine");
    driver.findElement(By.id("auth-password")).sendKeys("TSFirstLine");
    driver.findElement(By.cssSelector(".btn-primary")).click();
    sleep(5000);
    checkDownloadPage = true;
    while (checkDownloadPage) {
      if (!driver.findElement(By.cssSelector(".dt-loader-overlay")).isDisplayed()) {
        checkDownloadPage = false;
      }
    }
//    Duration duration = Duration.ofSeconds(15);
//    WebDriverWait wait = new WebDriverWait(driver, duration);
//    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ng-scope ng-isolate-scope")));
//
    driver.get("https://erpdev.smart-consulting.ru/#/vis/62b39885-d693-a2e3-c18a-0aed172c512e/fea07937-03e4-f015-c133-af9ef0e4e3d6/");
    Duration duration = Duration.ofSeconds(15);
    WebDriverWait wait = new WebDriverWait(driver, duration);
    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-primary")));
    element.click();
    sleep(50000);
    driver.quit();
  }
}
