/*
 * The Constructors
 * SchoolMarm
 */
package model;

import java.util.Date;

/**
 * The Class Assignment.
 *
 */
public class Assignment {

    /** The assignment name. */
    private String assignmentName;

    /** The assigned date. */
    private String assignedDate;

    /** The due date. */
    private String dueDate;

    /**
     * Instantiates a new assignment.
     *
     * @param name the name
     */
    public Assignment(String name) {
        this.assignmentName = name;
        this.assignedDate = new Date().toString();
        this.dueDate = null;
    }

    /**
     * Instantiates a new assignment.
     *
     * @param name the name
     * @param dueDate the due date
     */
    public Assignment(String name, Date dueDate) {
        this.assignmentName = name;
        this.assignedDate = new Date().toString();
        this.dueDate = dueDate.toString();
    }

    /**
     * Instantiates a new assignment.
     *
     * @param name the name
     * @param assigned the assigned
     * @param due the due
     */
    public Assignment(String name, Date assigned, Date due) {
        this.assignmentName = name;
        this.assignedDate = assigned.toString();
        this.dueDate = due.toString();
    }

    /**
     * Instantiates a new assignment.
     *
     * @param name the name
     * @param dueDate the due date
     */
    public Assignment(String name, String dueDate) {
        this.assignmentName = name;
        this.assignedDate = new Date().toString();
        this.dueDate = dueDate.toString();
    }

    /**
     * Instantiates a new assignment.
     *
     * @param name the name
     * @param assigned the assigned
     * @param due the due
     */
    public Assignment(String name, String assigned, String due) {
        this.assignmentName = name;
        this.assignedDate = assigned;
        this.dueDate = due;
    }

    /**
     * Gets the due date.
     *
     * @return the due date
     */
    public String getDueDate() {
        return dueDate.toString();
    }

    /**
     * Gets the assigned date.
     *
     * @return the assigned date
     */
    public String getAssignedDate() {
        return assignedDate.toString();
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return assignmentName;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.assignmentName = name;
    }

    /**
     * Sets the due.
     *
     * @param due the new due
     */
    public void setDue(String due) {
        this.dueDate = due;
    }

    /**
     * Sets the start.
     *
     * @param start the new start
     */
    public void setStart(String start) {
        this.assignedDate = start;
    }
}
