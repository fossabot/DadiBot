package commands;

import java.awt.Color;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;
import util.Prefix;

public class ModuleHelp {

	public EmbedBuilder modulehelp(Guild server) {
		Prefix pr = new Prefix();
		String prefix = pr.prefix(server);
		
		EmbedBuilder eb = new EmbedBuilder();
		
		eb.setColor(Color.decode("#1ABC9C"));
		eb.setTitle("Help");
		
		eb.addField("▪ " + prefix + "help", "Shows you helpful informations about the bot.", false);
		eb.addBlankField(false);
		eb.addField("▪ " + prefix + "info", "Shows you other informations about the bot.", false);
		eb.addBlankField(false);
		eb.addField("▪ " + prefix + "modules", "Shows you all the modules (catergories) of the bot.", false);
		eb.addBlankField(false);
		eb.addField("▪ " + prefix + "commands <module>", "Shows you all the commands of a module.", false);
		eb.addBlankField(false);
        eb.addField("▪ " + prefix + "donate", "Shows you informations about how you can donate.", false);
        eb.addBlankField(false);
		eb.addField("▪ " + prefix + "guilds", "Shows you all the Guilds with the Bot.", false);
		eb.addBlankField(false);
		eb.setFooter("You can see all the modules with " + prefix + "modules", null);
		
		return eb;
	}
	
}
