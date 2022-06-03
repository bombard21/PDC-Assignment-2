/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package AirlineTicketBookingSystemGUI;

import dataBaseCode.DBWriter;

import static AirlineTicketBookingSystemGUI.Booking.booking;

/**
 *
 * @author wangx
 */
public class User extends javax.swing.JFrame {

    /**
     * Creates new form User
     */
    public User() {
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

        BookingButton = new javax.swing.JButton();
        flightDataButton = new javax.swing.JButton();
        ticketButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BookingButton.setText("Booking");
        BookingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookingButtonActionPerformed(evt);
            }
        });

        flightDataButton.setText("Flight Data");
        flightDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flightDataButtonActionPerformed(evt);
            }
        });

        ticketButton.setText("Ticket");
        ticketButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ticketButtonActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AirlineImages/airplane-plane-flight-900.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(830, 830, 830)
                        .addComponent(ticketButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(620, 620, 620)
                        .addComponent(BookingButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(709, 709, 709)
                        .addComponent(flightDataButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ticketButton)
                    .addComponent(BookingButton)
                    .addComponent(flightDataButton))
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BookingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookingButtonActionPerformed
        // TODO add your handling code here:
        if(evt.getSource()== BookingButton){
            booking = new Booking(new DBWriter());
            booking.setVisible(true);
        }
    }//GEN-LAST:event_BookingButtonActionPerformed

    private void flightDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flightDataButtonActionPerformed
        // TODO add your handling code here:
        if (evt.getSource() == flightDataButton){
            dispose();
            flightDataBaseSearch flightSearch = new flightDataBaseSearch();
            flightSearch.setVisible(true);
        }
    }//GEN-LAST:event_flightDataButtonActionPerformed

    private void ticketButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ticketButtonActionPerformed
        // TODO add your handling code here:
        if(evt.getSource() == ticketButton){
            dispose();
            ticketDataBaseSearch ticketSearch = new ticketDataBaseSearch();
            ticketSearch.setVisible(true);
        }
    }//GEN-LAST:event_ticketButtonActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BookingButton;
    private javax.swing.JButton flightDataButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton ticketButton;
    // End of variables declaration//GEN-END:variables

}
