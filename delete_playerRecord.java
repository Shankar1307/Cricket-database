/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cricket;

/**
 *
 * @author HP
 */
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class delete_playerRecord extends Frame
{
    Label l1;
    TextField t1;
    JButton b,b2;
    String record;
    delete_playerRecord()
    {
        l1=new Label("ENTER PLAYER'S NAME TO DELETE THE RECORD:");
        t1=new TextField();
        b=new JButton("DELETE");
        b2=new JButton("BACK");
        l1.setBounds(100,200,350,25);
        t1.setBounds(450,200,200,25);
        b.setBounds(100,250,100,30);
        b2.setBounds(250, 250, 100, 30);
        add(l1);
        add(t1);
        add(b);
        add(b2);
       
        l1.setBackground(Color.orange);
        setFont(new Font("Times New Roman ", Font.BOLD, 13));
        setLayout(null);
        setSize(800,800);
        setVisible(true);
        setResizable(false);
        setBackground(Color.orange);
       
       
        t1.addTextListener(new TextListener() {
            @Override
            public void textValueChanged(TextEvent e) {
                record=t1.getText();
            }
        });
       
        b.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cricket","root","SYSTEM");
                    Statement st=con.createStatement();
                    String query="delete from Player_Details where(pname='"+record+"')";
                    st.executeUpdate(query);
                    con.close();
                    JOptionPane.showMessageDialog(null, "Deleted Successfully");
               
                } catch (Exception e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "File not found to Delete");
                }
            }

        });
       
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
           
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
       
       
    }
    public static void main(String args[])
    {
        delete_playerRecord d=new delete_playerRecord();
    }
   
}
