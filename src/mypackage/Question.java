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

    /*final private static String host = "10.101.208.15";
    final private static String user = "Teilnehmer";
    final private static String passwd = "Teilnehmer";*/

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

            /*Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.
                    getConnection("jdbc:mysql://" + host + "/zettelkasten?" +
                            "user=" + user + "&password=" + passwd);*/


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
