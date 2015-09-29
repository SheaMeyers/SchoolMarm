/*
 * The Constructors
 * SchoolMarm
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.MainFrame;

/**
 * The listener interface for receiving assignmentButton events.
 * The class that is interested in processing a assignmentButton
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addAssignmentButtonListener<code> method. When
 * the assignmentButton event occurs, that object's appropriate
 * method is invoked.
 *
 */
public class AssignmentButtonListener implements ActionListener {

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame newFrame = new MainFrame();
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newFrame.showUserView(MainFrame.ASSIGNMENT_VIEW, null, null);
        newFrame.setVisible(true);
    }

}
