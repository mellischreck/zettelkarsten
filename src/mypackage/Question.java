package mypackage;


import java.sql.*;
import java.sql.PreparedStatement;


public class Question {

    private int id;
    private String content;
    private int cardId;//should be same as id?

    private static Connection connect = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;


    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public int getCardId() {
        return cardId;
    }


    public Question(int id, String content) throws Exception {
        this.id = id;
        this.content = content;
    }


    public static void loadQuestionToCard(int id) throws Exception {
        try {
            connect = DB.connect();
            preparedStatement = connect
                    .prepareStatement("SELECT content FROM question WHERE id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while ((resultSet.next())) {
                String contentResult = resultSet.getString("content");
                //create question object with given id and content from db
                Question question = new Question(id, contentResult);
                Card.setQuestion(question);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }


    private static void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }


}
