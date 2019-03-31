package login;
import javax.swing.JOptionPane;
import javax.sound.midi.Synthesizer;
import database.DatabaseConnection;
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.imageio.ImageIO;
import java.awt.image.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
public class Login 
{
	static JFrame frame=new JFrame("LOGIN WINDOW");
	JButton b1,b3,b4,b5,b2;
	private JLabel l1,l2;
	
	private static JTextField t1;
	private static JTextField t2;
	public  Login()
	{
				
	frame.getContentPane().setBackground(Color.CYAN);
	frame.setContentPane(new JLabel(new ImageIcon("/home/kalyan/Downloads/bank.jpg")));
	
	JPanel p = new JPanel();
	//p.setBounds(341, 192, 683, 384);
	p.setBounds(200, 150, 850, 450);
	p.setLayout(null);
	p.setBackground(Color.BLACK);
	p.setBorder(new MatteBorder(2 ,2 ,2 ,2 , Color.black));
	frame.add(p);
	
	JButton bt = new JButton(new ImageIcon("/home/kalyan/Downloads/rupee.jpg"));
    bt.setBounds(0, 0, 400, 450);
    bt.setBorder(new MatteBorder(2 ,2 ,2 ,2 , Color.black));
    p.add(bt);
           
	l1=new JLabel("USERNAME :");
	l1.setBounds(500,150,100,30);
	l1.setForeground(Color.RED);
	p.add(l1);
	
	t1=new JTextField();
	t1.setBounds(620,152,150,25);
	p.add(t1);
	
	l2=new JLabel("PASSWORD:");
	l2.setBounds(500, 200, 100, 30);
	l2.setForeground(Color.red);
	p.add(l2);
	
	t2=new JPasswordField();
	t2.setBounds(620,202,150,25);
	p.add(t2);
	
	b1=new JButton("LOGIN");
	p.getRootPane().setDefaultButton(b1);
	
	b1.setBackground(Color.DARK_GRAY);
	b1.setForeground(Color.red);
	b1.setBounds(570,302,150,25);
	p.add(b1);
	
		
	//========================================================checkbox===========================================================
	JCheckBox jb=new JCheckBox("show password");
	jb.setBounds(500, 252, 130, 20);
	jb.setBackground(Color.black);
	jb.setForeground(Color.orange);
	p.add(jb);
	jb.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent aae) 
		{
			if(jb.isSelected())
			{
				((JPasswordField) t2).setEchoChar((char)0);
			}
			else
			{
				((JPasswordField) t2).setEchoChar('*');
			}
		}
	});
		
	//==========================================================forgot password=====================================================
	JButton fg=new JButton("Forgot password");
	fg.setBounds(625,252,200,20);
	fg.setBackground(Color.BLACK);
	fg.setForeground(Color.ORANGE);
	p.add(fg);
	fg.setBorder(BorderFactory.createEmptyBorder());
	Fgpass f=new Fgpass();
	fg.addActionListener(f);
	//=======================
	
	Handler h=new Handler();
	b1.addActionListener(h);
		  
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1366, 768);
	frame.setLayout(null);
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);
		
	}
	//===============================================MAIN=============================================================
	public static void main(String[] args)
	{
			new Login();
	}
	//================================================HANDLER=============================================================
	static class Handler implements ActionListener 
	{
		
		public void actionPerformed(ActionEvent e)
		{
			String uname=t1.getText();
		    String pass=t2.getText();
		    //======================================object of LOGIN2 class  for validating password=====================
		   	Login2 l2=new Login2(uname, pass);   
		  boolean flag = l2.passv();
			
		if(flag)
		{
			t2.setText(null);
			t1.setText(null);
			JFrame frame2=new JFrame("Signed in");
			frame2.getContentPane().setBackground(Color.BLUE);
			JPanel jsp1 = new JPanel();
			jsp1.setBounds(0, 0, 1300, 200);
			JPanel jsp2 = new JPanel();
			jsp2.setBounds(0,200,200,512);
			JPanel jsp3=new JPanel();
			jsp3.setBounds(200,200,1100,512);
						  
			jsp1.setBorder(new MatteBorder(2 ,2 ,2 ,2 , Color.white));
			jsp1.setLayout(null);
			jsp2.setBorder(new MatteBorder(2 ,2 ,2 ,2 , Color.MAGENTA));
			jsp2.setLayout(null);
			jsp3.setBorder(new MatteBorder(2,2,2,2,Color.black));
			jsp3.setLayout(null);
			jsp3.setBackground(Color.red);
			jsp1.setBackground(Color.WHITE);
			jsp2.setBackground(Color.DARK_GRAY);
			
			
			//================================================add panel============================================	
			frame2.getContentPane().add(jsp2);
			frame2.getContentPane().add(jsp1);
			frame2.getContentPane().add(jsp3);
			//=================
			//==========label for company name===============
			JLabel cn=new JLabel("G.J.R Group of Industries");
			cn.setForeground(Color.orange);
			cn.setBounds(1100, 15, 300, 20);
			jsp1.add(cn);
			JLabel cn1=new JLabel("Aurangabad");
			cn1.setForeground(Color.blue);
			cn1.setBounds(1180,35,200,20);
			jsp1.add(cn1);
			JLabel cn2=new JLabel("Maharashtra 431111");
			cn2.setForeground(Color.green);
			cn2.setBounds(1130, 55, 300, 20);
			jsp1.add(cn2);
			
			//========================logout===========
			JLabel lg=new JLabel("LOGOUT");
			lg.setBounds(1200, 140, 100, 25);
			lg.setForeground(Color.red);
			jsp1.add(lg);
			
			lg.addMouseListener(new MouseAdapter() 
			{
                public void mouseClicked(MouseEvent e)
                {
                	frame2.setVisible(false);
                    frame.setVisible(true);
                }

            });
			//======================================
			
			JButton bt1 = new JButton(new ImageIcon("/home/kalyan/Downloads/intre.jpg"));
		    bt1.setBounds(0, 0, 1100, 512);
		    jsp3.add(bt1);
			
			//======================
			//==========================================Customer Details===========================
			JButton CD=new JButton("Customer Details");
			CD.setBounds(10, 20, 150, 25);
			CD.setBorder(BorderFactory.createEmptyBorder());
			jsp2.add(CD);
			
			Cust_Details cd=new Cust_Details();
			 CD.addActionListener(cd);
			//====================================Add New User using form===========================================
			 JButton AU=new JButton("ADD USER");
			 AU.setBounds(10,80,150,25);
			 AU.setBorder(BorderFactory.createEmptyBorder());
			 jsp2.add(AU);
			 
			 ADD_USER au=new ADD_USER();
			 AU.addActionListener(au);
			 //====================================================================
			JButton bt = new JButton(new ImageIcon("/home/kalyan/Downloads/red_dot.png"));
		    bt.setBounds(0, 0, 200, 200);
		   		   	    
		    bt.setBorder(new MatteBorder(2,2,2,2,Color.WHITE));
			bt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					frame.setVisible(true);
					frame2.setVisible(false);
				}
			});
			
			jsp1.add(bt);
			//============================================================menu bar=======================================================
			JMenuBar m=new JMenuBar();
			m.setBackground(Color.DARK_GRAY);
			m.setBounds(0, 0, 400, 10);
			//=================================================first menu ==== service menu============================================
			JMenu m1=new JMenu("Service");
			m1.setForeground(Color.WHITE);
			m1.setMnemonic(KeyEvent.VK_S);
			JMenuItem i1,i2;
			i1=new JMenuItem("personal internet banking ");
			i2=new JMenuItem("corporate internet banking");
			m.add(m1);
			m1.add(i1);
			m1.add(i2);
			
			//=========================================================second menu ==========================================
			JMenu m2=new JMenu("SBI Anywhere");
			m2.setMnemonic(KeyEvent.VK_A);
			m2.setForeground(Color.white);
			JMenuItem j1,j2,j3;
			j1=new JMenuItem("SBA Saral ");
			j2=new JMenuItem("SBA Corporate");
			j3=new JMenuItem("SBA Personal");
			m.add(m2);
			m2.add(j1);
			m2.add(j2);
			m2.add(j3);
			
			frame2.setJMenuBar(m);
			frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame2.setSize(1366, 768);
			frame2.setLayout(null);
			frame.setVisible(false);
			frame2.setLocationRelativeTo(null);
			frame2.setVisible(true);
			
		}
		//=======================================else part=========================================================================
		else
		{
			JFrame frame3=new JFrame("error window");
			frame3.setContentPane(new JLabel(new ImageIcon("/home/kalyan/Downloads/ew.jpg")));
									
			JButton b=new JButton("GO TO LOGING PAGE");
			b.setBounds(500, 300, 200, 30);
			b.setBackground(Color.red);
			frame3.add(b);
			
			//button action listener
			 b.setBorder(new MatteBorder(2,2,2,2,Color.WHITE));
				b.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						frame.setVisible(true);
						frame3.setVisible(false);
					}
				});
			//frame3.add(new JLabel(new ImageIcon("/home/kalyan/Downloads/SBI-logo.jpeg")));
			frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame3.setSize(1366, 768);
			frame.setVisible(false);
			frame3.setLayout(null);
			frame3.setVisible(true);
		
		}
		}
		
	}
	//================================================class for forgot password==========================================
	static class Fgpass implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JFrame frame3=new JFrame("SBIForgot password page");
			frame3.getContentPane().setBackground(Color.ORANGE);
			frame3.setContentPane(new JLabel(new ImageIcon("/home/kalyan/Downloads/key.jpg")));
			
			JPanel f3 = new JPanel();
			f3.setBounds(200, 150, 850, 450);
						
			JLabel l1=new JLabel("Enter your middle name");
			l1.setBounds(400,150,200,30);
			f3.add(l1);
					
			JButton fgbt = new JButton(new ImageIcon("/home/kalyan/Downloads/fg.png"));
		    fgbt.setBounds(0, 0, 370, 450);
		    //fgbt.setBackground(Color.GREEN);
		    fgbt.setBorder(new MatteBorder(2 ,2 ,2 ,2 , Color.black));
		    f3.add(fgbt);
		    
			JTextField t1=new JTextField();
			t1.setBounds(600,150,200,25);
			f3.add(t1);
	
			JLabel l2=new JLabel("Enter your ATM PIN");
			l2.setBounds(400, 200, 200, 30);
			f3.add(l2);
			
			JTextField t2=new JPasswordField();
			t2.setBounds(600,200,200,25);
			f3.add(t2);

			JButton bt=new JButton("Submit");
			bt.setBackground(Color.RED);
			bt.setBounds(550, 250, 200, 25);
			f3.add(bt);
			
			
			
			//================================submit button to reset the password=========================================
			bt.addActionListener(new ActionListener () 
			{
				public void actionPerformed(ActionEvent ww)
				{
					String MNAME=t1.getText().trim();
					String ATMPIN=t2.getText().trim();
					ForgotPass p=new ForgotPass();
					boolean flag=p.fgps(MNAME, ATMPIN);
					if(flag)
					{
						JFrame frame4=new JFrame("reset password frame");
						frame4.getContentPane().setBackground(Color.BLACK);
						
						JPanel lf3 = new JPanel();
						lf3.setBounds(341, 192, 683, 384);
						
						JLabel ll1=new JLabel("Enter your new password");
						ll1.setBounds(50,100,300,30);
						lf3.add(ll1);
										
						JLabel ll2=new JLabel("Re-enter your new Password");
						ll2.setBounds(50,150,300,30);
						lf3.add(ll2);
						
						JLabel ll3=new JLabel("enter your atmpin");
						ll3.setBounds(50,50,300,30);
						lf3.add(ll3);
						//ATM pin text Field
						JTextField lt3=new JPasswordField();
						lt3.setBounds(270,50,200,25);
						lf3.add(lt3);
						//reenter
						JTextField lt2=new JPasswordField();
						lt2.setBounds(270,150,200,25);
						lf3.add(lt2);
						//enter password
						JTextField lt1=new JPasswordField();
						lt1.setBounds(270,100,200,25);
						lf3.add(lt1);
						
						JButton bt=new JButton("RESET");
						bt.setBounds(200, 200, 200, 25);
						lf3.add(bt);
						
						bt.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent ae) 
							{
								String epass=lt1.getText().trim();
								String rpass=lt2.getText().trim();
								String atmpin=lt3.getText().trim();
								System.out.println("hii 1");
								if(epass.equals(rpass))
								{
										ForgotPass f2=new ForgotPass();
										boolean flag =f2.resetPassword(epass,atmpin);
										System.out.println("flag is " + flag);
								 if(flag)
								 {
									 frame.setVisible(true);
								 }
								 else
								 {
									 
								 }
									 
								}
							}
						});
						
						
						lf3.setBorder(new MatteBorder(2 ,2 ,2 ,2 , Color.black));
						lf3.setLayout(null);
						frame4.add(lf3);
						frame4.setSize(1366, 768);
						frame3.setVisible(false);
						frame4.setLayout(null);
						
						frame4.setVisible(true);
					}
					else
					{
						
						//frame.setVisible(true);
					}
					
				}
			});
			
			JButton bt1=new JButton("GO TO LOGIN PAGE");
			bt1.setBackground(Color.RED);
			bt1.setBounds(550, 300, 200, 25);
			
			bt1.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae) 
				{
					frame.setVisible(true);
					frame3.setVisible(false);
				}
			});
			
			f3.add(bt1);
			f3.setBorder(new MatteBorder(2 ,2 ,2 ,2 , Color.black));
			f3.setLayout(null);
			f3.setBackground(Color.white);
			frame3.add(f3);
			frame3.setSize(1366, 768);
			frame3.setLayout(null);
			frame.setVisible(false);
			frame3.setVisible(true);
			
		}
	}
	
