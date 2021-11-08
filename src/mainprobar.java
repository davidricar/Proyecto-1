
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import GestorBD.*;

public class mainprobar {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		DBManager miManager = new DBManager("Mibases.db");
		miManager.createNewDatabase("MiBases.db");
		miManager.createLink();
		miManager.createNewTable1();
		miManager.insert("as", "masculino", 19);
		
		miManager.closeLink();
		//miManager.createNewDatabase("Mibases.db");
		
		

}

}
