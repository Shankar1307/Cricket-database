/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cricket;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author HP
 */
class view_playerRecord extends Frame
{
    JButton b1;
    JLabel l1;
    TextField t1;
    String pname;
    Label l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
    TextField t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13;
    
    view_playerRecord()
    {
        l1=new JLabel("Player name");
        t1=new TextField();
        b1=new JButton("Search");
        t1.addTextListener(new TextListener() {
            @Override
            public void textValueChanged(TextEvent e) {
                pname=t1.getText();
            }
        });
        l1.setBounds(100, 100, 100, 25);
        t1.setBounds(250, 100, 200, 25);
        b1.setBounds(225, 150, 100, 25);
        
        add(l1);
        add(t1);
        add(b1);
        
        l2=new Label("Player name");
        l3=new Label("Batting style");
        l4=new Label("Bowling style");
        l5=new Label("Test runs");
        l6=new Label("ODI runs");
        l7=new Label("T20 runs");
        l8=new Label("Test average");
        l9=new Label("ODI average");
        l10=new Label("T20 average");
        l11=new Label("Test strike rate");
        l12=new Label("ODI strike rate");
        l13=new Label("T20 strike rate");
        
        l2.setBounds(100,200,100,25);
        l3.setBounds(100,240,100,25);
        l4.setBounds(100,290,100,25);
        l5.setBounds(100,340,100,25);
        l6.setBounds(100,380,100,25);
        l7.setBounds(100,430,100,25);
        l8.setBounds(100,480,100,25);
        l9.setBounds(100,530,100,25);
        l10.setBounds(100,580,100,25);
        l11.setBounds(100,630,100,25);
        l12.setBounds(100,680,100,25);
        l13.setBounds(100,720,100,25);
        
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cricket","root","SYSTEM");
                    String query="select * from Player_Details where (pname='"+pname+"')";
                    PreparedStatement stmt=con.prepareStatement(query);
                    ResultSet rs=stmt.executeQuery();
                    
                    while(rs.next())
                    {
                        String rpname=rs.getString("pname");
                        String rbastyle=rs.getString("bastyle");
                        String rbostyle=rs.getString("bostyle");
                        String rtstruns=rs.getString("tstruns");
                        String rodiruns=rs.getString("odiruns");
                        String rt20runs=rs.getString("t20runs");
                        String rtstavg=rs.getString("tstavg");
                        String rodiavg=rs.getString("odiavg");
                        String rt20avg=rs.getString("t20avg");
                        String rtstsr=rs.getString("tstsr");
                        String rodisr=rs.getString("odisr");
                        String rt20sr=rs.getString("t20sr");
                    
                        t2=new TextField(""+rpname+"");
                        t3=new TextField(""+rbastyle+"");
                        t4=new TextField(""+rbostyle+"");
                        t5=new TextField(""+rtstruns+"");
                        t6=new TextField(""+rodiruns+"");
                        t7=new TextField(""+rt20runs+"");
                        t8=new TextField(""+rtstavg+"");
                        t9=new TextField(""+rodiavg+"");
                        t10=new TextField(""+rt20avg+"");
                        t11=new TextField(""+rtstsr+"");
                        t12=new TextField(""+rodisr+"");
                        t13=new TextField(""+rt20sr+"");
                    
                        add(l2);
                        add(l3);
                        add(l4);
                        add(l5);
                        add(l6);
                        add(l7);
                        add(l8);
                        add(l9);
                        add(l10);
                        add(l11);
                        add(l12);
                        add(l13);
                    
                        t2.setBounds(250,200,200,25);
                        t2.disable();
                        t3.setBounds(250,240,200,25);
                        t3.disable();
                        t4.setBounds(250,290,200,25);
                        t4.disable();
                        t5.setBounds(250,340,200,25);
                        t5.disable();
                        t6.setBounds(250,380,200,25);
                        t6.disable();
                        t7.setBounds(250,430,200,25);
                        t7.disable();
                        t8.setBounds(250,480,200,25);
                        t8.disable();
                        t9.setBounds(250,530,200,25);
                        t9.disable();
                        t10.setBounds(250,580,200,25);
                        t10.disable();
                        t11.setBounds(250,630,200,25);
                        t11.disable();
                        t12.setBounds(250,680,200,25);
                        t12.disable();
                        t13.setBounds(250,720,200,25);
                        t13.disable();
                    
                        add(t2);
                        add(t3);
                        add(t4);
                        add(t5);
                        add(t6);
                        add(t7);
                        add(t8);
                        add(t9);
                        add(t10);
                        add(t11);
                        add(t12);
                        add(t13);
                    }
                    
                    con.close();
                    JOptionPane.showMessageDialog(null,"Login Success for "+pname);
                    
                } 
                catch (Exception e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Login Failed ");
                }
                }
        });
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e7){
               dispose(); 
            }
        });
        
        setLayout(null);
        setBackground(Color.yellow);
        setFont(new Font("Times New Roman ", Font.BOLD, 12));
        setSize(500,500);
        setResizable(true);
        setVisible(true);
    }
    public static void main(String args[])
    {
        new view_playerRecord();
    }
}