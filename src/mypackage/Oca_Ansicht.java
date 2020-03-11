package mypackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Oca_Ansicht {
    public static List<JCheckBox> checkboxes1 = new ArrayList<>();
    public static List<JLabel> labelListe = new ArrayList<>();
    static int ifanger=0;
    static   int holen=0;


    public static List<Integer> AlleAusgewähltefragenbisher = new ArrayList<Integer>();

    public static List<Integer> AlleAusgewähltefragenOhneWiederholungen = new ArrayList<Integer>();
    public static List<Integer> FragenListezumsenden = new ArrayList<Integer>();
    public static List<Integer> alreadyselected = new ArrayList<Integer>();

    //There are 2 todos to finish. Find below
  /*  private static Container layoutComponents(String title, float alignment) {

        JPanel container = new JPanel();
        container.setBorder(BorderFactory.createTitledBorder(title));
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        //wenn keine Border haben will, nutze die code unten:
        //container.setBorder(BorderFactory.createEmptyBorder());
        return container;
    }*/

    private static Container layoutComponents(String title) {

        JPanel container = new JPanel();
        container.setBorder(BorderFactory.createTitledBorder(title));
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        //wenn keine Border haben will, nutze die code unten:
        //container.setBorder(BorderFactory.createEmptyBorder());
        return container;
    }


public Oca_Ansicht() {

    JFrame frame = new JFrame("Alignment Example");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //TODO:make an array list of checkbox data type- which can add strings and make new checkboxes using these strings. Then adding and deleting can be dynamic
    //wir erstellen checkboxen
    JCheckBox alles = new JCheckBox("Alle Themenbereiche auswählen");


    JCheckBox zufall = new JCheckBox("random");
    JCheckBox sortiert = new JCheckBox("sorted");

//wir erstellen textfields
    JTextField fragenAnzahl = new JTextField("Custom gewünschte Anzahl von Fragen", 1);
    fragenAnzahl.setColumns(4);
    fragenAnzahl.setBounds(100, 100, 140, 140);

    JTextField zeit = new JTextField("Zeitvorgabe", 1);
    zeit.setColumns(8);
    zeit.setBounds(100, 100, 140, 140);

    // JTextField gewaehltefragenanzahl = new JTextField("", 1);
    //gewaehltefragenanzahl.setColumns(4);
    //gewaehltefragenanzahl.setBounds(100,100,140,140);

    JLabel l1 = new JLabel("-");
    JLabel l2 = new JLabel("Total selected questions: ");
    //wir erstellen button für Submit

    JButton b = new JButton("Submit");

    b.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            //TODO: mach wenn username und passwort von datenbank gibts
            System.out.println("\n\nWelcome to the Learncard with question and anwers-------------------");
            //this is the list of fragen ready to send to class card to be displayed along with its matching answers
            System.out.println("These are the ids of questions from selected topics"+FragenListezumsenden);

            for(int i=0;i<FragenListezumsenden.size();i++){

                System.out.println("frage id"+FragenListezumsenden.get(i));
                List<String> Antwortlist = new ArrayList<>();
                Card card= new Card(FragenListezumsenden.get(i));
              /*  String frage= card.getFrageContentvonfrageID(FragenListezumsenden.get(i));
                System.out.println(frage);
                System.out.println("Diese sind die Antwortmöglichkeiten\n");
                Antwortlist=card.getAntwortenvonFrageid(FragenListezumsenden.get(i));*/

                System.out.println(card.getId());

                System.out.println(card.getFrageObject().toString());
                System.out.println(card.getAntwort());

                /*for(int j=0;j<Antwortlist.size();j++){
                    System.out.println((j+1)+") "+Antwortlist.get(j));

                }*/
                System.out.println("-----------------------------------");
            }


        }
    });


    //wir erstellen container mit aurfuf an method layoutcomponenets welches steht oben
    //   Container panel1 = layoutComponents("Themen zur auswahl", Component.LEFT_ALIGNMENT);
    Container panel1 = layoutComponents("Themen zur auswahl");
    /*Container panel3 = layoutComponents("Themen zur auswahl", Component.RIGHT_ALIGNMENT);
    Container panel4 = layoutComponents("", Component.LEFT_ALIGNMENT);
    Container panel5 = layoutComponents("", Component.RIGHT_ALIGNMENT);*/

    Container panel3 = layoutComponents("Themen zur auswahl");
    Container panel4 = layoutComponents("");
    Container panel5 = layoutComponents("");


