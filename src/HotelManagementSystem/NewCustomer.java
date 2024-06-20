package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class NewCustomer extends JFrame implements ActionListener {

    JComboBox comboBox;
    JTextField textFieldNumber,nameText,countryText,textDeposite;
    JRadioButton r1,r2;
    Choice c1;
    JLabel date;
    JButton add,back;
    NewCustomer(){
        //panel
        JPanel panel=new JPanel();
        panel.setBounds(5,5,840,540);
        panel.setLayout(null);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/customer.png"));
        Image image=imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel imgLabel=new JLabel(imageIcon1);
        imgLabel.setBounds(550,150,200,200);
        panel.add(imgLabel);

        JLabel labelName=new JLabel("NEW CUSTOMER FORM");
        labelName.setBounds(118,11,260,53);
        labelName.setFont(new Font("Tahoma",Font.BOLD,20));
        labelName.setForeground(Color.white);
        panel.add(labelName);

        //id label
        JLabel labelID=new JLabel("ID :");
        labelID.setBounds(35,76,200,14);
        labelID.setForeground(Color.WHITE);
        labelID.setFont(new Font("Tahoma",Font.PLAIN,15));
        panel.add(labelID);

        //Dropdown for id
        comboBox=new JComboBox(new String[]{"Passport","Aadhar Card","Voter ID","Driving License"});
        comboBox.setBounds(271,73,150,20);
        comboBox.setBackground(new Color(3,45,48));
        comboBox.setForeground(Color.white);
        comboBox.setFont(new Font("Tahoma",Font.PLAIN,15));
        panel.add(comboBox);

        //id  number label
        JLabel labelNumber=new JLabel("Number :");
        labelNumber.setBounds(35,111,200,14);
        labelNumber.setForeground(Color.WHITE);
        labelNumber.setFont(new Font("Tahoma",Font.PLAIN,15));
        panel.add(labelNumber);

        //text feild for id number
        textFieldNumber=new JTextField();
        textFieldNumber.setBounds(271,111,150,20);
        panel.add(textFieldNumber);

        //Name label
        JLabel labelname=new JLabel("Name :");
        labelname.setBounds(35,151,200,14);
        labelname.setForeground(Color.WHITE);
        labelname.setFont(new Font("Tahoma",Font.PLAIN,15));
        panel.add(labelname);

        //text feild for Name
        nameText=new JTextField();
        nameText.setBounds(271,151,150,20);
        panel.add(nameText);

        //Gender label
        JLabel gender=new JLabel("Gender :");
        gender.setBounds(35,191,200,14);
        gender.setForeground(Color.WHITE);
        gender.setFont(new Font("Tahoma",Font.PLAIN,15));
        panel.add(gender);

        r1=new JRadioButton("MALE");
        r1.setFont(new Font("Tahoma",Font.BOLD,15));
        r1.setForeground(Color.white);
        r1.setBackground(new Color(3,45,48));
        r1.setBounds(271,191,80,12);
        panel.add(r1);

        r2=new JRadioButton("FEMALE");
        r2.setFont(new Font("Tahoma",Font.BOLD,15));
        r2.setForeground(Color.white);
        r2.setBackground(new Color(3,45,48));
        r2.setBounds(350,191,120,12);
        panel.add(r2);

        //Country label
        JLabel country=new JLabel("Country :");
        country.setBounds(35,231,200,18);
        country.setForeground(Color.WHITE);
        country.setFont(new Font("Tahoma",Font.PLAIN,15));
        panel.add(country);

        //text feild for Name
        countryText=new JTextField();
        countryText.setBounds(271,231,150,20);
        panel.add(countryText);

        //Room label
        JLabel labelRoom=new JLabel("Allocated Room Number :");
        labelRoom.setBounds(35,275,200,14);
        labelRoom.setForeground(Color.WHITE);
        labelRoom.setFont(new Font("Tahoma",Font.PLAIN,15));
        panel.add(labelRoom);

        c1=new Choice();
        try{
            con c =new con();
            ResultSet resultSet=c.statement.executeQuery("select * from room");
            while(resultSet.next()){
                c1.add(resultSet.getString("roomnumber"));
            }

        }catch (Exception E){
            E.printStackTrace();
        }

        c1.setBounds(271,274,150,20);
        c1.setFont(new Font("Tahoma",Font.BOLD,15));
        c1.setBackground(new Color(3,45,48));
        c1.setForeground(Color.white);
        panel.add(c1);

        //Check in status label
        JLabel labelCIS=new JLabel("Checked-In Time:");
        labelCIS.setBounds(35,316,300,14);
        labelCIS.setForeground(Color.WHITE);
        labelCIS.setFont(new Font("Tahoma",Font.PLAIN,15));
        panel.add(labelCIS);

        Date date1=new Date();

        date =new JLabel(""+date1);
        date.setBounds(271,316,300,14);
        date.setForeground(Color.WHITE);
        date.setFont(new Font("Tahoma",Font.PLAIN,15));
        panel.add(date);

        //Deposite label
        JLabel labelDeposite=new JLabel("Deposite :");
        labelDeposite.setBounds(35,359,200,14);
        labelDeposite.setForeground(Color.WHITE);
        labelDeposite.setFont(new Font("Tahoma",Font.PLAIN,15));
        panel.add(labelDeposite);

        //text feild for deposite
        textDeposite=new JTextField();
        textDeposite.setBounds(271,359,150,20);
        panel.add(textDeposite);

        //add button
        add=new JButton("ADD");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.white);
        add.setBounds(100,430,120,30);
        add.addActionListener(this);
        panel.add(add);

        //Back button
        back=new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBounds(260,430,120,30);
        back.addActionListener(this);
        panel.add(back);


        //frame
        setUndecorated(true);
        setLayout(null);
        setSize(850,550);
        setLocation(500,150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            con c =new con();
            String radioBtn=null;
            if(r1.isSelected()){
                radioBtn="Male";
            }else if(r2.isSelected()){
                radioBtn="Female";
            }
            String s1=(String) comboBox.getSelectedItem();
            String s2=textFieldNumber.getText();
            String s3=nameText.getText();
            String s4=radioBtn;
            String s5=countryText.getText();
            String s6=c1.getSelectedItem();
            String s7=date.getText();
            String s8=textDeposite.getText();

            try{
                //Insert
                String q="insert into customer values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";

                //update availability
                String q1="update room set availability='Occupied' where roomnumber = "+s6;

                c.statement.executeUpdate(q);
                c.statement.executeUpdate(q1);

                JOptionPane.showMessageDialog(null,"Added Successfully!!");

            }catch (Exception E){
                E.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new NewCustomer();
    }
}
