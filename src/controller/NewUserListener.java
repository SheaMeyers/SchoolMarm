/*
 * The Constructors
 * SchoolMarm
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Database.DBAccessor;

import view.MainFrame;
import view.NewUserView;

/**
 * The listener interface for receiving newUser events.
 * The class that is interested in processing a newUser
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addNewUserListener<code> method. When
 * the newUser event occurs, that object's appropriate
 * method is invoked.
 *
 */
public class NewUserListener implements ActionListener {

    /** The frame. */
    private MainFrame frame;

    /** The parent. */
    private NewUserView parent;

    /**
     * Instantiates a new new user listener.
     *
     * @param frame the frame
     * @param parent the parent
     */
    public NewUserListener(MainFrame frame, NewUserView parent) {
        this.frame = frame;
        this.parent = parent;
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent arg0) {
        DBAccessor accessor = new DBAccessor();

        if(accessor.AddPerson(parent.getId(), parent.getFName(), parent.getLName(), null, null, parent.getAddress(), parent.getEmail(), null, parent.getPhoneNum(), -1, parent.getPassword(), 2, null)) {
            SchoolMarm.setup();
            frame.setVisible(false);
        }
    }
}
