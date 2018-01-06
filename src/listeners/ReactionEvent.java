package listeners;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import net.dv8tion.jda.client.events.message.group.react.GroupMessageReactionAddEvent;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.emote.EmoteAddedEvent;
import net.dv8tion.jda.core.events.emote.update.GenericEmoteUpdateEvent;
import net.dv8tion.jda.core.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.core.events.message.react.GenericMessageReactionEvent;
import net.dv8tion.jda.core.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class ReactionEvent extends ListenerAdapter{

	Properties prop = new Properties();
	OutputStream output = null;
	InputStream input = null;
	
	public void onReaction(MessageReactionAddEvent e) {
		System.out.println("event: OK");
		if(e.getChannel().getName().equalsIgnoreCase("witze")) {
			System.out.println("channel: OK");
			try {
				output = new FileOutputStream("config.properties");
				input = new FileInputStream("config.properties");
				
				if(e.getReactionEmote().equals("👍")) {
					System.out.println("reaction: OK");
					Message m = (Message) e.getTextChannel().getMessageById(e.getMessageId());
					int score = Integer.parseInt(prop.getProperty(m.getAuthor().getName())) +1;
					
					prop.setProperty(m.getAuthor().getName(), Integer.toString(score));
				}
				
				
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
