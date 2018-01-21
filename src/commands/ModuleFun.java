package commands;

import java.awt.Color;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;
import util.Prefix;

public class ModuleFun {

	public EmbedBuilder modulefun(Guild server) {
		Prefix pr = new Prefix();
		String prefix = pr.prefix(server);
		
		EmbedBuilder eb = new EmbedBuilder();
		
		eb.setColor(Color.decode("#1ABC9C"));
		eb.setTitle("Fun");
		
		eb.addField("▪ !dadi", "Dadi ist sehr cool :^)", false);
		eb.addBlankField(false);
		eb.addField("▪ " + prefix + "jokes [member]", "Shows the Jokes-Level of a user.", false);
		eb.addBlankField(false);
		eb.addField("▪ " + prefix + "explosion", "Coutdown to Self-destruction.", false);
		eb.addBlankField(false);
		eb.addField("▪ " + prefix + "quickmaths", "Shows you some quick maths.", false);
		eb.addBlankField(false);
		eb.addField("▪ " + prefix + "mocking <text>", "Turns the text into a mocking-(spongebob) text.", false);
		eb.addBlankField(false);
		eb.addField("▪ " + prefix + "meme <top text>, <bottom text>, <image url>", "Creates a meme with a custom image and a text on the bottom an on the top.", false);
		eb.addBlankField(false);
		eb.setFooter("You can see all the modules with " + prefix + "modules", null);
		
		return eb;
	}
	
}
