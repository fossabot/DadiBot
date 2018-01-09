package commands;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import util.Prefix;
import util.Statics;

public class Jokes {

	public EmbedBuilder jokes(Guild server, Member member) {
		Prefix pr = new Prefix();
		String prefix = pr.prefix(server);
		
		EmbedBuilder eb = new EmbedBuilder();
		
		eb.setColor(Color.decode("#F39C12"));
		
       	try {
       		Class.forName("com.mysql.jdbc.Driver");
       	} catch (ClassNotFoundException ex) {
       		ex.printStackTrace();
       	}
      	Connection connection = null;
       	Statement s = null;
       	try {
       		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + server.getId(),"root", Statics.pwd);
       		
       		s = connection.createStatement();
       		ResultSet rs = s.executeQuery("SELECT level FROM members WHERE member='" + member.getUser().getId() + "'");
   			
   			while(rs.next()) {
   				int lvl = rs.getInt(1);
   					eb.setDescription(member.getAsMention() + " is level **" + lvl + "**!");
   			}
       		

       	} catch (SQLException ex) {
       		ex.printStackTrace();
       	}
		return eb;
	}
	/*public EmbedBuilder top_jokes(Guild server, Member member) {
		Prefix pr = new Prefix();
		String prefix = pr.prefix(server);
		
		EmbedBuilder eb = new EmbedBuilder();
		
		eb.setColor(Color.decode("#F39C12"));
		
       	try {
       		Class.forName("com.mysql.jdbc.Driver");
       	} catch (ClassNotFoundException ex) {
       		ex.printStackTrace();
       	}
      	Connection connection = null;
       	Statement s = null;
       	try {
       		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + server.getId(),"root", Statics.pwd);
       		
       		s = connection.createStatement();
       		ResultSet rs = s.executeQuery("SELECT TOP 10  FROM Customers");
   			
   			while(rs.next()) {
   				int lvl = rs.getInt(1);
   					eb.setDescription(member.getAsMention() + " is level **" + lvl + "**!");
   			}
       		

       	} catch (SQLException ex) {
       		//ex.printStackTrace();
       	}
		return eb;
	}*/
	
}
