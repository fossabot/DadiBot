package commands;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import util.Prefix;
import util.Statics;

public class Jokes {

	public int score(Guild server, Member member) {
     	try {
       		Class.forName("com.mysql.jdbc.Driver");
       	} catch (ClassNotFoundException ex) {
       		ex.printStackTrace();
       	}
     	int sc = 0;
      	Connection connection = null;
       	Statement s = null;
       	
       	try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + server.getId(),"root", Statics.pwd);
			
       		s = connection.createStatement();
       		String query = "SELECT level FROM members WHERE member='" + member.getUser().getId() + "'";
       		final PreparedStatement ps = connection.prepareStatement(query);
   			final ResultSet resultSet = ps.executeQuery();
   			if(resultSet.next()) {	
   				sc = resultSet.getInt(1);
   			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
       	
       	return sc;
		
	}
	
	
	public EmbedBuilder jokes(Guild server, Member member) {
		Prefix pr = new Prefix();
		String prefix = pr.prefix(server);
		EmbedBuilder eb = new EmbedBuilder();
		Jokes jokes = new Jokes();
		int lvl = jokes.score(server, member);
		
		eb.setColor(Color.decode("#F39C12"));
		eb.setDescription(member.getAsMention() + " is level **" + lvl + "**!");
		
		return eb;

	}
	
	
}
