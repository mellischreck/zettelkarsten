package mypackage;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Topic {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    public static List<JCheckBox> checkboxes = new ArrayList<>();

    final private String host = "10.101.208.15";
    final private String user = "Teilnehmer";
    final private String passwd = "Teilnehmer";

    public void readDataBase() throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");

            // Setup the connection with the DB
            connect = DriverManager.
                    getConnection("jdbc:mysql://" + host + "/zettelkasten?" +
                            "user=" + user + "&password=" + passwd);

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement.executeQuery("SELECT * FROM topic ");
            writeResultSet(resultSet);


        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }


    public int readTopic_Id(int checkbox_id) {

        int topic_id = 0;
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");

            // Setup the connection with the DB
            connect = DriverManager.
                    getConnection("jdbc:mysql://" + host + "/zettelkasten?" +
                            "user=" + user + "&password=" + passwd);

            // Statements allow to issue SQL queries to the database
            //  statement = connect.createStatement();
            preparedStatement = connect.prepareStatement("SELECT topic_id FROM rel_question_topic WHERE id=? ");
            preparedStatement.setString(1, String.valueOf(checkbox_id));

            resultSet = preparedStatement.executeQuery();

            // Result set get the result of the SQL query
            //  resultSet = statement.executeQuery("SELECT * FROM rel_question_topic");

            //int id=topicid;
            //   resultSet=statement.executeQuery("SELECT topic_id FROM rel_question_topic WHERE id='topicid' ");
            if (resultSet.next()) {
                topic_id = resultSet.getInt("topic_id");
                System.out.println(topic_id);

            }

        /*    while (resultSet.next()) {
                topic_id = resultSet.getInt("topic_id");
                System.out.println(topic_id);

            }*/


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return topic_id;
        /*SELECT 	COUNT(question.id)
FROM question,topic,rel_question_topic
WHERE rel_question_topic.topic_id =topic.id
AND rel_question_topic.question_id=question.id*/
    }

    public ArrayList<Integer> getPassendeFragenList(int topic_id) {
        List<Integer> FragenListedieseTopic = new ArrayList<Integer>();
       int question_id=0;
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");

            // Setup the connection with the DB
            connect = DriverManager.
                    getConnection("jdbc:mysql://" + host + "/zettelkasten?" +
                            "user=" + user + "&password=" + passwd);

            // Statements allow to issue SQL queries to the database
            //  statement = connect.createStatement();
            preparedStatement = connect.prepareStatement("SELECT question_id FROM rel_question_topic WHERE topic_id=? ");
            preparedStatement.setString(1, String.valueOf(topic_id));

            resultSet = preparedStatement.executeQuery();

       /*     if (resultSet.next()) {
                count = resultSet.getInt("topic_id");
                System.out.println(count);

            }*/

            while (resultSet.next()) {
                question_id= resultSet.getInt("question_id");
              FragenListedieseTopic.add(question_id);
                Oca_Ansicht.AlleAusgewähltefragenbisher.add(question_id);
                System.out.println(question_id);

            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return (ArrayList<Integer>) FragenListedieseTopic;
    }


    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getString(2);
            int id = resultSet.getInt("id");
            String title = resultSet.getString("title");
            Oca_Ansicht.checkboxes1.add(new JCheckBox(title));
            //falls in console ausgeben soll
            //   System.out.println("id: " + id);
            //System.out.println("title: " + title );
        }
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
