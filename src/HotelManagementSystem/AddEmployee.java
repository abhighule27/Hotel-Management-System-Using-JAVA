package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField nameText,ageText,salaryText,phoneText,aadharText,emailText;

    JRadioButton radioButtonM,radioButtonF;
    JComboBox comboBox;
    JButton add,back;

    AddEmployee(){
        //Panel
        JPanel panel=new JPanel();
        panel.setBounds(5,5,890,490);
        panel.setLayout(null);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        //name label
        JLabel name = new JLabel("NAME");
        name.setBounds(60,30,150,27);
        name.setFont(new Font("serif",Font.BOLD,17));
        name.setForeground(Color.white);
        panel.add(name);

        //name textfeild
        nameText=new JTextField();
        nameText.setBounds(200,30,150,27);
        nameText.setBackground(new Color(16,108,115));
        nameText.setForeground(Color.white);
        nameText.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(nameText);

        //Age label
        JLabel Age = new JLabel("AGE");
        Age.setBounds(60,80,150,27);
        Age.setFont(new Font("serif",Font.BOLD,17));
        Age.setForeground(Color.white);
        panel.add(Age);

        //age textfeild
        ageText=new JTextField();
        ageText.setBounds(200,80,150,27);
        ageText.setBackground(new Color(16,108,115));
        ageText.setForeground(Color.white);
        ageText.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(ageText);

        //Gender label
        JLabel gender = new JLabel("GENDER");
        gender.setBounds(60,120,150,27);
        gender.setFont(new Font("serif",Font.BOLD,17));
        gender.setForeground(Color.white);
        panel.add(gender);

        //Male RadioButton
        radioButtonM=new JRadioButton("MALE");
        radioButtonM.setBounds(200,120,70,27);
        radioButtonM.setBackground(new Color(3,45,48));
        radioButtonM.setFont(new Font("Tahoma",Font.BOLD,14));
        radioButtonM.setForeground(Color.white);
        panel.add(radioButtonM);

        //Female RadioButton
        radioButtonF=new JRadioButton("FEMALE");
        radioButtonF.setBounds(280,120,100,27);
        radioButtonF.setBackground(new Color(3,45,48));
        radioButtonF.setFont(new Font("Tahoma",Font.BOLD,14));
        radioButtonF.setForeground(Color.white);
        panel.add(radioButtonF);

        //Job label
        JLabel job = new JLabel("JOB");
        job.setBounds(60,170,150,27);
        job.setFont(new Font("serif",Font.BOLD,17));
        job.setForeground(Color.white);
        panel.add(job);

        //DropDown for Job
        comboBox=new JComboBox(new String[]{"Front Desk","HouseKeeping","Kitchen Staff","Room Service","Manager","Accountant","Chef"});
        comboBox.setBackground(new Color(16,108,115));
        comboBox.setBounds(200,170,150,30);
        comboBox.setFont(new Font("Tahoma",Font.BOLD,14));
        comboBox.setForeground(Color.white);
        panel.add(comboBox);

        //Salary label
        JLabel salary = new JLabel("SALARY");
        salary.setBounds(60,220,150,27);
        salary.setFont(new Font("serif",Font.BOLD,17));
        salary.setForeground(Color.white);
        panel.add(salary);

        //salary textfeild
        salaryText=new JTextField();
        salaryText.setBounds(200,220,150,27);
        salaryText.setBackground(new Color(16,108,115));
        salaryText.setForeground(Color.white);
        salaryText.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(salaryText);

        //Phone label
        JLabel phone = new JLabel("PHONE");
        phone.setBounds(60,270,150,27);
        phone.setFont(new Font("serif",Font.BOLD,17));
        phone.setForeground(Color.white);
        panel.add(phone);

        //phone textfeild
        phoneText=new JTextField();
        phoneText.setBounds(200,270,150,27);
        phoneText.setBackground(new Color(16,108,115));
        phoneText.setForeground(Color.white);
        phoneText.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(phoneText);

        //AADHAR label
        JLabel aadhar = new JLabel("AADHAR");
        aadhar.setBounds(60,320,150,27);
        aadhar.setFont(new Font("serif",Font.BOLD,17));
        aadhar.setForeground(Color.white);
        panel.add(aadhar);

        //AADHAR textfeild
        aadharText=new JTextField();
        aadharText.setBounds(200,320,150,27);
        aadharText.setBackground(new Color(16,108,115));
        aadharText.setForeground(Color.white);
        aadharText.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(aadharText);

        //Email label
        JLabel email = new JLabel("EMAIL");
        email.setBounds(60,370,150,27);
        email.setFont(new Font("serif",Font.BOLD,17));
        email.setForeground(Color.white);
        panel.add(email);

        //Email textfeild
        emailText=new JTextField();
        emailText.setBounds(200,370,150,27);
        emailText.setBackground(new Color(16,108,115));
        emailText.setForeground(Color.white);
        emailText.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(emailText);

        //ADD EMPLOYEE label
        JLabel AED = new JLabel("ADD EMPLOYEE DETAILS");
        AED.setBounds(450,24,445,35);
        AED.setFont(new Font("Tahoma",Font.BOLD,31));
        AED.setForeground(Color.white);
        panel.add(AED);

        //ADD Button
        add=new JButton("ADD");
        add.setBounds(80,420,100,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.white);
        add.addActionListener(this);
        panel.add(add);

        //BACK Button
        back=new JButton("BACK");
        back.setBounds(200,420,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(this);
        panel.add(back);

        //image
        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/addemp.png"));
        Image image=imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(500,100,300,300);
        panel.add(label);

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
            String aadhar=aadharText.getText();
            String age=ageText.getText();
            String salary=salaryText.getText();
            String phone=phoneText.getText();
            String email=emailText.getText();
            String job=(String)comboBox.getSelectedItem();
            String gender=null;
            if(radioButtonM.isSelected()){
                gender="Male";
            } else if (radioButtonF.isSelected()) {
                gender="Female";
            }
            try{
                con c=new con();
                String q="insert into employee value('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Employee Added");
                setVisible(false);


            }catch (Exception E){
                E.printStackTrace();
            }

        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
