package HotelManagementSystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CustomerInfo extends JFrame {

    CustomerInfo(){

        //panel
        JPanel panel=new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        JTable table=new JTable();
        table.setBounds(10,40,900,450);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.white);
        panel.add(table);

        try{
            con c =new con();
            String q ="select * from customer";
            ResultSet resultSet=c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch(Exception E){
            E.printStackTrace();
        }

        //id label
        JLabel id =new JLabel("ID");
        id.setBounds(31,11,46,14);
        id.setForeground(Color.WHITE);
        id.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(id);

        //id no. label
        JLabel idn =new JLabel("ID NO.");
        idn.setBounds(150,11,70,14);
        idn.setForeground(Color.WHITE);
        idn.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(idn);

        //name label
        JLabel name =new JLabel("NAME");
        name.setBounds(270,11,70,14);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(name);

        //gender label
        JLabel gender =new JLabel("GENDER");
        gender.setBounds(360,11,70,14);
        gender.setForeground(Color.WHITE);
        gender.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(gender);

        //country label
        JLabel country =new JLabel("COUNTRY");
        country.setBounds(480,11,100,14);
        country.setForeground(Color.WHITE);
        country.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(country);

        //Room No label
        JLabel roomno =new JLabel("ROOM NO.");
        roomno.setBounds(580,11,100,14);
        roomno.setForeground(Color.WHITE);
        roomno.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(roomno);

        //Check in timelabel
        JLabel checkin =new JLabel("CHECK-IN");
        checkin.setBounds(690,11,100,14);
        checkin.setForeground(Color.WHITE);
        checkin.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(checkin);

        //deposit label
        JLabel deposit =new JLabel("DEPOSIT");
        deposit.setBounds(800,11,70,14);
        deposit.setForeground(Color.WHITE);
        deposit.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(deposit);

        //back button
        JButton back=new JButton("BACK");
        back.setBounds(450,510,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        panel.add(back);

        //frame
        setUndecorated(true);
        setLayout(null);
        setSize(900,600);
        setLocation(500,100);
        setVisible(true);
    }


    public static void main(String[] args) {
        new CustomerInfo();
    }
}
