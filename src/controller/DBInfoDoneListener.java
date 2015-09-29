/*
 * The Constructors
 * SchoolMarm
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Database.DBInfo;

import view.DBInfoView;
import view.MainFrame;

/**
 * The listener interface for receiving DBInfoDone events.
 * The class that is interested in processing a DBInfoDone
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addDBInfoDoneListener<code> method. When
 * the DBInfoDone event occurs, that object's appropriate
 * method is invoked.
 *
 */
public class DBInfoDoneListener implements ActionListener {

    /** The frame. */
    private MainFrame frame;

    /** The parent. */
    private DBInfoView parent;

    /**
     * Instantiates a new dB info done listener.
     *
     * @param frame the frame
     * @param parent the parent
     */
    public DBInfoDoneListener(MainFrame frame, DBInfoView parent) {
        this.frame = frame;
        this.parent = parent;
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        DBInfo.setInfo(parent.getHost(), parent.getDatabase(), parent.getUsername(), parent.getPassword());
        frame.setVisible(false);
    }

}
