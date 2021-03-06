
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.prefs.Preferences;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * Main frame of project
 *
 * @author Oliver King
 */
public class MainFrame extends javax.swing.JFrame {

    private Preferences pref = Preferences.userNodeForPackage(MainFrame.class);
    private SetAlarmFrame alarm;
    private ArrayList<Task> tasks = new ArrayList<Task>();

    /**
     * Creates MainFrame
     */
    public MainFrame() {
        initComponents();

        // Gets preferences
        updateName(pref.get("name", ""));
        updateBackgroundColor(new Color(pref.getInt("color", -26215)));

        // Sets date and time
        setDate();
        setTime();
        updateTime();
        //alarmLabel.setVisible(false);

        // Gets saved tasks
        FileInputStream fileIn;
        try {
            fileIn = new FileInputStream("tasks.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            tasks = (ArrayList<Task>) in.readObject();
            in.close();
            fileIn.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        updateTasks();

    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topPanel = new javax.swing.JPanel();
        welcomeLabel = new javax.swing.JLabel();
        settingsButton = new javax.swing.JButton();
        dateLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        alarmLabel = new javax.swing.JLabel();
        quoteButton = new javax.swing.JButton();
        setAlarmButton = new javax.swing.JButton();
        taskTextField = new javax.swing.JTextField();
        taskLabel = new javax.swing.JLabel();
        taskButton = new javax.swing.JButton();
        taskScrollPane = new javax.swing.JScrollPane();
        tasksList = new javax.swing.JList<>();
        taskPaneLabel = new javax.swing.JLabel();
        setAlarmLabel = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        xButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("To-Do");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        topPanel.setBackground(new java.awt.Color(255, 153, 153));

        welcomeLabel.setFont(new java.awt.Font("Verdana", 1, 48)); // NOI18N
        welcomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcomeLabel.setText("Hello!");

        settingsButton.setBackground(new java.awt.Color(255, 153, 153));
        settingsButton.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        settingsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/settings.png"))); // NOI18N
        settingsButton.setBorderPainted(false);
        settingsButton.setFocusPainted(false);
        settingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsButtonActionPerformed(evt);
            }
        });

        dateLabel.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        dateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dateLabel.setText("Today is");

        timeLabel.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        timeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeLabel.setText("At");

