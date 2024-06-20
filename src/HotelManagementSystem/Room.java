package HotelManagementSystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Room extends JFrame {

    JTable table;
    JButton back;

    Room(){

        //panel
        JPanel panel=new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        //Room image
        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/roomm.png"));
        Image image=imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(600,200,200,200);
        panel.add(label);

        //Table
        table=new JTable();
        table.setBounds(10,40,500,400);
        table.setBackground(new Color(3, 45, 48));
        table.setForeground(Color.white);
        panel.add(table);

        try{
            con c=new con();
            String RoomInfo="select * from room";
            ResultSet resultSet=c.statement.executeQuery(RoomInfo);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }

        //Back button
        back=new JButton("BACK");
        back.setBounds(200,500,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==back){
                    setVisible(false);
                }
            }
        });

        //Room no label
        JLabel roomNo=new JLabel("Room No");
        roomNo.setBounds(18,15,150,19);
        roomNo.setForeground(Color.white);
        roomNo.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(roomNo);

        //Availability label
        JLabel available=new JLabel("Availability");
        available.setBounds(119,15,80,19);
        available.setForeground(Color.white);
        available.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(available);

        //Clean status label
        JLabel clean=new JLabel("Clean Status");
        clean.setBounds(216,15,150,19);
        clean.setForeground(Color.white);
        clean.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(clean);

        //Price label
        JLabel price=new JLabel("Price");
        price.setBounds(330,15,150,19);
        price.setForeground(Color.white);
        price.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(price);

        //Price label
        JLabel bedType=new JLabel("Bed Type");
        bedType.setBounds(417,15,150,19);
        bedType.setForeground(Color.white);
        bedType.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(bedType);



        //frame
        setUndecorated(true);
        setLayout(null);
        setLocation(500,100);
        setSize(900,600);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Room();
    }
}
