/*
 * The Constructors
 * SchoolMarm
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainFrame;

/**
 * The listener interface for receiving calendar events.
 * The class that is interested in processing a calendar
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addCalendarListener<code> method. When
 * the calendar event occurs, that object's appropriate
 * method is invoked.
 *
 */
public class CalendarListener implements ActionListener {

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        SchoolMarm.main.showUserView(MainFrame.CALENDAR_VIEW, null, null);
    }

}
