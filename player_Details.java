/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cricket;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.WindowEvent;
import java.util.regex.Pattern;


public class player_Details extends JFrame implements ActionListener,ItemListener{

    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
    ButtonGroup bg;
    JRadioButton r1,r2;
    JComboBox cb1,cb2,cb3,cb4;
    JButton b,b1;
    Container co;
    String bastyle="";

    public player_Details(){

        co=getContentPane();
       
       
        l1=new JLabel("Enter player Name:");
        l2=new JLabel("Batting style:");
        l3=new JLabel("Bowling style:");
        l4=new JLabel("Test match runs:");
        l5=new JLabel("ODI runs:");
        l6=new JLabel("T20 runs:");
        l7=new JLabel("Test avg:");
        l8=new JLabel("ODI avg:");
        l9=new JLabel("T20 avg:");
        l10=new JLabel("Test strike rate: ");
        l11=new JLabel("ODI strike rate:");
        l12=new JLabel("T20 strike rate:");      
        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        t4=new JTextField();
        t5=new JTextField();
        t6=new JTextField();
        t7=new JTextField();
        t8=new JTextField();
        t9=new JTextField();
        t10=new JTextField();
       

        bg=new ButtonGroup();

        r1=new JRadioButton("right");
        r2=new JRadioButton("left");
       
        bg.add(r1);
        bg.add(r2);

        cb1=new JComboBox();

        cb1.addItem("--Select--");
        cb1.addItem("Coimbatore");
        cb1.addItem("Chennai");
        cb1.addItem("Salem");
        cb1.addItem("Bangalore");
        cb1.addItem("Ooty");
        cb1.addItem("Trichy");
       
        cb2=new JComboBox();

        cb2.addItem("--Select--");
        cb2.addItem("Right arm fast");
        cb2.addItem("Left arm fast");
        cb2.addItem("Right arm medium");
        cb2.addItem("Left arm medium");
        cb2.addItem("Right spin");
        cb2.addItem("Left spin");
       
        cb3=new JComboBox();
        cb3.addItem("--Select--");
        cb3.addItem("Residential");
        cb3.addItem("Commertial");
        cb3.addItem("Industrial");
       
             
        b=new JButton("submit");
        b1=new JButton("back");

        r1.addItemListener(this);
        r2.addItemListener(this);
        b.addActionListener(this);
        b1.addActionListener(this);

       
        l1.setBounds(100, 100, 150, 25);
        l2.setBounds(100, 150, 120, 25);
        l3.setBounds(100, 200, 120, 25);
        l4.setBounds(100, 250, 120, 25);
        l5.setBounds(100, 300, 120, 25);
        l6.setBounds(100, 350, 120, 25);
        l7.setBounds(100, 400, 120, 25);
        l8.setBounds(100, 450, 120, 25);
        l9.setBounds(100, 500, 120, 25);
        l10.setBounds(100, 550, 120, 25);
        l11.setBounds(100, 600, 150, 25);
        l12.setBounds(100, 650, 120, 25);

        b.setBounds(100, 700, 80, 25);
        b1.setBounds(200, 700, 80, 25);


       
        t1.setBounds(300, 100, 200, 25);
        cb2.setBounds(300, 200, 150, 25);
               
        r1.setBounds(300, 150, 60, 25);
        r2.setBounds(360, 150, 100, 25);
        t10.setBounds(300, 250, 200, 25);
        t2.setBounds(300, 300, 200, 25);
        t9.setBounds(300, 350, 200, 25);
       

        t3.setBounds(300, 400, 200, 25);
        t4.setBounds(300, 450, 200, 25);
        t5.setBounds(300, 500, 200, 25);
        t6.setBounds(300, 550, 200, 25);
        t7.setBounds(300, 600, 200, 25);
        t8.setBounds(300, 650, 200, 25);


       
        co.add(l1);
        co.add(l2);
        co.add(l3);
        co.add(l4);
        co.add(l5);
        co.add(l6);
        co.add(l7);
        co.add(l8);
        co.add(l9);
        co.add(l10);
        co.add(l11);
        co.add(l12);

        co.add(b);
        co.add(b1);

       
        co.add(t1);
        co.add(t2);
        co.add(r1);
        co.add(r2);
        co.add(t9);
        co.add(cb2);
        co.add(t10);
        co.add(t3);
        co.add(t4);
        co.add(t5);
        co.add(t6);
        co.add(t7);
        co.add(t8);
       
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
       
       
        co.setBackground(Color.cyan);
        r1.setBackground(Color.cyan);
        r2.setBackground(Color.cyan);      
        setLayout(null);
        setFont(new Font("Times New Roman ", Font.BOLD, 12));
        setSize(900, 900);
        setVisible(true);
         
       
    }

