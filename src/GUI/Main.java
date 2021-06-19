/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.RegistrationDTO;
import DTO.RegistrationInterface;
import java.rmi.Naming;
import java.util.Collections;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    RegistrationInterface ri;
    boolean themmoi = true;
    Vector<RegistrationDTO> Rlist;

    public Main() {
        initComponents();
        setLocationRelativeTo(null);
        connect();
        loadFile();
    }

    public void connect() {
        try {
            String tmp = "rmi://localhost:9999/manager";
            ri = (RegistrationInterface) Naming.lookup(tmp);
            if (ri != null) {
                System.out.println("Connected!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void loadFile() {
        Rlist = DAO.FileDAO.readFile();
        Vector header = new Vector();
        Vector data = new Vector();
        for (RegistrationDTO r : Rlist) {
            Vector row = new Vector();
            row.add(r.getRegistrationID());
            row.add(r.getFullName());
            row.add(r.getAge());
            row.add(r.isGender());
            row.add(r.getPhone());
            row.add(r.getAddress());
            data.add(row);
        }
        header.add("Registrator ID");
        header.add("Full Name");
        header.add("Age");
        header.add("Gender");
        header.add("Phone");
        header.add("Address");

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setDataVector(data, header);
    }

    public void clear() {
        txtregistrationID.setText("");
        txtaddress.setText("");
        txtadult.setText("");
        txtage.setText("");
        txtchildren.setText("");
        txtemail.setText("");
        txtfullname.setText("");
        txtno.setText("");
        txtphone.setText("");
    }

    public boolean CheckDupID(String ID) {
        for (RegistrationDTO r : Rlist) {
            if (r.getRegistrationID().equals(ID)) {
                JOptionPane.showMessageDialog(null, "ID is Duplicate!!");
                return false;
            } else if (!ID.matches("[a-zA-Z0-9 ]+{1,10}")) {
                JOptionPane.showMessageDialog(null, "ID less than or equals 10");
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtregistrationID = new javax.swing.JTextField();
        btnfindbyid = new javax.swing.JButton();
        txtfullname = new javax.swing.JTextField();
        txtage = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        rbmale = new javax.swing.JRadioButton();
        rbfemale = new javax.swing.JRadioButton();
        txtemail = new javax.swing.JTextField();
        txtphone = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtaddress = new javax.swing.JTextArea();
        txtno = new javax.swing.JTextField();
        txtchildren = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtadult = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btnaddnew = new javax.swing.JButton();
        btnsave = new javax.swing.JButton();
        btnremove = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cbsort = new javax.swing.JComboBox<>();
        txtsearch = new javax.swing.JTextField();
        btngetalldata = new javax.swing.JButton();
        btnsearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setText("Family Healthcare Managerment");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Detail part"));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("Registration ID:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("Full name:");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setText("Age:");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setText("Email:");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setText("Phone:");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setText("Address:");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel9.setText("Number of member:");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel10.setText("Include:");

        txtregistrationID.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtregistrationID.setToolTipText("");
        txtregistrationID.setEnabled(false);

        btnfindbyid.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnfindbyid.setText("Find by ID");
        btnfindbyid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfindbyidActionPerformed(evt);
            }
        });

        txtfullname.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        txtage.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel11.setText("Gender:");

        buttonGroup1.add(rbmale);
        rbmale.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        rbmale.setText("Male");

        buttonGroup1.add(rbfemale);
        rbfemale.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        rbfemale.setText("Female");

        txtemail.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        txtphone.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        txtaddress.setColumns(20);
        txtaddress.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtaddress.setRows(5);
        txtaddress.setPreferredSize(new java.awt.Dimension(300, 400));
        jScrollPane2.setViewportView(txtaddress);

        txtno.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        txtchildren.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel12.setText("Children");

        txtadult.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel13.setText("Adults");

        btnaddnew.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnaddnew.setText("Add new");
        btnaddnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddnewActionPerformed(evt);
            }
        });

        btnsave.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnsave.setText("Save");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        btnremove.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnremove.setText("Remove");
        btnremove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnremoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addGap(28, 28, 28))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(115, 115, 115)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtregistrationID, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnfindbyid))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtage, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(rbmale, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rbfemale))
                            .addComponent(txtemail)
                            .addComponent(txtphone)
                            .addComponent(txtno, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtchildren, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12)
                                .addGap(43, 43, 43)
                                .addComponent(txtadult, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13))
                            .addComponent(txtfullname)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(btnaddnew)
                        .addGap(105, 105, 105)
                        .addComponent(btnsave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnremove)
                        .addGap(55, 55, 55)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtregistrationID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnfindbyid))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtfullname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(rbmale)
                    .addComponent(rbfemale))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtchildren, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtadult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnaddnew)
                    .addComponent(btnsave)
                    .addComponent(btnremove))
                .addGap(42, 42, 42))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Main part"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Sort by name:");

        cbsort.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cbsort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ascending", "Deascending" }));
        cbsort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbsortActionPerformed(evt);
            }
        });

        txtsearch.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        btngetalldata.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btngetalldata.setText("Get all Data");

        btnsearch.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnsearch.setText("Search by name");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cbsort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(btnsearch)
                        .addGap(24, 24, 24)
                        .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(btngetalldata, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbsort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btngetalldata, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(341, 341, 341))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        if (CheckDupID(txtregistrationID.getText())
                && Validata.Valid.checkFullName(txtfullname.getText())
                && Validata.Valid.checkNO(txtage.getText())
                && Validata.Valid.checkEmail(txtemail.getText())
                && Validata.Valid.checkPhone(txtphone.getText())
                && Validata.Valid.checkString(txtaddress.getText().trim())
                && Validata.Valid.checkNO(txtno.getText())
                && Validata.Valid.checkNO(txtchildren.getText())
                && Validata.Valid.checkNO(txtadult.getText())) {
            String registrationID = txtregistrationID.getText();
            String fullName = txtfullname.getText();
            int age = Integer.parseInt(txtage.getText());
            boolean gender = false;
            if (rbmale.isSelected()) {
                gender = true;
            }
            String email = txtemail.getText();
            String phone = txtphone.getText();;
            String address = txtaddress.getText().trim();
            int numberOfMember = Integer.parseInt(txtno.getText());
            int numberOfChildren = Integer.parseInt(txtchildren.getText());
            int numberOfAdults = Integer.parseInt(txtadult.getText());
            if (ri != null) {
                if (themmoi) {
                    if (CheckDupID(registrationID)) {
                        try {
                            RegistrationDTO dto = new RegistrationDTO(registrationID, fullName, age, gender, email, phone, address, numberOfMember, numberOfChildren, numberOfAdults);
                            if (ri.createRegistration(dto)) {
                                loadFile();
                                JOptionPane.showMessageDialog(null, "Added");
                                clear();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    int index = jTable1.getSelectedRow();
                    if (index >= 0) {
                        try {
                            RegistrationDTO dto = new RegistrationDTO(registrationID, fullName, age, gender, email, phone, address, numberOfMember, numberOfChildren, numberOfAdults);
                            ri.updateRegistration(dto);
                            loadFile();
                            clear();
                            JOptionPane.showMessageDialog(null, "Updated");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void btnaddnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddnewActionPerformed
        clear();
        txtregistrationID.setEnabled(true);
        themmoi = true;
    }//GEN-LAST:event_btnaddnewActionPerformed

    private void btnremoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnremoveActionPerformed
        int index = jTable1.getSelectedRow();
        if (index >= 0) {
            if (ri != null) {
                try {
                    ri.removeRegistration(txtregistrationID.getText());
                    loadFile();
                    clear();
                    JOptionPane.showMessageDialog(null, "Removed");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_btnremoveActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int index = jTable1.getSelectedRow();
        if (index >= 0) {
            RegistrationDTO r = Rlist.get(index);
            txtregistrationID.setText(r.getRegistrationID());
            txtaddress.setText(r.getAddress());
            if (r.isGender()) {
                rbmale.setSelected(true);
            } else {
                rbfemale.setSelected(true);
            }
            txtadult.setText(r.getNumberOfAdults() + "");
            txtage.setText(r.getAge() + "");
            txtchildren.setText(r.getNumberOfChildren() + "");
            txtemail.setText(r.getEmail());
            txtfullname.setText(r.getFullName());
            txtno.setText(r.getNumberOfMember() + "");
            txtphone.setText(r.getPhone());
            themmoi = false;
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnfindbyidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfindbyidActionPerformed
        if (ri != null) {
            try {
                RegistrationDTO obj = ri.findByRegistrationID(txtregistrationID.getText());
                if (obj != null) {
                    txtaddress.setText(obj.getAddress());
                    if (obj.isGender()) {
                        rbmale.setSelected(true);
                    } else {
                        rbfemale.setSelected(true);
                    }
                    txtadult.setText(obj.getNumberOfAdults() + "");
                    txtage.setText(obj.getAge() + "");
                    txtchildren.setText(obj.getNumberOfChildren() + "");
                    txtemail.setText(obj.getEmail());
                    txtfullname.setText(obj.getFullName());
                    txtno.setText(obj.getNumberOfMember() + "");
                    txtphone.setText(obj.getPhone());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnfindbyidActionPerformed

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        String name = txtsearch.getText().trim();
        Vector header = new Vector();
        Vector data = new Vector();
        for (RegistrationDTO r : Rlist) {
            if (r.getFullName().contains(name)) {
                Vector row = new Vector();
                row.add(r.getRegistrationID());
                row.add(r.getFullName());
                row.add(r.getAge());
                if (r.isGender()) {
                    row.add("Male");
                } else {
                    row.add("Female");
                }
                row.add(r.getPhone());
                row.add(r.getAddress());
                data.add(row);
            }
        }
        header.add("ID");
        header.add("Full Name");
        header.add("Age");
        header.add("Gender");
        header.add("Phone");
        header.add("Address");

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setDataVector(data, header);
    }//GEN-LAST:event_btnsearchActionPerformed

    private void cbsortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbsortActionPerformed
        if (cbsort.getSelectedIndex() == 0) {
            Collections.sort(Rlist);
            DAO.FileDAO.writeFile(Rlist);
            loadFile();
        } else {
            Collections.sort(Rlist, Collections.reverseOrder());
            DAO.FileDAO.writeFile(Rlist);
            loadFile();
        }
    }//GEN-LAST:event_cbsortActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaddnew;
    private javax.swing.JButton btnfindbyid;
    private javax.swing.JButton btngetalldata;
    private javax.swing.JButton btnremove;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btnsearch;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbsort;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton rbfemale;
    private javax.swing.JRadioButton rbmale;
    private javax.swing.JTextArea txtaddress;
    private javax.swing.JTextField txtadult;
    private javax.swing.JTextField txtage;
    private javax.swing.JTextField txtchildren;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtfullname;
    private javax.swing.JTextField txtno;
    private javax.swing.JTextField txtphone;
    private javax.swing.JTextField txtregistrationID;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables
}
