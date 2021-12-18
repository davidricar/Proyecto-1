package VentanasSecundarias;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.event.ListSelectionListener;

import clases.Deporte;
import clases.Fichero;
import interfaz.I_Comparable;

import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class VentanaDeporte extends JFrame {

	private JPanel contentPane;
	private ArrayList<Deporte> lista_deportes;
	private ArrayList<Deporte> lista_deportesordenado;
	private JList list;
	private JButton btnVerDeporte;
	private JButton btnVolver;
	private JButton btnAnadirDeportes;
	private JButton btnEliminarDeporte;


	/**
	 * Create the frame.
	 */
	public VentanaDeporte(JFrame ventanaAnterior) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		list = new JList();
		cargarlistaDeporte();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				btnVerDeporte.setEnabled(true);
				btnEliminarDeporte.setEnabled(true);
			}
		});
		list.setBounds(64, 33, 130, 180);
		contentPane.add(list);
		
		btnVerDeporte = new JButton("Ver deporte");
		btnVerDeporte.setEnabled(false);
		btnVerDeporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String deporte = (String) list.getSelectedValue();
				JFrame ventana = new VentanaPais(deporte,VentanaDeporte.this);
				VentanaDeporte.this.setVisible(false);
				ventana.setVisible(true);
			}
		});
		btnVerDeporte.setBounds(239, 41, 141, 23);
		contentPane.add(btnVerDeporte);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaAnterior.setVisible(true);
				VentanaDeporte.this.dispose();
			}
		});
		btnVolver.setBounds(239, 209, 141, 23);
		contentPane.add(btnVolver);
		
		btnAnadirDeportes = new JButton("Anadir Deporte");
		btnAnadirDeportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame ventanaanadir = new AnadirDeporte(ventanaAnterior,lista_deportes);
				VentanaDeporte.this.dispose();
				ventanaanadir.setVisible(true);
			}
		});
		btnAnadirDeportes.setBounds(239, 102, 141, 23);
		contentPane.add(btnAnadirDeportes);
		
		btnEliminarDeporte = new JButton("Eliminar Deporte");
		btnEliminarDeporte.setEnabled(false);
		btnEliminarDeporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedItem = list.getSelectedIndex();
				Fichero.eliminarFichero("."+File.separator+"src"+File.separator+"deportes"+File.separator+lista_deportes.get(selectedItem).getTipodeporte()+".txt");
				lista_deportes.remove(selectedItem);
				Fichero.guardarDeporte(lista_deportes, "Deportes");
				JOptionPane.showMessageDialog(VentanaDeporte.this,"Deporte eliminado(pulsa volver para actualizar)");
				
			}
		});
		btnEliminarDeporte.setBounds(239, 154, 141, 23);
		contentPane.add(btnEliminarDeporte);
		
		
	}
	  public static <Deporte extends I_Comparable<Deporte>> ArrayList<Deporte> mergeSortString(ArrayList<Deporte> list) {
	        if (list.size() == 1) return list;
	        else {
	            ArrayList<Deporte> listLeft = new ArrayList<Deporte>(list.subList(0, list.size() / 2));
	            ArrayList<Deporte> listRight = new ArrayList<Deporte>(list.subList(list.size() / 2, list.size()));

	            listLeft = mergeSortString(listLeft);
	            listRight = mergeSortString(listRight);

	            return mergeStringDeporte(listLeft, listRight);
	        }


	    }
	  public static <Deporte extends I_Comparable<Deporte>> ArrayList<Deporte> mergeStringDeporte(ArrayList<Deporte> a, ArrayList<Deporte> b) {
	        ArrayList<Deporte> c = new ArrayList<>();
	        while (!a.isEmpty() && !b.isEmpty()) {
	            if (a.get(0).compareStr(b.get(0))) {
	                c.add(b.get(0));
	                b.remove(0);
	            } else {
	                c.add(a.get(0));
	                a.remove(0);
	            }
	        }
	        //At this point either a or b is empty
	        while (!a.isEmpty()) {
	            c.add(a.get(0));
	            a.remove(0);
	        }
	        while ((!b.isEmpty())) {
	            c.add(b.get(0));
	            b.remove(0);
	        }
	        return c;
	    }
public void cargarlistaDeporte() {
	lista_deportes=Fichero.leerDeporte("Deportes.txt");
	lista_deportesordenado=mergeSortString(lista_deportes);
	DefaultListModel<String> lista_paises = new DefaultListModel<String>();
	for (int i = 0; i < lista_deportes.size(); i++) {
		Deporte deportes = this.lista_deportes.get(i);
		lista_paises.addElement(deportes.getTipodeporte());
		
		
	}
	list.setModel(lista_paises);
}
public ArrayList<Deporte> getDeportes() {
	return lista_deportes;
}
public void setDatos(ArrayList<Deporte> lista_deportes) {
	this.lista_deportes = lista_deportes;
}
@Override
public String toString() {
	return "VentanaDeporte [contentPane=" + contentPane + ", lista_deportes=" + lista_deportes
			+ ", lista_deportesordenado=" + lista_deportesordenado + ", list=" + list + ", btnVerDeporte="
			+ btnVerDeporte + ", btnVolver=" + btnVolver + ", btnAnadirDeportes=" + btnAnadirDeportes
			+ ", btnEliminarDeporte=" + btnEliminarDeporte + "]";
}

}

