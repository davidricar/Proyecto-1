package GestorBD;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author David Pacheco
 *
 */
public class DBManager // esta clase del gestor, que resume el todo. Puedo usar esto como plantilla del proyecto
{
    private Connection conn;
    private String BDname;
    private final String URL = "jdbc:sqlite:";

    public static void createNewDatabase(String fileName)
    {

        String url = "jdbc:sqlite:" + fileName; 

        try (Connection conn = DriverManager.getConnection(url))//
        /*
         *  esta linea con apertura de recursos. si pongo try y (), cuando try termine el 
         *  string que esta en () se cierra automaticamente. Si ejecuto este archivo, se cierra la bd y sqlite la va a guardar 
         */
        {
            if (conn != null)
            {
                DatabaseMetaData meta = conn.getMetaData();// de esta manera puedo obtener informacion de bd
                System.out.println("The driver name is " + meta.getDriverName());               
                System.out.println("A new database has been created.");
            }
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
    }
//    public Connection connect(String filename)
//    
//    	
//    {
//    	String url = "jdbc:sqlite:" + filename; 
//        // SQLite connection string
//
//        Connection conn = null;
//
//        try
//        {
//            conn = DriverManager.getConnection(url);
//        } catch (SQLException e)
//        {
//            System.out.println(e.getMessage());
//        }
//
//        return conn;
//    }

    
    // Constructor
    public DBManager(String BDname)
    {
        this.BDname = this.URL + BDname;
    }

    public void createLink() throws SQLException
    {
        try
        {
            this.conn = DriverManager.getConnection(this.BDname);
            System.out.println("Link Connected");
        }
        catch (SQLException e)
        {
            System.out.println("BadAss error creating connection. " + e.getMessage());
        }
    }
   
    public void createNewTableDeporte() throws SQLException
    
    {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Table_With_Deporte (\n"
                + "    tipodeporte CHAR PRIMARY KEY,\n"
                + "    sexo CHAR NOT NULL\n"
                + ");";

        try
                (
                        // This is a try with resources syntax, resources taken here will be automatically freed at the end of the try block
                        Statement stmt = this.conn.createStatement()
                )
        {
            // create a new table
            boolean result = stmt.execute(sql);
        }
        catch (SQLException e)
        {
            System.out.println("BadAss error creating table. " + e.getMessage());
            System.out.println(sql);
        }
    }


    public void createNewTablePais() throws SQLException
    {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Table_With_Pais (\n"
                + "    nompais CHAR PRIMARY KEY\n"
                + ");";

        try
                (
                        // This is a try with resources syntax, resources taken here will be automatically freed at the end of the try block
                        Statement stmt = this.conn.createStatement()
                )
        {
            // create a new table
            boolean result = stmt.execute(sql);
        }
        catch (SQLException e)
        {
            System.out.println("BadAss error creating table. " + e.getMessage());
            System.out.println(sql);
        }
    }


    public void createNewTableDeportista() throws SQLException
    {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Table_With_Deportista (\n"
                + "    nomapellido CHAR PRIMARY KEY,\n"
                + "    sexo CHAR NOT NULL,\n"
                + "    edad INTEGER NOT NULL,\n"
                + "    idolimpico INTEGER NOT NULL\n"
                + ");";

        try
                (
                        // This is a try with resources syntax, resources taken here will be automatically freed at the end of the try block
                        Statement stmt = this.conn.createStatement()
                )
        {
            // create a new table
            boolean result = stmt.execute(sql);
        }
        catch (SQLException e)
        {
            System.out.println("BadAss error creating table. " + e.getMessage());
            System.out.println(sql);
        }
    }
   

    public void saveData(List<String> data) throws SQLException
    {
        for (String current : data)
        {
            this.insertTableDeportista(current, current, 0, 0);
        }
    }

    public void insertTableDeporte(String tipoderpote, String sexo) throws SQLException
    {
        // Take into account that SQLite id attribute is an special attribute that is autoincremented by SQLite
        String sql = "INSERT INTO Table_With_Deporte(tipodeporte, sexo) VALUES(?,?)";

        try
                (
                        
                        PreparedStatement pstmt = conn.prepareStatement(sql)
                )
        {
            pstmt.setString(1, tipoderpote);
            pstmt.setString(2, sexo);
            pstmt.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println("BadAss error executing insert. " + e.getMessage());
        }
    }

    public void insertTablePais(String nompais) throws SQLException
    {
        // Take into account that SQLite id attribute is an special attribute that is autoincremented by SQLite
        String sql = "INSERT INTO Table_With_Pais(nompais) VALUES(?)";

        try
                (
                        
                        PreparedStatement pstmt = conn.prepareStatement(sql)
                )
        {
            pstmt.setString(1, nompais);
            pstmt.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println("BadAss error executing insert. " + e.getMessage());
        }
    }


    public void insertTableDeportista(String nomapellido, String sexo, int edad, int idolimpico) throws SQLException
    {
        // Take into account that SQLite id attribute is an special attribute that is autoincremented by SQLite
        String sql = "INSERT INTO Table_With_Deportista(nomapellido, sexo, edad,idolimpico) VALUES(?,?,?,?)";

        try
                (
                        
                        PreparedStatement pstmt = conn.prepareStatement(sql)
                )
        {
            pstmt.setString(1, nomapellido);
            pstmt.setString(2, sexo);
        	pstmt.setInt(3, edad);
        	pstmt.setInt(4, idolimpico);
            pstmt.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println("BadAss error executing insert. " + e.getMessage());
        }
    }
    
 

    public void closeLink() throws SQLException
    {
        try
        {
            if (this.conn != null)
            {
                this.conn.close();
                System.out.println("Link Closed");
            }
        }
        catch (SQLException ex)
        {
            System.out.println("BadAss error closing connection" + ex.getMessage());
        }
    }
  

}