/*
 * The Constructors
 * SchoolMarm
 */
package model;

/**
 * The Class CalendarEvent.
 *
 */
public class CalendarEvent {
    /**
     * each event text area is related to the event time
     * EventTextAreas[0] is related to 9:00 and so on.
     */
    private String[] Events;

    /**
     * Instantiates a new calendar event.
     *
     * @param timeSlots the time slots
     */
    public CalendarEvent(TimeSlot[] timeSlots) {
        this.Events = new String[11];

        for(int j = 0; j < timeSlots.length; j++) {
            Events[timeSlots[j].getHour()] = timeSlots[j].getInfo();
        }

        for(int i = 0; i < 11; i++) {
            if(null == Events[i]) {
                Events[i] = "";
            }
        }
    }

    /**
     * Gets the event for hour.
     *
     * @param hour the hour
     * @return the event for hour
     */
    public String getEventForHour(int hour) {
        return Events[hour];
    }

}
