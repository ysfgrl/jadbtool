/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ysfgrl.jadbtool;

import java.awt.BorderLayout;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author yusuf
 */
public class center_panel extends javax.swing.JPanel {

    /**
     * Creates new form center_panel
     */
    //FileManager fileManager;
    
    Connection_panel connection_panel;
    Apkinstall_panel apkinstall;
    Commands_panel commands_panel;
    
    public center_panel() {
        initComponents();
        apkinstall=new Apkinstall_panel();
        jPanel9.add(apkinstall,BorderLayout.CENTER);
        
        commands_panel=new Commands_panel();
        jPanel1.add(commands_panel,BorderLayout.CENTER);
        
        connection_panel=new Connection_panel();
        jPanel2.add(connection_panel,BorderLayout.CENTER);
    }


    public static void addOutput(String s) {
        Date cl = Calendar.getInstance().getTime();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

        jTextArea1.append(format.format(cl) + " ");
        jTextArea1.append("=> ");

        jTextArea1.append(s);
        jTextArea1.append("\n");
        jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
    }

   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane2 = new javax.swing.JSplitPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel14 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(new java.awt.BorderLayout());

        jSplitPane2.setDividerLocation(500);
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.BorderLayout());
        jTabbedPane1.addTab("Connection", jPanel2);

        jPanel9.setLayout(new java.awt.BorderLayout());
        jTabbedPane1.addTab("install apk", jPanel9);

        jPanel1.setLayout(new java.awt.BorderLayout());
        jTabbedPane1.addTab("Commands", jPanel1);

        jSplitPane2.setLeftComponent(jTabbedPane1);

        jPanel7.setPreferredSize(new java.awt.Dimension(483, 300));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jPanel6.setOpaque(false);
        jPanel6.setLayout(new java.awt.BorderLayout());

        jLabel2.setBackground(new java.awt.Color(102, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Output");
        jLabel2.setOpaque(true);
        jPanel6.add(jLabel2, java.awt.BorderLayout.PAGE_START);

        jTextArea1.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jPanel6.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel7.add(jPanel6, java.awt.BorderLayout.CENTER);

        jSplitPane2.setRightComponent(jPanel7);

        add(jSplitPane2, java.awt.BorderLayout.CENTER);

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Selected Device"));
        jPanel14.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(".");
        jPanel14.add(jLabel1, java.awt.BorderLayout.CENTER);

        add(jPanel14, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}