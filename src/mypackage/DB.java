package mypackage;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DB {

    private static final String filename = "db.config";
    private static Connection connect = null;

    public static void connect() throws SQLException {

        Properties prop = new Properties();
        InputStream input = null;


        try {



            input = DB.class.getResourceAsStream(filename);
            if (input == null) {
                System.out.println("Sorry, we are closed: " + filename);
                return;
            }

            prop.load(input);

            System.out.println("database: "+prop.getProperty("database"));
            System.out.println("user: "+prop.getProperty("user"));
            System.out.println("password: "+prop.getProperty("password"));
            System.out.println("host: "+prop.getProperty("host"));
            System.out.println("url: "+prop.getProperty("url"));

            //load driver
            Class.forName(prop.getProperty("driver"));
            //connection
            connect = DriverManager.
                                getConnection(prop.getProperty("url") + prop.getProperty("host") + prop.getProperty("database") +
                                        "user=" +  prop.getProperty("user") + "&password=" +  prop.getProperty("password"));

            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}