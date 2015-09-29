/*
 * The Constructors
 * SchoolMarm
 */
package Database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import controller.SchoolMarm;

import view.DBInfoView;
import view.MainFrame;
import view.NewUserView;

/**
 * The Class DBInfo.
 *
 */
public class DBInfo {

    /** The host. */
    private static String host;

    /** The username. */
    private static String username;

    /** The database. */
    private static String database;

    /** The password. */
    private static String password;

    /** The db info file. */
    private static File dbInfoFile;

    /**
     * Setup db.
     */
    public void setupDB() {
        File directory = new File(SchoolMarm.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "Resources");
        directory.mkdir();
        String fileURL = SchoolMarm.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "Resources" + File.separator + "dbinfo.txt";
        dbInfoFile = new File(fileURL);

        if(!dbInfoFile.exists()) {
            try {
                dbInfoFile.createNewFile();
                getDBInfo();
            } catch(IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(dbInfoFile));
                host = reader.readLine();
                database = reader.readLine();
                username = reader.readLine();
                password = reader.readLine();
                reader.close();

                if(!DBConnect.createConnection()) {
                    getDBInfo();
                } else {
                    if(DBAccessor.peopleExist())
                        SchoolMarm.setup();
                    else
                        newUser();
                }
            } catch(Exception e) {
                e.printStackTrace();
                getDBInfo();
            }
        }
    }

    /**
     * New user.
     */
    public static void newUser() {
        MainFrame frame = new MainFrame();
        NewUserView nuv = new NewUserView(frame);
        frame.add(nuv);
        frame.setSize(400, 350);
        frame.setVisible(true);
    }

    /**
     * Gets the dB info.
     *
     * @return the dB info
     */
    public static void getDBInfo() {
        MainFrame frame = new MainFrame();
        DBInfoView dbiv = new DBInfoView(frame);
        frame.add(dbiv);
        frame.setSize(310, 220);
        frame.setVisible(true);
    }

    /**
     * Sets the info.
     *
     * @param nhost the nhost
     * @param ndatabase the ndatabase
     * @param nusername the nusername
     * @param npassword the npassword
     */
    public static void setInfo(String nhost, String ndatabase, String nusername, String npassword) {
        host = nhost;
        database = ndatabase;
        username = nusername;
        password = npassword;

        if(DBConnect.createConnection()) {
            try {
                PrintWriter out = new PrintWriter(new FileWriter(dbInfoFile));
                out.println(host);
                out.println(database);
                out.println(username);
                out.println(password);
                out.close();
            } catch(Exception e) {
                e.printStackTrace();
            }

            if(DBAccessor.peopleExist())
                SchoolMarm.setup();
            else
                newUser();
        } else {
            getDBInfo();
        }
    }

    /**
     * Gets the host.
     *
     * @return the host
     */
    public static String getHost() {
        return host;
    }

    /**
     * Gets the database.
     *
     * @return the database
     */
    public static String getDatabase() {
        return database;
    }

    /**
     * Gets the username.
     *
     * @return the username
     */
    public static String getUsername() {
        return username;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public static String getPassword() {
        return password;
    }

}
