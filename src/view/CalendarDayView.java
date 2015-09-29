/*
 * The Constructors
 * SchoolMarm
 */
package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.StringTokenizer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import model.CalendarEvent;
import model.TimeSlot;
import Database.DBAccessor;
import controller.CalendarEventDoneListener;

/**
 * The Class CalendarDayView.
 *
 */
public class CalendarDayView extends JPanel {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The text areas. */
    private JTextArea textAreas[];

    /* Will need a method somewhere to access the database
     * based on the value of date, to find
     * and save information based on the date and then the time
     */
    /**
     * Instantiates a new calendar day view.
     *
     * @param cal the cal
     */
    public CalendarDayView(Calendar cal) {
        DBAccessor accessor = new DBAccessor();
        String time = cal.get(Calendar.YEAR) + "/" + cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.DATE);
        String[] scheduleInfo = accessor.GetCalender(time);
        StringTokenizer schedule;
        TimeSlot[] timeSlots = new TimeSlot[scheduleInfo.length];

        for(int i = 0; i < scheduleInfo.length; i++) {
            schedule = new StringTokenizer(scheduleInfo[i], "\t");
            int index = 0;
            String[] data = new String[schedule.countTokens()];

            while(schedule.hasMoreTokens()) {
                data[index] = schedule.nextToken();
                index++;
            }

            timeSlots[i] = new TimeSlot(Integer.parseInt(data[1]), data[2]);
        }

        CalendarEvent event = new CalendarEvent(timeSlots);
        this.setLayout(new BorderLayout());
        String date = CalendarView.getMonthString(cal.get(Calendar.MONTH)) + " " + cal.get(Calendar.DAY_OF_MONTH) + ", " + cal.get(Calendar.YEAR);
        JLabel dayLabel = new JLabel("<html><font size = 5>" + date + "</font></html>");
        JPanel timePanel = new JPanel();
        JPanel labelPanel = new JPanel();
        JButton doneButton = new JButton("Done");
        JPanel donePanel = new JPanel();
        donePanel.add(doneButton);
        this.add(labelPanel, BorderLayout.WEST);
        this.add(timePanel, BorderLayout.CENTER);
        this.add(dayLabel, BorderLayout.NORTH);
        this.add(donePanel, BorderLayout.SOUTH);
        labelPanel.setLayout(new GridLayout(11, 0, 0, 1));
        timePanel.setLayout(new GridLayout(11, 0, 0, 1));
        JLabel timeLabels[] = new JLabel[11];
        textAreas = new JTextArea[11];
        JScrollPane scrollPanes[] = new JScrollPane[11];

        for(int i = 0; i < 11; i++) {
            int hour = 0;

            if(i < 5)
                hour = i + 8;

            if(i >= 5)
                hour = (i + 8) - 12;

            timeLabels[i] = new JLabel(hour + ":00");
            labelPanel.add(timeLabels[i]);
            textAreas[i] = new JTextArea();
            textAreas[i].setText(event.getEventForHour(i));
            scrollPanes[i] = new JScrollPane(textAreas[i]);
            timePanel.add(scrollPanes[i]);
        }

        /* This needs a method to be implemented which will save the data to the database
         * when the button is pressed.
         */
        doneButton.addActionListener(new CalendarEventDoneListener(this, cal));
    }

    /**
     * Gets the events.
     *
     * @return the events
     */
    public CalendarEvent getEvents() {
        int count = 0;

        for(int i = 0; i < textAreas.length; i++) {
            if(textAreas[i].getText() != "") {
                count++;
            }
        }

        TimeSlot[] timeSlots = new TimeSlot[count];

        for(int i = 0; i < textAreas.length; i++) {
            if(textAreas[i].getText() != "") {
                timeSlots[i] = new TimeSlot(i, textAreas[i].getText());
            }
        }

        CalendarEvent event = new CalendarEvent(timeSlots);
        return event;
    }
}
