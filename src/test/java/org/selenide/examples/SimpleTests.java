package org.selenide.examples;

import com.codeborne.selenide.junit.TextReport;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;



import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class SimpleTests {
  @Rule
  public TextReport report = new TextReport();

  @Before
  public void setUp() {
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
  }

  @Test
  public void test() {
    String user_name = "TSFirstLine";
    open("https://erpdev.smart-consulting.ru/#/login/");
    $(By.id("auth-username")).sendKeys("TSFirstLine");
    $(By.id("auth-password")).sendKeys("TSFirstLine");
    sleep(20000);
    $(By.xpath("//button[@class='btn btn-primary ng-binding ng-scope']")).click();
    sleep(100000);
    closeWindow();
  }

}
