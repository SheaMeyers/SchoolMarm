/*
 * The Constructors
 * SchoolMarm
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.EditAssignmentInfoView;
import view.EditAssignmentView;
import view.MainFrame;

/**
 * The listener interface for receiving editAssignClicked events.
 * The class that is interested in processing a editAssignClicked
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addEditAssignClickedListener<code> method. When
 * the editAssignClicked event occurs, that object's appropriate
 * method is invoked.
 *
 */
public class EditAssignClickedListener implements ActionListener {

    /** The frame. */
    private MainFrame frame;

    /** The parent. */
    private EditAssignmentView parent;

    /**
     * Instantiates a new edits the assign clicked listener.
     *
     * @param frame the frame
     * @param parent the parent
     */
    public EditAssignClickedListener(MainFrame frame, EditAssignmentView parent) {
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
        EditAssignmentInfoView editAssignmentView = new EditAssignmentInfoView(frame, parent.getSelectedAssign());
        frame.add(editAssignmentView);
        frame.setCurrentPanel(editAssignmentView);
        frame.setSize(300, 200);
        frame.validate();
        frame.setVisible(true);
    }

}
