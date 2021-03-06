
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.Timer;

/**
 * Sets the AlarmTimer
 *
 * @author Oliver King
 */
public class SetAlarmFrame extends javax.swing.JFrame {

    private boolean alarm = true;
    private MainFrame main;

    /**
     * Creates SetAlarmFrame
     */
    public SetAlarmFrame(MainFrame main) {
        initComponents();
        stopButton.setVisible(false);
        this.main = main;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timeLabel = new javax.swing.JLabel();
        setButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        minuteSpinner = new javax.swing.JSpinner();
        stopButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Set Alarm");

        timeLabel.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        timeLabel.setText("Time in Minutes");

        setButton.setText("Set");
        setButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        minuteSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        stopButton.setText("Stop");
        stopButton.setEnabled(false);
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 182, Short.MAX_VALUE)
                        .addComponent(cancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(setButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(timeLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(minuteSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(71, 71, 71)
                                .addComponent(stopButton)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(timeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(minuteSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stopButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(setButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Disposes of SetAlarmFrame
     *
     * @param evt
     */
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * Sets AlarmTimer
     *
     * @param evt
     */
    private void setButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setButtonActionPerformed
        this.setVisible(false);
        AlarmTimer timer = new AlarmTimer((int) minuteSpinner.getValue(), this);
        timer.start();
    }//GEN-LAST:event_setButtonActionPerformed

    /**
     * Stops AlarmTimer
     *
     * @param evt
     */
    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        alarm = false;
        this.dispose();
    }//GEN-LAST:event_stopButtonActionPerformed

    /**
     * Gets StopButton
     *
     * @return
     */
    public JButton getStopButton() {
        return stopButton;
    }

    /**
     * Gets MinuteSpinner
     *
     * @return
     */
    public JSpinner getMinuteSpinner() {
        return minuteSpinner;
    }

    /**
     * Gets TimeLabel
     *
     * @return
     */
    public JLabel getTimeLabel() {
        return timeLabel;
    }

    /**
     * Gets CancelButton
     *
     * @return
     */
    public JButton getCancelButton() {
        return cancelButton;
    }

    /**
     * Gets SetButton
     *
     * @return
     */
    public JButton getSetButton() {
        return setButton;
    }

    /**
     * Gets Alarm
     *
     * @return
     */
    public boolean isAlarm() {
        return alarm;
    }

    /**
     * Gets Main
     *
     * @return
     */
    public MainFrame getMain() {
        return main;
    }

    /**
     * Sets Alarm
     *
     * @param alarm
     */
    public void setAlarm(boolean alarm) {
        this.alarm = alarm;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JSpinner minuteSpinner;
    private javax.swing.JButton setButton;
    private javax.swing.JButton stopButton;
    private javax.swing.JLabel timeLabel;
    // End of variables declaration//GEN-END:variables
}
