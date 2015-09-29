/*
 * The Constructors
 * SchoolMarm
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Assignment;
import view.AddAssignmentView;
import view.MainFrame;
import Database.DBAccessor;

/**
 * The listener interface for receiving editAssignDone events.
 * The class that is interested in processing a editAssignDone
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addEditAssignDoneListener<code> method. When
 * the editAssignDone event occurs, that object's appropriate
 * method is invoked.
 *
 */
public class EditAssignDoneListener implements ActionListener {

    /** The frame. */
    private MainFrame frame;

    /** The parent. */
    private AddAssignmentView parent;

    /** The old assignment. */
    private Assignment oldAssignment;

    /**
     * Instantiates a new edits the assign done listener.
     *
     * @param frame the frame
     * @param parent the parent
     * @param oldAssignment the old assignment
     */
    public EditAssignDoneListener(MainFrame frame, AddAssignmentView parent, Assignment oldAssignment) {
        this.frame = frame;
        this.parent = parent;
        this.oldAssignment = oldAssignment;
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        int index = SchoolMarm.assignments.indexOf(oldAssignment);
        DBAccessor accessor = new DBAccessor();

        if(accessor.updateAssignment("Class", parent.getName(), parent.getStartDate(), parent.getDueDate()))
            SchoolMarm.assignments.get(index).setDue(parent.getDueDate());

        frame.showUserView(MainFrame.ASSIGNMENT_VIEW, null, null);
    }

}
