package mypackage;

import java.util.ArrayList;

public class Card {

    private ArrayList<PotentialAnswer> pa;
    private Question question;
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

    public Card() {

    }

    public Card(int id, int learnBox_id, String topic) {
        this.id = id;
        this.learnBox_id = learnBox_id;
        this.topic = topic;
    }


    public Card(int id) throws Exception {
        this.id = id;

        //readQuestionContent(this.id);

        //loadPotentialAnswersToCard(Card cardObject);

    }

    public void setPotentialAnswers(ArrayList<PotentialAnswer> al) {
        pa = al;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Card(Card cardObject) {
        this.id = cardObject.id;
    }


}
