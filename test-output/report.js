$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:Feature/Login.feature");
formatter.feature({
  "name": "User should be able to login with valid credential and user should not be",
  "description": "  able to login with invalid credential.",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Login Data Driven",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "User Launch Chrome Browser with URL",
  "keyword": "Given "
});
formatter.step({
  "name": "User Enters Email as \"\u003cemail\u003e\" and Password as \"\u003cpassword\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "Click on Login",
  "keyword": "And "
});
formatter.step({
  "name": "HomePage should be displayed",
  "keyword": "Then "
});
formatter.step({
  "name": "User Click on Logout link",
  "keyword": "When "
});
formatter.step({
  "name": "Close Browser",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "email",
        "password"
      ]
    },
    {
      "cells": [
        "ustel1111@gmail.com",
        "Freeuyghur22@@"
      ]
    },
    {
      "cells": [
        "admin1@yourstore.com",
        "admin123"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Login Data Driven",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "User Launch Chrome Browser with URL",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginNegativeAndPositiveTest.user_Launch_Chrome_Browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Enters Email as \"ustel1111@gmail.com\" and Password as \"Freeuyghur22@@\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginNegativeAndPositiveTest.user_Enters_Email_as_and_Password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on Login",
  "keyword": "And "
});
formatter.match({
  "location": "LoginNegativeAndPositiveTest.click_on_Login()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "HomePage should be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginNegativeAndPositiveTest.homepage_should_be_displayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Click on Logout link",
  "keyword": "When "
});
formatter.match({
  "location": "LoginNegativeAndPositiveTest.user_Click_on_Logout_link()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Close Browser",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginNegativeAndPositiveTest.close_Browser()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Login Data Driven",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "User Launch Chrome Browser with URL",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginNegativeAndPositiveTest.user_Launch_Chrome_Browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Enters Email as \"admin1@yourstore.com\" and Password as \"admin123\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginNegativeAndPositiveTest.user_Enters_Email_as_and_Password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on Login",
  "keyword": "And "
});
formatter.match({
  "location": "LoginNegativeAndPositiveTest.click_on_Login()"
});
formatter.result({
  "error_message": "org.openqa.selenium.NoSuchElementException: Cannot locate an element using xpath\u003d//span[text()\u003d\u0027Log in\u0027]\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027TPRODUCTION\u0027, ip: \u0027192.168.2.19\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_292\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:327)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:428)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy15.click(Unknown Source)\r\n\tat kzapro.pages.LoginPage.clickLoginPassword(LoginPage.java:52)\r\n\tat stepDefinitions.LoginNegativeAndPositiveTest.click_on_Login(LoginNegativeAndPositiveTest.java:36)\r\n\tat ✽.Click on Login(file:Feature/Login.feature:7)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "HomePage should be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginNegativeAndPositiveTest.homepage_should_be_displayed()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "User Click on Logout link",
  "keyword": "When "
});
formatter.match({
  "location": "LoginNegativeAndPositiveTest.user_Click_on_Logout_link()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Close Browser",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginNegativeAndPositiveTest.close_Browser()"
});
formatter.result({
  "status": "skipped"
});
});