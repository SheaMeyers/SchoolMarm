
/*
 * Referenced libraries derby.jar, derbyclient.jar, derbytools.jar, derbynet.jar
 * and postgresql-9.2-1000.jdbc4.jar and the sourcecode for postgresql-9.2-1000.jdbc4
 * have to be in the build path
 */
package Database;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Takes incoming messages passed from DBAccessor and insert/updates/deletes/selects from the tables.
 * Validates the connection before a query and validates the existence of the tables before a query is done.
 * If the tables are not present, it will create the tables or missing tables (on first run).
 * Opens and closes the connection and statements.
 *
 */
public class DBConnect {
	//variables returned from DBInfo to allow one to dynamically connect to any database
	//used in createConnection
    private static String hostName = DBInfo.getHost();
    private static String dbaseName = DBInfo.getDatabase();
    private static String userName = DBInfo.getUsername();
    private static String password = DBInfo.getPassword();
	
	//connection variable
    private static Connection connection = null;

    //These are of type statement, used to build a statement, once implemented
    //they would not be used
    private static Statement stmt, qstmt = null;

    //tableName of table being confirmed created
    private static String tableName = null;

    //String value to create grades table
    private static String gradesTable = ("CREATE TABLE " + "grades" + "(" +
                                         "gr_assignment varchar(50) not null," +
                                         " gr_sid varchar(6) not null," +
                                         " gr_class varchar(25) not null," +
                                         " gr_mark numeric(3)," +
                                         " PRIMARY KEY (gr_assignment, gr_sid, gr_class)," +
                                         " FOREIGN KEY (gr_sid) references people(pl_pid)," +
                                         " FOREIGN KEY (gr_class, gr_assignment) references assign(as_class, as_assignment));");

    //String value to create attendance table
    private static String attendanceTable = ("CREATE TABLE " + "attendance" + "(" +
                                          "at_sid varchar(6) not null," +
                                          " at_datetime date not null," +
                                          " at_present boolean default true ," +
                                          " PRIMARY KEY (at_sid, at_datetime)," +
                                          " FOREIGN KEY (at_sid) references people(pl_pid));");

    //String value to create infractions table
    private static String infractionsTable = ("CREATE TABLE " + "infractions" + "(" +
    									"in_sid varchar(6) not null," +
    									" in_datetime timestamp not null," +
    									" in_type varchar(25)," +
    									" in_description text," +
    									" PRIMARY KEY (in_sid, in_datetime)," +
            							" FOREIGN KEY (in_sid) references people(pl_pid));");

    //String value to create calendar table
    private static String calendarTable = ("CREATE TABLE " + "calendar" + "(" +
                                        "c_date date not null," + 
                                        "c_hour int not null," +
                                        "c_info text," +
                                        " PRIMARY KEY (c_date, c_hour));");

    //String values to create the options table
    private static String optionsTable = ("CREATE TABLE " + "options" + "(" +
                                          "o_rows int," +
                                          "o_columns int);");

    //String value to create people table
    private static String peopleTable = ("CREATE TABLE " + "people" + "(" +
                                         "pl_pid varchar(6) not null unique primary key," +
                                         " pl_fname varchar(50) not null," +
                                         " pl_lname varchar(50) not null," +
                                         " pl_gaurdian1 varchar(50)," +
                                         " pl_gaurdian2 varchar(50)," +
                                         " pl_address text," +
                                         " pl_email varchar(50)," +
                                         " pl_allergy varchar(50)," +
                                         " pl_phone varchar(14)," +
                                         " pl_desk int," +
                                         " pl_pass varchar(25) not null," +
                                         " pl_user_level int," +
                                         " pl_img_url varchar(50));");

    //String value to create assignment table
    private static String assignTable = ("CREATE TABLE " + "assign" + "(" +
                                         "as_class varchar(25) not null," +
                                         " as_assignment varchar(50) not null, " +
                                         " as_start timestamp," +
                                         " as_due timestamp," +
                                         " PRIMARY KEY (as_class, as_assignment));");



    //main to test connection and other functions
    public static void main(String[] argv) {
        
    	//test values to allow login for testing purposes
    	hostName = "edjo.usask.ca";
    	dbaseName = "cmpt370_constructors";
    	userName = "cmpt370_constructors";
    	password = "38gjjskdf3423jfj";
    	
    	Boolean valid = false;
        //String query = ("update people set pl_desk = '5' where pl_pid = 'daj113'");
        String query2 = ("select * from people");
        // Create a connection to the database and checks for existence of the database
        //and creates it if necessary.
        System.out.println(hostName + dbaseName + userName + password);
        
        valid = createConnection();
        //checks to see if the connection is still valid, used before and update or a query
        //valid = isValid();
        System.out.println(valid);
       
        //check existence of table before trying to query or update it
        tableName = "people";
        checkTablesExistance(tableName, peopleTable);
        tableName = "assign";
        checkTablesExistance(tableName, assignTable);
        tableName = "grades";
        checkTablesExistance(tableName, gradesTable);
        tableName = "infractions";
        checkTablesExistance(tableName, infractionsTable);
        tableName = "calendar";
        checkTablesExistance(tableName, calendarTable);
        tableName = "attendance";
        checkTablesExistance(tableName, attendanceTable);
        tableName = "options";
        checkTablesExistance(tableName, optionsTable);
        //query table using a pre compiled string of the database command
        //updateTable(query);
        //select info from table additional code to show how it is parsed
        //and requested only as an example and will not stay
        select(query2);

        //Close connection to database, to be done when exiting the School Marm application
        if(closeConnection()) {
            System.out.println("Connection closed.");
        }
    }

