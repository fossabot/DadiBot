package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.dv8tion.jda.core.entities.Guild;

public class Prefix {

	public String prefix(Guild server) {
		try {
       		Class.forName("com.mysql.jdbc.Driver");
       	} catch (ClassNotFoundException ex) {
       		ex.printStackTrace();
       	}
     	String prefix = "-";
      	Connection connection = null;
       	
       	try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "settings","root", Statics.pwd);
			
       		String query = "SELECT state FROM prefix WHERE guild='" + server.getId() + "'";
       		final PreparedStatement ps = connection.prepareStatement(query);
   			final ResultSet resultSet = ps.executeQuery();
   			if(resultSet.next()) {	
   				prefix = resultSet.getString(1);
   			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return "-";
	}
	
}
