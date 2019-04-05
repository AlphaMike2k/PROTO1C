package proto1c;

import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * Interface the user interacts with to edit the budget list
 * @author UP820734
 */
public class gui_BLEdit extends javax.swing.JFrame {
    private final manager_userClient userClientParent;
    private DecimalFormat decFormat = new DecimalFormat("#.00");
    private int prevRow = -1; 
    
    /**
     * Creates new form gui_BLEditthe GUI
     * @param userClient The parent that creates this GUI
     */
    public gui_BLEdit(manager_userClient userClient) {
        userClientParent = userClient;
        
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtItemName = new javax.swing.JTextField();
        txtPriority = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        userBudgetList = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnEditBudgetList = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Edit Budget List", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 0, 18))); // NOI18N

        txtItemName.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        txtPriority.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        txtPrice.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel1.setText("Item:");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setText("Price (£):");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel3.setText("Priority:");

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete Selected");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtPrice)
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(29, 29, 29))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtPriority, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDelete)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtItemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPrice)
                    .addComponent(btnSave))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPriority, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel)))
                .addGap(18, 18, 18)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        userBudgetList.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        userBudgetList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Priority:", "Item:", "Cost:", "Select:"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        userBudgetList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userBudgetListMouseClicked(evt);
            }
        });
        userBudgetList.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                userBudgetListPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(userBudgetList);

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnEditBudgetList.setText("Add Item");
        btnEditBudgetList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditBudgetListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditBudgetList))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBack)
                            .addComponent(btnEditBudgetList))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Triggers an event when calendar is clicked.
     * If tickbox column is true, gets values of selected rows
     * @param evt The click event
     */
    private void userBudgetListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userBudgetListMouseClicked
        String value = userBudgetList.getModel().getValueAt(userBudgetList.getSelectedRow(), userBudgetList.getSelectedColumn()).toString();
        int row = userBudgetList.getSelectedRow();
        try {
             if (value.equals("true")) {
                if (prevRow >= 0) {
                    userBudgetList.getModel().setValueAt(false, prevRow, 3);
                } 
                txtItemName.setText(userBudgetList.getModel().getValueAt(row, 1).toString());
                txtPrice.setText(userBudgetList.getModel().getValueAt(row, 2).toString().replace("£", ""));
                txtPriority.setText(userBudgetList.getModel().getValueAt(row, 0).toString());
                prevRow = row;
            }
        }
       
        catch (Exception e) {
            prevRow = -1;
        }
    }//GEN-LAST:event_userBudgetListMouseClicked
    
    /**
     * Fills the Jtable with values
     * @param budgetList The sorted list of values from the database
     */
    public void loadList(ArrayList <type_TableRow> budgetList) {
        userBudgetList.setRowHeight(40);
        DefaultTableModel model = (DefaultTableModel) userBudgetList.getModel();
            
        for (int i = (userBudgetList.getRowCount() -1); i >= 0; i--) {
            model.removeRow(i);
        }
            
        for (int i = 0; i < budgetList.size(); i++) {
            model.addRow(new Object[]{budgetList.get(i).getItemPriority(), budgetList.get(i).getItemName(), "£" + budgetList.get(i).getItemCost()}); 
        }
    }
    
    private void userBudgetListPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_userBudgetListPropertyChange

    }//GEN-LAST:event_userBudgetListPropertyChange
    
    /**
     * Triggers event when back button pressed
     * @param evt The click event
     */
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userClientParent.back();
    }//GEN-LAST:event_btnBackActionPerformed
    
    /**
     * Triggers event when save button pressed.
     * Validates users input.
     * Creates a table row object of values.
     * @param evt The click event
     */
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        int row = userBudgetList.getSelectedRow();
        
        String itemName = txtItemName.getText();
        String itemCost = txtPrice.getText();
        String itemPriority = txtPriority.getText();
        String oldName = userBudgetList.getModel().getValueAt(row, 1).toString();
        double oldCost = Double.valueOf(userBudgetList.getModel().getValueAt(row, 2).toString().replace("£",""));
        int oldPriority = Integer.valueOf(userBudgetList.getModel().getValueAt(row, 0).toString()); 
        
        double cost;
        int priority;
                
        try {
            if (itemName.length() > 30) {
                userClientParent.displayAlert("Item name can't be more than 30 characters");
                return;
            }
            
            cost = Double.valueOf(itemCost);
            cost = Double.valueOf(String.format("%.2f", cost));
            priority = Integer.valueOf(itemPriority);
            
            userClientParent.spendingListSave(new type_TableRow(oldName,oldCost,oldPriority,itemName,cost,priority));
            clearBoxes();
        }
        
        catch (NumberFormatException e) {
            userClientParent.displayAlert("Invalid value");
            clearBoxes();
        }
    }//GEN-LAST:event_btnSaveActionPerformed
    
    /**
     * Clears user input boxes and sets tickbox to false
     * @param evt The click event
     */
    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        int row = userBudgetList.getSelectedRow();
        
        if (userBudgetList.getValueAt(row, 3).equals(true)) {
            userBudgetList.setValueAt(false, row, 3);
        }
        
        clearBoxes();
    }//GEN-LAST:event_btnCancelActionPerformed
    
    /**
     * Triggers event to display the spending list
     * @param evt The click event
     */
    private void btnEditBudgetListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditBudgetListActionPerformed
        userClientParent.spendingList();
    }//GEN-LAST:event_btnEditBudgetListActionPerformed
    
    /**
     * Triggers event to remove selected item from database.
     * Converts/checks values before creating table row object
     * @param evt The click event
     */
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            String value = userBudgetList.getModel().getValueAt(userBudgetList.getSelectedRow(), userBudgetList.getSelectedColumn()).toString();
            int row = userBudgetList.getSelectedRow();
        
            double cost = Double.valueOf(userBudgetList.getModel().getValueAt(row, 2).toString().replace("£", ""));
        
            if (value.equals("true")) {
                userClientParent.spendingListCheck(new type_TableRow(userBudgetList.getModel().getValueAt(row, 1).toString(), cost, Integer.valueOf(userBudgetList.getModel().getValueAt(row, 0).toString())));
            }
        }
        
        catch (Exception e) {
            userClientParent.displayAlert("Please select a value");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed
    
    /**
     * Sets the input boxes to blank
     */
    public void clearBoxes() {
        txtItemName.setText("");
        txtPrice.setText("");
        txtPriority.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEditBudgetList;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtItemName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtPriority;
    private javax.swing.JTable userBudgetList;
    // End of variables declaration//GEN-END:variables
    
    
    /**
     * For Testing purposes
     */
    public String getTxtItemName() {
        return txtItemName.getText();
    }
    
    /**
     * For Testing purposes
     */
    public String getTxtPrice() {
        return txtPrice.getText();
    }
    
    /**
     * For Testing purposes
     */
    public String getTxtPriority() {
        return txtPriority.getText();
    }
    
    /**
     * For Testing purposes
     */
    public JTable getUserBudgetList() {
        return userBudgetList;
    }
    
    /**
     * For Testing purposes
     */
    public void setTxtItemName(String txtItemName) {
        this.txtItemName.setText(txtItemName);
    }
    
    /**
     * For Testing purposes
     */
    public void setTxtPrice(String txtPrice) {
        this.txtPrice.setText(txtPrice);
    }
    
    /**
     * For Testing purposes
     */
    public void setTxtPriority(String txtPriority) {
        this.txtPriority.setText(txtPriority);
    }
    
    
    
}
