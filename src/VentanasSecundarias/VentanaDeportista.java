package VentanasSecundarias;
import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class VentanaDeportista extends JFrame {

	private JPanel contentPane;
	private ArrayList<Deportista>lista_deportistas;
	private JList list;
	private JButton btnVerDeportista;
	private JButton btnAnadirDeportista;
	private JButton btnEliminarDeportista;
	private JButton btnVolver;
	private JButton btnAnadirMedalla;
	


	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public VentanaDeportista(String pais, JFrame ventanaAnterior) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		list = new JList();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				
				btnVerDeportista.setEnabled(true);
				btnEliminarDeportista.setEnabled(true);
				btnAnadirMedalla.setEnabled(true);
			}
		});
		list.setBounds(25, 29, 124, 196);
		cargarlistaDeportista(pais);
		contentPane.add(list);
		
		btnVerDeportista = new JButton("Ver Deportista");
		btnVerDeportista.setEnabled(false);
		btnVerDeportista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String deportista = (String) list.getSelectedValue();
				
				ArrayList<Medalla> lista_medallas=Fichero.leerMedallas(File.separator + "deportes" + File.separator +"paises"+ File.separator+ "deportistas" +File.separator+deportista+ ".txt");
				String mensaje = deportista + " tiene las siguientes medallas\n";
				int contadororo =0 ;
				int contadorplata=0;
				int contadorcobre=0;
				int contadortotal=0;
				String tipomedallaoro = "Oro";
				String tipomedallaplata= "Plata";
				String tipomedallacobre = "Cobre";

				for (Medalla medalla : lista_medallas) {
					if (medalla.getTipomedalla().equals(tipomedallaoro)) {
						contadororo+=1;
						contadortotal+=1;
						
					}else if (medalla.getTipomedalla().equals(tipomedallaplata)) {
						contadorplata+=1;
						contadortotal+=1;

						
					}else if (medalla.getTipomedalla().equals(tipomedallacobre)) {
						contadorcobre+=1;
						contadortotal+=1;

						
					}
					

				} mensaje = mensaje+ "Oro: "+contadororo+"\nPlata: "+contadorplata+"\nCobre: "+contadorcobre+"\nTotal: "+contadortotal;
				JOptionPane.showMessageDialog(VentanaDeportista.this, mensaje);
			}
		});
		btnVerDeportista.setBounds(259, 42, 145, 23);
		contentPane.add(btnVerDeportista);
		
		btnAnadirDeportista = new JButton("Anadir Deportista");
		btnAnadirDeportista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame ventanaanadirdeportista = new AnadirDeportista(ventanaAnterior,lista_deportistas,pais);
				VentanaDeportista.this.setVisible(false);
				ventanaanadirdeportista.setVisible(true);
			}
		});
		btnAnadirDeportista.setBounds(259, 106, 145, 23);
		contentPane.add(btnAnadirDeportista);
		
		btnEliminarDeportista = new JButton("Eliminar Deportista");
		btnEliminarDeportista.setEnabled(false);
		btnEliminarDeportista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedItem = list.getSelectedIndex();
				Fichero.eliminarFichero("."+File.separator+"src"+File.separator+"deportes"+File.separator+"paises"+File.separator+"deportistas"+File.separator+lista_deportistas.get(selectedItem).getNomapellido()+".txt");
				lista_deportistas.remove(selectedItem);
				Fichero.guardarDeportista(lista_deportistas, pais);
				JOptionPane.showMessageDialog(VentanaDeportista.this,"Deportista eliminado(pulsa volver para actualizar)");

			}
		});
		btnEliminarDeportista.setBounds(259, 172, 145, 23);
		contentPane.add(btnEliminarDeportista);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaAnterior.setVisible(true);
				VentanaDeportista.this.dispose();
		}});
		btnVolver.setBounds(171, 206, 107, 46);
		contentPane.add(btnVolver);
		
		btnAnadirMedalla = new JButton("Anadir Medalla");
		btnAnadirMedalla.setEnabled(false);
		btnAnadirMedalla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String deportista = (String) list.getSelectedValue();
				ArrayList<Medalla> lista_medallas=Fichero.leerMedallas(File.separator + "deportes" + File.separator +"paises"+ File.separator+ "deportistas" +File.separator+deportista+ ".txt");
				JFrame ventana = new AnadirMedalla(lista_medallas,deportista);
				ventana.setVisible(true);

			}
		});
		btnAnadirMedalla.setBounds(303, 206, 123, 46);
		contentPane.add(btnAnadirMedalla);
	}
	public void cargarlistaDeportista(String pais) {
		lista_deportistas=Fichero.leerDeportistas(File.separator + "deportes" + File.separator +"paises"+ File.separator+ pais + ".txt");
		DefaultListModel<String> lista_deportistas_default = new DefaultListModel<String>();
		for (int i = 0; i < lista_deportistas.size(); i++) {
			Deportista deportista = lista_deportistas.get(i);
			lista_deportistas_default.addElement(deportista.getNomapellido());
			
			
		}
		list.setModel(lista_deportistas_default);
	}
}
