package ie.mike;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class app 
{
    public static void main( String[] args )
    {
    String connectionString = "Server=tcp:scom673.database.windows.net,1433;Initial Catalog=DCOM673;Persist Security Info=False;User ID={Mike};Password={Fbs@330320};MultipleActiveResultSets=False;Encrypt=True;TrustServerCertificate=False;Connection Timeout=30;";

	// Create the connection object
	Connection connection = null;  

	try 
	{  
	    // Attempt to connect to the database
	    System.out.println("Attempting to connect to the database...");
	    connection = DriverManager.getConnection(connectionString);  
	    // Success!
	    System.out.println("Connected...");
	}
	catch(Exception e)
	{
	    // Not success!
	    System.out.println(e.getMessage());
	}
    }
}