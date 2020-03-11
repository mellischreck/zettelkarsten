package mypackage;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Card {

    private List<Object> Antwortliste = new ArrayList<>();
    private Object frage;
    private int card_Id;
    //above list maynot be needed. made a local variable instead
        private Connection connect = null;
        private Statement statement = null;
        private PreparedStatement preparedStatement = null;
        private ResultSet resultSet = null;
        public static List<JCheckBox> checkboxes = new ArrayList<>();

        final private String host = "10.101.208.15";
        final private String user = "Teilnehmer";
        final private String passwd = "Teilnehmer";

        
        public Card(int Frage_id){
        this.card_Id=Frage_id;
        this.Antwortliste= getAnswerObjectFromQuestionId(Frage_id);
        this.frage= getQuestionObjectFromQuestionID(Frage_id);

        }
    public int getId() {
        return card_Id;
    }

    public Object getFrageObject() {
        return frage;
    }

    public List getAntwort() {
        return Antwortliste;
    }

    public  Object getQuestionObjectFromQuestionID(int frage_id) {
        String content = "";
        int question_id=frage_id;
        Object Frage=null;
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");

            // Setup the connection with the DB
            connect = DriverManager.
                    getConnection("jdbc:mysql://" + host + "/zettelkasten?" +
                            "user=" + user + "&password=" + passwd);

            // Statements allow to issue SQL queries to the database
            //  statement = connect.createStatement();
            preparedStatement = connect.prepareStatement("SELECT content FROM question WHERE id=? ");
            preparedStatement.setString(1, String.valueOf(frage_id));

            resultSet = preparedStatement.executeQuery();

            // Result set get the result of the SQL query
            //  resultSet = statement.executeQuery("SELECT * FROM rel_question_topic");

            //int id=topicid;
            //   resultSet=statement.executeQuery("SELECT topic_id FROM rel_question_topic WHERE id='topicid' ");
            if (resultSet.next()) {
                content = resultSet.getString("content");

                // System.out.println(content);
            }
            Question q= new Question(content,question_id);
            Frage=q;

        } catch (Exception e) {
            e.printStackTrace();
        }


        return Frage;
    }

    public List<Object> getAnswerObjectFromQuestionId(int frage_id) {
        List<Object> Antwortlist = new ArrayList<>();
        String content;
        int AntwortidDatenbank;
        boolean ist_richtig;
        int Fragengehörigkeit;


        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");

            // Setup the connection with the DB
            connect = DriverManager.
                    getConnection("jdbc:mysql://" + host + "/zettelkasten?" +
                            "user=" + user + "&password=" + passwd);

            // Statements allow to issue SQL queries to the database
            //  statement = connect.createStatement();
            preparedStatement = connect.prepareStatement("SELECT id,content,is_proper_answer FROM answer WHERE question_id=? ");
            preparedStatement.setString(1, String.valueOf(frage_id));

            resultSet = preparedStatement.executeQuery();

          /*  if (resultSet.next()) {
                Antwortlist.add( resultSet.getString("content"));
               // System.out.println(Antwortliste);
            }*/

            while (resultSet.next()) {

              content=resultSet.getString("content");
              AntwortidDatenbank=resultSet.getInt("id");
              ist_richtig=resultSet.getBoolean("is_proper_answer");
              Fragengehörigkeit=frage_id;
            PotentialAnswer AntwortObjekt= new PotentialAnswer(AntwortidDatenbank,content, ist_richtig,Fragengehörigkeit);
            Antwortlist.add( AntwortObjekt);

            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }

        return Antwortlist;

    }

    //below are two methods to be called from outside

    public static void setPotentialAnswers(ArrayList<PotentialAnswer> al) {
       // potAns = al;
        //class card now has its own ArrayList with potential answers
    }

    public static void setQuestion(Question question) {
       // questionObject = question;
        //class card has now its own questionObject
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
