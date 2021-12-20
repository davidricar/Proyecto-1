package clasesrecursivas;

import java.util.ArrayList;
import java.util.Collections;

import clases.Deporte;
import interfaz.I_Comparable;

public class Sorting {

	public static ArrayList<clases.Deporte> mergeSortStr1(ArrayList<clases.Deporte> lista_deportes) {
        if (lista_deportes.size() == 1) return lista_deportes;
        else {
            ArrayList<Deporte> listLeft = new ArrayList<Deporte>(lista_deportes.subList(0, lista_deportes.size() / 2));
            ArrayList<Deporte> listRight = new ArrayList<Deporte>(lista_deportes.subList(lista_deportes.size() / 2, lista_deportes.size()));

            listLeft = mergeSortStr1(listLeft);
            listRight = mergeSortStr1(listRight);

            return (ArrayList<clases.Deporte>) mergeStr1(listLeft, listRight);
        }


    }
	  private static ArrayList<Deporte> mergeStr1(ArrayList<clases.Deporte> a, ArrayList<clases.Deporte> b) {
		  ArrayList<Deporte> c = new ArrayList<>();
	        while (!a.isEmpty() && !b.isEmpty()) {
	            if (((clases.Deporte) a.get(0)).compareStr1(b.get(0))) {
	                c.add((Deporte) b.get(0));
	                b.remove(0);
	            } else {
	                c.add((Deporte) a.get(0));
	                a.remove(0);
	            }
	        }
	        //At this point either a or b is empty
	        while (!a.isEmpty()) {
	            c.add((Deporte) a.get(0));
	            a.remove(0);
	        }
	        while ((!b.isEmpty())) {
	            c.add((Deporte) b.get(0));
	            b.remove(0);
	        }
	        return c;
	}
	  
}
