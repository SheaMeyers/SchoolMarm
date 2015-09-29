/*
 * The Constructors
 * SchoolMarm
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Database.DBAccessor;
import model.Assignment;
import view.AddAssignmentView;
import view.MainFrame;

/**
 * The listener interface for receiving addAssignmentDoneButton events.
 * The class that is interested in processing a addAssignmentDoneButton
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addAddAssignmentDoneButtonListener<code> method. When
 * the addAssignmentDoneButton event occurs, that object's appropriate
 * method is invoked.
 *
 */
public class AddAssignmentDoneButtonListener implements ActionListener {

    /** The frame. */
    private MainFrame frame;

    /** The parent. */
    private AddAssignmentView parent;

    /**
     * Instantiates a new adds the assignment done button listener.
     *
     * @param frame the frame
     * @param parent the parent
     */
    public AddAssignmentDoneButtonListener(MainFrame frame, AddAssignmentView parent) {
        this.frame = frame;
        this.parent = parent;
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Assignment assignment = new Assignment(parent.getName(), parent.getStartDate(), parent.getDueDate());
        DBAccessor accessor = new DBAccessor();

        if(accessor.AddAssignment("Class", parent.getName(), parent.getStartDate(), parent.getDueDate()))
            SchoolMarm.assignments.add(assignment);

        for(int i = 0; i < SchoolMarm.students.size(); i++) {
            if(accessor.AddGrade(SchoolMarm.students.get(i).getID(), "Class", parent.getName(), "0"))
                SchoolMarm.students.get(i).addNewGrade(assignment);
        }

        frame.showUserView(MainFrame.ASSIGNMENT_VIEW, null, null);
    }

}