//wir addieren checkboxen, textfields und button an gewünschte containers
    panel1.add(alles);
    int erstepanellange = checkboxes1.size() / 2;
    int zweitepanellange = checkboxes1.size() - erstepanellange;


    for (int i = 0; i < erstepanellange; i++) {
        panel1.add(checkboxes1.get(i));
        // checkboxes1.get(i).addActionListener((ActionListener) this);

    }

    for (int i = zweitepanellange - 1; i < checkboxes1.size(); i++) {
        panel3.add(checkboxes1.get(i));

    }


    int anzahllabel = checkboxes1.size();
    for (int i = 0; i < anzahllabel; i++) {

        labelListe.add(new JLabel("-"));

    }


    for (int i = 0; i < checkboxes1.size(); i++) {
        panel5.add(labelListe.get(i));
        // labelListe.get(ifanger).setText("12 fragen");
    }




/* //trying to put the repeating listeners in loop. doesnt work yet
    for(int i=0; i<checkboxes1.size();i++) {
ifanger=i;
        checkboxes1.get(i).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                labelListe.get(ifanger).setText("12 fragen");

            }
        });

    }

*/




/*
    do{
    //trying to put the repeating listeners in loop. doesnt work yet
        checkboxes1.get(holen).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                labelListe.get(holen).setText("12 fragen");
                System.out.println("erledigt");
            }
        });
        System.out.println(holen);
        holen++;
        System.out.println(holen);
        System.out.println("goes to next round");
        //check if we have same number of labels as checkboxes1
    }while (holen<checkboxes1.size()-1);

*/


/*
public class unserlistener extends ActionListener{


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        labelListe.get(2).setText("12 fragen");
        System.out.println("erledigt");

    }
}
*/

  alles.addItemListener(new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent itemEvent) {
            l1.setText("Anzahl Fragen von Alle Themen : 500(fiktive nummer !!)");
        }

    });


    checkboxes1.get(0).addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
        Topic x= new Topic();
        int topic_id= x.readTopic_Id(0+1);
            List<Integer> FragenListevondieseTopic;
            FragenListevondieseTopic=x.getPassendeFragenList(0);


            labelListe.get(0).setText("There are "+String.valueOf(FragenListevondieseTopic.size())+" questions");
            l2.setText("Total questions from selected Topics bisher : "+getAktuelleFragenAnzahl());

        }
    });

    checkboxes1.get(1).addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            Topic x= new Topic();
            int topic_id= x.readTopic_Id(1+1);
            List<Integer> FragenListevondieseTopic;
            FragenListevondieseTopic=x.getPassendeFragenList(1);

            labelListe.get(1).setText("There are "+String.valueOf(FragenListevondieseTopic.size())+" questions");
            l2.setText("Total questions from selected Topics bisher : "+getAktuelleFragenAnzahl());


        }
    });


    checkboxes1.get(2).addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            Topic x= new Topic();
            int topic_id= x.readTopic_Id(2+1);
            List<Integer> FragenListevondieseTopic;
            FragenListevondieseTopic=x.getPassendeFragenList(2);

            labelListe.get(2).setText("There are "+String.valueOf(FragenListevondieseTopic.size())+" questions");
            l2.setText("Total questions from selected Topics bisher : "+getAktuelleFragenAnzahl());

        }
    });


    checkboxes1.get(3).addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            Topic x= new Topic();
            int topic_id= x.readTopic_Id(3+1);
            List<Integer> FragenListevondieseTopic;
            FragenListevondieseTopic=x.getPassendeFragenList(3);

            labelListe.get(3).setText("There are "+String.valueOf(FragenListevondieseTopic.size())+" questions");
            l2.setText("Total questions from selected Topics bisher : "+getAktuelleFragenAnzahl());

        }
    });


    checkboxes1.get(4).addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            Topic x= new Topic();
            int topic_id= x.readTopic_Id(4+1);
            List<Integer> FragenListevondieseTopic;
            FragenListevondieseTopic=x.getPassendeFragenList(4);

            labelListe.get(4).setText("There are "+String.valueOf(FragenListevondieseTopic.size())+" questions");
            l2.setText("Total questions from selected Topics bisher : "+getAktuelleFragenAnzahl());

        }
    });


    checkboxes1.get(5).addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            Topic x= new Topic();
            int topic_id= x.readTopic_Id(5+1);
            List<Integer> FragenListevondieseTopic;
            FragenListevondieseTopic=x.getPassendeFragenList(5);

            labelListe.get(5).setText("There are "+String.valueOf(FragenListevondieseTopic.size())+" questions");
            l2.setText("Total questions from selected Topics bisher : "+getAktuelleFragenAnzahl());

        }
    });



    checkboxes1.get(6).addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            Topic x= new Topic();
            int topic_id= x.readTopic_Id(6+1);
            List<Integer> FragenListevondieseTopic;
            FragenListevondieseTopic=x.getPassendeFragenList(6);
            System.out.println("case of 6:");
            System.out.println(FragenListevondieseTopic);
            labelListe.get(6).setText("There are "+String.valueOf(FragenListevondieseTopic.size())+" questions");
            l2.setText("Total questions from selected Topics bisher : "+getAktuelleFragenAnzahl());

        }
    });

    checkboxes1.get(7).addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            Topic x= new Topic();
            int topic_id= x.readTopic_Id(7+1);
            List<Integer> FragenListevondieseTopic;
            FragenListevondieseTopic=x.getPassendeFragenList(7);

            labelListe.get(7).setText("There are "+String.valueOf(FragenListevondieseTopic.size())+" questions");
            l2.setText("Total questions from selected Topics bisher : "+getAktuelleFragenAnzahl());

        }
    });

    checkboxes1.get(8).addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            Topic x= new Topic();
            int topic_id= x.readTopic_Id(8+1);
            List<Integer> FragenListevondieseTopic;
            FragenListevondieseTopic=x.getPassendeFragenList(8);


            labelListe.get(8).setText("There are "+String.valueOf(FragenListevondieseTopic.size())+" questions");
            l2.setText("Total questions from selected Topics bisher : "+getAktuelleFragenAnzahl());

        }
    });











    panel4.add(fragenAnzahl);
    panel4.add(zeit);
    panel4.add(zufall);
    panel4.add(sortiert);
    // panel4.add(b);
    panel5.add(l2);

    panel5.add(l1);

    panel5.add(b);
   // panel5.setLayout( new CardLayout(65,65) );
   // panel5.setLayout( new CardLayout(100,65) );

    //wir definieren einen layout für frame
    //  frame.setLayout(new FlowLayout());

    frame.setLayout(new GridLayout(2,2));

