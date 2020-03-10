package mypackage;


import java.sql.*;
import java.util.ArrayList;


public class PotentialAnswer {
    private int id; // PK
    private String content; // ein Antworttext zu einer Frage(Karte)
    private boolean correct; // in db 1 für true
    private int card_id; // FK

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

    public boolean isCorrect() {
        return correct;
    }

    public int card_id() {
        return card_id;
    }


    public PotentialAnswer(int id, String content, boolean correct, int card_id) {
        this.id = id;
        this.content = content;
        this.correct = correct;
        this.card_id = card_id;
    }


    public static void loadPotentialAnswersToCard(Card cardObject) throws Exception {
        ArrayList<PotentialAnswer> answerList = new ArrayList<>();
        try {
            connect= DB.connect();
            statement = connect.createStatement();
            String dummy = "SELECT * FROM answer WHERE question_id=" + cardObject;
            resultSet = statement.executeQuery("SELECT * FROM answer WHERE question_id=" + cardObject.getId());
            while (resultSet.next()) {
                int paId = resultSet.getInt("id");
                String paContent = resultSet.getString("content");
                boolean paCorrect = resultSet.getBoolean("is_proper_answer");
                int paCardId = resultSet.getInt("question_id");
                //add potential answer objects to ArrayList
                answerList.add(new PotentialAnswer(paId, paContent, paCorrect, paCardId));
            }
            Card.setPotentialAnswers(answerList);

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



