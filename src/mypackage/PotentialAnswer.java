package mypackage;

import jdk.internal.net.http.common.Utils.*;

import java.sql.*;
import java.util.ArrayList;

import static jdk.internal.net.http.common.Utils.close;

//import static jdk.internal.net.http.common.Utils.*;

//import static jdk.internal.net.http.common.Utils.close;


public class PotentialAnswer {
    private static int id; // PK
    private static String content; // ein Antworttext zu einer Frage(Karte)
    private static boolean correct; // in db 1 für true
    private static int card_id; // FK

    private static Connection connect = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    final static private String host = "10.101.208.15";
    final static private String user = "Teilnehmer";
    final static private String passwd = "Teilnehmer";

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public boolean isCorrect() {
        return correct;
    }

    public int card_id() {
        return card_id;
    }

    /*public PotentialAnswer(int id) {

    }*/

    public PotentialAnswer(int id, String content, boolean correct, int card_id) {
        this.id = id;
        this.content = content;
        this.correct = correct;
        this.card_id = card_id;
    }

    /*
     *       card_id muss - wenn es die Klasse card gibt - durch ein card-Objekt ersetzt werden
     *       und im sql-statement ist card_id durch cardObjekt->getId() zu ersetzen.
     *       In der Klasse card brauchen wir Methode loadPotentialAnswers(this);
     *       cardObjekt.loadPotentialAnswers(al); soll dann einkommentiert werden
     */

    public static void loadPotentialAnswersToCard(Card cardObject) throws Exception {
        ArrayList<PotentialAnswer> al = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.
                    getConnection("jdbc:mysql://" + host + "/zettelkasten?" +
                            "user=" + user + "&password=" + passwd);
            statement = connect.createStatement();
            String dummy = "SELECT * FROM answer WHERE question_id=" + cardObject;
            resultSet = statement.executeQuery("SELECT * FROM answer WHERE question_id=" + cardObject.getId());
            while (resultSet.next()) {
                id = resultSet.getInt("id");
                content = resultSet.getString("content");
                correct = resultSet.getBoolean("is_proper_answer");
                card_id = resultSet.getInt("question_id");
                al.add(new PotentialAnswer(id, content, correct, card_id));
            }
            Card.setPotentialAnswers(al);

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



