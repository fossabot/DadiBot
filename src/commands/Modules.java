package commands;

import java.awt.Color;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;
import util.Prefix;

public class Modules {
	public EmbedBuilder modules(Guild server) {
		Prefix pr = new Prefix();
		String prefix = pr.prefix(server);
		
		EmbedBuilder eb = new EmbedBuilder();
		
		eb.setColor(Color.decode("#2ECC71"));
		
		eb.addField("DadiBot Modules", "▪Bot-Options \n▪Help \n▪Fun", false);
		eb.setFooter("You can see the commands of a module with " + prefix + "commands <module>", null);
		
		return eb;
	}
}
