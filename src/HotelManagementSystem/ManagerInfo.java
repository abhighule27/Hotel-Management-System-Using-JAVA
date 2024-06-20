package HotelManagementSystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ManagerInfo extends JFrame{

    ManagerInfo(){
        //panel
        JPanel panel=new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        //table
        JTable table =new JTable();
        table.setBounds(10,34,980,450);
        table.setForeground(Color.white);
        table.setBackground(new Color(3,45,48));
        panel.add(table);

        try{
            con c =new con();
            String managerInfo="select * from Employee where job= 'manager'";
            ResultSet resultSet=c.statement.executeQuery(managerInfo);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch(Exception e){
            e.printStackTrace();
        }

        //Back Button
        JButton back=new JButton("BACK");
        back.setBounds(400,500,120,30);
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

        //Name label
        JLabel name=new JLabel("Name");
        name.setBounds(41,11,70,19);
        name.setBackground(new Color(3,45,48));
        name.setForeground(Color.white);
        name.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(name);

        //Age label
        JLabel age=new JLabel("Age");
        age.setBounds(159,11,70,19);
        age.setBackground(new Color(3,45,48));
        age.setForeground(Color.white);
        age.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(age);

        //Gender label
        JLabel gender=new JLabel("Gender");
        gender.setBounds(273,11,70,19);
        gender.setBackground(new Color(3,45,48));
        gender.setForeground(Color.white);
        gender.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(gender);

        //Job label
        JLabel job=new JLabel("Job");
        job.setBounds(416,11,70,19);
        job.setBackground(new Color(3,45,48));
        job.setForeground(Color.white);
        job.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(job);

        //Salary label
        JLabel salary=new JLabel("Salary");
        salary.setBounds(536,11,70,19);
        salary.setBackground(new Color(3,45,48));
        salary.setForeground(Color.white);
        salary.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(salary);

        //Phone label
        JLabel phone=new JLabel("Phone");
        phone.setBounds(656,11,70,19);
        phone.setBackground(new Color(3,45,48));
        phone.setForeground(Color.white);
        phone.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(phone);

        //Email label
        JLabel email=new JLabel("Email");
        email.setBounds(786,11,70,19);
        email.setBackground(new Color(3,45,48));
        email.setForeground(Color.white);
        email.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(email);

        //Aadhar label
        JLabel aadhar=new JLabel("Aadhar No.");
        aadhar.setBounds(896,11,150,19);
        aadhar.setBackground(new Color(3,45,48));
        aadhar.setForeground(Color.white);
        aadhar.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(aadhar);


        //frame
        setUndecorated(true);
        setLayout(null);
        setLocation(430,100);
        setSize(1000,600);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ManagerInfo();
    }
}
