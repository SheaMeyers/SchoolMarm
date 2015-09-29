/*
 * The Constructors
 * SchoolMarm
 */
package Database;
import java.sql.*;

/**
 * The Class DBAccessor.
 *
 */
public class DBAccessor {

    /** The sql text. */
    private static String sqlText;		//String used to do Database queries

    /** The result. */
    private static ResultSet result;	//ResultSet that holds info the was taken from the database


    /**
     * First return the number of the rows, then the number of the columns,
     * then the students.
     *
     * Everything is seperated by a \t character
     *
     * @return the string
     */
    public String getInfo() {
        boolean exist = DBConnect.checkTablesExistance("people", "pl_fname"); //First ensure the table exists

        if(exist == false) { //If it doesn't return null
            return null;
        } else {
            sqlText = "select * from 'people'"; //Create the query
            result = DBConnect.select(sqlText);		//Query the database
            String students = "";
            int rows = 0;
            int cols = 14;

            try {
                //Will run while there are result to process
                while(result.next()) {
                    students += result.getString(2) + "\t"; //Gets the students first name
                    rows++;	//For every next() there means there is one more row
                }
            } catch(SQLException SQLe) {
                System.out.println(SQLe);
                SQLe.printStackTrace();
            }

            String sres = rows + "\t" + cols + "\t" + students; //Create a string that holds the row, then column, then student names
            return sres; //Return the string
        }
    }

