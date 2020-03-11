package mypackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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


        var iconExit = new ImageIcon("src/resources/exit.png");

      var fileMenu = new JMenu("LernAngebote");

        var ocamenu = new JMenuItem("JavaOCA");
        var ocpmenu= new JMenuItem("JavaOCP");
        var datenbanken= new JMenuItem("Datenbanken");
        var linuxlernen= new JMenuItem("Linux");


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
            public void actionPerformed(ActionEvent actionEvent)  {
               dispose();
              //  new ocaansicht();

                Topic dao = new Topic();
                try {
                    dao.readDataBase();
                } catch (Exception e) {
                    e.printStackTrace();
                }
               // new Oca_test_dísplay();
                new Oca_Ansicht();
            }


    });






    }


   public static void machSubmenu(){


       EventQueue.invokeLater(() -> {

           var ex = new SubmenuEx();
           ex.setVisible(true);
       });
   }



   /*
    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            var ex = new SubmenuEx();
            ex.setVisible(true);
        });
    }*/
}