package HotelManagementSystem;

import com.mysql.cj.jdbc.result.ResultSetImpl;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Pickup extends JFrame {

    Pickup(){
        //Panel
        JPanel panel=new JPanel();
        panel.setBackground(new Color(3,45,48));
        panel.setBounds(5,5,790,590);
        panel.setLayout(null);
        add(panel);

        //Pick up service label
        JLabel pus=new JLabel("PICK UP SERVICE");
        pus.setBounds(90,11,250,25);
        pus.setForeground(Color.white);
        pus.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(pus);

        //Pick up service label
        JLabel toc=new JLabel("Type of Car");
        toc.setBounds(32,97,90,15);
        toc.setForeground(Color.white);
        toc.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(toc);

        Choice c=new Choice();
        c.setBounds(123,94,150,25);
        panel.add(c);

        try{
            con C=new con();
            ResultSet resultSet=C.statement.executeQuery("select * from driver");
            while(resultSet.next()){
                c.add(resultSet.getString("carname"));
            }

        }catch (Exception E){
            E.printStackTrace();
        }

        JTable table=new JTable();
        table.setBounds(10,233,800,250);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.white);
        panel.add(table);

        try{
            con x=new con();
            String q="select * from driver";
            ResultSet resultSet=x.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception E){
            E.printStackTrace();
        }

        //name label
        JLabel name =new JLabel("NAME");
        name.setBounds(24,208,46,14);
        name.setForeground(Color.white);
        panel.add(name);

        //age label
        JLabel age =new JLabel("Age");
        age.setBounds(165,208,46,14);
        age.setForeground(Color.white);
        panel.add(age);

        //gender label
        JLabel gender =new JLabel("GENDER");
        gender.setBounds(264,208,100,14);
        gender.setForeground(Color.white);
        panel.add(gender);

        //company label
        JLabel company =new JLabel("COMPANY");
        company.setBounds(366,208,100,14);
        company.setForeground(Color.white);
        panel.add(company);

        // c name label
        JLabel cname =new JLabel("CAR NAME");
        cname.setBounds(486,208,80,14);
        cname.setForeground(Color.white);
        panel.add(cname);

        //name label
        JLabel available =new JLabel("AVAILABILITY");
        available.setBounds(600,208,100,14);
        available.setForeground(Color.white);
        panel.add(available);

        //location label
        JLabel location =new JLabel("LOCATION");
        location.setBounds(700,208,100,14);
        location.setForeground(Color.white);
        panel.add(location);

        //display button
        JButton display=new JButton("DISPLAY");
        display.setBounds(200,500,120,30);
        display.setBackground(Color.BLACK);
        display.setForeground(Color.white);
        panel.add(display);
        display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q="select * from driver where carname='"+c.getSelectedItem()+"'";
                try{
                    con c =new con();
                    ResultSet resultSet=c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));

                }catch (Exception m){
                    m.printStackTrace();
                }
            }
        });

        //bacck button
        JButton back=new JButton("BACK");
        back.setBounds(420,500,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        //frame
        setUndecorated(true);
        setLayout(null);
        setSize(800,600);
        setLocation(500,100);
        setVisible(true);
    }


    public static void main(String[] args) {
        new Pickup();
    }
}
