
/**
 * Assists AlarmTimer
 *
 * @author Oliver King
 */
public class Time {

    private int totalSeconds;
    private int hours;
    private int minutes;
    private int seconds;

    /**
     * Sets initial time
     *
     * @param seconds
     */
    public Time(int seconds) {
        this.totalSeconds = seconds;
        calculate(seconds);
    }

    /**
     * Calculates time remaining based on seconds
     *
     * @param seconds
     */
    public void calculate(int seconds) {
        this.hours = seconds / 3600;
        seconds = seconds % 3600;
        this.minutes = seconds / 60;
        seconds = seconds % 60;
        this.seconds = seconds;
    }

    /**
     * Simulates a second passing
     */
    public void oneLessSecond() {
        totalSeconds += -1;
        calculate(totalSeconds);
    }

    /**
     * Gets Hours
     *
     * @return
     */
    public int getHours() {
        return hours;
    }

    /**
     * Gets Minutes
     *
     * @return
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * Gets Seconds
     *
     * @return
     */
    public int getSeconds() {
        return seconds;
    }

    /**
     * Returns hours, minutes, and seconds in String format
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        if (hours > 1) {
            output.append(hours + " Hours ");
        } else if (hours == 1) {
            output.append(hours + " Hour ");
        }

        if (minutes > 1) {
            output.append(minutes + " Minutes ");
        } else if (minutes == 1) {
            output.append(minutes + " Minute ");
        }

        if (seconds > 1) {
            output.append(seconds + " Seconds");
        } else if (seconds == 1) {
            output.append(seconds + " Second");
        }

        return output.toString();
    }

    /**
     * Gets TotalSeconds
     *
     * @return
     */
    public int getTotalSeconds() {
        return totalSeconds;
    }

    /**
     * Sets TotalSeconds
     *
     * @param totalSeconds
     */
    public void setTotalSeconds(int totalSeconds) {
        this.totalSeconds = totalSeconds;
    }
}
