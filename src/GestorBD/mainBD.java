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
		miManager.insertTableDeporte("Baseball","Femenino");
		
		miManager.createNewTablePais();
		miManager.insertTablePais("PER");
		
		miManager.createNewTableDeportista();
		miManager.insertTableDeportista("Olga", "femenino", 35,0010);



		miManager.closeLink();


		//miManager.createNewDatabase("Mibases.db");
		
		

}

}
