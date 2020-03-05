package mypackage;

import java.sql.*;
import java.util.ArrayList;

import static jdk.internal.net.http.common.Utils.close;


public class PotentialAnswer {
    private int id; // PK
    private String content; // ein Antworttext zu einer Frage(Karte)
    private boolean correct; // in db 1 für true
    private Card cardObject; // FK

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    final static private String host = "localhost";
    final static private String user = "root";
    final static private String passwd = "toor";

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public boolean isCorrect() {
        return correct;
    }

    public Card cardObject() {
        return cardObject;
    }

    public PotentialAnswer(int id) {

    }

    public PotentialAnswer(int id, String content, boolean correct, Card cardObject) {
        this.id = id;
        this.content = content;
        this.correct = correct;
        this.cardObject = cardObject;
    }

    /*
     *       card_id muss - wenn es die Klasse card gibt - durch ein card-Objekt ersetzt werden
     *       und im sql-statement ist card_id durch cardObjekt->getId() zu ersetzen.
     *       In der Klasse card brauchen wir Methode loadPotentialAnswers(this);
     *       cardObjekt.loadPotentialAnswers(al); soll dann einkommentiert werden
     */

    public void loadPotentialAnswersToCard(Card cardObject) throws Exception {
        ArrayList<PotentialAnswer> al = new ArrayList<>();
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
            String dummy = "SELECT * FROM answer WHERE question_id=" + cardObject;
            resultSet = statement.executeQuery("SELECT * FROM answer WHERE question_id=" + cardObject.getId());
            while (resultSet.next()) {
                id = resultSet.getInt("id");
                content = resultSet.getString("content");
                correct = resultSet.getBoolean("is_proper_answer");

                //cardObject = resultSet.getInt("question_id");------------------------------------Lösung bitte
                al.add(new PotentialAnswer(id, content, correct, cardObject));
            }
            cardObject.setPotentialAnswers(al);

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

}
