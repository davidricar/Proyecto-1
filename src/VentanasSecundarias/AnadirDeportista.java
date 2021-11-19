package VentanasSecundarias;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Deportista;
import clases.Fichero;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class AnadirDeportista extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombreDeportista;
	private JTextField textFieldEdad;
	private JTextField textFieldidDeportista;
	private ArrayList<Deportista>lista_deportistas;
	private Deportista deportista;
	/**
	 * Launch the application.
	 */
	
	public AnadirDeportista(JFrame VentanaAnterior,ArrayList<Deportista>lista, String pais) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.lista_deportistas=lista;
		
		JLabel lblNombreDeportista = new JLabel("Nombre Deportista");
		lblNombreDeportista.setBounds(27, 43, 125, 26);
		contentPane.add(lblNombreDeportista);
		
		JLabel lblNombreSexo = new JLabel("Sexo");
		lblNombreSexo.setBounds(27, 90, 133, 26);
		contentPane.add(lblNombreSexo);
		
		JLabel lbledad = new JLabel("Edad");
		lbledad.setBounds(27, 143, 49, 14);
		contentPane.add(lbledad);
		
		JLabel lblidDeportista = new JLabel("ID Deportista");
		lblidDeportista.setBounds(27, 185, 80, 14);
		contentPane.add(lblidDeportista);
		
		textFieldNombreDeportista = new JTextField();
		textFieldNombreDeportista.setBounds(160, 46, 96, 20);
		contentPane.add(textFieldNombreDeportista);
		textFieldNombreDeportista.setColumns(10);
		
		textFieldEdad = new JTextField();
		textFieldEdad.setBounds(160, 140, 96, 20);
		contentPane.add(textFieldEdad);
		textFieldEdad.setColumns(10);
		
		textFieldidDeportista = new JTextField();
		textFieldidDeportista.setBounds(160, 182, 96, 20);
		contentPane.add(textFieldidDeportista);
		textFieldidDeportista.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(287, 213, 89, 23);
		contentPane.add(btnGuardar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(160, 92, 96, 14);
		contentPane.add(comboBox);
		comboBox.addItem("Masculino");
		comboBox.addItem("Femenino");
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAnterior.setVisible(true);
				AnadirDeportista.this.dispose();
			}
		});
		btnVolver.setBounds(135, 213, 89, 23);
		contentPane.add(btnVolver);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int edadint = Integer.parseInt(textFieldEdad.getText());
				int idint= Integer.parseInt(textFieldidDeportista.getText());
				ArrayList<Deportista> lista_deportistas1=Fichero.leerDeportistas(File.separator + "deportes" + File.separator +"paises"+ File.separator+pais +".txt");
				int i = 0;
				boolean coincide = false;
				while (i < lista_deportistas1.size() && !coincide) {
					if(lista_deportistas1.get(i).getIdolimpico() == idint) {
						coincide = true;
					}
					i++;
				}
				if(coincide) {
					JOptionPane.showMessageDialog(AnadirDeportista.this,"IDolimpico coincide, volver a rellenar");
				} else {
					lista_deportistas.add(new Deportista(textFieldNombreDeportista.getText(), (String) comboBox.getSelectedItem(), edadint, idint));
					Fichero.guardarDeportista(lista_deportistas, pais);
					JOptionPane.showMessageDialog(AnadirDeportista.this,"Deportista Insertado");
				}
					
				

			}
		});
		
	}
}
