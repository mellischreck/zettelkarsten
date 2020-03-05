package mypackage;


import java.sql.*;
import java.sql.PreparedStatement;


public class Question {

    private int id;
    private String content;


    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    final private String host = "10.101.208.15";
    final private String user = "Teilnehmer";
    final private String passwd = "Teilnehmer";

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

    public void readQuestionContent(int id) throws Exception {
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
            Question question = new Question(id, content);
            Card cardObject = new Card(id);
            cardObject.setQuestion(question);
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    public String toString() { //testing
        return this.content;
    }


    private void close() {
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
