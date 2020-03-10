package mypackage;

import java.util.ArrayList;

public class Card {

    private static ArrayList<PotentialAnswer> potAns = new ArrayList<>();
    private static Question questionObject;
    private int id;
    private int learnBox_id;//used later
    private String topic;//used later


    public int getLearnBox_id() {
        return learnBox_id;
    }

    public String getTopic() {
        return topic;
    }

    public int getId() {
        return id;
    }

    public Card(int id) throws Exception {
        this.id = id;

        Question.loadQuestionToCard(this.id); //wants question obejct with id
        PotentialAnswer.loadPotentialAnswersToCard(this); //wants ArrayList with potentiel answers with empty card
    }

    public static void setPotentialAnswers(ArrayList<PotentialAnswer> al) {
        potAns = al;
        //class card now has its own ArrayList with potential answers
    }

    public static void setQuestion(Question question) {
        questionObject = question;
        //class card has now its own questionObject
    }


}
