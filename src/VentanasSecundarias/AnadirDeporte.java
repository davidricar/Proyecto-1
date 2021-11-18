package VentanasSecundarias;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Deporte;
import clases.Fichero;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class AnadirDeporte extends JFrame {

	
/**
 */

	private JPanel contentPane;
	private ArrayList<Deporte> lista_deportes;
	private JTextField textFieldNombreDeporte;
	private Deporte deporte;


	/**
	 * Create the frame.
	 */

	/**
	 * 
	 * @param VentanaAnterior hace referencia a la ventana bienvenido
	 * @param lista es un arraylist de tipo deportes en la que paso desde la ventana anterior (VentanaDeporte), 
	 * y donde se guardan los deportes definidos en la interfaz, y luego las escribe en el fichero.
	 */

	public AnadirDeporte(JFrame VentanaAnterior,ArrayList<Deporte> lista) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.lista_deportes = lista;
		
		JButton btnGuardar = new JButton("Guardar");
		
		btnGuardar.setBounds(281, 185, 89, 23);
		contentPane.add(btnGuardar);
		
		textFieldNombreDeporte = new JTextField();
		textFieldNombreDeporte.setBounds(158, 50, 129, 23);
		contentPane.add(textFieldNombreDeporte);
		textFieldNombreDeporte.setColumns(10);
		
		JLabel lblNombreDeporte = new JLabel("Nombre Deporte");
		lblNombreDeporte.setBounds(25, 54, 123, 14);
		contentPane.add(lblNombreDeporte);
		
		JLabel lblsexo = new JLabel("Sexo");
		lblsexo.setBounds(35, 118, 49, 14);
		contentPane.add(lblsexo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(158, 114, 129, 22);
		contentPane.add(comboBox);
		comboBox.addItem("Masculino");
		comboBox.addItem("Femenino");
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAnterior.setVisible(true);
				AnadirDeporte.this.dispose();
			}
		});
		btnVolver.setBounds(141, 185, 89, 23);
		contentPane.add(btnVolver);
		
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lista_deportes.add(new Deporte(textFieldNombreDeporte.getText(), (String) comboBox.getSelectedItem()));
				Fichero.guardarDeporte(lista_deportes, "Deportes");
				JOptionPane.showMessageDialog(AnadirDeporte.this,"Deporte Insertado");
			}
		});
		
	}
}
