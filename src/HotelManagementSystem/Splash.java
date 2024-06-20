package HotelManagementSystem;

import javax.swing.*;

public class Splash extends JFrame {
    Splash(){
        ImageIcon imageaIcon=new ImageIcon(ClassLoader.getSystemResource("icon/splash.gif"));
        JLabel label=new JLabel(imageaIcon);
        label.setBounds(0,0,786,528);
        add(label);

        setLayout(null);
        setLocation(300,80);
        setSize(786,538);
        setVisible(true);

        try{
            Thread.sleep(6000);
            new Login();
            setVisible(false);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Splash();
    }
}
