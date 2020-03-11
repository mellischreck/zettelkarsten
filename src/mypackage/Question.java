package mypackage;


public class Question {

    private int id;
    private String content;
    private int belongtoWhichCard;//should be same as id?




    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public int getWhichCard() {
        return belongtoWhichCard;
    }


    public Question(String content, int id) throws Exception {

        this.content = content;
        this.id = id;
        this.belongtoWhichCard=id;
    }
    //this code is to display object eigensachaften as String. Else we get to seee only object reference
    @Override
    public String toString() {
        return ("(question nr:" + id +") " + content);
    }

    //call this from submit button oncall function from Oca_Ansicht-  b.addActionListener(new ActionListener() -give frage id as parameter
    // see how to deal with it and how it works - this code below // Card.setQuestion(question);

  /*  public static void loadQuestionToCard(int id) {

               // String contentResult = ;
                //create question object with given id and content from db
              //  Question question = new Question(id, contentResult);
               // Card.setQuestion(question);

    }
*/



}
