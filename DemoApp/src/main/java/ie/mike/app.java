package ie.mike;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class app 
{
    public static void main( String[] args )
    {
    String connectionString = "jdbc:sqlserver://scom673.database.windows.net:1433;database=DCOM673;user=Mike@scom673;password={Fbs@330320};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";


	// Create the connection object
	Connection connection = null;  

	try 
	{  
	    // Attempt to connect to the database
	    System.out.println("Attempting to connect to the database...");
	    connection = DriverManager.getConnection(connectionString);  
		// Success!
		// Execute a query against the database and return rows (if any) to the ResultSet
ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM customerTable");
// The ResultSet places the current row directly before the first row. Calling next() moves it to the next row, and returns true if there is a row. False if there is no row there.
while(rs.next())
{              
	if(rs.getBoolean("paid") == true) // If the current row has true for the boolean column 'paid'
	{  
    		// Print out a message made up from the columns in the database 
    		System.out.println(rs.getString("first_name") + " " + rs.getString("last_name") + " has paid " + rs.getDouble("amount"));
	}
	else
	{
    		System.out.println(rs.getString("first_name") + " " + rs.getString("last_name") + " has not paid " + rs.getDouble("amount"));
	}
}
	    System.out.println("Connected...");
	}
	catch(Exception e)
	{
	    // Not success!
	    System.out.println(e.getMessage());
	}
	}
}


