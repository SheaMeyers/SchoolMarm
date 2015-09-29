/*
 * The Constructors
 * SchoolMarm
 */
package view;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import controller.OptionDoneButtonListener;
import controller.SchoolMarm;

/**
 * The Class OptionsView.
 *
 */
public class OptionsView extends JPanel {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The row field. */
    private JTextField rowField;

    /** The column field. */
    private JTextField columnField;

    /** The error label. */
    private JLabel errorLabel;

    /** The max size num. */
    private JLabel maxSizeNum;

    /**
     * Instantiates a new options view.
     *
     * @param main the main
     * @param myFrame the my frame
     */
    public OptionsView(MainFrame main, MainFrame myFrame) {
        JLabel rowLabel = new JLabel("Rows: ");
        JLabel columnLabel = new JLabel("Columns: ");
        errorLabel = new JLabel();
        rowField = new JTextField(5);
        columnField = new JTextField(5);
        rowField.setText("" + SchoolMarm.rows);
        columnField.setText("" + SchoolMarm.cols);
        int maxSize = Integer.parseInt(rowField.getText()) * Integer.parseInt(columnField.getText());
        maxSizeNum = new JLabel(maxSize + "");
        JLabel maxLabel = new JLabel("Maximum Classroom Size: ");
        JPanel rowPanel = new JPanel();
        JPanel colPanel = new JPanel();
        JPanel maxPanel = new JPanel();
        rowPanel.add(rowLabel);
        rowPanel.add(rowField);
        colPanel.add(columnLabel);
        colPanel.add(columnField);
        maxPanel.add(maxLabel);
        maxPanel.add(maxSizeNum);
        rowField.addKeyListener(new maxLabelChanger());
        columnField.addKeyListener(new maxLabelChanger());
        JPanel infoPanel = new JPanel();
        infoPanel.add(errorLabel);
        infoPanel.add(rowPanel);
        infoPanel.add(colPanel);
        infoPanel.add(maxPanel);
        JPanel donePanel = new JPanel();
        JButton doneButton = new JButton("Done");
        donePanel.add(doneButton);
        doneButton.addActionListener(new OptionDoneButtonListener(this, myFrame));
        this.setLayout(new BorderLayout());
        this.add(infoPanel, BorderLayout.CENTER);
        this.add(donePanel, BorderLayout.SOUTH);
    }

    /**
     * Gets the rows.
     *
     * @return the rows
     */
    public int getRows() {
        return Integer.parseInt(rowField.getText());
    }

    /**
     * Gets the cols.
     *
     * @return the cols
     */
    public int getCols() {
        return Integer.parseInt(columnField.getText());
    }

    /**
     * Sets the error message.
     *
     * @param errorMessage the new error message
     */
    public void setErrorMessage(String errorMessage) {
        errorLabel.setText(errorMessage);
    }

    /**
     * The Class maxLabelChanger.
     */
    class maxLabelChanger implements KeyListener {

        /* (non-Javadoc)
         * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
         */
        @Override
        public void keyPressed(KeyEvent arg0) {}

        /* (non-Javadoc)
         * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
         */
        @Override
        public void keyReleased(KeyEvent arg0) {
            int maxSize = 0;

            try {
                maxSize = Integer.parseInt(rowField.getText()) * Integer.parseInt(columnField.getText());
            } catch(Exception e) {}

            maxSizeNum.setText("" + maxSize);
        }

        /* (non-Javadoc)
         * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
         */
        @Override
        public void keyTyped(KeyEvent arg0) {}
    }

}
