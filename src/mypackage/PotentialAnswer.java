package mypackage;

import java.sql.*;
import java.util.ArrayList;

import static jdk.internal.net.http.common.Utils.close;


public class PotentialAnswer  {
    private int id; // PK
    private String content; // ein Antworttext zu einer Frage(Karte)
    private boolean correct; // in db 1 für true
    private int card_id; // FK

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

    public int getCard_id() {
        return card_id;
    }

    public PotentialAnswer() {
    }

    public PotentialAnswer(int id, String content, boolean correct, int card_id) {
        this.id = id;
        this.content = content;
        this.correct = correct;
        this.card_id = card_id;
    }

    /*
    ** @todo card_id muss - wenn es die Klasse card gibt - durch ein card-Objekt ersetzt werden
    *       und im sql-statement ist card_id durch cardObjekt->getId() zu ersetzen.
    *       In der Klasse card brauchen wir Methode loadPotentialAnswers(this);
    *       cardObjekt.loadPotentialAnswers(al); soll dann einkommentiert werden
     */
    public  void loadPotentialAnswersToCard(int card_id) throws Exception {
        ArrayList<PotentialAnswer> al = new ArrayList<>();
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");

            // Setup the connection with the DB
            connect = DriverManager.
                    getConnection("jdbc:mysql://" + host + "/zettelkasten?" +
                            "user=" + user + "&password=" + passwd );

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            String dummy = "SELECT * FROM answer WHERE question_id=" + card_id;
            resultSet = statement.executeQuery("SELECT * FROM answer WHERE question_id=" + card_id);
            while (resultSet.next()) {
                id = resultSet.getInt("id");
                content = resultSet.getString("content");
                correct= resultSet.getBoolean("is_proper_answer");
                card_id = resultSet.getInt("question_id");
                al.add(new PotentialAnswer(id, content, correct, card_id));
            }
            // cardObjekt.loadPotentialAnswers(al);

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }
}