    @Override
    public void itemStateChanged(ItemEvent ie){

        ItemSelectable itemselected=ie.getItemSelectable();

        if(itemselected==r1){
                bastyle="right";
        }
        else if(itemselected==r2){
                bastyle="left";
        }
    }

    public void actionPerformed(ActionEvent e){

        Object obj=e.getSource();

        if(obj==b){
            int y=0;
            int z=0;
            String pname=t1.getText();
            String odiruns=t2.getText();
            String t20runs=t9.getText();
            String bostyle=cb2.getSelectedItem().toString();
            String tstruns=t10.getText();
            String tstavg=t3.getText();
            String odiavg=t4.getText();
            String t20avg=t5.getText();
            String tstsr=t6.getText();
            String odisr=t7.getText();
            String t20sr=t8.getText();
           
            /*if(atype=="--Select--")
                {
                    JOptionPane.showMessageDialog(null, "Please select Area Type");
                    cb3.setBackground(Color.green);
                    z++;
                }
                else
                {
                    cb3.setBackground(Color.white);
                }*/
                /*if(bostyle=="--Select--")
                {
                    JOptionPane.showMessageDialog(null, "Please select Land Type");
                    cb2.setBackground(Color.green);
                    z++;
                }
                else
                {
                    cb2.setBackground(Color.white);
                }
                /*if(city=="--Select--")
                {
                    JOptionPane.showMessageDialog(null, "Please select city");
                    cb1.setBackground(Color.green);
                    z++;
                }
                else
                {
                    cb1.setBackground(Color.white);
                }*/
               
                /*if(r1==null&&r2==null)
                {
                    JOptionPane.showMessageDialog(null, "Please select Gender");
                    z++;
                }
               
               
                if(Pattern.matches("[0-9]{6}", pname))
                {
                    t1.setBackground(Color.white);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please fill the Seller Id correctly");
                    t1.setBackground(Color.green);
                    z++;
                }
                if(Pattern.matches("[0-9]{2}", t20runs))
                {
                    t2.setBackground(Color.white);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please fill the Area(cent) correctly");
                    t2.setBackground(Color.green);
                    z++;
                }              
                if(Pattern.matches("[0-9]*$", maxprice))
                {
                    t4.setBackground(Color.white);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please enter Maximum Price correctly");
                    t4.setBackground(Color.green);
                    z++;
                }
                if(Pattern.matches("[0-9]*$", minprice))
                {
                    t5.setBackground(Color.white);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please fill the Minimum price correctly");
                    t5.setBackground(Color.green);
                    z++;
                }
                if(Pattern.matches("[a-zA-Z]*$", sname))
                {
                    t6.setBackground(Color.white);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please fill the Seller's Name correctly");
                    t6.setBackground(Color.green);
                    z++;
                }
                if(Pattern.matches("[0-9]{10}", contact))
                {
                    t8.setBackground(Color.white);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please fill the vaild contact number");
                    t8.setBackground(Color.green);
                    z++;
                }
                if(Pattern.matches("[0-9]{6}", tstruns))
                {
                    t9.setBackground(Color.white);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please fill the Seller Id correctly");
                    t9.setBackground(Color.green);
                    z++;
                }
                if(Pattern.matches("[0-9]{6}", sid))
                {
                    t10.setBackground(Color.white);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please fill the Seller Id correctly");
                    t10.setBackground(Color.green);
                    z++;
                }*/
               

                try{
                    if(z==0)
                    {

                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cricket","root","SYSTEM");
                        Statement stmt=con.createStatement();
                        String query="insert into Player_Details values('"+pname+"','"+bastyle+"','"+bostyle+"','"+tstruns+"','"+odiruns+"','"+t20runs+"','"+tstavg+"','"+odiavg+"','"+t20avg+"','"+tstsr+"','"+odisr+"','"+t20sr+"')";
                        stmt.executeUpdate(query);
                        con.setAutoCommit(true);
                        JOptionPane.showMessageDialog(this, "Registration Success!");
                    }
                    else
                    {
                        y++;
                        JOptionPane.showMessageDialog(null, "Please enter all the required fields correctly");
                    }


                }
                catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex);
            }

        }
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
       
    }

    public static void main(String args[]){
        new player_Details();
    }
}
