package mypackage;


import java.sql.*;
import java.sql.PreparedStatement;


public class Question {

    private int id;
    private static String content;
    private int card_id;


    private static Connection connect = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    final private static String host = "10.101.208.15";
    final private static String user = "Teilnehmer";
    final private static String passwd = "Teilnehmer";

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }


    public Question(int id, String content) throws Exception {
        this.id = id;
        this.content = content;
    }

    public Question(int id){
        this.id = id;
    }

    public static void readQuestionContent(int id) throws Exception {
        try {

            Class.forName("com.mysql.jdbc.Driver");

            connect = DriverManager.
                    getConnection("jdbc:mysql://" + host + "/zettelkasten?" +
                            "user=" + user + "&password=" + passwd);

            preparedStatement = connect
                    .prepareStatement("SELECT content FROM question WHERE id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while ((resultSet.next())) {
                content = resultSet.getString("content");
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    public String toString() { //testing
        return this.content;
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
