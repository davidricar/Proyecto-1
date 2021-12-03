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
		miManager.insertTablePais("IND");
		
		miManager.createNewTableDeportista();
		miManager.insertTableDeportista("Rahul", "masculino", 22,15);
		
		miManager.createNewTableMedalla();
		miManager.insertTableMedalla(15, 0, 1, 0);
		
		
		miManager.selectAllPais();
		miManager.selectAllDeportes();
		miManager.selectAllDeportistas();
		miManager.selectEdadDeportistaMayorQue(30);
		miManager.selectEdadDeportistaMenorQue(28);
		miManager.selectMedallasDeportistas(15);
		
		
		
		miManager.deleteDeportistaViaID(5);
	


		miManager.closeLink();


		//miManager.createNewDatabase("Mibases.db");
		
		

}

}
