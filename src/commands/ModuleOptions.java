package commands;

import java.awt.Color;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;
import util.Prefix;

public class ModuleOptions {
	public EmbedBuilder moduleoptions(Guild server) {
		Prefix pr = new Prefix();
		String prefix = pr.prefix(server);
		
		EmbedBuilder eb = new EmbedBuilder();
		
		eb.setColor(Color.decode("#1ABC9C"));
		
		eb.addField("Bot-Options", "*Nothing to show here :/*", false);
		eb.addBlankField(false);
		eb.setFooter("You can see all the modules with " + prefix + "modules", null);
		
		return eb;
	}
}
