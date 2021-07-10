package testNG;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import kzapro.utilities.TestBase;
import kzapro.utilities.TestDataHolder;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITestRunner extends TestBase {
    Response response;
    int statusCode;
    String boardId = prop.getProperty("boardId");
    String APIkey = prop.getProperty("apiKey");
    String Token = prop.getProperty("token");



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

    @Test(dependsOnMethods = "createList")
    public void createCard() {
        String cardName = String.format(prop.getProperty("cardNames"), System.currentTimeMillis());
        String listId = TestDataHolder.getListId();
        RestAssured.baseURI =  prop.getProperty("BaseURI");
        response = RestAssured.given()
                .header("Content-Type", "application/json")
                .and().post("/1/cards?key=" + APIkey + "&token=" + Token + "&idList=" + listId + "&name=" + cardName);
        response.getBody().prettyPrint();
        String cardId = response.getBody().jsonPath().getString("id");
        TestDataHolder.setCardId(cardId);
        System.out.println("Card ID " + cardId);
    }

    @Test(dependsOnMethods = "createCard")
    public void getCard() {
        String cardId = TestDataHolder.getCardId();
        RestAssured.baseURI = prop.getProperty("BaseURI");
        response = RestAssured.given()
                .header("Content-Type", "application/json")
                .and().get("/1/cards/" + cardId + "?key=" + APIkey + "&token=" + Token);
        response.getBody().prettyPrint();
        System.out.println("Card ID " + cardId);
    }

    @Test(dependsOnMethods = "getCard")
    public void postComment() {
        String comment = String.format(prop.getProperty("comments"), System.currentTimeMillis());
        String cardId = TestDataHolder.getCardId();
        RestAssured.baseURI = prop.getProperty("BaseURI");
        response = RestAssured.given()
                .header("Content-Type", "application/json")
                .and().post("/1/cards/" + cardId + "/actions/comments?key=" + APIkey + "&token=" + Token + "&text=" + comment);
        response.getBody().prettyPrint();
        String commentId = response.getBody().jsonPath().getString("id");
        TestDataHolder.setComment(commentId);
        System.out.println("Comment ID " + commentId);
    }

    @Test(dependsOnMethods = "postComment")
    public void updateComment() {
        String updateComment = String.format(prop.getProperty("updateComment"), System.currentTimeMillis());
        String cardId = TestDataHolder.getCardId();
        String commentId = TestDataHolder.getComment();
        RestAssured.baseURI = prop.getProperty("BaseURI");
        response = RestAssured.given()
                .header("Content-Type", "application/json")
                .and().put("/1/cards/" + cardId + "/actions/" + commentId + "/comments?key=" + APIkey + "&token=" + Token + "&text=" + updateComment);
        response.getBody().prettyPrint();

    }

    @Test(dependsOnMethods = "updateComment")
    public void deleteCard() {
        String cardId = TestDataHolder.getCardId();
        RestAssured.baseURI = prop.getProperty("BaseURI");
        response = RestAssured.given()
                .header("Content-Type", "application/json")
                .and().delete("/1/cards/" + cardId + "?key=" + APIkey + "&token=" + Token);
        response.getBody().prettyPrint();
    }

    @Test(dependsOnMethods = "deleteCard")
    public void deleteList() {
        String listId = TestDataHolder.getListId();
        RestAssured.baseURI = prop.getProperty("BaseURI");
        response = RestAssured.given()
                .header("Content-Type", "application/json")
                .and().put("/1/lists/" + listId + "/closed?key=" + APIkey + "&token=" + Token + "&value=true");
        response.getBody().prettyPrint();
    }
}