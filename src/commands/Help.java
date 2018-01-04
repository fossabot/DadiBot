package commands;

import java.awt.Color;

import net.dv8tion.jda.core.EmbedBuilder;

public class Help {

	public EmbedBuilder help() {
		EmbedBuilder eb = new EmbedBuilder();
		
		eb.setColor(Color.GREEN);
		
		eb.setTitle("DadiBot Commands");
		eb.setDescription("by EweLoHD");
		
		eb.addField("-help", "List all the Commands", false);
		eb.addField("-info", "Shows common informations", false);
		eb.addField("!dadi", "Dadi ist sehr cool :^)", false);
		
		return eb;
	}
	
}
