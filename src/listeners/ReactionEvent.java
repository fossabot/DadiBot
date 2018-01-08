package listeners;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import net.dv8tion.jda.client.events.message.group.react.GroupMessageReactionAddEvent;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.emote.EmoteAddedEvent;
import net.dv8tion.jda.core.events.emote.update.GenericEmoteUpdateEvent;
import net.dv8tion.jda.core.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.core.events.message.react.GenericMessageReactionEvent;
import net.dv8tion.jda.core.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.requests.RestAction;
import util.Statics;

public class ReactionEvent extends ListenerAdapter{

	Properties prop = new Properties();
	OutputStream output = null;
	InputStream input = null;
	
	@Override
	public void onMessageReactionAdd(MessageReactionAddEvent e) {
		if(e.getChannel().getName().equalsIgnoreCase("witze")) {

				
			if(e.getReactionEmote().getName().equals("👍")) {
					
				RestAction<Message> m = e.getChannel().getMessageById(e.getMessageIdLong());
				
		       	try {
		       		Class.forName("com.mysql.jdbc.Driver");
		       	} catch (ClassNotFoundException ex) {
		       		ex.printStackTrace();
		       		return;
		       	}
		      	Connection connection = null;
		       	Statement s = null;
		       	try {
		       		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + e.getGuild().getId(),"root", Statics.pwd);
		       		
		       		s = connection.createStatement();
		       		ResultSet rs = s.executeQuery("SELECT * FROM messages WHERE message='" + e.getMessageId() + "'");
		       		while(rs.next()) {
		       			System.out.println(rs.getString(1));
		       			System.out.println(rs.getString(2));
		       			System.out.println(e.getGuild().getMemberById(rs.getString(2)).getEffectiveName());
		       		}
/*		       		ResultSet rs2 = s.executeQuery("SELECT level FROM members WHERE member='" + "EweLoHD" + "'");
		       		while(rs2.next()) {
		       			int lvl = rs2.getInt(1) + 1;*/
		       			s.executeUpdate("REPLACE INTO members SET member='EweLoHD', level=1");
		       		//}
		       		
		       		
		        				
		       	} catch (SQLException ex) {
		       		ex.printStackTrace();
		       		return;
		       	}
			}		
		}
	}
}
