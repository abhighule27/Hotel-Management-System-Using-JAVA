package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateRooms extends JFrame {

    UpdateRooms(){
        //panel
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(3,45,48));
        panel.setBounds(5,5,940,440);
        add(panel);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/update.png"));
        Image image=imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(500,60,300,300);
        panel.add(label);

        //label
        JLabel label1=new JLabel("Update Room Status");
        label1.setBounds(124,11,222,25);
        label1.setFont(new Font("Tahoma",Font.BOLD,20));
        label1.setForeground(Color.white);
        panel.add(label1);

        // id label
        JLabel label2=new JLabel("ID :");
        label2.setBounds(25,88,50,14);
        label2.setFont(new Font("Tahoma",Font.PLAIN,14));
        label2.setForeground(Color.white);
        panel.add(label2);

        Choice c=new Choice();
        c.setBounds(248,85,140,20);
        panel.add(c);

        try{
            con C=new con();
            ResultSet resultSet=C.statement.executeQuery("select * from customer");
            while (resultSet.next()){
                c.add(resultSet.getString("number"));
            }

        }catch (Exception E){
            E.printStackTrace();
        }

        //roomno label
        JLabel roomno=new JLabel("Room No :");
        roomno.setBounds(25,129,107,14);
        roomno.setFont(new Font("Tahoma",Font.PLAIN,14));
        roomno.setForeground(Color.white);
        panel.add(roomno);

        JTextField troom=new JTextField();
        troom.setBounds(248,129,120,20);
        panel.add(troom);

        //name label
        JLabel name=new JLabel("Availability :");
        name.setBounds(25,174,97,14);
        name.setFont(new Font("Tahoma",Font.PLAIN,14));
        name.setForeground(Color.white);
        panel.add(name);

        JTextField tname=new JTextField();
        tname.setBounds(248,174,120,20);
        panel.add(tname);


        //cheked in label
        JLabel chekedin=new JLabel("Clean-Status :");
        chekedin.setBounds(25,216,107,14);
        chekedin.setFont(new Font("Tahoma",Font.PLAIN,14));
        chekedin.setForeground(Color.white);
        panel.add(chekedin);

        JTextField chekedint=new JTextField();
        chekedint.setBounds(248,216,120,20);
        panel.add(chekedint);


        //update button
        JButton update =new JButton("UPDATE");
        update.setBounds(120,315,89,23);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.white);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    con C=new con();
                    String status=chekedint.getText();
                    C.statement.executeUpdate("update room set cleaning_status='"+status+"' where roomnumber="+troom.getText());


                    JOptionPane.showMessageDialog(null,"Updated Successfully!!");


                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        //back button
        JButton back =new JButton("BACK");
        back.setBounds(180,355,89,23);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        //check button
        JButton check =new JButton("CHECK");
        check.setBounds(60,355,89,23);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.white);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id=c.getSelectedItem();
                String q="select * from customer where number='"+id+"'";
                try{
                    con C=new con();
                    ResultSet resultSet=C.statement.executeQuery(q);

                    while(resultSet.next()){
                        troom.setText(resultSet.getString("room"));

                    }

                    ResultSet resultSet1=C.statement.executeQuery("select * from room where roomnumber='"+troom.getText()+"'");

                    while(resultSet1.next()){
                        tname.setText(resultSet1.getString("availability"));
                        chekedint.setText(resultSet1.getString("cleaning_status"));
                    }

                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        //frame
        setUndecorated(true);
        setLayout(null);
        setSize(950,450);
        setLocation(400,200);
        setVisible(true);
    }


    public static void main(String[] args) {
        new UpdateRooms();
    }
}
