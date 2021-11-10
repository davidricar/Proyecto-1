package VentanasSecundarias;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Fichero;
import clases.Pais;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AnadirPais extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombrepais;
	private ArrayList<Pais>lista_paises;
	private Pais pais;
	

	/**
	 * Launch the application.
	 */

	public AnadirPais(JFrame VentanaAnterior,ArrayList<Pais>lista, String pais) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.lista_paises=lista;
		
		JLabel lblNombrePais = new JLabel("Nombre Pais");
		lblNombrePais.setBounds(35, 123, 76, 14);
		contentPane.add(lblNombrePais);
		
		textFieldNombrepais = new JTextField();
		textFieldNombrepais.setBounds(154, 120, 96, 20);
		contentPane.add(textFieldNombrepais);
		textFieldNombrepais.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(234, 195, 96, 23);
		contentPane.add(btnGuardar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAnterior.setVisible(true);
				AnadirPais.this.dispose();
			}
		});
		btnVolver.setBounds(100, 195, 89, 23);
		contentPane.add(btnVolver);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lista_paises.add(new Pais(textFieldNombrepais.getText()));
				Fichero.guardarPais(lista_paises,pais);
				JOptionPane.showMessageDialog(AnadirPais.this,"Pais Insertado");

			}
		});
		
		
	}

}
