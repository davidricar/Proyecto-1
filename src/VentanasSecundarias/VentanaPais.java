package VentanasSecundarias;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Fichero;
import clases.Pais;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class VentanaPais extends JFrame {

	private JPanel contentPane;
	private ArrayList<Pais>lista_paises;
	private JList list;
	private JButton btnDeportista;
	private JButton btnAnadirdeportista;
	private JButton btnEliminarDeportista;
	private JButton btnVolver;

	/**
	 * Create the frame.
	 */
	public VentanaPais(String deporte,JFrame ventanaAnterior) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		list = new JList();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				btnDeportista.setEnabled(true);
				btnEliminarDeportista.setEnabled(true);
				
			}
		});
		list.setBounds(33, 29, 107, 174);
		cargarlistaPais(deporte);
		contentPane.add(list);
		
		btnDeportista = new JButton("Ver Pais");
		btnDeportista.setEnabled(false);
//		btnDeportista.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				String pais = (String) list.getSelectedValue();
//				JFrame ventana = new VentanaDeportista(pais,VentanaPais.this);
//				VentanaPais.this.setVisible(false);
//				ventana.setVisible(true);
//			}
//			
//		});
		btnDeportista.setBounds(251, 48, 133, 23);
		contentPane.add(btnDeportista);
		
		btnAnadirdeportista = new JButton("Anadir Pais");
		btnAnadirdeportista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame ventanaanadirpais = new AnadirPais(ventanaAnterior,lista_paises, deporte);
				VentanaPais.this.setVisible(false);
				ventanaanadirpais.setVisible(true);
				
			}
		});
		btnAnadirdeportista.setBounds(251, 102, 133, 23);
		contentPane.add(btnAnadirdeportista);
		
		btnEliminarDeportista = new JButton("Eliminar pais");
		btnEliminarDeportista.setEnabled(false);
		btnEliminarDeportista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedItem = list.getSelectedIndex();
				Fichero.eliminarFichero("."+File.separator+"src"+File.separator+"deportes"+File.separator+"paises"+File.separator+lista_paises.get(selectedItem).getNompais()+".txt");
				lista_paises.remove(selectedItem);
				Fichero.guardarPais(lista_paises,deporte);
				JOptionPane.showMessageDialog(VentanaPais.this,"Pais eliminado(pulsa volver para actualizar)");

			}
		});
		btnEliminarDeportista.setBounds(251, 161, 133, 23);
		contentPane.add(btnEliminarDeportista);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaAnterior.setVisible(true);
				VentanaPais.this.dispose();
			}
		});
		btnVolver.setBounds(246, 229, 89, 23);
		contentPane.add(btnVolver);
	}
	public void cargarlistaPais(String deporte) {
		lista_paises=Fichero.leerPaises(File.separator + "deportes" + File.separator + deporte + ".txt");
		DefaultListModel<String> lista_paises_default = new DefaultListModel<String>();
		for (int i = 0; i < lista_paises.size(); i++) {
			Pais paises = lista_paises.get(i);
			lista_paises_default.addElement(paises.getNompais());
			
			
		}
		list.setModel(lista_paises_default);
	}
}
