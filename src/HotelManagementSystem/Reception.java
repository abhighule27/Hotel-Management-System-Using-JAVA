package HotelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame {

    Reception(){

        //Right side panel
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(280,5,1238,820);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        //Left side panel
        JPanel panel1=new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5,5,270,820);
        panel1.setBackground(new Color(3,45,48));
        add(panel1);

        //gif on right panel
        ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("icon/raw.png"));
        Image i2=i11.getImage().getScaledInstance(350,350, Image.SCALE_DEFAULT);
        ImageIcon imageIcon11=new ImageIcon(i2);
        JLabel label1=new JLabel(imageIcon11);
        label1.setBounds(300,20,800,800);
        panel.add(label1);

        //gif on left panel
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/loginn.png"));
        Image i=i1.getImage().getScaledInstance(250,250, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(i);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(5,530,250,250);
        panel1.add(label);

        //New Customer Form Button
        JButton btnNCF = new JButton("New Customer Form");
        btnNCF.setBounds(30,30,200,30);
        btnNCF.setBackground(Color.BLACK);
        btnNCF.setForeground(Color.white);
        panel1.add(btnNCF);
        btnNCF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new NewCustomer();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        //Room Button
        JButton btnRoom = new JButton("Room");
        btnRoom.setBounds(30,70,200,30);
        btnRoom.setBackground(Color.BLACK);
        btnRoom.setForeground(Color.white);
        panel1.add(btnRoom);
        btnRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new Room();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        //Department Button
        JButton btnDepartment = new JButton("Department");
        btnDepartment.setBounds(30,110,200,30);
        btnDepartment.setBackground(Color.BLACK);
        btnDepartment.setForeground(Color.white);
        panel1.add(btnDepartment);
        btnDepartment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new Department();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        //All Employee INFO Button
        JButton btnAEI = new JButton("All Employee Info");
        btnAEI.setBounds(30,150,200,30);
        btnAEI.setBackground(Color.BLACK);
        btnAEI.setForeground(Color.white);
        panel1.add(btnAEI);
        btnAEI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new Employee();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        //Customer Info Button
        JButton btnCI = new JButton("Customer Info");
        btnCI.setBounds(30,190,200,30);
        btnCI.setBackground(Color.BLACK);
        btnCI.setForeground(Color.white);
        panel1.add(btnCI);
        btnCI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new CustomerInfo();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        //Manager Info Button
        JButton btnMI = new JButton("Manager Info");
        btnMI.setBounds(30,230,200,30);
        btnMI.setBackground(Color.BLACK);
        btnMI.setForeground(Color.white);
        panel1.add(btnMI);
        btnMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new ManagerInfo();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        //CheckOut Button
        JButton btnCO = new JButton("Check Out");
        btnCO.setBounds(30,270,200,30);
        btnCO.setBackground(Color.BLACK);
        btnCO.setForeground(Color.white);
        panel1.add(btnCO);
        btnCO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new CheckOut();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        //UpDate Checkin Details Button
        JButton btnUC = new JButton("Update Check-in Details");
        btnUC.setBounds(30,310,200,30);
        btnUC.setBackground(Color.BLACK);
        btnUC.setForeground(Color.white);
        panel1.add(btnUC);
        btnUC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new UpdateCheck();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        //UpDate Room Status Button
        JButton btnURS = new JButton("Update Room Status");
        btnURS.setBounds(30,350,200,30);
        btnURS.setBackground(Color.BLACK);
        btnURS.setForeground(Color.white);
        panel1.add(btnURS);
        btnURS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new UpdateRooms();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        //Pickup servie Button
        JButton btnPUS = new JButton("Pick up Service");
        btnPUS.setBounds(30,390,200,30);
        btnPUS.setBackground(Color.BLACK);
        btnPUS.setForeground(Color.white);
        panel1.add(btnPUS);
        btnPUS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new Pickup();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        //Search Room  Button
        JButton btnSR = new JButton("Search Room");
        btnSR.setBounds(30,430,200,30);
        btnSR.setBackground(Color.BLACK);
        btnSR.setForeground(Color.white);
        panel1.add(btnSR);
        btnSR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new SearchRoom();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        //LOGOUT  Button
        JButton logout = new JButton("LOGOUT");
        logout.setBounds(30,470,95,30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.white);
        panel1.add(logout);
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    System.exit(7);
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        //back  Button
        JButton back = new JButton("BACK");
        back.setBounds(140,470,95,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        panel1.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    setVisible(false);
                    new Dashboard();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });



        getContentPane().setBackground(Color.white);
        setLayout(null);
        setSize(1950,1090);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Reception();
    }
}
