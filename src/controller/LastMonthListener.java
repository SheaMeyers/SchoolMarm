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
 * The listener interface for receiving lastMonth events.
 * The class that is interested in processing a lastMonth
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addLastMonthListener<code> method. When
 * the lastMonth event occurs, that object's appropriate
 * method is invoked.
 *
 */
public class LastMonthListener implements ActionListener {

    /** The cal. */
    private Calendar cal;

    /**
     * Instantiates a new last month listener.
     *
     * @param cal the cal
     */
    public LastMonthListener(Calendar cal) {
        this.cal = cal;
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1);
        SchoolMarm.main.showUserView(MainFrame.CALENDAR_VIEW, null, cal);
    }

}