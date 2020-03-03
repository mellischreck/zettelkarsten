package mypackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Oca_Ansicht {
    //There are 2 todos to finish. Find below
    private static Container layoutComponents(String title, float alignment) {

        JPanel container = new JPanel();
        container.setBorder(BorderFactory.createTitledBorder(title));
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        //wenn keine Border haben will, nutze die code unten:
      //container.setBorder(BorderFactory.createEmptyBorder());
        return container;
    }

public Oca_Ansicht(){

    JFrame frame = new JFrame("Alignment Example");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 //TODO:make an array list of checkbox data type- which can add strings and make new checkboxes using these strings. Then adding and deleting can be dynamic
    //wir erstellen checkboxen
    JCheckBox alles = new JCheckBox("Alle Themenbereiche auswählen");
    JCheckBox stringLernen = new JCheckBox("String & String Builder");
    JCheckBox oopLernen = new JCheckBox("\t"+"ObjektOrientierung");
    JCheckBox interfaceLernen = new JCheckBox("Interface");
    JCheckBox inheritanceLernen = new JCheckBox("Inheritance");
    JCheckBox wrapperlernen = new JCheckBox("wrapperclass");
    JCheckBox anonymeklassen = new JCheckBox("anonymclass");
    JCheckBox lambdalernen = new JCheckBox("Lambda Expressions");
    JCheckBox datentypen = new JCheckBox("Datatypes");
    JCheckBox operatoren = new JCheckBox("Operators");
    JCheckBox schleifen = new JCheckBox("Loops");
    JCheckBox zufall = new JCheckBox("random");
    JCheckBox sortiert = new JCheckBox("sorted");

//wir erstellen textfields
    JTextField fragenAnzahl = new JTextField("Anzahl von Fragen", 1);
    fragenAnzahl.setColumns(4);
    fragenAnzahl.setBounds(100,100,140,140);

    JTextField zeit = new JTextField("Zeitvorgabe", 1);
    zeit.setColumns(8);
    zeit.setBounds(100,100,140,140);

    //wir erstellen button für Submit

    JButton b=new JButton("Submit");

    b.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            //TODO: mach wenn username und passwort von datenbank gibts
        }
    });






    //wir erstellen container mit aurfuf an method layoutcomponenets welches steht oben
    Container panel1 = layoutComponents("Themen zur auswahl", Component.LEFT_ALIGNMENT);
    Container panel3 = layoutComponents("Themen zur auswahl", Component.RIGHT_ALIGNMENT);
    Container panel4 = layoutComponents("", Component.LEFT_ALIGNMENT);
    Container panel5 = layoutComponents("", Component.RIGHT_ALIGNMENT);

//wir addieren checkboxen, textfields und button an gewünschte containers
    panel1.add(alles);
    panel1.add(stringLernen);
    panel1.add(oopLernen);
    panel1.add(interfaceLernen);
    panel1.add(inheritanceLernen);
    panel1.add(schleifen);

    panel3.add(wrapperlernen);
    panel3.add(anonymeklassen);
    panel3.add(lambdalernen);
    panel3.add(datentypen);
    panel3.add(operatoren);


    panel4.add(fragenAnzahl);
    panel4.add(zeit);
    panel4.add(zufall);
    panel4.add(sortiert);
   // panel4.add(b);
panel5.add(b);
panel5.setLayout( new CardLayout(65,65) );

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


    public static void main(String args[]) {
        new Oca_Ansicht();
    }
}