package mypackage;

import java.util.ArrayList;

public class Card {

    private static ArrayList<PotentialAnswer> pa;
    private static Question questionObject;
    private int id;
    private int learnBox_id;
    private String topic;


    public int getLearnBox_id() {
        return learnBox_id;
    }

    public String getTopic() {
        return topic;
    }

    public int getId() {
        return id;
    }

    /*public Card() {

    }

    public Card(Card cardObject) {
        this.id = cardObject.id;
    }*/


    public Card(int id, int learnBox_id, String topic) {
        this.id = id;
        this.learnBox_id = learnBox_id;
        this.topic = topic;
    }

    public Card(int id) throws Exception {
        this.id = id;

        Question.readQuestionContent(this.id);

        PotentialAnswer.loadPotentialAnswersToCard(this);

    }

    public static void setPotentialAnswers(ArrayList<PotentialAnswer> al) {
        pa = al;
    }

    public static void setQuestion(Question question) {
        questionObject = question;
    }


}
