package proto1c;
import java.time.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;

/**
 * The main interface the user interacts with
 * @author UP820734
 */
public class gui_Main extends javax.swing.JFrame {
    private final manager_userClient userClientParent;
    
    /**
     * The main GUI the user interacts with
     * @param userClient the parent of the GUI
     */
    public gui_Main(manager_userClient userClient) {
        userClientParent = userClient;
        
        initComponents();
        setUpCalendar();
    }
    

    /**
     * This method is called from within the constructor to initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userCalendar = new javax.swing.JTable();
        lblMonth = new java.awt.Label();
        btnNext = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        userEvents = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        userTask = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        userReminder = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnAddEvent = new javax.swing.JButton();
        btnAddReminder = new javax.swing.JButton();
        btnAddTask = new javax.swing.JButton();
        btnDeleteTask = new javax.swing.JButton();
        btnEditTask = new javax.swing.JButton();
        btnEditReminder = new javax.swing.JButton();
        btnImportLectures = new javax.swing.JButton();
        btnDeleteReminder = new javax.swing.JButton();
        btnBudget = new javax.swing.JButton();
        btnBudgetList = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Struggle Preventer");
        setResizable(false);

        userCalendar.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        userCalendar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        userCalendar.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        userCalendar.setName("userCalendar"); // NOI18N
        userCalendar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userCalendarMouseClicked(evt);
            }
        });
        userCalendar.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                userCalendarPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(userCalendar);

        lblMonth.setAlignment(java.awt.Label.CENTER);
        lblMonth.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        lblMonth.setText("label1");

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnPrev.setText("Previous");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        userEvents.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        userEvents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Event", "Time"
            }
        ));
        jScrollPane6.setViewportView(userEvents);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(lblMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblMonth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPrev, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        userTask.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        userTask.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Task:", "Deadline:", "Completed:"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(userTask);

        userReminder.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        userReminder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reminder", "Time"
            }
        ));
        jScrollPane2.setViewportView(userReminder);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Options:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        btnAddEvent.setText("Events");
        btnAddEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEventActionPerformed(evt);
            }
        });

        btnAddReminder.setText("Add Reminder");
        btnAddReminder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddReminderActionPerformed(evt);
            }
        });

        btnAddTask.setText("Add Task");
        btnAddTask.setMaximumSize(new java.awt.Dimension(123, 25));
        btnAddTask.setMinimumSize(new java.awt.Dimension(123, 25));

        btnDeleteTask.setText("Delete Task");
        btnDeleteTask.setMaximumSize(new java.awt.Dimension(123, 25));
        btnDeleteTask.setMinimumSize(new java.awt.Dimension(123, 25));

        btnEditTask.setText("Edit Task");
        btnEditTask.setMaximumSize(new java.awt.Dimension(123, 25));
        btnEditTask.setMinimumSize(new java.awt.Dimension(123, 25));

        btnEditReminder.setText("Edit Reminder");
        btnEditReminder.setMaximumSize(new java.awt.Dimension(123, 25));
        btnEditReminder.setMinimumSize(new java.awt.Dimension(123, 25));
        btnEditReminder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditReminderActionPerformed(evt);
            }
        });

        btnImportLectures.setText("Import Lectures");

        btnDeleteReminder.setText("Delete Reminder");

        btnBudget.setText("Budget");
        btnBudget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBudgetActionPerformed(evt);
            }
        });

        btnBudgetList.setText("Spending List");
        btnBudgetList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBudgetListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAddEvent, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddReminder, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, Short.MAX_VALUE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDeleteTask, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditReminder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditTask, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddTask, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(btnDeleteReminder)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnBudget, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBudgetList, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(btnImportLectures, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddTask, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditTask, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeleteTask, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddReminder, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditReminder, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeleteReminder, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnImportLectures, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBudget, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(btnBudgetList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Triggers method in parent that user has pressed 'Next' button
     * @param evt press event
     */
    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        userClientParent.nextMonth();
    }//GEN-LAST:event_btnNextActionPerformed
    
    /**
     * Triggers method in parent that user has pressed 'Previous' button
     * @param evt press event
     */
    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        userClientParent.prevMonth();
    }//GEN-LAST:event_btnPrevActionPerformed

    /**
     * 
     * @param evt 
     */
    private void userCalendarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_userCalendarPropertyChange

    }//GEN-LAST:event_userCalendarPropertyChange
    
    /**
     * 
     * @param evt 
     */
    private void userCalendarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userCalendarMouseClicked
        int value = Integer.valueOf(userCalendar.getModel().getValueAt(userCalendar.getSelectedRow(), userCalendar.getSelectedColumn()).toString());
        userClientParent.calendarClicked(value);
    }//GEN-LAST:event_userCalendarMouseClicked
    
    /**
     * 
     * @param evt 
     */
    private void btnEditReminderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditReminderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditReminderActionPerformed
    
    /**
     * 
     * @param evt 
     */
    private void btnBudgetListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBudgetListActionPerformed
        userClientParent.spendingList();
    }//GEN-LAST:event_btnBudgetListActionPerformed

    private void btnAddEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEventActionPerformed
        // Clicking this button opens the Event GUI, enabling you to access features from there.
        userClientParent.viewEvents();
    }//GEN-LAST:event_btnAddEventActionPerformed

    private void btnAddReminderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddReminderActionPerformed
        userClientParent.remindersAdd();
    }//GEN-LAST:event_btnAddReminderActionPerformed

    private void btnBudgetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBudgetActionPerformed
        userClientParent.updateBudget();
    }//GEN-LAST:event_btnBudgetActionPerformed
    
    /**
     * Specifies calender properties
     */
    private void setUpCalendar() {
        userCalendar.setRowHeight(59);
        userReminder.setRowHeight(30);
        userTask.setRowHeight(30);
        userEvents.setRowHeight(30);
        
    }
    
    /**
     * Sets values the calendar displays
     * @param numDays the number of days in the month
     * @param month the String value of the month
     * @param firstDay what day the 1st of the month is on
     * @param year the int value of the year
     */
    public void setCalendar(int numDays, String month, int firstDay, int year) {
        int day = 1;
        
        lblMonth.setText(month + " " + year);
        
        for (int i = 0; i<5; i++) {
            for (int k = 0; k<7; k++) {
                userCalendar.setValueAt("", i, k);
            }
        }
        
        for (int j = 0; j<7; j++) {
            if (firstDay+j > 7) {
                firstDay = Math.negateExact(j-1);
                
            }
            userCalendar.getColumnModel().getColumn(j).setHeaderValue(DayOfWeek.of(firstDay + j).name());
            repaint();
            //System.out.println(DayOfWeek.of(firstDay + j).name());
        }
        
        for (int i = 0; i<5; i++) {
            for (int k = 0; k<7; k++) {
                if (day <= numDays) {
                    userCalendar.setValueAt(day, i, k);
                    day ++;
                }
                else {
                    break;
                }
            }
        }
        
        
    }
    
    /**
     * 
     * @param reminderList 
     */
    public void setReminders(ArrayList<type_TableRow> reminderList) {
        DefaultTableModel model = (DefaultTableModel) userReminder.getModel();
            
        for (int i = (userReminder.getRowCount() -1); i >= 0; i--) {
            model.removeRow(i);
        }
            
        for (int i = 0; i < reminderList.size(); i++) {
            model.addRow(new Object[]{reminderList.get(i).getTblName(), reminderList.get(i).getTblDate() + " " + reminderList.get(i).getTblTime()}); 
        }
    }
    
    /**
     * 
     * @param taskList 
     */
    public void setTasks(ArrayList<type_TableRow> taskList) {
        DefaultTableModel model = (DefaultTableModel) userTask.getModel();
            
        for (int i = (userTask.getRowCount() -1); i >= 0; i--) {
            model.removeRow(i);
        }
            
        for (int i = 0; i < taskList.size(); i++) {
            model.addRow(new Object[]{taskList.get(i).getTblName(), taskList.get(i).getTblDate() + " " + taskList.get(i).getTblTime()}); 
        }
    }
    
    /**
     * 
     * @param eventList 
     */
    public void setEvents(ArrayList<type_TableRow> eventList) {
        DefaultTableModel model = (DefaultTableModel) userEvents.getModel();
            
        for (int i = (userEvents.getRowCount() -1); i >= 0; i--) {
            model.removeRow(i);
        }
            
        for (int i = 0; i < eventList.size(); i++) {
            model.addRow(new Object[]{eventList.get(i).getTblName(), eventList.get(i).getTblDate() + " " + eventList.get(i).getTblTime()}); 
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddEvent;
    private javax.swing.JButton btnAddReminder;
    private javax.swing.JButton btnAddTask;
    private javax.swing.JButton btnBudget;
    private javax.swing.JButton btnBudgetList;
    private javax.swing.JButton btnDeleteReminder;
    private javax.swing.JButton btnDeleteTask;
    private javax.swing.JButton btnEditReminder;
    private javax.swing.JButton btnEditTask;
    private javax.swing.JButton btnImportLectures;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private java.awt.Label lblMonth;
    private javax.swing.JTable userCalendar;
    private javax.swing.JTable userEvents;
    private javax.swing.JTable userReminder;
    private javax.swing.JTable userTask;
    // End of variables declaration//GEN-END:variables
}
