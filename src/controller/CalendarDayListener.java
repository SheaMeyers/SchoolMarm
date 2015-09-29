/*
 * The Constructors
 * SchoolMarm
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import view.MainFrame;

/**
 * The listener interface for receiving calendarDay events.
 * The class that is interested in processing a calendarDay
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addCalendarDayListener<code> method. When
 * the calendarDay event occurs, that object's appropriate
 * method is invoked.
 *
 */
public class CalendarDayListener implements ActionListener {

    /** The date. */
    private Calendar date;

    /**
     * Instantiates a new calendar day listener.
     *
     * @param date the date
     */
    public CalendarDayListener(Calendar date) {
        this.date = date;
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent arg0) {
        SchoolMarm.main.showUserView(MainFrame.CALENDAR_DAY_VIEW, null, date);
    }

}
