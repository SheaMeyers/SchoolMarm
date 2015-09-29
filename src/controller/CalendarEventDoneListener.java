/*
 * The Constructors
 * SchoolMarm
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import model.CalendarEvent;

import Database.DBAccessor;

import view.CalendarDayView;
import view.MainFrame;

/**
 * The listener interface for receiving calendarEventDone events.
 * The class that is interested in processing a calendarEventDone
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addCalendarEventDoneListener<code> method. When
 * the calendarEventDone event occurs, that object's appropriate
 * method is invoked.
 *
 */
public class CalendarEventDoneListener implements ActionListener {

    /** The parent. */
    private CalendarDayView parent;

    /** The cal. */
    private Calendar cal;

    /**
     * Instantiates a new calendar event done listener.
     *
     * @param parent the parent
     * @param cal the cal
     */
    public CalendarEventDoneListener(CalendarDayView parent, Calendar cal) {
        this.parent = parent;
        this.cal = cal;
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent arg0) {
        DBAccessor accessor = new DBAccessor();
        CalendarEvent event = parent.getEvents();
        String time = cal.get(Calendar.YEAR) + "/" + cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.DATE);

        for(int i = 0; i < 11; i++) {
            if(!event.getEventForHour(i).equals("")) {
                accessor.updateCalenderItem(time, i, event.getEventForHour(i));
            }
        }

        SchoolMarm.main.showUserView(MainFrame.CALENDAR_VIEW, null, cal);
    }

}
