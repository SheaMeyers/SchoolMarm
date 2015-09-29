/*
 * The Constructors
 * SchoolMarm
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Database.DBAccessor;

import model.Seat;

import view.MainFrame;
import view.OptionsView;

/**
 * The listener interface for receiving optionDoneButton events.
 * The class that is interested in processing a optionDoneButton
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addOptionDoneButtonListener<code> method. When
 * the optionDoneButton event occurs, that object's appropriate
 * method is invoked.
 *
 */
public class OptionDoneButtonListener implements ActionListener {

    /** The my frame. */
    private MainFrame myFrame;

    /** The view. */
    private OptionsView view;

    /**
     * Instantiates a new option done button listener.
     *
     * @param view the view
     * @param myFrame the my frame
     */
    public OptionDoneButtonListener(OptionsView view, MainFrame myFrame) {
        this.view = view;
        this.myFrame = myFrame;
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(view.getRows() == 0 || view.getCols() == 0) {
            view.setErrorMessage("<html><font color = RED>Cannot have a row or column of size 0</font></html>");
        } else {
            SchoolMarm.rows = view.getRows();
            SchoolMarm.cols = view.getCols();

            if((SchoolMarm.rows * SchoolMarm.cols) - SchoolMarm.seats.size() > 0) {
                for(int i = SchoolMarm.seats.size(); i < (SchoolMarm.rows * SchoolMarm.cols); i++) {
                    SchoolMarm.seats.add(new Seat(i));
                    SchoolMarm.seatListeners.add(new SeatListener(SchoolMarm.seats.get(i)));
                    SchoolMarm.seats.get(i).addActionListener(SchoolMarm.seatListeners.get(i));
                }
            } else {
                for(int i = SchoolMarm.seats.size() - 1; i >= (SchoolMarm.rows * SchoolMarm.cols); i--) {
                    SchoolMarm.seats.remove(i);
                }
            }

            //reinitialize the seats
            for(int i = 0; i < SchoolMarm.students.size(); i++) {
                SchoolMarm.seats.get(SchoolMarm.students.get(i).getSeat()).assign(SchoolMarm.students.get(i));
            }

            //save the options to the database.
            DBAccessor accessor = new DBAccessor();
            accessor.saveOptions(view.getRows(), view.getCols());
            myFrame.setVisible(false);
            SchoolMarm.main.showUserView(MainFrame.TEACHER_VIEW, null, null);
        }
    }

}
