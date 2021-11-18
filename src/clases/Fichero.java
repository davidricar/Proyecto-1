package clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Fichero {

	/**
	 * Se guarda en el fichero el deporte insertado en la ventada Anadir Deporte.
	 * @param contenido, array de tipo derpote
	 * @param nomDeporte , nombre de deporte
	 */

	public static void guardarDeporte(ArrayList<Deporte> contenido, String nomDeporte){
		File F = new File("."+File.separator+"src"+File.separator+nomDeporte+".txt");
		try {
			FileWriter w = new FileWriter(F);
			BufferedWriter bw = new BufferedWriter(w);
			for (int i = 0; i < contenido.size(); i++) {
				bw.write(contenido.get(i).formatoFichero()+"\n");
			}
			bw.flush();
			bw.close();
			w.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void guardarPais(ArrayList<Pais> contenido, String nomPais){
		File F = new File("."+File.separator+"src"+File.separator+"deportes"+File.separator+nomPais+".txt");
		try {
			FileWriter w = new FileWriter(F);
			BufferedWriter bw = new BufferedWriter(w);
			for (int i = 0; i < contenido.size(); i++) {
				bw.write(contenido.get(i).formatoFichero()+"\n");
			}
			bw.flush();
			bw.close();
			w.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void guardarDeportista(ArrayList<Deportista> contenido, String nomDeportista){
		File F = new File("."+File.separator+"src"+File.separator+"deportes"+File.separator+"paises"+File.separator+nomDeportista+".txt");
		try {
			FileWriter w = new FileWriter(F);
			BufferedWriter bw = new BufferedWriter(w);
			for (int i = 0; i < contenido.size(); i++) {
				bw.write(contenido.get(i).formatoFichero()+"\n");
			}
			bw.flush();
			bw.close();
			w.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
//	public static void guardarMedallas(ArrayList<Medalla> contenido, String nomDeportista){
//		File F = new File("."+File.separator+"src"+File.separator+"deportes"+File.separator+"paises"+File.separator+"deportistas"+File.separator+nomDeportista+".txt");
//		try {
//			FileWriter w = new FileWriter(F);
//			BufferedWriter bw = new BufferedWriter(w);
//			for (int i = 0; i < contenido.size(); i++) {
//				bw.write(contenido.get(i).formatoFichero()+"\n");
//			}
//			bw.flush();
//			bw.close();
//			w.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	

	/**
	 * Este método lee del fichero deporte para luego cargarlo en un array y mostrarlo en la VentanaDeporte 
	 * @param nomFichero String del nombre del fichero al que lo paso
	 * @return d--> devuelve el variable de tipo deporte donde se han anadido todos los deportes en el fichero deportes.txt
	 * 				dividido los atributos de cada deporte con ";".
	 */

	public static ArrayList<Deporte> leerDeporte(String nomFichero){
		ArrayList<Deporte>d = new ArrayList<Deporte>();
		FileReader reader;
		try {
			reader = new FileReader("."+File.separator+"src"+File.separator+nomFichero);
			BufferedReader bf = new BufferedReader(reader);
			String text = bf.readLine();
			String []textoDividido;
			while (text!=null) {
				textoDividido = text.split(";");
				Deporte de = new Deporte(textoDividido[0],textoDividido[1]);
				d.add(de);
				text = bf.readLine();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return d;
	}
	public static ArrayList<Pais> leerPaises(String nomFichero){
		ArrayList<Pais>p = new ArrayList<Pais>();
		FileReader reader;
		try {
			reader = new FileReader("."+File.separator+"src"+File.separator+nomFichero);
			BufferedReader bf = new BufferedReader(reader);
			String text = bf.readLine();
			String[] textoDividido;
			while (text!=null) {
				textoDividido = text.split(";");
				Pais pa = new Pais(textoDividido[0]);
				p.add(pa);
				text = bf.readLine();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
		
	}
	public static ArrayList<Deportista> leerDeportistas(String nomFichero){
		ArrayList<Deportista>dep = new ArrayList<Deportista>();
		FileReader reader;
		try {
			reader = new FileReader("."+File.separator+"src"+File.separator+nomFichero);
			BufferedReader bf = new BufferedReader(reader);
			String text = bf.readLine();
			String[] textoDividido;
			while (text!=null) {
				textoDividido = text.split(";");
				Deportista deportista = new Deportista(textoDividido[0],textoDividido[1],Integer.parseInt(textoDividido[2]),Integer.parseInt(textoDividido[3]));
				dep.add(deportista);
				text = bf.readLine();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dep;
		
	}
//	public static ArrayList<Medalla> leerMedallas(String nomFichero){
//		ArrayList<Medalla>med = new ArrayList<Medalla>();
//		FileReader reader;
//		try {
//			reader = new FileReader("."+File.separator+"src"+File.separator+nomFichero);
//			BufferedReader bf = new BufferedReader(reader);
//			String text = bf.readLine();
//			String[] textoDividido;
//			while (text!=null) {
//				textoDividido = text.split(";");
//				Medalla medallas = new Medalla(textoDividido[0]);
//				med.add(medallas);
//				text = bf.readLine();
//			}
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return med;
//		
//	}

	/**
	 * Este metodo sirve para eliminar del Fichero el variable indicado
	 * @param ruta --> pasa al método el nombre del fichero que se quiere eliminar
	 */

	public static void eliminarFichero(String ruta) {
		File f = new File(ruta);
		f.delete();
	}
	
}