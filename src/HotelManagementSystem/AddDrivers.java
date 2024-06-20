package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDrivers extends JFrame implements ActionListener {

    JTextField nameText,ageText,carCText,carNText,carLText;
    JComboBox comboBox,comboBox1;
    JButton add,back;

    AddDrivers(){
        //Panel
        JPanel panel=new JPanel();
        panel.setBounds(5,5,890,490);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        //Add Drivers label
        JLabel label=new JLabel("ADD DRIVERS");
        label.setBounds(194,12,200,22);
        label.setForeground(Color.white);
        label.setFont(new Font("Tahoma",Font.BOLD,22));
        panel.add(label);

        //Name label
        JLabel name=new JLabel("NAME");
        name.setBounds(64,70,102,22);
        name.setForeground(Color.white);
        name.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(name);

        //Name TextField
        nameText=new JTextField();
        nameText.setBounds(174,70,156,20);
        nameText.setBackground(new Color(16,108,115));
        nameText.setForeground(Color.white);
        nameText.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(nameText);

        //Age label
        JLabel age=new JLabel("AGE");
        age.setBounds(64,110,102,22);
        age.setForeground(Color.white);
        age.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(age);

        //Age TextField
        ageText=new JTextField();
        ageText.setBounds(174,110,156,20);
        ageText.setBackground(new Color(16,108,115));
        ageText.setForeground(Color.white);
        ageText.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(ageText);

        //Gender label
        JLabel gender=new JLabel("GENDER");
        gender.setBounds(64,150,102,22);
        gender.setForeground(Color.white);
        gender.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(gender);

        //Dropdown for gender
        comboBox=new JComboBox(new String[]{"Male","Female"});
        comboBox.setBounds(176,150,154,20);
        comboBox.setBackground(new Color(16,108,115));
        comboBox.setForeground(Color.white);
        comboBox.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(comboBox);

        //Car Company label
        JLabel carC=new JLabel("CAR COMPANY");
        carC.setBounds(64,190,120,22);
        carC.setForeground(Color.white);
        carC.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(carC);

        //car company type TextField
        carCText=new JTextField();
        carCText.setBounds(174,190,156,20);
        carCText.setBackground(new Color(16,108,115));
        carCText.setForeground(Color.white);
        carCText.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(carCText);

        //Car Name label
        JLabel carN=new JLabel("CAR NAME");
        carN.setBounds(64,230,120,22);
        carN.setForeground(Color.white);
        carN.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(carN);

        //car name TextField
        carNText=new JTextField();
        carNText.setBounds(174,230,156,20);
        carNText.setBackground(new Color(16,108,115));
        carNText.setForeground(Color.white);
        carNText.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(carNText);

        //Availability label
        JLabel available=new JLabel("AVAILABLE");
        available.setBounds(64,270,102,22);
        available.setForeground(Color.white);
        available.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(available);

        //Dropdown for gender
        comboBox1=new JComboBox(new String[]{"YES","NO"});
        comboBox1.setBounds(176,270,154,20);
        comboBox1.setBackground(new Color(16,108,115));
        comboBox1.setForeground(Color.white);
        comboBox1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(comboBox1);

        //Car Location label
        JLabel carL=new JLabel("LOCATION");
        carL.setBounds(64,310,120,22);
        carL.setForeground(Color.white);
        carL.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(carL);

        //car Loation TextField
        carLText=new JTextField();
        carLText.setBounds(174,310,156,20);
        carLText.setBackground(new Color(16,108,115));
        carLText.setForeground(Color.white);
        carLText.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(carLText);

        //ADD Button
        add=new JButton("ADD");
        add.setBounds(64,380,100,33);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.white);
        add.addActionListener(this);
        panel.add(add);

        //BACK Button
        back=new JButton("BACK");
        back.setBounds(200,380,100,33);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(this);
        panel.add(back);

        //Image icon
        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/license.png"));
        Image image=imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel label1=new JLabel(imageIcon1);
        label1.setBounds(500,60,300,300);
        panel.add(label1);

        //Frame
        setUndecorated(true);
        setLocation(60,160);
        setLayout(null);
        setSize(900,500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            String name=nameText.getText();
            String age=ageText.getText();
            String gender=(String)comboBox.getSelectedItem();
            String company=carCText.getText();
            String carname=carNText.getText();
            String available=(String)comboBox1.getSelectedItem();
            String location=carLText.getText();

            try{
                con c =new con();
                String q ="insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+carname+"','"+available+"','"+location+"')";
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Driver Added Successfully!!");
                setVisible(false);
            }catch(Exception E){

            }

        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddDrivers();
    }
}
