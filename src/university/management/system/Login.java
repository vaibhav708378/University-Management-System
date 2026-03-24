package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JButton login, cancel;
    JTextField tfusername;
    JPasswordField tfpassword;
    Login () {

        JLabel lable1 = new JLabel("Username");
        lable1.setBounds(40,20,100,20);
        setFont(new Font("serif", Font.BOLD, 16));
        add(lable1);

        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 20);
        setFont(new Font("serif", Font.BOLD, 16));
        add(tfusername);

        JLabel label2 = new JLabel("Password");
        label2.setBounds(40,50,100,50);
        setFont(new Font("serif", Font.BOLD, 16));
        add(label2);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(150,70,150,20);
        add(tfpassword);

        login = new JButton("Login");
        login.setBounds(40, 140,120, 30);
        login.setForeground(Color.WHITE);
        login.setBackground(Color.black);
        login.addActionListener(this);
        login.setFont(new Font("serif", Font.BOLD, 16));
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(180, 140,120, 30);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.black);
        cancel.addActionListener(this);
        cancel.setFont(new Font("serif", Font.BOLD, 16));
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0,200,200);
        add(image);

        setSize(600, 300);
        setLocation(500,250);
        setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == login) {
                try {
                    String username = tfusername.getText();
                    String password = tfpassword.getText();

                    conn conn = new conn();
                    String query = "select * from login, where username='"+username+"'and password='"+password+"'";
                    ResultSet rs = conn.s.executeQuery(query);

                    if (rs.next()) {
                        setVisible(false);
                        new Project();
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                        setVisible(false);
                    }
                } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }
}
