/*
 * The Constructors
 * SchoolMarm
 */
package model;

import java.util.ArrayList;
import controller.Login;

/**
 * The Class Student.
 *
 */
public class Student extends Person {

    /** The attendance. */
    private boolean attendance;

    /** The guardian1. */
    private String guardian1;

    /** The guardian2. */
    private String guardian2;

    /** The allergy. */
    private String allergy;

    /** The seat. */
    private int seat;

    /** The img url. */
    private String imgURL;

    /** The grades. */
    private ArrayList<Grade> grades;

    /** The infractions. */
    private ArrayList<Infraction> infractions;

    /**
     * Instantiates a new student.
     *
     * @param FirstName the first name
     * @param MiddleName the middle name
     * @param LastName the last name
     * @param id the id
     * @param address the address
     * @param email the email
     * @param telephoneNumber the telephone number
     * @param pass the pass
     * @param guardian1 the guardian1
     * @param guardian2 the guardian2
     * @param allergy the allergy
     * @param seat the seat
     * @param imgURL the img url
     */
    public Student(String FirstName, String LastName, String id, String address, String email, String telephoneNumber,
                   char[] pass, String guardian1, String guardian2, String allergy, int seat, String imgURL) {
        super(FirstName, LastName, id, address, email, telephoneNumber, pass);
        this.attendance = true;
        this.guardian1 = guardian1;
        this.guardian2 = guardian2;
        this.allergy = allergy;
        this.seat = seat;
        this.grades = new ArrayList<Grade>();
        this.infractions = new ArrayList<Infraction>();

        if(imgURL == null)
            this.imgURL = "generic-face.png";
        else
            this.imgURL = imgURL;
    }

    /**
     * Instantiates a new student.
     *
     * @param FirstName the first name
     * @param MiddleName the middle name
     * @param LastName the last name
     * @param id the id
     * @param address the address
     * @param email the email
     * @param telephoneNumber the telephone number
     * @param pass the pass
     * @param guardian1 the guardian1
     * @param guardian2 the guardian2
     * @param allergy the allergy
     * @param imgURL the img url
     */
    public Student(String FirstName, String LastName, String id, String address, String email, String telephoneNumber,
                   char[] pass, String guardian1, String guardian2, String allergy, String imgURL) {
        super(FirstName, LastName, id, address, email, telephoneNumber, pass);
        this.attendance = true;
        this.guardian1 = guardian1;
        this.guardian2 = guardian2;
        this.allergy = allergy;
        this.seat = -1;
        this.grades = new ArrayList<Grade>();
        this.infractions = new ArrayList<Infraction>();

        if(imgURL == null)
            this.imgURL = "generic-face.png";
        else
            this.imgURL = imgURL;
    }

    /* (non-Javadoc)
     * @see model.Person#getUserLevel()
     */
    @Override
    public int getUserLevel() {
        return Login.STUDENT;
    }

    /**
     * Gets the attendance.
     *
     * @return the attendance
     */
    public boolean getAttendance() {
        return attendance;
    }

    /**
     * Update student.
     *
     * @param address the address
     * @param email the email
     * @param telephoneNumber the telephone number
     * @param pass the pass
     * @param guardian1 the guardian1
     * @param guardian2 the guardian2
     * @param allergy the allergy
     * @param imgURL the img url
     */
    public void updateStudent(String address, String email, String telephoneNumber,
                              char[] pass, String guardian1, String guardian2, String allergy, String imgURL) {
        this.address = address;
        this.email = email;
        this.phoneNumber = telephoneNumber;
        this.pass = pass;
        this.guardian1 = guardian1;
        this.guardian2 = guardian2;
        this.allergy = allergy;
        this.imgURL = imgURL;
    }

    /**
     * Sets the attendance.
     *
     * @param attendance the new attendance
     */
    public void setAttendance(boolean attendance) {
        this.attendance = attendance;
    }

    /**
     * Gets the guardian1.
     *
     * @return the guardian1
     */
    public String getGuardian1() {
        return guardian1;
    }

    /**
     * Gets the guardian2.
     *
     * @return the guardian2
     */
    public String getGuardian2() {
        return guardian2;
    }

    /**
     * Gets the allergy.
     *
     * @return the allergy
     */
    public String getAllergy() {
        return allergy;
    }

