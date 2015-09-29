/*
 * The Constructors
 * SchoolMarm
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Database.DBAccessor;
import model.Student;
import view.MainFrame;
import view.TeacherGradesView;

/**
 * The listener interface for receiving studentGradesDoneButton events.
 * The class that is interested in processing a studentGradesDoneButton
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addStudentGradesDoneButtonListener<code> method. When
 * the studentGradesDoneButton event occurs, that object's appropriate
 * method is invoked.
 *
 */
public class StudentGradesDoneButtonListener implements ActionListener {

    /** The frame. */
    private MainFrame frame;

    /** The parent. */
    private TeacherGradesView parent;

    /** The student. */
    private Student student;

    /**
     * Instantiates a new student grades done button listener.
     *
     * @param frame the frame
     * @param parent the parent
     * @param student the student
     */
    public StudentGradesDoneButtonListener(MainFrame frame, TeacherGradesView parent, Student student) {
        this.frame = frame;
        this.parent = parent;
        this.student = student;
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent arg0) {
        DBAccessor accessor = new DBAccessor();

        for(int i = 0; i < student.getNumGrades(); i++) {
            if(accessor.updateGrade(parent.getAssignment(i), student.getID(), "Class", parent.getGrade(i)))
                student.addGradeForAssignment(parent.getGrade(i), parent.getAssignment(i));
        }

        frame.showUserView(MainFrame.STUDENT_VIEW, student, null);
    }

}
