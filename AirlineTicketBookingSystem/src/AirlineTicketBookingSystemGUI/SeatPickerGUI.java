///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package AirlineTicketBookingSystemGUI;
//
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.Graphics;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//
///**
// *
// * @author Xiaofeng Wang
// */
//public class SeatPickerGUI extends JFrame{
//    public JButton [][] seat;
//    private final DrawPanel drawPanel;
//    
//    
//    public SeatPickerGUI(){
//        drawPanel = new DrawPanel();
//        drawPanel.repaint();
//        
//        seat = new JButton[100][100];
//        for (int row = 0; row < seat.length; row++) {
//            for (int col = 0; col < seat[row].length; col++) {
//                seat[row][col] = new JButton();
//            }
//        }
//        super.add(drawPanel);
//        
//    }
//    
//    public class DrawPanel extends JPanel {
//        public DrawPanel() {
//            super.setPreferredSize(new Dimension(400, 400));
//        }
//        @Override
//        protected void paintComponent(Graphics g) {
//            super.paintComponent(g);
//            for(int row = 0; row < seat.length; row++) {
//                for(int col = 0; col < seat[row].length; col++) {
//                        seat[row][col].setBounds(row*1, col*30, 30, 30);
//                }
//            }
//        }
//    }
//    
//    public static void main (String[] args){
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new SeatPickerGUI().setVisible(true);
//                
//            }
//        });
//    }
//    
//}
