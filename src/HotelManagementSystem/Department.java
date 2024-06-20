package HotelManagementSystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame {

    Department(){
        //Panel
        JPanel panel=new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        JTable table=new JTable();
        table.setBounds(0,40,700,350);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.white);
        panel.add(table);

        try{
            con c=new con();
            String departmentInfo="select * from department";
            ResultSet resultSet=c.statement.executeQuery(departmentInfo);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }

        JButton back=new JButton("BACK");
        back.setBounds(400,410,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==back){
                    setVisible(false);
                }
            }
        });

        //Dept label
        JLabel deptName=new JLabel("Department");
        deptName.setBounds(145,11,105,20);
        deptName.setForeground(Color.white);
        deptName.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(deptName);

        //Budget label
        JLabel budget=new JLabel("Budget");
        budget.setBounds(431,11,105,20);
        budget.setForeground(Color.white);
        budget.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(budget);


        //Frame
        setUndecorated(true);
        setLayout(null);
        setLocation(550,150);
        setSize(700,500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Department();
    }
}
