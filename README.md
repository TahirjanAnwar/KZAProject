# Test Strategy 

This Testing framework will use a common framework in the CI/CD process as follows:
* Page Object Pattern for any UI Verification
* Combination of TestNG and the Cucumber framework.
* TestNG framework for Integration Tests
* Cucumber Framework for the smoke test

## Testing and other tools during the project:

* [Jira](https://www.atlassian.com/software/jira) - use it to create an epic task, feature and bug tickets
* [Confluence](https://www.atlassian.com/software/confluence) - for documentation, to create test plan and test cases.
* [Intellij](https://www.jetbrains.com/idea/) IDE - to create a test automation framework and execute our codes and tests.
* [Github](https://github.com/) - for managing code in git versions and code repository system.
* [Postman](https://www.postman.com/) - use it for API manual testing and verify status code.
# Overview 

Trello is a web-based, Kanban-style, list-making application that made by Atlassian.  We use it for find all kind of information such as what is being worked on, who is working on what and what progress the project is making. As a result we can have all of information we need in one collaborative location and it is very time saving make our day 
very productive.

So, I created manually new board, Lists and card inside the Trello web application.
* <img src="https://thumb.gyazo.com/thumb/992_w/eyJhbGciOiJIUzI1NiJ9.eyJpbWciOiJfZDA5N2M0MGJiNDFkMzdjZjZhYWFjOWY2NDIyOTIwNDMifQ.HlBNB9KM7iJLQQ4QYV6R85wZo8VZX--ysVJ1UR4mx-g-gif.gif">



# Manual test 

* ### For manual test I created a Test plan and Test cases using Confluence.

## Test plan
* <img src="https://thumb.gyazo.com/thumb/692_w/eyJhbGciOiJIUzI1NiJ9.eyJpbWciOiJfMGU1OGRiNWIyZWNkYjQwMDkyZTQyMjZjMjZkYWNlMWUifQ.GrpgKBYmHq4DvKm6KB4ID9kuO6_fFLYAgCSl45U_omQ-gif.gif">

## Test cases
* ### included all the test steps and expected results. 
* <img src="https://thumb.gyazo.com/thumb/1280_w/eyJhbGciOiJIUzI1NiJ9.eyJpbWciOiJfN2YwZDg3NDU3MzQ1ZTBlYTFhOGM3ZjE4NTY1NDZjNGUifQ.dYUzbfrGHVqCdK7NRZPs3zowSK6YHfc5H4dLUf7Pd6s-gif.gif">


* ## Then I created a epic task and feature tickets using Jira.
* <img src="https://i.gyazo.com/708680265410c29e1d8b5abb34eb4f6f.png" />
* When I finish the manual test, I can easly click and slide the task from "In Progress" to "DONE".
* <img src="https://thumb.gyazo.com/thumb/804_w/eyJhbGciOiJIUzI1NiJ9.eyJpbWciOiJfNmNmNmQxNmQ5MGI1YjkzMDc3YjUwZTRiYTYxMWVlYTkifQ.Js4kWOZKBK0MxY1F251V8ft1Sr2EuyTCw29s0z35EoI-gif.gif">


* ## when all the manual test passed, then I started for automation test.

# Developed automation test scripts using Selenium WebDriver with Java in Intellij IDE.
## Automation tests 
* ## **Front-End**  
1. A valid user should be able to create an new board on Trello work space.
2. A valid user should be able to add 3 lists(To Do, In Progress, Done).
3. A valid user should be able to add a card on To Do list.
4. A valid user should be able to update his/her task.
5. A valid user should be able to delete his/her task.
6. A valid user should be able to delete his/her board.

 
* ## After I created my project, I manage all my dependencies in POM.xml file.
* <img src="https://i.gyazo.com/ea058954d348bb1a3c4caaf6b2541f4a.png">

* ## I also used POM structure in order to keep my code organize and clean, So I basically created a separate Java Class for each page of my application where I store all elements of that page as well as related methods.

* <img src="https://thumb.gyazo.com/thumb/462_w/eyJhbGciOiJIUzI1NiJ9.eyJpbWciOiJfODEwOTViY2Y0YmI1ZWMwYTUxZGUwMWJjZGIyOTE2NWIifQ.ZYO2o_oduEmsCjnNGGNniL1XcOZaz13rLsBRAF6Qqxs-gif.gif">

* ## I created another package for my utilities where I would store all page files or utilities that I need when I execute my tests.

* <img src="https://i.gyazo.com/a71e14164cc78d0ca17e481e8740422f.gif">

```java
public class TestBase {
    public static WebDriver driver;
    public static Properties prop;

    public TestBase() {
        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("C:\\Users\\Game PC-Maintake\\IdeaProjects\\KZAProject\\config.properties");
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
```
***
* ## I also created config file and put all variables I need like username, password, email etc and when I need it I call from config file instead of hard coding. 

```java
public void createList() {
RestAssured.baseURI=prop.getProperty("BaseURI");
String listName = String.format(prop.getProperty("listName"), System.currentTimeMillis());
TestDataHolder.setListName(listName);;
}

```

* <img src="https://i.gyazo.com/e604ae512414197fc0aba0b311eec9fd.gif">
```java
url=https://trello.com/
userEmail=us****1@gmail.com
userPassword=Freeuyghur***
boardName=KZA Board
browser=chrome
toDoListName=To Do
inProgressListName= In Progress
doneListName= Done
description=This is an update test
cardName=KZA Test
```

<br/><br>


***

* ## Then I created a runner class for TestNG and  run my all tests in the runner class that I created. 

* <img src="https://i.gyazo.com/c8b10cc41b52a8cbaf5460e1095289e8.gif">

### Frameworks
* ## TestNG Framework

```java
// This is a TestNG framework runner class
    @BeforeMethod
    public void setUp()
    {
        initialization();
        loginPage=new LoginPage();
        loginPage.clickLoginLink();
    }
    @Test(priority = 1)
    public void createBoard()
    {
        homePage=new HomePage();
        createBoardPage=homePage.clickLink();
        createBoardPage=new CreateBoardPage();
        createBoardPage.addBoardTitle(prop.getProperty("boardName"));
        createBoardPage.clickButton();
        TestUtilities.sleep(3);
        createBoardPage.clickCancelButton();
        Assert.assertTrue(driver.findElement(By.xpath("//h1 [text()='KZA Board']")).isDisplayed());
    }

    @AfterMethod
    public void tearDown()
    {
        driver.close();
        driver.quit();
    }

```
***
* ## Cucumber Framework
* ### For Cucumber I have separate classes where I keep my implemented Step Definitions.

* <img src="https://thumb.gyazo.com/thumb/436_w/eyJhbGciOiJIUzI1NiJ9.eyJpbWciOiJfMjRmMDNkOTAxMDk4N2UyN2Q3ODM2ZTcyYTM4N2I0NjMifQ.kJMaUwkgwFQyuVLti-XgeRcLoiEgvkGxj5zfYR98fig-gif.gif">
```java
//Cucumber framework step definition 
@Given("User click KZA board")
    public void user_click_KZA_board() {

        homePage=new HomePage();
        homePage.clickKzaBoard();
        TestUtilities.sleep(2);

    }
```

* ## Also for each scenario for positive and negative
```java
public class LoginNegativeAndPositiveTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    LogOutPage logOutPage;

    @Given("User Launch Chrome Browser with URL")
    public void user_Launch_Chrome_Browser() {

        initialization();
    }

    @When("User Enters Email as {string} and Password as {string}")
    public void user_Enters_Email_as_and_Password_as(String email, String pws) {

        loginPage=new LoginPage();
        loginPage.clickLoginLink();
        loginPage.enterUserName(email);
        loginPage.clickLoginWithAtlassianLin();
        loginPage.enterPassword(pws);

    }
```
* ### I created Cucumber Feature Files where I used Gherkin language in order to describe my test scenario, by doing that my test cases are understandable  for each member of my team. 

* <img src="https://thumb.gyazo.com/thumb/410_w/eyJhbGciOiJIUzI1NiJ9.eyJpbWciOiJfOTk5YTM0NDVhZWRmZDRjMjMxNTlhNWViOWM3N2JkYWEifQ.oK7j4p37BLsNRZSYF9e1GeF1rGoJpCVQKLOU5pv4lT0-gif.gif">
```java
//Cucumber feature file
Feature: KZA create new Board

  Background:
    Given I launch chrome browser
    And User enters Email
    Then click Log with in atlassian button
    And User enters Password

    Scenario: Create new Board
    When User Clicks Create new board link
    And User enters new board name
    And create board button
    And click cancel arrow
    Then add list page should be displayed

//Cucumber negative feature file
Feature: User should be able to login with valid credential and user should not be
  able to login with invalid credential.

  Scenario Outline: Login Data Driven
    Given User Launch Chrome Browser with URL
    And User Enters Email as "<email>" and Password as "<password>"
    And Click on Login
    Then HomePage should be displayed
    When User Click on Logout link
    Then Close Browser


    Examples:
      |email | password|
      |ust***1@gmail.com| Freeuyghur****|
      |admin1@yourstore.com | admin123|

```
* ### And I created runner classes
* <img src="https://thumb.gyazo.com/thumb/1164_w/eyJhbGciOiJIUzI1NiJ9.eyJpbWciOiJfMjAyOWViM2RjMWI1ZDgzODFmMzJmMDhkZDA3MDc2NmYifQ.yQypcTLQJVTahgjQ_Sgzd-Gr6H5sfwnXQS_2UYSnX34-gif.gif">

```java
//runner class
    @RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\Users\\Game PC-Maintake\\IdeaProjects\\KZAProject\\Feature\\kzacreate.feature",
        glue = "stepDefinitions",
        dryRun = false,
        plugin = {"pretty","html:test-output"}
)
public class TestRunner {
}

```
***
## Rest Assure for API manual tests
* I verified API response manually by using Postman.
* <img src="https://thumb.gyazo.com/thumb/1186_w/eyJhbGciOiJIUzI1NiJ9.eyJpbWciOiJfNDg0Y2FlMzJhMmQzMzE3NDQ3MGFiNTRhZDhhMWIzNjYifQ.v9PFAro35nemUsaCkjRN05jVR-uRDAssT6Q8nsgY910-gif.gif">
* when all the manual test passed with response code 200, then I started for automation test.
***
## Rest Assure for API Automation tests


* ### TestNG Framework


```java 
//test steps

public class APITestRunner extends TestBase {
    Response response;

@Test
    public void createList() {
       RestAssured.baseURI=prop.getProperty("BaseURI");
        String listName = String.format(prop.getProperty("listName"), System.currentTimeMillis());
        TestDataHolder.setListName(listName);

        response = RestAssured.given()
                .header("Content-Type", "application/json")
                .and()
                .post("/1/lists?key=" + APIkey + "&token=" + Token + "&name=" + listName + "&idBoard=" + boardId);
        // check the status code
        response.getBody().prettyPrint();

        String listId = response.getBody().jsonPath().getString("id");
        System.out.println("list ID: " + listId);
        TestDataHolder.setListId(listId);
        statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }
```

`POST /1/cards` - - Create a new card on a List
 * https://api.trello.com/1/cards?key={API KEY}&token={API TOKEN}&idList={idList}&name={New card name} *
 <br/><br>

`GET /1/cards/{id}` - - Get a Card
* https://api.trello.com/1/cards/{CARD ID}?key={API KEY}&token={API TOKEN}
<br/><br>

`POST /1/cards/[card id or shortlink]/actions/comments` - -  Add a comment to a Card
* https://api.trello.com/1/cards/{CARD ID}/actions/comments?key={API KEY}&token={API TOKEN}&text={New comment}
<br/><br>

`PUT /1/cards/{id}/actions/{idAction}/comments 
`- - Update an existing comment
* https://api.trello.com/1/cards/{CARD ID}/actions/{Comment ID}/comments?key={API KEY}&token={API TOKEN}&text={UPDATED COMMENT}

`DELETE /1/cards/{id}
` - - Delete a Card
* https://api.trello.com/1/cards/{CARD ID}?key={API KEY}&token={API TOKEN}

***
