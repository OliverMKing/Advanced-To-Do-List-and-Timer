
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.Timer;

/**
 * The alarm
 * @author Oliver King
 */
public class AlarmTimer implements ActionListener {

    private Timer noiseTimer;
    private SetAlarmFrame frame;
    private Time time;
    private int seconds;

    /**
     * Starts the alarm
     * @param minutes minutes the alarm lasts for
     * @param frame the original frame
     */
    public AlarmTimer(int minutes, SetAlarmFrame frame) {
        noiseTimer = new Timer(1000, this);
        this.seconds = minutes * 60;
        this.frame = frame;
        this.time = new Time(minutes * 60);
    }

    /**
     * Starts the timer
     */
    public void start() {
        noiseTimer.start();
        
        // Changes visibilities and sets text
        frame.getStopButton().setVisible(true);
        frame.getStopButton().setEnabled(true);
        frame.getTimeLabel().setVisible(false);
        frame.getMinuteSpinner().setVisible(false);
        frame.getMinuteSpinner().setEnabled(false);
        frame.getCancelButton().setVisible(false);
        frame.getCancelButton().setEnabled(false);
        frame.getSetButton().setVisible(false);
        frame.getSetButton().setEnabled(false);
        frame.getMain().getAlarmLabel().setText(time.toString());
        frame.getMain().getAlarmLabel().setVisible(true);
        frame.getMain().getCancelButton().setEnabled(true);
        frame.getMain().getSetAlarmButton().setEnabled(false);
    }

    /**
     * Stops the timer
     */
    public void stop() {
        noiseTimer.stop();
    }

    /**
     * Checks if it is time to stop
     * @return 
     */
    public boolean isTimeToStop() {
        return !(frame.isAlarm());
    }

    /**
     * Called for every tick of the timer
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Reduces the time
        seconds += -1;
        time.oneLessSecond();
        
        // Checks if there is time left
        if (time.getTotalSeconds() > 0) {
            frame.getMain().getAlarmLabel().setText(time.toString());
        } else if (time.getTotalSeconds() == 0) {
            frame.getMain().getAlarmLabel().setVisible(false);
            frame.getMain().getAlarmLabel().setEnabled(true);
            frame.getMain().getCancelButton().setEnabled(false);
        }

        // If there is no time left
        if (seconds == 0) {
            frame.setVisible(true);
            AudioClip clip;

            // Plays the alarm
            try {
                clip = Applet.newAudioClip(new URL("file:C:\\Users\\Oliver\\Documents\\NetBeansProjects\\To-DoTimeManager\\alert.wav"));
                new Thread() {
                    public void run() {
                        while (!isTimeToStop()) {
                            clip.play();
                            try {
                                Thread.sleep(2000);
                            } catch (Exception e) {
                                System.out.print(e);
                            }
                        }
                    }
                }.start();

            } catch (Exception ee) {
                System.out.print(ee);
            };
        }

        // Checks if the timer should stop
        if (isTimeToStop()) {
            stop();
            frame.dispose();
            frame.getMain().getCancelButton().setEnabled(false);
            frame.getMain().getSetAlarmButton().setEnabled(true);
            frame.getMain().getAlarmLabel().setVisible(false);
        }
    }
}
