package GestorBD;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.List;



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
            System.out.println("Connected");
        }
        catch (SQLException e)
        {
            System.out.println("BadAss error creating connection. " + e.getMessage());
        }
    }

    public void createNewTable() throws SQLException
    {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Table_With_Dates (\n"
                + "    nomapellido CHAR PRIMARY KEY,\n"
                + "    sexo CHAR NOT NULL,\n"
                + "    edad INTEGER NOT NULL\n"
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
            this.insert(current, current, 0);
        }
    }

    private void insert(String nomapellido, String sexo, int edad) throws SQLException
    {
        // Take into account that SQLite id attribute is an special attribute that is autoincremented by SQLite
        String sql = "INSERT INTO Table_With_Persona(nomapellidp, sexo, edad) VALUES(?,?,?)";

        try
                (
                        PreparedStatement pstmt = conn.prepareStatement(sql)
                )
        {
            pstmt.setString(1, nomapellido);
            pstmt.setString(2, sexo);
        	pstmt.setInt(3, edad);
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
            }
        }
        catch (SQLException ex)
        {
            System.out.println("BadAss error closing connection" + ex.getMessage());
        }
    }

}