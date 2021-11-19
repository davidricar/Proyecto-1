package VentanasSecundarias;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Deportista;
import clases.Fichero;
import clases.Medalla;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class AnadirMedalla extends JFrame {

	private JPanel contentPane;
	private ArrayList<Medalla>lista_medallas;


	/**
	 * Create the frame.
	 */
	public AnadirMedalla(ArrayList<Medalla>lista, String deportista) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.lista_medallas=lista;
		
		JButton btnvolver = new JButton("volver");
		btnvolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		btnvolver.setBounds(251, 165, 89, 23);
		contentPane.add(btnvolver);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(57, 90, 102, 22);
		contentPane.add(comboBox);
		comboBox.addItem("Oro");
		comboBox.addItem("Plata");
		comboBox.addItem("Cobre");
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lista_medallas.add(new Medalla((String) comboBox.getSelectedItem()));
				Fichero.guardarMedallas(lista_medallas, deportista);
				JOptionPane.showMessageDialog(AnadirMedalla.this,"Medalla insertada");

			}
		});
		btnGuardar.setBounds(261, 90, 89, 23);
		contentPane.add(btnGuardar);

		
	}
}