    /**
     * This function will query the database and create a ResultSet result
     * that can be broken apart as shown, the table name is part of the query.
     *
     * @param query - A String value of the command.
     * @return
     */
    public static ResultSet select(String query) {
        if(isValid()) {
            try {
                qstmt = connection.createStatement();
                //Get a result back from the query to the database
                ResultSet results = qstmt.executeQuery(query);
                return results;
            } catch(SQLException e) {
                System.out.println(e);
                e.printStackTrace();
            }
        }

        return null;
    }

    /**
     * Insert, delete and update or otherwise modify the table. The statement should be
     * built as a string and passed into query.
     *
     * @param query - A query built in calling class.
     * @return
     */
    public static Boolean updateTable(String query) {
        int result = 0;

        try {
            qstmt = connection.createStatement();
            result = qstmt.executeUpdate(query);

            //System.out.println(result);
            if(result != 0)
                return true;
        } catch(SQLException e) {
            System.out.println(e);
        }

        return false;
    }

    /**
     * This method check the existence of a specific table tblNm and if it does not
     * exist it will call createTable and pass in the tblNm and the table attributes to
     * build the table. Should have named it tableExists()
     *
     * @param tblNm	 Name of the table to check the existence of.
     * @param tableAtt  a String representation of the create table statement
     * @return
     *
     */
    public static boolean checkTablesExistance(String tblNm, String tableAtt) {
    	//create a variable for the returned result set
        ResultSet rs = null;
        //create a variable for the returned metadata
        java.sql.DatabaseMetaData dbmd = null;

        //check for tables to ensure that all tables are present in the
        //database and create the tables if needed
        try {
            dbmd = connection.getMetaData();
            rs = dbmd.getTables("cmpt370_constructors", null, tblNm, null);

            if(rs.next()) {
                System.out.println("Table name: " + rs.getString("TABLE_NAME") + ", found");
                return true;
            } else {
                createTable(tblNm, tableAtt);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * This will create a table that has not been created if checkTableExistence
     * does not find the table
     *
     * @param tblNm  table name
     * @param tableAtt create statement will all attributes
     */
    public static void createTable(String tblNm, String tableAtt) {
        //create tables if not present
    	try {
            stmt = connection.createStatement();
            stmt.execute(tableAtt);
            //output to indicate to console that the table was created
            System.out.println(stmt.toString());
            System.out.println(connection.toString());
        } catch(SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    /**
     * Create a connection to the database. This is called when SchoolMarm is opened.'
     * This will also check for the existence of all the tables and if they do not
     * exist they will be created.
     */
    public static boolean createConnection() {

        System.out.println("-------- PostgreSQL JDBC Connection Testing ------------");

        //try loading the driver for postgres, if it is not found display a message to 
        //indicate that it is missing the driver and unable to load
        try {
            Class.forName("org.postgresql.Driver");
        } catch(ClassNotFoundException e) {
            System.out.println("Where is your PostgreSQL JDBC Driver? Please add it to your library path!");
            e.printStackTrace();
            return false;
        }
        //indicate that the postgres driver was found and loaded
        System.out.println("PostgreSQL JDBC Driver Registered!");

        //try to connect to the database that was indicated on first startup and saved  as dbinfo.txt
        //call DBInfo to get this information from the file, if file is missing SchoolMarm will ask for 
        //it at startup by means of a popup box
        try {
            connection = DriverManager.getConnection(
                             "jdbc:postgresql://" + hostName + "/" + dbaseName, userName,
                             password);
        } catch(SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return false;
        }
        //if connection was successful test for database file every time startup starts, 
        //this only displays to the console and will create them if not found
        if(connection != null) {
            System.out.println("Connection successful!");
            tableName = "people";
            checkTablesExistance(tableName, peopleTable);
            tableName = "assign";
            checkTablesExistance(tableName, assignTable);
            tableName = "grades";
            checkTablesExistance(tableName, gradesTable);
            tableName = "infractions";
            checkTablesExistance(tableName, infractionsTable);
            tableName = "calendar";
            checkTablesExistance(tableName, calendarTable);
            tableName = "attendance";
            checkTablesExistance(tableName, attendanceTable);
            tableName = "options";
            checkTablesExistance(tableName, optionsTable);
            return true;
        } else {
            System.out.println("Failed to make connection!");
            return false;
        }
    }

    /**
     * This will check to see if the connection to the database id still valid
     *
     * @return Boolean value true if connection is valid false otherwise
     */
    public static Boolean isValid() {
        try {
            if(connection.isValid(0))
                return true;
        } catch(SQLException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }

        return false;
    }

    /**
     * This method closes the open statements and then closes the connection
     * 
     * @return a boolean true if the statements and connections closed
     * 			false otherwise
     */
    public static Boolean closeConnection() {
        {
            try {
                if(stmt != null) {
                    stmt.close();
                }

                if(connection != null) {
                    connection.close();
                    return true;
                }
            } catch(SQLException e) {
                System.out.println(e.toString());
                e.printStackTrace();
            }
        }
        return true;
    }
}
