package mypackage;


import java.util.ArrayList;


public class PotentialAnswer {
    private int DatenbankId; // PK
    private String content; // ein Antworttext zu einer Frage(Karte)
    private boolean correct; // in db 1 für true
    private int belongtoWhichquestion; // FK
    private int belongtoWhichCard;


    public int getId() {
        return DatenbankId;
    }

    public String getContent() {
        return content;
    }

    public boolean isCorrect() {
        return correct;
    }

    public int getwhichquestion() {
        return belongtoWhichquestion;
    }
    public int getwhichcard_id() {
        return belongtoWhichCard;
    }


    public PotentialAnswer(int id, String content, boolean correct, int question_id) {
        this.DatenbankId = id;
        this.content = content;
        this.correct = correct;
        this.belongtoWhichquestion = question_id;
        this.belongtoWhichCard=question_id;
    }
    //this code is to display object eigensachaften as String. Else we get to seee only object reference.TODO how to create A,B,C,D for each answers
    @Override
    public String toString() {
        return ("Antwortmöglichkeit: "+getContent()+"\n");
    }

    //call this from submit button oncall function from Oca_Ansicht-  b.addActionListener(new ActionListener() -give answer id/object/answer list as parameter
    // see how to deal with it and how it works - this code below Card.setPotentialAnswers(answerList);

   /* public static void loadPotentialAnswersToCard(Card cardObject)  {
        ArrayList<PotentialAnswer> answerList = new ArrayList<>();



             /*   int paId = resultSet.getInt("id");
                String paContent = resultSet.getString("content");
                boolean paCorrect = resultSet.getBoolean("is_proper_answer");
                int paCardId = resultSet.getInt("question_id");
                //add potential answer objects to ArrayList
                answerList.add(new PotentialAnswer(paId, paContent, paCorrect, paCardId));

           // Card.setPotentialAnswers(answerList);

    }*/
}