        alarmLabel.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        alarmLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        quoteButton.setBackground(new java.awt.Color(255, 153, 153));
        quoteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quote.png"))); // NOI18N
        quoteButton.setBorderPainted(false);
        quoteButton.setFocusPainted(false);
        quoteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quoteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 893, Short.MAX_VALUE)
            .addComponent(timeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addComponent(settingsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(quoteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(alarmLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(welcomeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(quoteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(settingsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(welcomeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(timeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(alarmLabel)
                .addGap(26, 26, 26))
        );

        setAlarmButton.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        setAlarmButton.setText("Set Alarm");
        setAlarmButton.setFocusPainted(false);
        setAlarmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setAlarmButtonActionPerformed(evt);
            }
        });

        taskTextField.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N

        taskLabel.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        taskLabel.setText("Add Task");

        taskButton.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        taskButton.setText("Add");
        taskButton.setFocusPainted(false);
        taskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taskButtonActionPerformed(evt);
            }
        });

        tasksList.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        tasksList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        taskScrollPane.setViewportView(tasksList);

        taskPaneLabel.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        taskPaneLabel.setText("Tasks");

        setAlarmLabel.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        setAlarmLabel.setText("Alarm");

        cancelButton.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        cancelButton.setText("Cancel Alarm");
        cancelButton.setEnabled(false);
        cancelButton.setFocusPainted(false);
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        xButton.setText("╳");
        xButton.setFocusPainted(false);
        xButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(taskTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 507, Short.MAX_VALUE)
                        .addComponent(setAlarmButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(taskLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(setAlarmLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(taskButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelButton))
                    .addComponent(taskPaneLabel)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(taskScrollPane)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(xButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(taskLabel)
                    .addComponent(setAlarmLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(taskTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(setAlarmButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(taskButton)
                    .addComponent(cancelButton))
                .addGap(18, 18, 18)
                .addComponent(taskPaneLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(taskScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(xButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        setBounds(0, 0, 911, 617);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Creates OptionsFrame
     *
     * @param evt
     */
    private void settingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsButtonActionPerformed
        OptionsFrame options = new OptionsFrame(topPanel.getBackground(), this, pref.get("name", ""));
        options.setVisible(true);
    }//GEN-LAST:event_settingsButtonActionPerformed

    /**
     * Creates SetAlarmFrame
     *
     * @param evt
     */
    private void setAlarmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setAlarmButtonActionPerformed
        alarm = new SetAlarmFrame(this);
        alarm.setVisible(true);
    }//GEN-LAST:event_setAlarmButtonActionPerformed

    /**
     * Cancels AlarmTimer on next tick
     *
     * @param evt
     */
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        alarm.setAlarm(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * Adds task to tasks
     *
     * @param evt
     */
    private void taskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taskButtonActionPerformed
        // Checks if field is empty
        if (!(taskTextField.getText().equals(""))) {
            tasks.add(new Task(taskTextField.getText()));
            taskTextField.setText("");
            updateTasks();

            try {
                saveTasks();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_taskButtonActionPerformed

    /**
     * Removes task from tasks
     *
     * @param evt
     */
    private void xButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xButtonActionPerformed
        try {
            tasks.remove(tasksList.getSelectedIndex());
            saveTasks();
        } catch (Exception e) {
            System.out.println(e);
        }

        updateTasks();
    }//GEN-LAST:event_xButtonActionPerformed

    /**
     * Creates QuoteFrame
     *
     * @param evt
     */
    private void quoteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quoteButtonActionPerformed
        QuoteFrame quote = new QuoteFrame();
        quote.setVisible(true);
    }//GEN-LAST:event_quoteButtonActionPerformed

    /**
     * Updates the background color
     *
     * @param color
     */
    public void updateBackgroundColor(Color color) {
        topPanel.setBackground(color);
        settingsButton.setBackground(color);
        quoteButton.setBackground(color);
        pref.putInt("color", (color.getRGB()));
    }

    /**
     * Updates the name
     *
     * @param name
     */
    public void updateName(String name) {
        welcomeLabel.setText("Hello " + name + "!");
        pref.put("name", name);
    }

    /**
     * Sets the date
     */
    public void setDate() {
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy"));
        dateLabel.setText("Today is " + date);
    }

    /**
     * Sets the time
     */
    public void setTime() {
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("h:mm a"));
        timeLabel.setText("At " + time);
    }

    /**
     * Updates date and time
     */
    public void updateTime() {
        new Timer(20000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("h:mm a"));
                timeLabel.setText("At " + time);
            }
        }).start();
    }

    /**
     * Saves tasks to tasks.ser
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void saveTasks() throws FileNotFoundException, IOException {
        FileOutputStream fileOut = new FileOutputStream("tasks.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(tasks);
    }

    /**
     * Updates tasksList model
     */
    public void updateTasks() {
        DefaultListModel model = new DefaultListModel();

        for (int i = 0; i < tasks.size(); i++) {
            model.addElement(tasks.get(i).getTask());
        }

        tasksList.setModel(model);
    }

    /**
     * Gets SetAlarmButton
     *
     * @return
     */
    public JButton getSetAlarmButton() {
        return setAlarmButton;
    }

    /**
     * Gets AlarmLabel
     *
     * @return
     */
    public JLabel getAlarmLabel() {
        return alarmLabel;
    }

    /**
     * Gets CancelButton
     *
     * @return
     */
    public JButton getCancelButton() {
        return cancelButton;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alarmLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JButton quoteButton;
    private javax.swing.JButton setAlarmButton;
    private javax.swing.JLabel setAlarmLabel;
    private javax.swing.JButton settingsButton;
    private javax.swing.JButton taskButton;
    private javax.swing.JLabel taskLabel;
    private javax.swing.JLabel taskPaneLabel;
    private javax.swing.JScrollPane taskScrollPane;
    private javax.swing.JTextField taskTextField;
    private javax.swing.JList<String> tasksList;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JPanel topPanel;
    private javax.swing.JLabel welcomeLabel;
    private javax.swing.JButton xButton;
    // End of variables declaration//GEN-END:variables
}
