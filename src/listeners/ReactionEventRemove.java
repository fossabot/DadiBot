package listeners;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;
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
import net.dv8tion.jda.core.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.requests.RestAction;
import util.Prefix;
import util.Statics;

public class ReactionEventRemove extends ListenerAdapter{

	Properties prop = new Properties();
	OutputStream output = null;
	InputStream input = null;
	
	@Override
	public void onMessageReactionRemove(MessageReactionRemoveEvent e) {
		if (e.getChannel().getName().equalsIgnoreCase("witze")) {

			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException ex) {
				System.out.println(Prefix.error + "There was an ClassNotFoundException while the initialization of the JDBC Driver!");
			}
			Connection connection = null;
			Statement s = null;
			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + e.getGuild().getId(), "root", Statics.pwd);

				s = connection.createStatement();
				String query1 = "SELECT * FROM messages WHERE message='" + e.getMessageId() + "'";
				final PreparedStatement ps = connection.prepareStatement(query1);

				if (e.getReactionEmote().getName().equals("👍")) {
					final ResultSet rs = ps.executeQuery();

					while (rs.next()) {
						String memb = rs.getString(2);
						s.executeUpdate("INSERT INTO members (member, level) VALUES ('" + memb + "', 0) ON DUPLICATE KEY UPDATE level = level-1");
					}

				}

			} catch (SQLException ex) {
				System.out.println(Prefix.error + "There was an SQLException while adding a Reaction!");
				return;
			}

		}
	}
}
