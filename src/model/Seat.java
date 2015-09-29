/*
 * The Constructors
 * SchoolMarm
 */
package model;

import javax.swing.JButton;

import controller.SchoolMarm;

/**
 * The Class Seat.
 *
 */
public class Seat extends JButton {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The student. */
    private Student student;

    /** The seat num. */
    private int seatNum;

    /**
     * Instantiates a new seat.
     *
     * @param seatNum the seat num
     */
    public Seat(int seatNum) {
        student = null;
        this.seatNum = seatNum;
        this.setIcon(null);
    }

    /* the following to be implemented properly later
     * Will need a class StudentIcon and a field within
     * the Student object, getImageURL.
     *
     * This should be implemented by Zinchao mainly.
     * imageURL should be stored in database.
     */

    /**
     * Instantiates a new seat.
     *
     * @param student the student
     * @param seatNum the seat num
     */
    public Seat(Student student, int seatNum) {
        this.student = student;
        this.seatNum = seatNum;
        this.setIcon(new StudentIcon(student.getImgURL()));
    }

    /**
     * Gets the student.
     *
     * @return the student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Removes the student.
     */
    public void removeStudent() {
        this.student = null;
        this.setIcon(null);
    }

    /**
     * Assign.
     *
     * @param student the student
     */
    public void assign(Student student) {
        if(student.getSeat() >= 0) {
            SchoolMarm.seats.get(student.getSeat()).removeStudent();
        }

        student.setSeat(seatNum);
        this.student = student;
        this.setIcon(new StudentIcon(student.getImgURL()));
    }

    /**
     * Gets the seat num.
     *
     * @return the seat num
     */
    public int getSeatNum() {
        return seatNum;
    }
}
