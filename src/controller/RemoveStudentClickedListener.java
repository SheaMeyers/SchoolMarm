/*
 * The Constructors
 * SchoolMarm
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Student;

import Database.DBAccessor;

import view.MainFrame;
import view.RemoveStudentView;

/**
 * The listener interface for receiving removeStudentClicked events.
 * The class that is interested in processing a removeStudentClicked
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addRemoveStudentClickedListener<code> method. When
 * the removeStudentClicked event occurs, that object's appropriate
 * method is invoked.
 *
 */
public class RemoveStudentClickedListener implements ActionListener {

    /** The frame. */
    private MainFrame frame;

    /** The parent. */
    private RemoveStudentView parent;

    /**
     * Instantiates a new removes the student clicked listener.
     *
     * @param frame the frame
     * @param parent the parent
     */
    public RemoveStudentClickedListener(MainFrame frame, RemoveStudentView parent) {
        this.frame = frame;
        this.parent = parent;
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Student student = parent.getSelectedStudent();
        DBAccessor accessor = new DBAccessor();

        if(accessor.deletePerson(student.getID())){
            SchoolMarm.seats.get(student.getSeat()).removeStudent();
        	SchoolMarm.students.remove(student); 
        }
        frame.setVisible(false);
    }

}
