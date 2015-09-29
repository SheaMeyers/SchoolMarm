/*
 * The Constructors
 * SchoolMarm
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.BackButtonListener;
import controller.CalendarDayListener;
import controller.LastMonthListener;
import controller.NextMonthListener;
import controller.SchoolMarm;

/**
 * The Class CalendarView.
 *
 */
public class CalendarView extends JPanel {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The cal. */
    Calendar cal;

    /**
     * Instantiates a new calendar view.
     *
     * @param cal the Calendar
     */
    public CalendarView(Calendar cal) {
        this.cal = cal;

        if(cal == null) {
            Date today = new Date();
            cal = Calendar.getInstance();
            cal.setTime(today);
        }

        String month = getMonthString(cal.get(Calendar.MONTH));
        JPanel topPanel = new JPanel();
        JLabel monthLabel = new JLabel("<html><font size=15>" + month + " " + cal.get(Calendar.YEAR) + "</font></html>");
        JPanel monthPanel = new JPanel();
        monthPanel.add(monthLabel);
        JPanel daysPanel = new JPanel();
        daysPanel.setLayout(new GridLayout(7, 7));
        JLabel monLabel = new JLabel("MON", JLabel.CENTER);
        JLabel tueLabel = new JLabel("TUE", JLabel.CENTER);
        JLabel wedLabel = new JLabel("WED", JLabel.CENTER);
        JLabel thuLabel = new JLabel("THU", JLabel.CENTER);
        JLabel friLabel = new JLabel("FRI", JLabel.CENTER);
        JLabel satLabel = new JLabel("SAT", JLabel.CENTER);
        JLabel sunLabel = new JLabel("SUN", JLabel.CENTER);
        daysPanel.add(sunLabel);
        daysPanel.add(monLabel);
        daysPanel.add(tueLabel);
        daysPanel.add(wedLabel);
        daysPanel.add(thuLabel);
        daysPanel.add(friLabel);
        daysPanel.add(satLabel);
        JButton[] dayButtons = new JButton[42];
        Calendar curCal = Calendar.getInstance();
        int currentDay = curCal.get(Calendar.DAY_OF_MONTH);
        Date date = cal.getTime();
        cal.set(Calendar.DAY_OF_MONTH, 1);
        int firstDay = cal.get(Calendar.DAY_OF_WEEK);
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1);
        int previousLastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.setTime(date);

        for(int i = 1; i <= 42; i++) {
            if(i < firstDay) {
                dayButtons[i - 1] = new JButton("<html><font color=GRAY>" + (previousLastDay - firstDay + i + 1) + "</html>");
                dayButtons[i - 1].setEnabled(false);
            } else if((i - firstDay + 1) > lastDay) {
                dayButtons[i - 1] = new JButton("<html><font color=GRAY>" + (i - lastDay - firstDay + 1) + "</html>");
                dayButtons[i - 1].setEnabled(false);
            } else if((i - firstDay + 1) == currentDay && (cal.get(Calendar.MONTH) == curCal.get(Calendar.MONTH)) && cal.get(Calendar.YEAR) == curCal.get(Calendar.YEAR)) {
                dayButtons[i - 1] = new JButton("" + (i - firstDay + 1));
                dayButtons[i - 1].setBackground(Color.yellow);
            } else {
                dayButtons[i - 1] = new JButton("" + (i - firstDay + 1));
            }

            dayButtons[i - 1].addActionListener(new CalendarDayListener(cal));
            daysPanel.add(dayButtons[i - 1]);
        }

        String nextMonthString = getMonthString(cal.get(Calendar.MONTH) + 1);
        String lastMonthString = getMonthString(cal.get(Calendar.MONTH) - 1);
        JButton nextMonth = new JButton(nextMonthString + ">");
        JButton lastMonth = new JButton(lastMonthString + "<");
        nextMonth.addActionListener(new NextMonthListener(cal));
        lastMonth.addActionListener(new LastMonthListener(cal));
        topPanel.setLayout(new BorderLayout());
        topPanel.add(lastMonth, BorderLayout.WEST);
        topPanel.add(monthPanel, BorderLayout.CENTER);
        topPanel.add(nextMonth, BorderLayout.EAST);
        JPanel donePanel = new JPanel();
        JButton doneButton = new JButton("Done");
        doneButton.addActionListener(new BackButtonListener(SchoolMarm.main, MainFrame.TEACHER_VIEW, null, null));
        donePanel.add(doneButton);
        this.setLayout(new BorderLayout());
        this.add(topPanel, BorderLayout.NORTH);
        this.add(daysPanel, BorderLayout.CENTER);
        this.add(donePanel, BorderLayout.SOUTH);
    }

    /**
     * Gets the cal.
     *
     * @return the cal
     */
    public Calendar getCal() {
        return cal;
    }

    /**
     * Sets the cal.
     *
     * @param cal the new cal
     */
    public void setCal(Calendar cal) {
        this.cal = cal;
    }

    /**
     * Gets the month string.
     *
     * @param month the month
     * @return the month string
     */
    protected static String getMonthString(int month) {
        switch(month) {
            case 0:
                return "January";

            case 1:
                return "February";

            case 2:
                return "March";

            case 3:
                return "April";

            case 4:
                return "May";

            case 5:
                return "June";

            case 6:
                return "July";

            case 7:
                return "August";

            case 8:
                return "September";

            case 9:
                return "October";

            case 10:
                return "November";

            case 11:
                return "December";

            case 12:
                return "January";

            case 13:
                return "February";

            default:
                return "Invalid";
        }
    }
}