    /**
     * Get all the assignments for a class.
     *
     * @return - A string containing all the information about the assignments
     * Tab delimited, a newline for each row
     */
    public String[] getAllAssignments() {
        sqlText = "select count(*) from assign";
        result = DBConnect.select(sqlText);
        int numItems = 0;

        //Gets the number of assignments in the database
        try {
            result.next();
            numItems = result.getInt(1);
        } catch(SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        sqlText = "select * from assign";
        result = DBConnect.select(sqlText);

        //Gets all the information from the database
        if(result == null) {
            return null;
        } else {
            String[] sres = new String[numItems];

            try {
                int i = 0;

                while(result.next()) {
                    sres[i] = "";
                    sres[i] += result.getString(1) + "\t";
                    sres[i] += result.getString(2) + "\t";
                    sres[i] += result.getString(3) + "\t";
                    sres[i] += result.getString(4) + "\n";
                    i++;
                }
            } catch(SQLException SQLe) {
                System.out.println(SQLe);
                SQLe.printStackTrace();
            }
            
            //return the results
            return sres;
        }
    }

    /**
     * Gets all the calender events in the database.
     *
     * @return - All calendder events, tab delimited, each new row end with a newline
     */
    public String[] getAllCalenderEvents() {
        sqlText = "select count(*) from calender";
        result = DBConnect.select(sqlText);
        int numItems = 0;

        // number of calender items
        try {
            result.next();
            numItems = result.getInt(1);
        } catch(SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        sqlText = "select * from calendar";
        result = DBConnect.select(sqlText);

        //Get information from calender
        if(result == null) {
            return null;
        } else {
            String[] sres = new String[numItems];

            try {
                int i = 0;

                while(result.next()) {
                    sres[i] = "";
                    sres[i] += result.getString(1) + "\t";
                    sres[i] += result.getString(2) + "\n";
                    i++;
                }
            } catch(SQLException SQLe) {
                System.out.println(SQLe);
                SQLe.printStackTrace();
            }

            return sres;
        }
    }


    /**
     * Get all the grades in the database.
     *
     * @param sid the sid
     * @return - The grades, tab delimited, rows separted by newline
     */
    public String[] getStudentGrades(String sid) {
        sqlText = "select count(*) from grades where gr_sid='" + sid + "'";
        result = DBConnect.select(sqlText);
        int numItems = 0;

        try {
            result.next();
            numItems = result.getInt(1);
        } catch(SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        sqlText = "select * from grades where gr_sid='" + sid + "'";
        result = DBConnect.select(sqlText);

        if(result == null) {
            return null;
        } else {
            String[] sres = new String[numItems];

            try {
                int i = 0;

                while(result.next()) {
                    sres[i] = "";
                    sres[i] += result.getString(1) + "\t";
                    sres[i] += result.getString(2) + "\t";
                    sres[i] += result.getString(3) + "\t";
                    sres[i] += result.getString(4) + "\n";
                    i++;
                }
            } catch(SQLException SQLe) {
                System.out.println(SQLe);
                SQLe.printStackTrace();
            }

            return sres;
        }
    }

    /**
     * Gets the student infractions.
     *
     * @param sid the sid
     * @return the student infractions
     */
    public String[] getStudentInfractions(String sid) {
        sqlText = "select count(*) from infractions where in_sid='" + sid + "'";
        result = DBConnect.select(sqlText);
        int numItems = 0;

        try {
            result.next();
            numItems = result.getInt(1);
        } catch(SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String[] sres = new String[numItems];
        sqlText = "select * from infractions where in_sid='" + sid + "'";
        result = DBConnect.select(sqlText);

        if(result == null) {
            return null;
        } else {
            try {
                int i = 0;

                while(result.next()) {
                    sres[i] = "";
                    sres[i] += result.getString(1) + "\t";
                    sres[i] += result.getString(2) + "\t";
                    sres[i] += result.getString(3) + "\t";
                    sres[i] += result.getString(4) + "\t";
                    i++;
                }
            } catch(SQLException SQle) {
                System.out.println(SQle);
                SQle.printStackTrace();
            }

            return sres;
        }
    }

    /**
     * Login.
     *
     * @param id - Persons ID
     * @param password - Persons Password
     * @return All the information about the person logging in
     *
     * All the results are seperated by a \t
     */
    public String login(String id, String password) {
        sqlText = "Select * from people where pl_pid='" + id + "' and pl_pass='" + password + "'"; //Create the query
        ResultSet result = DBConnect.select(sqlText); //Query the database

        if(result == null) { //If the username or password is wrong then result will be null, and therefore we return null
            return null;
        } else {
            String sres = null;

            try {
                while(result.next()) {
                    sres = "";
                    //Get information about the person
                    sres += result.getString(1) + "\t";
                    sres += result.getString(2) + "\t";
                    sres += result.getString(3) + "\t";
                    sres += result.getString(4) + "\t";
                    sres += result.getString(5) + "\t";
                    sres += result.getString(6) + "\t";
                    sres += result.getString(7) + "\t";
                    sres += result.getString(8) + "\t";
                    sres += result.getString(9) + "\t";
                    //sres += result.getString(10) + "\t";
                    //sres += result.getString(11) + "\t";
                    //sres += result.getString(12) + "\t";
                    sres += Integer.toString(result.getInt(10)) + "\t";
                    sres += result.getString(11) + "\t";
                    sres += Integer.toString(result.getInt(12)) + "\t";
                    sres += result.getString(13);
                }
            } catch(SQLException SQLe) {
                System.out.println(SQLe);
                SQLe.printStackTrace();
            }

            return sres; //Return the information about the person
        }
    }



    /**
     * Get all the students info at startup.
     *
     * @return - A string array, the index is the seat number of the student
     */
    public static String[] StartUp() {
        //String[] students=null;
        sqlText = "select count(*) from people where pl_user_level = 0";
        result = DBConnect.select(sqlText);
        int numPeople = 0;

        try {
            result.next();
            numPeople = result.getInt(1);
        } catch(SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String[] students = new String[numPeople];
        sqlText = "select * from people where pl_user_level = 0"; //Create the query
        result = DBConnect.select(sqlText); //Query the database

        //Get all the information of the student and put into an array
        try {
            int i = 0;

            while(result.next()) {
                /*
                students[result.getInt(13)] += result.getString(1) + "\t";
                students[result.getInt(13)] += result.getString(2) + "\t";
                students[result.getInt(13)] += result.getString(3) + "\t";
                students[result.getInt(13)] += result.getString(4) + "\t";
                students[result.getInt(13)] += result.getString(5) + "\t";
                students[result.getInt(13)] += result.getString(6) + "\t";
                students[result.getInt(13)] += result.getString(7) + "\t";
                students[result.getInt(13)] += result.getString(8) + "\t";
                students[result.getInt(13)] += result.getString(9) + "\t";
                students[result.getInt(13)] += result.getString(10) + "\t";
                students[result.getInt(13)] += result.getString(11) + "\t";
                students[result.getInt(13)] += result.getString(12) + "\t";
                students[result.getInt(13)] += Integer.toString(result.getInt(13)) + "\t";
                students[result.getInt(13)] += result.getString(14) + "\t";
                students[result.getInt(13)] += Integer.toString(result.getInt(15));
                */
                students[i] = "";
                students[i] += result.getString(1) + "\t";
                students[i] += result.getString(2) + "\t";
                students[i] += result.getString(3) + "\t";
                students[i] += result.getString(4) + "\t";
                students[i] += result.getString(5) + "\t";
                students[i] += result.getString(6) + "\t";
                students[i] += result.getString(7) + "\t";
                students[i] += result.getString(8) + "\t";
                students[i] += result.getString(9) + "\t";
                //students[i] += result.getString(10) + "\t";
                //students[i] += result.getString(11) + "\t";
                //students[i] += result.getString(12) + "\t";
                students[i] += Integer.toString(result.getInt(10)) + "\t";
                students[i] += result.getString(11) + "\t";
                students[i] += Integer.toString(result.getInt(12)) + "\t";
                students[i] += result.getString(13);
                i++;
            }
        } catch(SQLException SQLe) {
            System.out.println(SQLe);
            SQLe.printStackTrace();
        }

        //Return the array containing the information
        return students;
    }

    /**
     * Adds an infraction into the infractions table.
     *
     * @param pid the pid
     * @param no the no
     * @param info the info
     * @param desc the desc
     * @return -True if entered, false otherwise
     */
    public boolean addInfraction(String pid, int no, String info, int desc) {
        sqlText = "insert into infractions values ('" + pid + "','" + no + "','" + info + "','" + desc + "');";
        return DBConnect.updateTable(sqlText);
    }

    /**
     * Adds a person into the people's table.
     *
     * @param pid the pid
     * @param fname the fname
     * @param lname the lname
     * @param grdnOne the grdn one
     * @param grdnTwo the grdn two
     * @param stAddress the st address
     * @param email the email
     * @param allergy the allergy
     * @param phone the phone
     * @param stSeat the st seat
     * @param pass the pass
     * @param userLevel the user level
     * @param url the url
     * @return true, if successful
     * @return- True if data is entered, false otherwise
     */
    public boolean addPerson(String pid, String fname, String lname, String grdnOne, String grdnTwo, String stAddress, String email, String allergy, String phone, int stSeat, String pass, int userLevel, String url) {
        sqlText = "insert into people values ('" + pid + "','" + fname + "','" + lname + "','" + grdnOne + "','" + grdnTwo + "','" + stAddress + "','" + email + "','" + allergy + "','" + phone + "','" + stSeat + "','" + pass + "','" + userLevel + "','" + url + "');";
        return DBConnect.updateTable(sqlText);
    }

    /**
     * Records the attendance of the students.
     *
     * @param sid the sid
     * @param there the there
     * @return - True if recorded, false otherwise
     */
    public boolean recordAttendance(String sid, boolean there) {
        //delete attendace for the current date if it exists
        sqlText = "delete from attendance * where at_datetime=current_date and at_sid='" + sid + "'";
        DBConnect.updateTable(sqlText);
        //insert new attendance.
        sqlText = "insert into attendance values ('" + sid + "',current_date,'" + there + "');";
        return DBConnect.updateTable(sqlText);
    }

    /**
     * Gets the attendance for student.
     *
     * @param sid the sid
     * @param date the date
     * @return the attendance for student
     */
    public boolean getAttendanceForStudent(String sid, String date) {
        sqlText = "select at_present from attendance where at_sid='" + sid + "' and at_datetime='" + date + "';";
        result = DBConnect.select(sqlText);
        boolean retval = true;
        
        //Get the students attendance
        try {
            while(result.next()) {
                retval = result.getBoolean(3);
            }
        } catch(SQLException SQLe) {
            System.out.println(SQLe);
            SQLe.printStackTrace();
        }

        return retval;
    }

    /**
     * Get the information of a student.
     *
     * @param fname the fname
     * @param lname the lname
     * @return - The information of the student
     */
    public String getStudent(String fname, String lname) {
        String student = "";
        sqlText = "select * from people where pl_fname='" + fname + "' or pl_lname='" + lname + "'";
        result = DBConnect.select(sqlText);

        //Get information with a student by the certain name
        try {
            while(result.next()) {
                student += result.getString(1) + "\t";
                student += result.getString(2) + "\t";
                student += result.getString(3) + "\t";
                student += result.getString(4) + "\t";
                student += result.getString(5) + "\t";
                student += result.getString(6) + "\t";
                student += result.getString(7) + "\t";
                student += result.getString(8) + "\t";
                student += result.getString(9) + "\t";
                //student += result.getString(10) + "\t";
                //student += result.getString(11) + "\t";
                //student += result.getString(12) + "\t";
                student += Integer.toString(result.getInt(10)) + "\t";
                student += result.getString(11) + "\t";
                student += Integer.toString(result.getInt(12)) + "\t";
                student += result.getString(13);
            }
        } catch(SQLException SQLe) {
            System.out.println(SQLe);
            SQLe.printStackTrace();
        }

        //Return the information
        return student;
    }

    /**
     * Get a grade.
     *
     * @param pid the pid
     * @return - The information of the pid
     */
    public String getGrade(String pid) {
        sqlText = "select * from  grades where gr_sid='" + pid + "'";
        result = DBConnect.select(sqlText);
        String student = "";

        //Get information on the student
        try {
            while(result.next()) {
                student += result.getString(1) + "\t";
                student += result.getString(2) + "\t";
                student += result.getString(3) + "\t";
                student += result.getString(4) + "\n";
            }
        } catch(SQLException SQLe) {
            System.out.println(SQLe);
            SQLe.printStackTrace();
        }

        return student;
    }

    /**
     * Gets an infraction.
     *
     * @param no the no
     * @return - The information of the infraction
     */
    public String getInfraction(int no) {
        String infraction = "";
        sqlText = "select * from infractions where int_no='" + no + "'";
        result = DBConnect.select(sqlText);

        //Get information about the infraction
        try {
            while(result.next()) {
                infraction += result.getString(1) + "\t";
                infraction += result.getString(2) + "\t";
                infraction += result.getString(3) + "\t";
                infraction += result.getString(4) + "\n";
            }
        } catch(SQLException SQLe) {
            System.out.println(SQLe);
            SQLe.printStackTrace();
        }

        return infraction;
    }

    /**
     * Get information about the date in a calender.
     *
     * @param date the date
     * @return - The information about a particular date
     */
    public String[] getCalender(String date) {
        sqlText = "select count(*) from calendar where c_date='" + date + "'";
        result = DBConnect.select(sqlText);
        int size = 0;

        try {
            while(result.next()) {
                size = result.getInt(1);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        String[] calendar = new String[size];
        sqlText = "select * from calendar where c_date='" + date + "'";
        result = DBConnect.select(sqlText);

        //Get info
        try {
            int index = 0;

            while(result.next()) {
                calendar[index] = "";
                calendar[index] += result.getString(1) + "\t";
                calendar[index] += result.getInt(2) + "\t";
                calendar[index] += result.getString(3);
                index++;
            }
        } catch(SQLException SQLe) {
            System.out.println(SQLe);
            SQLe.printStackTrace();
        }

        return calendar;
    }

    /**
     * Adds an infraction for a student.
     *
     * @param pid the pid
     * @param date the date
     * @param info the info
     * @param desc the desc
     * @return True if the infraction added, false otherwise
     */
    public boolean addInfraction(String pid, String date, String info, String desc) {
        sqlText = "insert into infractions values ('" + pid + "','" + date + "','" + info + "','" + desc + "');";
        return DBConnect.updateTable(sqlText);
    }

    /**
     * Adds a grade to the grades table.
     *
     * @param pid the pid
     * @param ClassName the class name
     * @param Assignment the assignment
     * @param grade the grade
     * @return - True if entered correctly, false otherwise
     */
    public boolean addGrade(String pid, String ClassName, String Assignment, String grade) {
        sqlText = "insert into grades values ('" + Assignment + "','" + pid + "','" + ClassName + "','" + grade + "');";
        return DBConnect.updateTable(sqlText);
    }

    /**
     * Adds an assignment to the assign table.
     *
     * @param ClassName the class name
     * @param Assignment the assignment
     * @param date the date
     * @param due the due
     * @return - True if entered correctly, false otherwise
     */
    public boolean addAssignment(String ClassName, String Assignment, String date, String due) {
        sqlText = "insert into assign values ('" + ClassName + "','" + Assignment + "','" + date + "','" + due + "');"; //Create neccessary insert statment
        return DBConnect.updateTable(sqlText); //Return whether it was entered correctly or not
    }

    /**
     * Inserts an item into the calender.
     *
     * @param date the date
     * @param text the text
     * @return - True if entered correctly, false otherwise
     */
    public boolean insertItemIntoCalender(String date, String text) {
        sqlText = "insert into calendar value ('" + date + "','" + text + "');";
        return DBConnect.updateTable(sqlText);
    }

    /**
     * Update seat.
     *
     * @param sid the sid
     * @param seat the seat
     * @return true, if successful
     */
    public boolean updateSeat(String sid, int seat) {
        sqlText = "update people set pl_desk=" + seat + "where pl_pid='" + sid + "'";
        return DBConnect.updateTable(sqlText);
    }

    /**
     * Update the due date of an assignment.
     *
     * @param Class the class
     * @param assignment the assignment
     * @param start the start
     * @param due the due
     * @return true, if successful
     */
    public boolean updateAssignment(String Class, String assignment, String start, String due) {
        String sqlText = "update assign set as_due='" + due + "' where as_class='" + Class + "' and as_assignment='" + assignment + "';";
        return DBConnect.updateTable(sqlText);
    }

    /**
     * Deletes an assignment.
     *
     * @param Class the class
     * @param assignment the assignment
     * @return - True if successful, false otherwise
     */
    public boolean deleteAssignment(String Class, String assignment) {
        sqlText = "delete from assign where as_assignment='" + assignment + "'";
        return DBConnect.updateTable(sqlText);
    }

    /**
     * Updates the grade of a particular assignment,  takes in the student, class, and assignment
     * and updates the mark.
     *
     * @param assignment the assignment
     * @param sid the sid
     * @param Class the class
     * @param mark the mark
     * @return - True if successful, false otherwise
     */
    public boolean updateGrade(String assignment, String sid, String Class, String mark) {
        sqlText = "update grades set gr_mark='" + mark + "' where gr_assignment='"
                  + assignment + "' and gr_sid='" + sid + "' and gr_class='" + Class + "'";
        return DBConnect.updateTable(sqlText);
    }

    /**
     * Deletes the particular grade from the person, class, and assignment.
     *
     * @param assignment the assignment
     * @param sid the sid
     * @param Class the class
     * @return true, if successful
     */
    public boolean deleteGrade(String assignment, String sid, String Class) {
        sqlText = "delete from grades where gr_assignment='" + assignment + "' and gr_side='"
                  + sid + "' and gr_class='" + Class + "'";
        return DBConnect.updateTable(sqlText);
    }

    /**
     * Update infraction.
     *
     * @param sid the sid
     * @param datetime the datetime
     * @param type the type
     * @param description the description
     * @return true, if successful
     */
    public boolean updateInfraction(String sid, String datetime, String type, String description) {
        deleteInfraction(sid, datetime);
        return AddInfraction(sid, datetime, type, description);
    }

    /**
     * Delete an infraction of a person and datetime.
     *
     * @param sid the sid
     * @param datetime the datetime
     * @return true, if successful
     */
    public boolean deleteInfraction(String sid, String datetime) {
        sqlText = "delete from infractions where in_sid='" + sid + "' and in_datetime='" + datetime + "';";
        return DBConnect.updateTable(sqlText);
    }

    /**
     * Updates the person in the database, it deletes the person with the particular pid
     * and then re-enters them into the database.
     *
     * @param pid the pid
     * @param fname the fname
     * @param lname the lname
     * @param grdnOne the grdn one
     * @param grdnTwo the grdn two
     * @param stAddress the st address
     * @param email the email
     * @param allergy the allergy
     * @param phone the phone
     * @param pass the pass
     * @param url the url
     * @return true, if successful
     */
    public boolean updatePerson(String pid, String fname, String lname, String grdnOne, String grdnTwo, String stAddress, String email, String allergy, String phone, String pass, String url) {
        sqlText = "update people set pl_gaurdian1='" + grdnOne + "',pl_gaurdian2='" + grdnTwo + "',pl_address='" + stAddress + "',pl_email='" + email + "',pl_allergy='" + allergy + "',pl_phone='" + phone + "',pl_pass='" + pass + "', pl_img_url='" + url
                  + "' where pl_pid='" + pid + "';";
        //Attempt to delete the person, if successful try to add the person
        return DBConnect.updateTable(sqlText);
    }

    /**
     * Updates the attendance.  It first deletes the attendance and then creates a new
     * entry of the attendance.
     *
     * @param sid the sid
     * @param datetime the datetime
     * @param present the present
     * @return true, if successful
     */
    public boolean updateAttendance(String sid, String datetime, boolean present) {
        sqlText = "delete from attendance * where date=now()";

        if(DBConnect.updateTable(sqlText) == false) {
            return false;
        } else {
            sqlText = "insert into attendance values ('" + sid + "','" + datetime + "','" + present + "');";
            return DBConnect.updateTable(sqlText);
        }
    }

    /**
     * Updates a calender items.  Sets the info to be the new info of a particular day
     *
     * @param date the date
     * @param time the time
     * @param info the info
     * @return true, if successful
     */
    public boolean updateCalenderItem(String date, int time, String info) {
        sqlText = "delete from calendar * where c_date='" + date + "' and c_hour=" + time;
        DBConnect.updateTable(sqlText);
        sqlText = "insert into calendar values('" + date + "', " + time + ",'" + info + "');";
        return DBConnect.updateTable(sqlText);
    }

    /**
     * Deletes the calender item based on the datetime.
     *
     * @param datetime the datetime
     * @return true, if successful
     */
    public boolean deleteCalenderItem(String datetime) {
        sqlText = "delete from calendar * where c_datetime='" + datetime + "';";
        return DBConnect.updateTable(sqlText);
    }

    /**
     * Delete person.
     *
     * @param pid the pid
     * @return true, if successful
     */
    public boolean deletePerson(String pid) {
    	sqlText = "delete from attendance * where at_sid='" + pid + "';";
    	DBConnect.updateTable(sqlText);
    	sqlText = "delete from infractions * where in_sid='" + pid + "';";
    	DBConnect.updateTable(sqlText);
    	sqlText = "delete from grades * where gr_sid='" + pid + "';";
    	DBConnect.updateTable(sqlText);
        sqlText = "delete from people * where pl_pid='" + pid + "';";
        return DBConnect.updateTable(sqlText);
    }

    /**
     * Gets the options.
     *
     * @return the options
     */
    public int[] getOptions() {
        sqlText = "select * from options;";
        result = DBConnect.select(sqlText);
        int[] options = new int[2];

        try {
            while(result.next()) {
                options[0] = result.getInt(1);
                options[1] = result.getInt(2);
            }
        } catch(SQLException SQLe) {
            System.out.println(SQLe);
            SQLe.printStackTrace();
        }

        return options;
    }

    /**
     * Save options.
     *
     * @param rows the rows
     * @param cols the cols
     */
    public void saveOptions(int rows, int cols) {
        sqlText = "delete from options *;";
        DBConnect.updateTable(sqlText);
        sqlText = "insert into options values(" + rows + "," + cols + ");";
        DBConnect.updateTable(sqlText);
    }

    /**
     * People exist.
     *
     * @return true, if successful
     */
    public static boolean peopleExist() {
        sqlText = "select count(*) from people";
        result = DBConnect.select(sqlText);
        int numPeople = 0;

        //See if someone exists
        try {
            result.next();
            numPeople = result.getInt(1);
        } catch(SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //Returns false if the database is empty eg. no one exists
        if(numPeople == 0)
            return false;
        //Otherwise return true
        return true;
    }
    
    /**
     * Main method, used to test the above methods
     * 
     * @param args
     */
    public static void main(String[] args){
    	
    	DBAccessor dba = new DBAccessor();
    	String sres[] = new String[1000];
    	
    	
    	if(dba.AddAssignment("CMPT","1","January 1,2012","January 2,2012")==false){System.out.println("Error adding assingment");}
    		else System.out.println("AddAssignment testing successful");
    	if(dba.AddGrade("1", "CMPT","1", "1")==false){System.out.println("Error adding grade");}
    		else System.out.println("AddGrade testing successful");
    	if(dba.AddInfraction("1","January 1,2012","Bad","Bad")==false){System.out.println("Error adding infraction");}
    		else System.out.println("AddInfractiont testing successful");
    	if(dba.AddPerson("1","1","1","1", "1","1","1","1","1",1,"1",1,"1")==false){System.out.println("Error adding a person");}
    		else System.out.println("AddPerson testing successful");
    	if(dba.InsertItemIntoCalender("January 1,2012","1")==false){System.out.println("Error entering into calender");}
    		else System.out.println("InsertItemIntoCalendar testing successful");
    		
    	
    	if(peopleExist()==false){System.out.println("Error in peopleExist");}
    		else System.out.println("peopleExist testing successful");
    	
    	sres=StartUp();
    	if(sres==null){System.out.println("Error in StartUp");}
    		else System.out.println("StartUp() testing successful");
    	
    	sres=dba.getAllAssignments();
    	if(sres==null){System.out.println("Error in getAllAssignments");}
			else System.out.println("getAllAssignments() testing successful");
    	
    	sres=dba.getAllCalenderEvents();
    	if(sres==null){System.out.println("Error in getAllCalenderEvents");}
			else System.out.println("getAllCalenderEvents() testing successful");
    	
    	sres=dba.getAllAssignments();
    	if(sres==null){System.out.println("Error in StartUp");}
			else System.out.println("getAllAssignments() testing successful");
    	
    	if(dba.updateAssignment("CMPT","1","January 1,2012", "January 2,2012")==false){System.out.println("Error updating assignment");}
    		else System.out.println("updateAssignment testing successful");
    	if(dba.updateGrade("1","1","CMPT","1")==false){System.out.println("Error updating grade");}
    		else System.out.println("updateGrade testing successful");
    	if(dba.updateInfraction("1","January 1,2012","Bad","Bad")==false){System.out.println("Error updating infraction");}
    		else System.out.println("updateInfraction testing successful");
    	if(dba.updatePerson("1","1","1","1", "1","1","1","1","1","1","1")==false){System.out.println("Error updating person");}   	
    		else System.out.println("updatePerson testing successful");
    	
    	
    	if(dba.deleteAssignment("CMPT","1")==false){System.out.println("Error deleting assignment.");}
    		else System.out.println("deleteAssignment testing successful");
    	if(dba.deleteCalenderItem("January 1,2012")==false){System.out.println("Error deleting calender item");}
    		else System.out.println("deleteCalenderItem testing successful");
    	if(dba.deleteGrade("1","1", "CMPT")==false){System.out.println("Error deleting grade.");}	
    		else System.out.println("deleteGrade testing successful");
    	if(dba.deleteInfraction("1","January 1,2012")==false){System.out.println("Error deleting infraction");}
    		else System.out.println("deleteInfraction testing successful");
    	if(dba.deletePerson("1")==false){System.out.println("Error deleting person");}
    		else System.out.println("deletePerson testing successful");
  	
    	
    	
    }

}
