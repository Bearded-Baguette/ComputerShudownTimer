/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computershutdowntimer;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Devon
 */
public class MainWindow extends javax.swing.JFrame {

    public LocalDateTime currentTime;
    public DateTimeFormatter dateFormat;
    
    public MainWindow() {
        initComponents();
        
        // Set the current time label to be the current time
        dateFormat = DateTimeFormatter.ofPattern("MM/dd/uuuu hh:mm:ss a");
        currentTime = LocalDateTime.now();
        CurrentTimeLabel.setText(dateFormat.format(currentTime));
        
        // Default the date to today's date
        DayTextField.setText(Integer.toString(currentTime.getDayOfMonth()));
        MonthTextField.setText(Integer.toString(currentTime.getMonthValue()));
        YearTextField.setText(Integer.toString(currentTime.getYear()));
        
        // Set status text
        statusText.setText("Set a date and time, then click \"Set Timer\"");
    }
        
    Boolean checkDate(LocalDateTime shutdownTime)
    {
        return shutdownTime.isAfter(currentTime);
    }
    
    void startCountdown(LocalDateTime shutDownTime) throws IOException, InterruptedException
    {
        Timer timer = new Timer();
        
        timer.schedule( new TimerTask() { 
                public void run() {
                    currentTime = LocalDateTime.now();

                    Duration timeDifference = Duration.between(currentTime, shutDownTime);

                    if (timeDifference.toMillis() <= 0)
                    {
                        System.out.println("Shutting down now...");

                        Runtime runtime = Runtime.getRuntime();
                        try {
                            Process proc = runtime.exec("shutdown -s -t 0");
                        } catch (IOException ex) {
                            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        System.exit(0);
                    }
                    else
                    {
                        String status = String.valueOf(timeDifference.toMinutes()) + " minutes remaining until shutdown";
                        if (timeDifference.toMinutes() == 0)
                        {
                            JFrame frame = new JFrame();
                            JOptionPane.showMessageDialog(frame, "SHUTTING DOWN");
                        }
                        
                        else if (timeDifference.toMinutes() > 0 && timeDifference.toMinutes() <= 5)
                        {
                            JFrame frame = new JFrame();
                            JOptionPane.showMessageDialog(frame, "SHUTDOWN IN " +  String.valueOf(timeDifference.toMinutes()) + " MINUTES");
                        }
                        
                        statusText.setText(status);
                    }
                }
        }, 0, 60*1000);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        setTimerButton = new javax.swing.JButton();
        CurrentTimeLabel = new javax.swing.JLabel();
        DayTextField = new javax.swing.JTextField();
        MonthTextField = new javax.swing.JTextField();
        YearTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        HourTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        MinuteTextField = new javax.swing.JTextField();
        AMPMComboBox = new javax.swing.JComboBox<String>();
        jScrollPane2 = new javax.swing.JScrollPane();
        statusText = new javax.swing.JTextArea();

        jTextField1.setText("jTextField1");

        jLabel4.setText(":");

        jLabel10.setText("jLabel10");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Current Time:");

        jLabel2.setText("Shutdown Time:");

        jLabel3.setText("Date:");

        setTimerButton.setText("Set Timer");
        setTimerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                setTimerButtonMouseClicked(evt);
            }
        });

        CurrentTimeLabel.setText("Current Time...");

        jLabel5.setText("Day");

        jLabel6.setText("Month");

        jLabel7.setText("Year");

        jLabel8.setText("Hour");

        jLabel9.setText("Minute");

        AMPMComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AM", "PM" }));

        statusText.setEditable(false);
        statusText.setColumns(20);
        statusText.setLineWrap(true);
        statusText.setRows(5);
        statusText.setWrapStyleWord(true);
        jScrollPane2.setViewportView(statusText);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(setTimerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(CurrentTimeLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(HourTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MinuteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AMPMComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MonthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(YearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CurrentTimeLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8)
                    .addComponent(HourTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(MinuteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AMPMComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(MonthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(YearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(setTimerButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setTimerButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_setTimerButtonMouseClicked
        String shutdownHour = HourTextField.getText();
        String shutdownMinute = MinuteTextField.getText();
        String shutdownAMPM = AMPMComboBox.getSelectedItem().toString();
        String shutdownMonth = MonthTextField.getText();
        String shutdownDay = DayTextField.getText();
        String shutdownYear = YearTextField.getText();
        
        String shutdownTime = shutdownMonth + "/" + shutdownDay + "/" + shutdownYear +
                " " + shutdownHour + ":" + shutdownMinute + ":00 " + shutdownAMPM;
        
        
        LocalDateTime shutDownTime = LocalDateTime.parse(shutdownTime, dateFormat);
        
        
        // If shutdownTime is after the current time, continue on
        if(checkDate(shutDownTime))
        {            
            try {
                dispose();
                startCountdown(shutDownTime);
            } catch (IOException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        // Else, enter a valid time
        else
        {
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Please enter a date that is after today's date");
        }
    }//GEN-LAST:event_setTimerButtonMouseClicked

  
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> AMPMComboBox;
    private javax.swing.JLabel CurrentTimeLabel;
    private javax.swing.JTextField DayTextField;
    private javax.swing.JTextField HourTextField;
    private javax.swing.JTextField MinuteTextField;
    private javax.swing.JTextField MonthTextField;
    private javax.swing.JTextField YearTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton setTimerButton;
    private javax.swing.JTextArea statusText;
    // End of variables declaration//GEN-END:variables
}
