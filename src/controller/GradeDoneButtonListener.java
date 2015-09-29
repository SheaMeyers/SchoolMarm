/*
 * The Constructors
 * SchoolMarm
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Database.DBAccessor;
import view.MainFrame;
import view.GradesView;

/**
 * The listener interface for receiving gradeDoneButton events.
 * The class that is interested in processing a gradeDoneButton
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addGradeDoneButtonListener<code> method. When
 * the gradeDoneButton event occurs, that object's appropriate
 * method is invoked.
 *
 */
public class GradeDoneButtonListener implements ActionListener {

    /** The parent. */
    private GradesView parent;

    /**
     * Instantiates a new grade done button listener.
     *
     * @param parent the parent
     */
    public GradeDoneButtonListener(GradesView parent) {
        this.parent = parent;
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    public void actionPerformed(ActionEvent e) {
        DBAccessor accessor = new DBAccessor();

        for(int i = 0; i < SchoolMarm.students.size(); i++) {
            for(int j = 0; j < SchoolMarm.assignments.size(); j++) {
                if(accessor.updateGrade(SchoolMarm.assignments.get(j).getName(), SchoolMarm.students.get(i).getID(), "Class", parent.getGrade(SchoolMarm.students.get(i), SchoolMarm.assignments.get(j))))
                    SchoolMarm.students.get(i).addGradeForAssignment(parent.getGrade(SchoolMarm.students.get(i), SchoolMarm.assignments.get(j)), SchoolMarm.assignments.get(j).getName());
            }
        }

        SchoolMarm.main.showUserView(MainFrame.TEACHER_VIEW, null, null);
    }

}