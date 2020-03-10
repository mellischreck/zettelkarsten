package mypackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SubmenuEx extends JFrame {

    public SubmenuEx() {

        initUI();
    }

    private void initUI() {

        createMenuBar();

        setTitle("Lernkarten");
        setSize(360, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createMenuBar() {

        var menuBar = new JMenuBar();

        var iconNew = new ImageIcon("src/resources/new.png");
        var iconOpen = new ImageIcon("src/resources/open.png");
        var iconSave = new ImageIcon("src/resources/save.png");
        var iconExit = new ImageIcon("src/resources/exit.png");

      var fileMenu = new JMenu("LernAngebote");

      /*
        var ocamenu = new JMenu("JavaOCA");
        var ocpmenu= new JMenu("JavaOCP");
        var datenbanken= new JMenu("Datenbanken");
        var linuxlernen= new JMenu("Linux");
*/

        var ocamenu = new JMenuItem("JavaOCA");
        var ocpmenu= new JMenuItem("JavaOCP");
        var datenbanken= new JMenuItem("Datenbanken");
        var linuxlernen= new JMenuItem("Linux");




        //basics
        JCheckBox alles = new JCheckBox("Alle Themenbereiche auswählen");
        JCheckBox stringLernen = new JCheckBox("String & String Builder");
        JCheckBox oopLernen = new JCheckBox("ObjektOrientierung");
        JCheckBox interfaceLernen = new JCheckBox("Interface");
        JCheckBox inheritanceLernen = new JCheckBox("Inheritance");

        JTextField fragenAnzahl = new JTextField("Anzahl von Fragen", 1);
        JTextField zeit = new JTextField("Zeitvorgabe", 1);
        JCheckBox zufall = new JCheckBox("random");
        JCheckBox sortiert = new JCheckBox("sorted");
//till here

/*
        ocamenu.add(alles);
        ocamenu.add(stringLernen);
        ocamenu.add(oopLernen);
        ocamenu.add(interfaceLernen);
        ocamenu.add(inheritanceLernen);
        ocamenu.add(fragenAnzahl);

        ocamenu.add(zeit);
        ocamenu.add(zufall);
        ocamenu.add(sortiert);

*/
        var exitMenuItem = new JMenuItem("Exit", iconExit);
        exitMenuItem.setToolTipText("Exit application");

        exitMenuItem.addActionListener((event) -> System.exit(0));


        fileMenu.add(linuxlernen);
        fileMenu.addSeparator();
         fileMenu.add(datenbanken);
        fileMenu.addSeparator();
        fileMenu.add(ocpmenu);
        fileMenu.addSeparator();
        fileMenu.add(ocamenu);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        ocamenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
               dispose();
              //  new ocaansicht();
                new Oca_Ansicht();

            }


    });
    }
    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            var ex = new SubmenuEx();
            ex.setVisible(true);
            try {
                DB.connect();
            } catch (SQLException e) {
                e.printStackTrace();
            }


        });
    }
}