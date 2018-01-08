package commands;

import java.awt.Color;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;
import util.Prefix;

public class Serverinfo {

	public EmbedBuilder sinfo(Guild server) {
		Prefix pr = new Prefix();
		String prefix = pr.prefix(server);
		
		EmbedBuilder eb = new EmbedBuilder();
		
		eb.setColor(Color.decode("#3498DB"));
		
		eb.setTitle("Server Info");
		eb.addField("▪ Server Name", server.getName(), false);
		eb.addBlankField(false);
		eb.addField("▪ Server ID", server.getId(), false);
		eb.addBlankField(false);
		eb.addField("▪ Icon", server.getIconUrl(), false);
		eb.setImage(server.getIconUrl());

		
		return eb;
	}
	
}