//wir addieren oben gemachte container panels an unsere frame
    frame.add(panel1);
    frame.add(panel3);
    frame.add(panel4);
    frame.add(panel5);


    frame.pack();
    frame.setVisible(true);
}

    public int  getAktuelleFragenAnzahl() {
        System.out.println("new round-------------------------------------------------------\n\n");
        System.out.println("original list for vergleich");
        System.out.println(AlleAusgewähltefragenbisher);

        int aktuelleanzahl=AlleAusgewähltefragenbisher.size();
        System.out.println("aktuelle anzahl by landing to the method :"+aktuelleanzahl);

        for (int i = 0; i < AlleAusgewähltefragenbisher.size(); i++) {

            int anzahldiesenummer= Collections.frequency(AlleAusgewähltefragenbisher, AlleAusgewähltefragenbisher.get(i));

            System.out.println("number "+AlleAusgewähltefragenbisher.get(i)+" repeats "+anzahldiesenummer+" times");
            System.out.println();

            if( (anzahldiesenummer>1) &&  ((alreadyselected.contains(AlleAusgewähltefragenbisher.get(i))))==false)

            {
                System.out.println("removing "+anzahldiesenummer+" times repeated "+AlleAusgewähltefragenbisher.get(i));
                System.out.println(aktuelleanzahl+"(-"+anzahldiesenummer+"- 1)");
                aktuelleanzahl= aktuelleanzahl-(anzahldiesenummer-1);
                AlleAusgewähltefragenOhneWiederholungen.add(AlleAusgewähltefragenbisher.get(i));
                System.out.println("So final aktuelle anzahl "+aktuelleanzahl);
            }


            if( (anzahldiesenummer==1) &&  ((AlleAusgewähltefragenOhneWiederholungen.contains(AlleAusgewähltefragenbisher.get(i))))==false)
            {
                AlleAusgewähltefragenOhneWiederholungen.add(AlleAusgewähltefragenbisher.get(i));

            }

            alreadyselected.add(AlleAusgewähltefragenbisher.get(i));
            System.out.println("selected till now:");
            System.out.println(alreadyselected);
        }


        System.out.println(" list without repeats");
        System.out.println(AlleAusgewähltefragenOhneWiederholungen);
        FragenEmpfangerFürSubmitButton(AlleAusgewähltefragenOhneWiederholungen);

        System.out.println("So final aktuelle anzahl "+aktuelleanzahl);

        alreadyselected.clear();

        //  Important- send this below list to any other method to collect learnbox on click of submit button. then learnbox will give fragen and antworten to gui as per the
        //question id taken from the list below
        AlleAusgewähltefragenOhneWiederholungen.clear();
        return aktuelleanzahl;


    }

    public void FragenEmpfangerFürSubmitButton(List<Integer> Fragenzumhinzufugen) {

        for (int i = 0; i < Fragenzumhinzufugen.size(); i++) {


            if (((FragenListezumsenden.contains(Fragenzumhinzufugen.get(i)))) == false) {
                FragenListezumsenden.add(Fragenzumhinzufugen.get(i));
            }


        }


    }









    }


