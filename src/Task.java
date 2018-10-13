
import java.io.Serializable;

/**
 * Serialized format of tasks
 *
 * @author Oliver King
 */
public class Task implements Serializable {

    private String task;

    /**
     * Sets task
     *
     * @param task
     */
    public Task(String task) {
        this.task = task;
    }

    /**
     * Gets Task
     *
     * @return
     */
    public String getTask() {
        return task;
    }
}
