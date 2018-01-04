package commands;

import java.awt.Color;

import net.dv8tion.jda.core.EmbedBuilder;

public class Info {

	public EmbedBuilder info() {
		EmbedBuilder eb = new EmbedBuilder();
		
		eb.setColor(Color.GREEN);
		
		eb.setTitle("DadiBot Info");
		eb.setDescription("Common Informations");
		
		eb.addField("Invite Link", "Click [here](https://discordapp.com/api/oauth2/authorize?client_id=396990218751967254&permissions=8&scope=bot) to invite the Bot.", false);
		eb.addField("Discord Server Link", "Click [here](https://discord.gg/bdTQnaW) to get on my Discord.", false);
		eb.addField("Wiki", "Click [here](https://github.com/EweLoHD/DadiBot/wiki) to get to the Wiki.", false);
		eb.addField("Developed by", "EweLoHD", false);
		
		return eb;
	}
	
}
