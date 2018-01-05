package commands;

import java.awt.Color;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;
import util.Prefix;

public class Help {

	public EmbedBuilder help(Guild server) {
		Prefix pr = new Prefix();
		String prefix = pr.prefix(server);
		
		EmbedBuilder eb = new EmbedBuilder();
		
		eb.setColor(Color.decode("#3498DB"));
		
		eb.setTitle("Help");
		
		eb.addField("▪ Commands", "Use `" + prefix + "modules` to see all the modules/categories of commands. \nTo see all the commands of a module use `" + prefix + "commands <module>`.", false);
		eb.addBlankField(true);
		eb.addField("▪ Other Informations", "To get informations about inviting the Bot,getting on my Discord, Wiki and more, use `" + prefix + "info`.", false);
		
		return eb;
	}
	
}
