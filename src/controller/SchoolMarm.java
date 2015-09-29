/*
 * The Constructors
 * SchoolMarm
 */
package controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

import Database.DBAccessor;
import Database.DBInfo;

import model.Assignment;
import model.Infraction;
import model.Seat;
import model.Student;
import view.MainFrame;

/**
 * The Class SchoolMarm.
 *
 */
public class SchoolMarm {

    //this will be the student array accessed by almost every piece of the UI
    //it should be populated at startup.
    /** The students. */
    public static ArrayList<Student> students;

    /** The seats. */
    public static ArrayList<Seat> seats;

    /** The seat listeners. */
    public static ArrayList<SeatListener> seatListeners;

    /** The Assignments. */
    //public static ArrayList<String> assignments;
    public static ArrayList<Assignment> assignments;

    /** The rows. */
    public static int rows;

    /** The cols. */
    public static int cols;

    /** The main. */
    public static MainFrame main;

    /**
     * Run.
     */
    public static void run() {
        main = new MainFrame();
        main.setVisible(true);
    }

    /**
     * Setup.
     */
    public static void setup() {
        DBAccessor accessor = new DBAccessor();
        int[] options = accessor.getOptions();
        rows = options[0];
        cols = options[1];
        //Populate Student ListArray
        String[] studentsInfo = DBAccessor.StartUp();
        StringTokenizer individualInfo;
        char[] passwordString;
        Student newStudent;
        students = new ArrayList<Student>();
        String[] data;

        for(int i = 0; i < studentsInfo.length; i++) {
            individualInfo = new StringTokenizer(studentsInfo[i], "\t");
            int index = 0;
            data = new String[individualInfo.countTokens()];

            while(individualInfo.hasMoreTokens()) {
                data[index] = individualInfo.nextToken();
                index++;
            }
            
            passwordString = data[10].toCharArray();
            //String address = data[5]+" "+data[6]+", "+data[7]+", "+data[8];
            newStudent = new Student(data[1], data[2], data[0],  data[5], data[6], data[8],
                                     passwordString , data[3], data[4], data[7], Integer.parseInt(data[9]), data[12]);
            //now get all the grades from the database, for the student, and populate their "grade" list.
            //should come in the form assignmentName \t studentId \t Class \t grade
            String[] studentGrades = accessor.getStudentGrades(newStudent.getID());

            for(int j = 0; j < studentGrades.length; j++) {
                individualInfo = new StringTokenizer(studentGrades[j], "\t");
                index = 0;
                data = new String[individualInfo.countTokens()];

                //parse out the data from studentGrades to add the grades to the newStudent();
                while(individualInfo.hasMoreTokens()) {
                    data[index] = individualInfo.nextToken();
                    index++;
                }

                newStudent.addGradeForAssignment(data[3], data[0]);
            }

            //now get all the infractions for the student in very much the same was as for Grades.
            //comes in the form: Student id \t date \t title \t description
            String[] studentInfractions = accessor.getStudentInfractions(newStudent.getID());

            for(int j = 0; j < studentInfractions.length; j++) {
                individualInfo = new StringTokenizer(studentInfractions[j], "\t");
                index = 0;
                data = new String[individualInfo.countTokens()];

                //parse out the data from studentInfractions to add the grades to the newStudent();
                while(individualInfo.hasMoreTokens()) {
                    data[index] = individualInfo.nextToken();
                    index++;
                }

                newStudent.addInfraction(new Infraction(data[2], data[3], data[1]));
            }

            //finally get the attendance for today's date for the student.
            Calendar cal = Calendar.getInstance();
            Date today = new Date();
            cal.setTime(today);
            String time = cal.get(Calendar.YEAR) + "/" + cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.DATE);
            newStudent.setAttendance(accessor.getAttendanceForStudent(newStudent.getID(), time));
            students.add(i, newStudent);
        }

        //get all the assignment info from the database;
        assignments = new ArrayList<Assignment>();
        String[] assignmentInfo = accessor.getAllAssignments();

        for(int i = 0; i < assignmentInfo.length; i++) {
            individualInfo = new StringTokenizer(assignmentInfo[i], "\t");
            int index = 0;
            data = new String[individualInfo.countTokens()];

            while(individualInfo.hasMoreTokens()) {
                data[index] = individualInfo.nextToken();
                index++;
            }

            assignments.add(i, new Assignment(data[1], data[2], data[3]));
        }

        seats = new ArrayList<Seat>();
        seatListeners = new ArrayList<SeatListener>();

        if(rows != 0 && cols != 0) {
            //instantiate the seats
            for(int i = 0; i < (rows * cols); i++) {
                seats.add(i, new Seat(i));
                seatListeners.add(i, new SeatListener(seats.get(i)));
                seats.get(i).addActionListener(seatListeners.get(i));
            }

            //now I will populate seats with the students that already have a seat assigned
            for(int i = 0; i < students.size(); i++) {
                if(students.get(i).getSeat() >= 0) {
                    seats.get(students.get(i).getSeat()).assign(students.get(i));
                }
            }
        }

        run();
    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        new DBInfo().setupDB();
    }

}
