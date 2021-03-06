package gui;
import javax.imageio.ImageIO;
import javax.swing.*;

import com.alee.laf.WebLookAndFeel;

import core.Core;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//Test
public class IniPage extends JFrame{
	JButton btnOk = new JButton("OK");
	JTextPane txtEpos = new JTextPane();
	JLabel labOutput;
	Core core;
	private JTextField txtEmail;
	public IniPage() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPane = new JPanel();
		
		getContentPane().add(contentPane, BorderLayout.CENTER);
		contentPane.setLayout(null);
		
		
		txtEmail = new JTextField();
		txtEmail.setBounds(10, 143, 364, 23);
		contentPane.add(txtEmail);
		
		
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] parts = txtEmail.getText().split("@");
				if (parts.length == 2 && parts[1].indexOf(".")!=-1){ // Check for only one @ and atleast one. -Ole
					System.out.println("working");
					try {
						core = new Core();
						core.showGUI(txtEmail.getText());
						disposeThis();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else 
					labOutput.setText("Ikke gyldig email.");
					txtEmail.requestFocus();
			}
		});
		txtEmail.requestFocus();
		btnOk.setBounds(150, 177, 89, 23);
		contentPane.add(btnOk);
		this.getRootPane().setDefaultButton(btnOk);
		
		JPanel imgPanel = new JPanel();
		imgPanel.setBounds(72, 11, 208, 101);
		contentPane.add(imgPanel);
		
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("koie_login.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		imgPanel.add(txtEpos);
		
		
		txtEpos.setEditable(false);
		txtEpos.setBackground(contentPane.getBackground());
		txtEpos.setText("Epost adresse:");
		
		imgPanel.add(picLabel);
		
		labOutput = new JLabel();
		labOutput.setBounds(66, 118, 214, 14);
		contentPane.add(labOutput);
		txtEmail.requestFocus();		
	}	

	public static void main(String[] args) {  
		try {
			UIManager.setLookAndFeel ( WebLookAndFeel.class.getCanonicalName () );
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		IniPage initer = new IniPage();
		initer.show();
		initer.setSize(400, 250);
		initer.setResizable(false);
	}
	public void disposeThis(){
		this.dispose();
	}
}
