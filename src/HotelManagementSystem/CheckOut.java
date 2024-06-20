package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class CheckOut extends JFrame {

    CheckOut(){
        //Panel
        JPanel panel=new JPanel();
        panel.setBounds(5,5,790,390);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        //check out label
        JLabel label=new JLabel("Check-Out");
        label.setBounds(100,20,150,30);
        label.setFont(new Font("Tahoma",Font.BOLD,20));
        label.setForeground(Color.white);
        panel.add(label);


        //userID label
        JLabel userID=new JLabel("Customer Id :");
        userID.setBounds(30,80,150,30);
        userID.setFont(new Font("Tahoma",Font.BOLD,14));
        userID.setForeground(Color.white);
        panel.add(userID);

        Choice Customer =new Choice();
        Customer.setBounds(200,85,150,25);
        panel.add(Customer);

        //roomNum label
        JLabel roomNum=new JLabel("Room Number :");
        roomNum.setBounds(30,130,150,30);
        roomNum.setFont(new Font("Tahoma",Font.BOLD,14));
        roomNum.setForeground(Color.white);
        panel.add(roomNum);

        //roomNum label
        JLabel labelroomNum=new JLabel();
        labelroomNum.setBounds(200,130,150,30);
        labelroomNum.setFont(new Font("Tahoma",Font.BOLD,14));
        labelroomNum.setForeground(Color.white);
        panel.add(labelroomNum);

        //checkintime label
        JLabel checkintime=new JLabel("Check-In Time :");
        checkintime.setBounds(30,180,150,30);
        checkintime.setFont(new Font("Tahoma",Font.BOLD,14));
        checkintime.setForeground(Color.white);
        panel.add(checkintime);

        //checkintime label
        JLabel labelcheckintime=new JLabel();
        labelcheckintime.setBounds(200,180,300,30);
        labelcheckintime.setFont(new Font("Tahoma",Font.BOLD,14));
        labelcheckintime.setForeground(Color.white);
        panel.add(labelcheckintime);

        //checkouttime label
        JLabel checkouttime=new JLabel("Check-Out Time :");
        checkouttime.setBounds(30,230,150,30);
        checkouttime.setFont(new Font("Tahoma",Font.BOLD,14));
        checkouttime.setForeground(Color.white);
        panel.add(checkouttime);

        Date date=new Date();

        //labelcheckouttime label
        JLabel labelcheckouttime=new JLabel(""+date);
        labelcheckouttime.setBounds(200,230,300,30);
        labelcheckouttime.setFont(new Font("Tahoma",Font.BOLD,14));
        labelcheckouttime.setForeground(Color.white);
        panel.add(labelcheckouttime);

        try{
            con c =new con();
            ResultSet resultSet=c.statement.executeQuery("select * from customer");
            while(resultSet.next()){
                Customer.add(resultSet.getString("number"));
            }

        }catch (Exception E){
            E.printStackTrace();
        }

        //checkout button
        JButton checkOut=new JButton("CHECK OUT");
        checkOut.setBounds(30,300,120,30);
        checkOut.setForeground(Color.white);
        checkOut.setBackground(Color.BLACK);
        panel.add(checkOut);
        checkOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    con cv=new con();
                    cv.statement.executeUpdate("delete from customer where number='"+Customer.getSelectedItem()+"'");
                    cv.statement.executeUpdate("update room set availability ='Available' where roomnumber='"+labelroomNum.getText()+"'");
                    JOptionPane.showMessageDialog(null,"DONE!!");
                    setVisible(false);
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        //check button
        JButton check=new JButton("CHECK");
        check.setBounds(300,300,120,30);
        check.setForeground(Color.white);
        check.setBackground(Color.BLACK);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                con c=new con();

                try{
                    ResultSet resultSet=c.statement.executeQuery("select * from customer where number='"+Customer.getSelectedItem()+"'");
                    while (resultSet.next()){
                        labelroomNum.setText(resultSet.getString("room"));
                        labelcheckintime.setText(resultSet.getString("checkintime"));
                    }

                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        //back button
        JButton back=new JButton("BACK");
        back.setBounds(170,300,120,30);
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        //Frame
        setUndecorated(true);
        setLayout(null);
        setSize(800,400);
        setLocation(500,210);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CheckOut();
    }
}
