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
 * The listener interface for receiving studentButton events.
 * The class that is interested in processing a studentButton
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addStudentButtonListener<code> method. When
 * the studentButton event occurs, that object's appropriate
 * method is invoked.
 *
 */
public class StudentButtonListener implements ActionListener {

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame newFrame = new MainFrame();
        newFrame.showUserView(MainFrame.STUDENT_AED_VIEW, null, null);
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}
