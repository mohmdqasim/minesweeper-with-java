

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.sound.sampled.LineEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class Minesweeper extends JFrame  {

    private JLabel statusbar;
    private JLabel t; //for timer
    private JMenu menu, submenu;  
    private JMenuItem i1, i2, i3, i4, i5,i6,i7,i8;
    private MenuItemListener menuItemListener = new MenuItemListener(); 
   

    public Minesweeper() {

        initUI();
    }
    public void windowClosing(WindowEvent e) {
    	   setVisible(true);
    	}

    private void initUI() {

        statusbar = new JLabel("");
        t=new JLabel("");
        
        
        
        
        JMenuBar mb=new JMenuBar();  
        menu=new JMenu("Menu");  
        submenu=new JMenu("Leader Board");  
        i1=new JMenuItem("Beginner");  
        i2=new JMenuItem("Intermediate");  
        i3=new JMenuItem("Master");  
        i4=new JMenuItem("Custom");  
        i5=new JMenuItem("Beginner");  
        i6=new JMenuItem("Intermediate");  
        i7=new JMenuItem("Master");   
        i8=new JMenuItem("Close"); 
        menu.add(i1); menu.add(i2); menu.add(i3);   menu.add(i4);  
        submenu.add(i5); submenu.add(i6);   submenu.add(i7);
        menu.add(submenu);  
        menu.add(i8);
        mb.add(menu);  
        setJMenuBar(mb); 
        

        i1.addActionListener(menuItemListener);
        i2.addActionListener(menuItemListener);
        i3.addActionListener(menuItemListener);
        i4.addActionListener(menuItemListener);
        i5.addActionListener(menuItemListener);
        i6.addActionListener(menuItemListener);
        i7.addActionListener(menuItemListener);
        i8.addActionListener(menuItemListener);
        
//        for Checking which item is click
        
        i1.setActionCommand("Beginner");
        i2.setActionCommand("Intermediate");
        i3.setActionCommand("Master");
        i4.setActionCommand("Custom");
        i5.setActionCommand("CHB");
        i6.setActionCommand("CHI");
        i7.setActionCommand("CHM");
        i8.setActionCommand("Close");


        setResizable(true);
        
      
        
        setSize(400,400);
        setTitle("Minesweeper");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    class MenuItemListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {  
        	final JFrame   b = new JFrame("MineSweeper_Game");
        	b.add(t,BorderLayout.EAST);
            b.add(statusbar,  BorderLayout.SOUTH);
            b.setResizable(false);
            b.setLocation(400, 120);
            
            
            KeyAdapter listener = new KeyAdapter() {
                @Override public void keyPressed(KeyEvent e) {
                    if(e.getKeyChar() == 'f' || e.getKeyChar() == 'F')
                    {
                    	b.dispose();
                    	 EventQueue.invokeLater(() -> {

                             var ex = new Minesweeper();
                             ex.setVisible(true);
                         });
                    	
                    	
                    	
                    }
                    
                }
            };

            b.addKeyListener(listener);
        	
        	if(e.getActionCommand() == "Beginner")
        	{
        		
        		b.add(new Board(statusbar,t,8,8,10));
        		b.setSize(250,250);
        		b.setVisible(true);
        		setVisible(false);
        		
        	}
        	
        	else if (e.getActionCommand() == "Intermediate")
        	{

        		b.add(new Board(statusbar,t,16,16,40));
        		
        		b.setSize(400,400);
        		b.setVisible(true);
        		setVisible(false);
        		
        	}
        	else if(e.getActionCommand() == "Master")
        	{

        		b.add(new Board(statusbar,t,16,30,99));
        		b.setSize(400,570);
        		b.setVisible(true);
        		setVisible(false);
        		
        	}
        	else if(e.getActionCommand() == "Custom") {
        		
        		JFrame f=new JFrame("Button Example"); 
                //submit button
			    JButton submit = new JButton("Submit");    
			    submit.setBounds(70,200,90, 30);    
			                //enter name label
			    JLabel r,c,m;
			    r = new JLabel(); 
			    c = new JLabel(); 
			    m = new JLabel(); 
			    c.setText("Column :");
			    c.setBounds(10, 12, 100, 100);
			    r.setText("Rows :");
			    r.setBounds(10, 62, 100, 100);
			    
			    m.setText("Mine :");
			    m.setBounds(10, 112, 100, 100);
			            
			    JTextField col= new JTextField();
			    col.setBounds(70, 50, 100, 30);
			    JTextField row= new JTextField();
			    row.setBounds(70, 100, 100, 30);
			    JTextField mine= new JTextField();
			    mine.setBounds(70, 150, 100, 30);
			                //add to frame
			    f.add(c);
			    f.add(r);
			    f.add(m);
			    f.add(col);
			    f.add(row);
			    f.add(mine);
			   
			    f.add(submit);    
			    f.setSize(300,300);    
			    f.setLayout(null);    
			    f.setVisible(true); 
			    
			    row.addKeyListener(new KeyAdapter() {
			         public void keyPressed(KeyEvent ke) {
			            String value = row.getText();
			            int l = value.length();
			            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
			               row.setEditable(true);
			              
			            } else {
			            	JOptionPane.showMessageDialog(f, "Only Digits are allowed",
						               "Information", JOptionPane.WARNING_MESSAGE);
			            	row.setText("");
			              
			            }
			         }
			      });
			    col.addKeyListener(new KeyAdapter() {
			         public void keyPressed(KeyEvent ke) {
			            String value = col.getText();
			            int l = value.length();
			            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
			               row.setEditable(true);
			              
			            } else {
			            	JOptionPane.showMessageDialog(f, "Only Digits are allowed",
						               "Information", JOptionPane.WARNING_MESSAGE);
			            	col.setText("");
			              
			            }
			         }
			      });
			    mine.addKeyListener(new KeyAdapter() {
			         public void keyPressed(KeyEvent ke) {
			            String value = mine.getText();
			            int l = value.length();
			            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
			               mine.setEditable(true);
			              
			            } else {
			            	JOptionPane.showMessageDialog(f, "Only Digits are allowed",
						               "Information", JOptionPane.WARNING_MESSAGE);
			            	mine.setText("");
			              
			            }
			         }
			      });
			    
			    submit.addActionListener(new ActionListener() {
		            
		            @Override
		            public void actionPerformed(ActionEvent arg0) {
		            	String m,r,c;
		            	m= mine.getText();r=row.getText();c=col.getText();
		            	
		            	int mine = Integer.parseInt(m);
		            	int row = Integer.parseInt(r);
		            	int col = Integer.parseInt(c);
		            	
		            	b.add(new Board(statusbar,t,col,row,mine));
		        		b.pack();
		        		b.setVisible(true);
		        		setVisible(false);
		        		f.dispose();
		            	
		                  
		            }          
		          });
		     
 		

        	}
        	else if(e.getActionCommand() == "CHB")
        	{
        		BufferedReader in = null;
        		String str;
        		
        		try {
					in = new BufferedReader(new FileReader("Beginner.txt"));
					String message = "";
						while ((str = in.readLine()) != null) {
							if(str.trim().equals("")) {
								JOptionPane.showMessageDialog(b, "No Record Found!",
							               "Information", JOptionPane.WARNING_MESSAGE);
								break;
							}
							
	 					   message = message + str + "\n";
	 					}
						JOptionPane.showMessageDialog(null, message, "InfoBox: " + "Beginer Record", JOptionPane.INFORMATION_MESSAGE);
						
						in.close();
					
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					System.out.println("File Not Found");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    			
        	}
        	else if(e.getActionCommand() == "CHI")
        	{
        		BufferedReader in = null;
        		String str;
        		
        		try {
        			
					in = new BufferedReader(new FileReader("Intermediate.txt"));
					System.out.println("Intermediate Records");
					String message = "";
						while ((str = in.readLine()) != null) {
							
							if(str.trim().equals("")) {
								JOptionPane.showMessageDialog(b, "No Record Found!",
							               "", JOptionPane.WARNING_MESSAGE);
								break;
							}
							message = message + str + "\n";
	 					}
						JOptionPane.showMessageDialog(null, message, "InfoBox: " + "Intermediate Record", JOptionPane.INFORMATION_MESSAGE);
						
						
						in.close();
					
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					System.out.println("File Not Found");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        	else if(e.getActionCommand() == "CHM")
        	{
        		BufferedReader in = null;
        		String str;
        		
        		try {
					in = new BufferedReader(new FileReader("Master.txt"));
					System.out.println("Master Records");
					String message = "";
						while ((str = in.readLine()) != null) {
							
							if(str.trim().equals("")) {
								JOptionPane.showMessageDialog(b, "No Record Found!",
							               "", JOptionPane.WARNING_MESSAGE);
								break;
							}
							
	 					   message = message + str + "\n";
	 					}
						JOptionPane.showMessageDialog(null, message, "InfoBox: " + "Master Record", JOptionPane.INFORMATION_MESSAGE);
						
						in.close();
						
					
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					System.out.println("File Not Found");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		
        	}
        	else if(e.getActionCommand() == "Close")
        	{
        		dispose();
        		System.exit(0);
        		
        	}
        	b.addWindowListener(new WindowAdapter() {
        	    

        	    public void windowClosing(WindowEvent e) {
        	        b.dispose();
        	        EventQueue.invokeLater(() -> {

        	            var ex = new Minesweeper();
        	            ex.setVisible(true);
        	        });
        	        
        	    }
        	});
    			
 
        }
       

        
     }
    

    public static void main(String[] args) {
    	
        EventQueue.invokeLater(() -> {

        	Minesweeper ex = new Minesweeper();
            ex.setVisible(true);
        });
    }
}
