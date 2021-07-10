package kzapro.utilities;

public class TestDataHolder {
    private static String listId;

    public static String getListName() {
        return listName;
    }

    public static void setListName(String listName) {
        TestDataHolder.listName = listName;
    }

    public static String getCardName() {
        return cardName;
    }

    public static void setCardName(String cardName) {
        TestDataHolder.cardName = cardName;
    }

    private static String listName;
    private static String cardName;


    public TestDataHolder() {

    }

    public static String getListId() {
        return listId;
    }

    public static void setListId(String listId) {
        TestDataHolder.listId = listId;
    }

    public static String getComment() {
        return comment;
    }

    public static void setComment(String comment) {
        TestDataHolder.comment = comment;
    }

    private  static String comment;

    public static String getCardId() {
        return cardId;
    }

    public static void setCardId(String cardId) {
        TestDataHolder.cardId = cardId;
    }

    private  static String cardId;

}

