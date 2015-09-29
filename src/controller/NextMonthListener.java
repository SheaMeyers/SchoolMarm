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
 * The listener interface for receiving nextMonth events.
 * The class that is interested in processing a nextMonth
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addNextMonthListener<code> method. When
 * the nextMonth event occurs, that object's appropriate
 * method is invoked.
 *
 */
public class NextMonthListener implements ActionListener {

    /** The cal. */
    private Calendar cal;

    /**
     * Instantiates a new next month listener.
     *
     * @param cal the cal
     */
    public NextMonthListener(Calendar cal) {
        this.cal = cal;
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);
        SchoolMarm.main.showUserView(MainFrame.CALENDAR_VIEW, null, cal);
    }

}
