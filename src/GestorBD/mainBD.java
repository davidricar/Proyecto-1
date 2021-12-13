package GestorBD;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;


public class mainBD {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		DBManager miManager = new DBManager("Mibase.db");
		
		miManager.createNewDatabase("MiBase.db");
		miManager.createLink();
		
		miManager.createNewTableDeporte();
		miManager.insertTableDeporte("Cricket","Masculino");
		
		miManager.createNewTablePais();
		miManager.insertTablePais("PAK");
		
		miManager.createNewTableDeportista();
		miManager.insertTableDeportista("Mahdmit", "masculino", 24,19);
		
		miManager.createNewTableMedalla();
		miManager.insertTableMedalla(19, 1, 2, 0);
		
		
		miManager.selectAllPais();
		miManager.selectAllDeportes();
		miManager.selectAllDeportistas();
		miManager.selectEdadDeportistaMayorQue(30);
		miManager.selectEdadDeportistaMenorQue(28);
		miManager.selectMedallasDeportistas(15);
		
		
		

	


		miManager.closeLink();


		//miManager.createNewDatabase("Mibases.db");
		
		

}

}
