/*
 * The Constructors
 * SchoolMarm
 */
package model;

/**
 * The Class Grade.
 *
 */
public class Grade {

    /** The grade. */
    private String grade;

    /** The assignment. */
    private Assignment assignment;

    /**
     * Instantiates a new grade.
     *
     * @param grade the grade
     * @param assignment the assignment
     */
    public Grade(String grade, Assignment assignment) {
        this.assignment = assignment;
        this.grade = grade;
    }

    /**
     * Instantiates a new grade.
     *
     * @param assignment the assignment
     */
    public Grade(Assignment assignment) {
        this.assignment = assignment;
        this.grade = "0";
    }

    /**
     * Gets the grade.
     *
     * @return a grade
     */
    public String getGrade() {
        return grade;
    }

    /**
     * Sets the grade.
     *
     * @param newGrade change the grade if marking got wrong
     */
    public void setGrade(String newGrade) {
        grade = newGrade;
    }

    /**
     * Gets the assignment.
     *
     * @return the assignment
     */
    public Assignment getAssignment() {
        return assignment;
    }
}
