package HotelManagementSystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame implements ActionListener {

    JCheckBox checkBox;
    Choice choice;
    JTable table;
    JButton search,back;

    SearchRoom(){
        //Panel
        JPanel panel=new JPanel();
        panel.setBackground(new Color(3,45,48));
        panel.setBounds(5,5,690,490);
        panel.setLayout(null);
        add(panel);

        // Head Label
        JLabel searchRoom=new JLabel("Search For Room");
        searchRoom.setBounds(250,11,186,31);
        searchRoom.setForeground(Color.white);
        searchRoom.setFont(new Font("Tahomna",Font.BOLD,20));
        panel.add(searchRoom);

        //bed type Label
        JLabel rbt=new JLabel("Room Bed Type :");
        rbt.setBounds(30,73,130,20);
        rbt.setForeground(Color.white);
        rbt.setFont(new Font("Tahomna",Font.BOLD,14));
        panel.add(rbt);

        //room number Label
        JLabel rn=new JLabel("Room Number");
        rn.setBounds(18,162,150,20);
        rn.setForeground(Color.white);
        rn.setFont(new Font("Tahomna",Font.BOLD,14));
        panel.add(rn);

        //Availability Label
        JLabel available=new JLabel("Availability");
        available.setBounds(175,162,150,20);
        available.setForeground(Color.white);
        available.setFont(new Font("Tahomna",Font.BOLD,14));
        panel.add(available);

        //clean status Label
        JLabel cl=new JLabel("Clean Status");
        cl.setBounds(306,162,150,20);
        cl.setForeground(Color.white);
        cl.setFont(new Font("Tahomna",Font.BOLD,14));
        panel.add(cl);

        //price Label
        JLabel price=new JLabel("Price");
        price.setBounds(458,162,150,20);
        price.setForeground(Color.white);
        price.setFont(new Font("Tahomna",Font.BOLD,14));
        panel.add(price);

        //bed type Label
        JLabel bt=new JLabel("Bed Type");
        bt.setBounds(580,162,150,20);
        bt.setForeground(Color.white);
        bt.setFont(new Font("Tahomna",Font.BOLD,14));
        panel.add(bt);

        checkBox=new JCheckBox("Only Display Available");
        checkBox.setBounds(400,69,205,23);
        checkBox.setForeground(Color.white);
        checkBox.setBackground(new Color(3,45,48));
        panel.add(checkBox);

        choice=new Choice();
        choice.add("Single Bed");
        choice.add("Double Bed");
        choice.setBounds(167,75,120,20);
        panel.add(choice);

        table=new JTable();
        table.setBounds(0,187,700,150);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.white);
        panel.add(table);

        try{
            con c =new con();
            String q="select * from room";
            ResultSet resultSet=c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception E){
            E.printStackTrace();
        }

        //search button
        search=new JButton("SEARCH");
        search.setBackground(Color.BLACK);
        search.setForeground(Color.white);
        search.setBounds(200,400,120,30);
        search.addActionListener(this);
        panel.add(search);

        //back button
        back=new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBounds(380,400,120,30);
        back.addActionListener(this);
        panel.add(back);

        //Frame
        setUndecorated(true);
        setLayout(null);
        setLocation(500,200);
        setSize(700,500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==search){
            String Q ="select * from room where bed_type='"+choice.getSelectedItem()+"'";
            String Q1="select * from room where availability ='Available' and bed_type='"+choice.getSelectedItem()+"'";
            try{
                con c =new con();
                ResultSet resultSet=c.statement.executeQuery(Q);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));

                if(checkBox.isSelected()){
                    ResultSet resultSet1=c.statement.executeQuery(Q1);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet1));

                }
            }catch (Exception E){
                E.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new SearchRoom();
    }
}
