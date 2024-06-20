package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCheck extends JFrame {

    UpdateCheck (){
        //panel
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(3,45,48));
        panel.setBounds(5,5,940,490);
        add(panel);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image image=imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(500,60,300,300);
        panel.add(label);

        //label
        JLabel label1=new JLabel("Check-In Details");
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
        JLabel name=new JLabel("Name :");
        name.setBounds(25,174,97,14);
        name.setFont(new Font("Tahoma",Font.PLAIN,14));
        name.setForeground(Color.white);
        panel.add(name);

        JTextField tname=new JTextField();
        tname.setBounds(248,174,120,20);
        panel.add(tname);


        //cheked in label
        JLabel chekedin=new JLabel("Checked-In :");
        chekedin.setBounds(25,216,107,14);
        chekedin.setFont(new Font("Tahoma",Font.PLAIN,14));
        chekedin.setForeground(Color.white);
        panel.add(chekedin);

        JTextField chekedint=new JTextField();
        chekedint.setBounds(248,216,120,20);
        panel.add(chekedint);

        //amt  paid label
        JLabel amtP=new JLabel("Amount Paid (RS) :");
        amtP.setBounds(25,261,150,20);
        amtP.setFont(new Font("Tahoma",Font.PLAIN,14));
        amtP.setForeground(Color.white);
        panel.add(amtP);

        JTextField amtPt=new JTextField();
        amtPt.setBounds(248,261,120,20);
        panel.add(amtPt);

        //amt pending label
        JLabel amt=new JLabel("Pending Amount (RS) :");
        amt.setBounds(25,302,150,20);
        amt.setFont(new Font("Tahoma",Font.PLAIN,14));
        amt.setForeground(Color.white);
        panel.add(amt);

        JTextField amtt=new JTextField();
        amtt.setBounds(248,302,120,20);
        panel.add(amtt);


        //update
        JButton update =new JButton("UPDATE");
        update.setBounds(56,378,89,23);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.white);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    con C=new con();
                    String q=c.getSelectedItem();
                    String room=troom.getText();
                    String name=tname.getText();
                    String check=chekedint.getText();
                    String amount=amtPt.getText();

                    C.statement.executeUpdate("update customer set room ='"+room+"',name='"+name+"',checkintime='"+check+"',deposit='"+amount+"' where number='"+q+"'" );
                    JOptionPane.showMessageDialog(null,"Updated Successfully!!");


                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        //back
        JButton back =new JButton("BACK");
        back.setBounds(168,378,89,23);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        //check
        JButton check =new JButton("CHECK");
        check.setBounds(281,378,89,23);
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
                        tname.setText(resultSet.getString("name"));
                        chekedint.setText(resultSet.getString("checkintime"));
                        amtPt.setText(resultSet.getString("deposit"));
                    }

                    ResultSet resultSet1=C.statement.executeQuery("select * from room where roomnumber='"+troom.getText()+"'");

                    while(resultSet1.next()){
                        String price=resultSet1.getString("price");
                        int amountPaid=Integer.parseInt(price)-Integer.parseInt(amtPt.getText());
                        amtt.setText(""+amountPaid);
                    }

                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        //frame
        setUndecorated(true);
        setLayout(null);
        setSize(950,500);
        setLocation(400,200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new UpdateCheck();
    }
}