    /**
     * Gets the seat.
     *
     * @return the seat
     */
    public int getSeat() {
        return seat;
    }

    /**
     * Sets the guardian1.
     *
     * @param newGuardian1 the new guardian1
     */
    public void setGuardian1(String newGuardian1) {
        guardian1 = newGuardian1;
    }

    /**
     * Sets the guardian2.
     *
     * @param newGuardian2 the new guardian2
     */
    public void setGuardian2(String newGuardian2) {
        guardian2 = newGuardian2;
    }

    /**
     * Sets the allergy.
     *
     * @param newAllergy the new allergy
     */
    public void setAllergy(String newAllergy) {
        allergy = newAllergy;
    }

    /**
     * Sets the seat.
     *
     * @param newSeat the new seat
     */
    public void setSeat(int newSeat) {
        seat = newSeat;
    }

    /**
     * Adds the grade for assignment.
     *
     * @param grade the grade
     * @param assignment the assignment
     */
    public void addGradeForAssignment(String grade, String assignment) {
        for(int i = 0; i < grades.size(); i++) {
            //if the assignment already exists, update the grade
            if(grades.get(i).getAssignment().getName().equals(assignment)) {
                grades.get(i).setGrade(grade);
                return;
            }
        }

        grades.add(new Grade(grade, new Assignment(assignment)));
    }

    /**
     * Adds the new grade.
     *
     * @param assignment the assignment
     */
    public void addNewGrade(Assignment assignment) {
        grades.add(new Grade(assignment));
    }

    /**
     * Gets the grade for assignment.
     *
     * @param assignment the assignment
     * @return the grade for assignment
     */
    public Grade getGradeForAssignment(Assignment assignment) {
        for(int i = 0; i < grades.size(); i++) {
            if(grades.get(i).getAssignment().getName().equals(assignment.getName()))
                return grades.get(i);
        }

        System.out.println("Error");
        return null;
    }

    /**
     * Gets the infraction.
     *
     * @param infNum the inf num
     * @return the infraction
     */
    public Infraction getInfraction(int infNum) {
        return infractions.get(infNum);
    }

    /**
     * Adds the infraction.
     *
     * @param inf the inf
     */
    public void addInfraction(Infraction inf) {
        infractions.add(inf);
    }

    /**
     * Gets the grade.
     *
     * @param i the i
     * @return the grade
     */
    public Grade getGrade(int i) {
        return grades.get(i);
    }

    /**
     * Gets the num grades.
     *
     * @return the num grades
     */
    public int getNumGrades() {
        return grades.size();
    }

    /**
     * Gets the num infractions.
     *
     * @return the num infractions
     */
    public int getNumInfractions() {
        return infractions.size();
    }

    /**
     * Gets the img url.
     *
     * @return the img url
     */
    public String getImgURL() {
        return imgURL;
    }

    /* (non-Javadoc)
     * @see model.Person#toString()
     */
    @Override
    public String toString() {
        return "\nName: " + fullName() + "\nID: " + getID() + "\nGuardian 1: " + guardian1 + "\nGuardian2: " + guardian2 + "\nAddress: " + address
               + "\nE-mail: " + email + "\nAllergy: " + allergy + "\nPhone Number: " + phoneNumber
               + "\nNumber of seat: " + seat + "\n";
    }

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        Student student = new Student("Billy", "Smith", "bjs123", "Some Address", "bjs@hotmail.com", "123-456-7890", new char[] {'p', 'a', 's'}, "Mrs. Smith", "Mr. Smith", "None", 5, null);
        student.addGradeForAssignment("50", "Assignment 1");
        Assignment assignment1 = new Assignment("Assignment 1");
        System.out.println("Number of grades: " + student.getNumGrades());
        System.out.println(student.getGradeForAssignment(assignment1).getGrade());
        student.addGradeForAssignment("75", "Assignment 1");
        System.out.println("Number of grades: " + student.getNumGrades());
        System.out.println(student.getGradeForAssignment(assignment1).getGrade());
        student.addNewGrade(new Assignment("Assignment 2"));
        System.out.println("Number of grades: " + student.getNumGrades());
        System.out.println(student.getGradeForAssignment(new Assignment("Assignment 2")).getGrade());
    }
}