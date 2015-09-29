/*
 * The Constructors
 * SchoolMarm
 */
package controller;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.EditStudentInfoView;
import view.EditStudentView;
import view.MainFrame;

/**
 * The listener interface for receiving editStudentClicked events.
 * The class that is interested in processing a editStudentClicked
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addEditStudentClickedListener<code> method. When
 * the editStudentClicked event occurs, that object's appropriate
 * method is invoked.
 *
 */
public class EditStudentClickedListener implements ActionListener {

    /** The frame. */
    private MainFrame frame;

    /** The parent. */
    private EditStudentView parent;

    /**
     * Instantiates a new edits the student clicked listener.
     *
     * @param frame the frame
     * @param parent the parent
     */
    public EditStudentClickedListener(MainFrame frame, EditStudentView parent) {
        this.frame = frame;
        this.parent = parent;
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.setVisible(false);
        frame.removeCurrentPanel();
        frame.validate();
        EditStudentInfoView editStudentView = new EditStudentInfoView(frame, parent.getSelectedStudent());
        frame.add(editStudentView);
        frame.setCurrentPanel(editStudentView);
        frame.validate();
        frame.setSize(400, 650);
        frame.setLocation(new Point(SchoolMarm.main.getX() + 700, SchoolMarm.main.getY()));
        frame.setVisible(true);
    }

}