//==============================our_schemes==========================class=======================	
	
	static class Cust_Details implements ActionListener
	{	
		public void actionPerformed(ActionEvent e)
		{
		JFrame details=new JFrame("Customer Details");
		details.setSize(900, 750);
		details.getContentPane().setBackground(Color.WHITE);
		//details.setLayout(new GridLayout(3,2));
		
		JLabel l=new JLabel("Enter Details of customer to access info --------------------------------------------------------------------");
		l.setBounds(70, 40, 600, 25);
		l.setForeground(Color.red);
		l.setFont(new Font("Serif", Font.PLAIN, 14));
		details.add(l);
	    
	    JLabel l1=new JLabel("ATM PIN:");
		l1.setBounds(90, 80,100 ,25);
		//l1.setForeground(Color.red);
	    details.add(l1);
	    
	    JTextField t1=new JTextField();
	    t1.setBounds(180,83,200,20);
	    details.add(t1);
	    
	    JLabel l2=new JLabel("A/C No:");
		l2.setBounds(90, 120,100 ,25);
		//l1.setForeground(Color.red);
	    details.add(l2);
	    
	    JTextField t2=new JTextField();
	    t2.setBounds(180,123,200,20);
	    details.add(t2);
	    
	    //=============================button=================================================================
	    JButton submit=new JButton("SUBMIT");
	    submit.setBounds(400,100,100,25);
	    details.add(submit);
	    
	   
	    //ForgotPass sub=new ForgotPass();
	    
	    
	    //==================================================/////////////////////////////////==================================/////////////////=
	    JLabel i=new JLabel("The Details of customer are as follows--------------------------------------------------------------------");
		i.setBounds(70, 160, 600, 25);
		i.setForeground(Color.red);
		i.setFont(new Font("Serif", Font.PLAIN, 14));
	    details.add(i);
	    /////////////////////////////////fname/////////////////////////////////////////////////
	    JLabel i1=new JLabel("Cust Fname:");
		i1.setBounds(90, 200,100 ,25);
		//l1.setForeground(Color.red);
	    details.add(i1);
	    
	    JTextField ti1=new JTextField();
	    ti1.setBounds(180,203,200,20);
	    details.add(ti1);
	    //////////////////////lname================================
	    JLabel i3=new JLabel("Lname:");
		i3.setBounds(440, 200,100 ,25);
		//l1.setForeground(Color.red);
	    details.add(i3);
	    
	    JTextField ti3=new JTextField();
	    ti3.setBounds(540,203,200,20);
	    details.add(ti3);
	    ///////////////////////////////////////account number        ===================
	    JLabel i2=new JLabel("A/C No:");
		i2.setBounds(90, 240,100 ,25);
		//l1.setForeground(Color.red);
	    details.add(i2);
	    
	    JTextField ti2=new JTextField();
	    ti2.setBounds(180,243,200,20);
	    details.add(ti2);
	    //////////////////////////mobile number==================================
	    JLabel i4=new JLabel("MO. No:");
		i4.setBounds(90, 280,100 ,25);
		//l1.setForeground(Color.red);
	    details.add(i4);
	    
	    JTextField ti4=new JTextField();
	    ti4.setBounds(180,283,200,20);
	    details.add(ti4);
	    //=========================address===================
	    
	    JLabel A=new JLabel("ADDRESS");
	    A.setBounds(90, 320,400 ,25);
		A.setForeground(Color.blue);
	    details.add(A);
	    
	    JLabel la1=new JLabel("Country:");
		la1.setBounds(110, 360,100 ,25);
		//l1.setForeground(Color.red);
	    details.add(la1);
	    
	    JTextField ta1=new JTextField();
	    ta1.setBounds(200,363,200,20);
	    details.add(ta1);
	    
	    JLabel la2=new JLabel("State:");
		la2.setBounds(440, 360,100 ,25);
		//l1.setForeground(Color.red);
	    details.add(la2);
	    
	    JTextField ta2=new JTextField();
	    ta2.setBounds(540,363,200,20);
	    details.add(ta2);
	    
	    JLabel la3=new JLabel("City:");
		la3.setBounds(110, 400,100 ,25);
		//l1.setForeground(Color.red);
	    details.add(la3);
	    
	    JTextField ta3=new JTextField();
	    ta3.setBounds(200,403,200,20);
	    details.add(ta3);
	    
	    JLabel la4=new JLabel("Taluka:");
		la4.setBounds(440, 400,100 ,25);
		//l1.setForeground(Color.red);
	    details.add(la4);
	    
	    JTextField ta4=new JTextField();
	    ta4.setBounds(540,403,200,20);
	    details.add(ta4);
	    
	    JLabel la5=new JLabel("Village:");
		la5.setBounds(110, 440,100 ,25);
		//l1.setForeground(Color.red);
	    details.add(la5);
	    
	    JTextField ta5=new JTextField();
	    ta5.setBounds(200,443,200,20);
	    details.add(ta5);
	    
	    JLabel la6=new JLabel("Building Name:");
		la6.setBounds(440, 440,150 ,25);
		//l1.setForeground(Color.red);
	    details.add(la6);
	    
	    JTextField ta6=new JTextField();
	    ta6.setBounds(590,443,200,20);
	    details.add(ta6);
	    
	    JLabel la7=new JLabel("Pin Code:");
		la7.setBounds(110, 480,100 ,25);
		//l1.setForeground(Color.red);
	    details.add(la7);
	    
	    JTextField ta7=new JTextField();
	    ta7.setBounds(200,483,200,20);
	    details.add(ta7);
	    
	    // ACCOUNT Balance========================================
	    JLabel AB=new JLabel("ACCOUNT INFORMATION");
	    AB.setBounds(90, 520,400 ,25);
		AB.setForeground(Color.blue);
	    details.add(AB);
	    
	    JLabel AB1=new JLabel("Account Type:");
		AB1.setBounds(110, 560,150 ,25);
		//l1.setForeground(Color.red);
	    details.add(AB1);
	    
	    JTextField TAB1=new JTextField();
	    TAB1.setBounds(250,563,200,20);
	    details.add(TAB1);
	    
	    JLabel AB2=new JLabel("REMAINING BALANCE:");
		AB2.setBounds(110, 600,200 ,25);
		//l1.setForeground(Color.red);
	    details.add(AB2);
	    
	    JTextField TAB2=new JTextField();
	    TAB2.setEditable(false);
	    TAB2.setBounds(300,603,200,20);
	    details.add(TAB2);
	    ti2.setEditable(false);
	    submit.addActionListener(new ActionListener()
	    {
	    	public void actionPerformed(ActionEvent arg0) 
	    	{
			String atmpin=t1.getText();
			String acno=t2.getText();
			Connection con = DatabaseConnection.getConnection() ; 
			try
			{
				
				PreparedStatement stmt1=con.prepareStatement("select * from dummy where atm=? and ano=?");
				System.out.println(acno + " " + atmpin	);
				
				stmt1.setString(1, atmpin);
				stmt1.setString(2, acno);
				ResultSet rs=stmt1.executeQuery();
				while(rs.next())
				{
					String s = rs.getString(1);
	                String s1 = rs.getString(2);
	                String s2 = rs.getString(3);
	              //  String s3 = rs.getString(4);
				
	                
	                //
	                ti2.setText(s1);
	                ti4.setText(s2);
	                
	                
	                
				}
				//stmt1.close();
				//con.close();
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			}
		});
	    
		details.setLayout(null);
		details.setLocationRelativeTo(null);
		details.setVisible(true);
		
		}
		
	}
	// separate classes because in some situation there is need of running two frame at a time
	static class ADD_USER implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			JFrame au=new JFrame("ADD_USER");
			au.getContentPane().setBackground(Color.WHITE);
			
			JLabel l=new JLabel("Enter Details of new user which you want to add---------------------------------------------------------");
			l.setBounds(70, 100, 600, 25);
			l.setForeground(Color.red);
			l.setFont(new Font("Serif", Font.PLAIN, 20));
			au.add(l);
			
			JLabel i1=new JLabel("Enter id:");
			i1.setBounds(90, 200,100 ,25);
			//l1.setForeground(Color.red);
		    au.add(i1);
		    
		    JTextField ti1=new JTextField();
		    ti1.setBounds(180,203,200,20);
		    au.add(ti1);
		    
		    JLabel i2=new JLabel("First name:");
			i2.setBounds(90, 240,100 ,25);
			//l1.setForeground(Color.red);
		    au.add(i2);
		    
		    JTextField ti2=new JTextField();
		    ti2.setBounds(180,243,200,20);
		    au.add(ti2);
			
		    JLabel i3=new JLabel("Mname:");
			i3.setBounds(440, 240,100 ,25);
			//l1.setForeground(Color.red);
		    au.add(i3);
		    
		    JTextField ti3=new JTextField();
		    ti3.setBounds(540,243,200,20);
		    au.add(ti3);
		    
		    JLabel i4=new JLabel("Lname:");
			i4.setBounds(90, 280,100 ,25);
			//l1.setForeground(Color.red);
		    au.add(i4);
		    
		    JTextField ti4=new JTextField();
		    ti4.setBounds(180,283,200,20);
		    au.add(ti4);
		    		      
		    JLabel la1=new JLabel("Password:");
			la1.setBounds(90, 320,100 ,25);
			//l1.setForeground(Color.red);
		    au.add(la1);
		    
		    JTextField ta1=new JTextField();
		    ta1.setBounds(180,323,200,20);
		    au.add(ta1);
		    
		    JLabel t=new JLabel("ATMPIN:");
			t.setBounds(440, 320,100 ,25);
			//l1.setForeground(Color.red);
		    au.add(t);
		    
		    JTextField t1=new JTextField();
		    t1.setBounds(540,323,200,20);
		    au.add(t1);
		    
		    JButton ADD=new JButton("ADD");
		    ADD.setBounds(350,400,200,20);
		    ADD.setBackground(Color.RED);
		    au.add(ADD);
		    
		    ADD.addActionListener(new ActionListener() 
		    {
				public void actionPerformed(ActionEvent arg0)
				{
					String id=ti1.getText();
					String fname=ti2.getText();
					String mname=ti3.getText();
					String Lname=ti4.getText();
					String passwd=ta1.getText();
					String atmpin=t1.getText();
					
				}
			});
		    
			au.setSize(900, 750);
			au.setLayout(null);
			au.setLocationRelativeTo(null);
			au.setVisible(true);
		}
		
	}
} 
