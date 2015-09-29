/*
 * The Constructors
 * SchoolMarm
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.MainFrame;
import model.Student;

/**
 * The listener interface for receiving studentGrades events.
 * The class that is interested in processing a studentGrades
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addStudentGradesListener<code> method. When
 * the studentGrades event occurs, that object's appropriate
 * method is invoked.
 *
 */
public class StudentGradesListener implements ActionListener {

    /** The frame. */
    private MainFrame frame;

    /** The student. */
    private Student student;

    /**
     * Instantiates a new student grades listener.
     *
     * @param student the student
     * @param frame the frame
     */
    public StudentGradesListener(Student student, MainFrame frame) {
        this.student = student;
        this.frame = frame;
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(MainFrame.user.getUserLevel()) {
            case Login.STUDENT:
                frame.showUserView(MainFrame.STUDENT_GRADES_VIEW, student, null);
                break;

            case Login.TEACHER:
                frame.showUserView(MainFrame.TEACHER_GRADES_VIEW, student, null);
                break;

            case Login.PRINCIPAL:
                frame.showUserView(MainFrame.TEACHER_GRADES_VIEW, student, null);
                break;
        }
    }

}
