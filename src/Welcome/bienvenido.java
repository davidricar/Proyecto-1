package Welcome;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import VentanasSecundarias.VentanaDeporte;

//import VentanasSecundarias.VentanaDeporte;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class bienvenido extends JFrame { 

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					bienvenido frame = new bienvenido();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public bienvenido() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbtextoolimpiada = new JLabel("Olimpiadas 2020");
		lbtextoolimpiada.setBounds(173, 80, 101, 28);
		contentPane.add(lbtextoolimpiada);
		
		JButton btnDeportes = new JButton("Deportes");
		btnDeportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				VentanaDeporte d = new VentanaDeporte(bienvenido.this);
				d.setVisible(true);
				
				
				
				
				
			}
		});
		btnDeportes.setBounds(149, 116, 125, 50);
		contentPane.add(btnDeportes);
		
		JLabel labelolimpic = new JLabel();
		labelolimpic.setBounds(112, 0, 205, 81);
		String path="olimpiadas.png";
		contentPane.add(labelolimpic);
		ImageIcon imageolimpiada = new ImageIcon(path);
		Image img = imageolimpiada.getImage();
		Image newimg = img.getScaledInstance(labelolimpic.getWidth(), labelolimpic.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newimg);
		labelolimpic.setIcon(image);
		
	}
}