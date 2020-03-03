package mypackage;

public class Card {

    private void loadCard(int id) throws Exception {
        Question question = new Question(id);
        question.getContent();
        question.getId();

    }

    private void readCard(){

    }

}
