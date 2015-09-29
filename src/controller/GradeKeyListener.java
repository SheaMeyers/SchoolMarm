/*
 * The Constructors
 * SchoolMarm
 */
package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

/**
 * The listener interface for receiving gradeKey events.
 * The class that is interested in processing a gradeKey
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addGradeKeyListener<code> method. When
 * the gradeKey event occurs, that object's appropriate
 * method is invoked.
 *
 */
public class GradeKeyListener implements KeyListener {

    /** The grade fields. */
    private JTextField[][] gradeFields;

    /**
     * Instantiates a new grade key listener.
     *
     * @param gradeFields the grade fields
     */
    public GradeKeyListener(JTextField[][] gradeFields) {
        this.gradeFields = gradeFields;
    }

    /* (non-Javadoc)
     * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
     */
    @Override
    public void keyPressed(KeyEvent arg0) {
        int pressed = arg0.getKeyCode();

        switch(pressed) {
            case(KeyEvent.VK_DOWN):
                for(int i = 0; i < SchoolMarm.students.size() + 1; i++) {
                    for(int j = 0; j < SchoolMarm.assignments.size() + 1; j++) {
                        if(gradeFields[i][j] == arg0.getSource()) {
                            if(i < SchoolMarm.students.size())
                                gradeFields[i + 1][j].requestFocus();
                        }
                    }
                }

                break;

            case(KeyEvent.VK_ENTER):
                for(int i = 0; i < SchoolMarm.students.size() + 1; i++) {
                    for(int j = 0; j < SchoolMarm.assignments.size() + 1; j++) {
                        if(gradeFields[i][j] == arg0.getSource()) {
                            if(i < SchoolMarm.students.size())
                                gradeFields[i + 1][j].requestFocus();
                        }
                    }
                }

                break;

            case(KeyEvent.VK_RIGHT):
                for(int i = 0; i < SchoolMarm.students.size() + 1; i++) {
                    for(int j = 0; j < SchoolMarm.assignments.size() + 1; j++) {
                        if(gradeFields[i][j] == arg0.getSource()) {
                            if(j < SchoolMarm.assignments.size() - 1)
                                gradeFields[i][j + 1].requestFocus();
                        }
                    }
                }

                break;

            case(KeyEvent.VK_LEFT):
                for(int i = 0; i < SchoolMarm.students.size() + 1; i++) {
                    for(int j = 0; j < SchoolMarm.assignments.size() + 1; j++) {
                        if(gradeFields[i][j] == arg0.getSource()) {
                            if(j > 1)
                                gradeFields[i][j - 1].requestFocus();
                        }
                    }
                }

                break;

            case(KeyEvent.VK_UP):
                for(int i = 0; i < SchoolMarm.students.size() + 1; i++) {
                    for(int j = 0; j < SchoolMarm.assignments.size() + 1; j++) {
                        if(gradeFields[i][j] == arg0.getSource()) {
                            if(i > 1)
                                gradeFields[i - 1][j].requestFocus();
                        }
                    }
                }

                break;

            default:
                break;
        }
    }

    /* (non-Javadoc)
     * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
     */
    @Override
    public void keyReleased(KeyEvent arg0) {}

    /* (non-Javadoc)
     * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
     */
    @Override
    public void keyTyped(KeyEvent arg0) {
    }

}
