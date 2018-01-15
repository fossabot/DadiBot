package commands;


import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.Event;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class Guilds {

    public void guilds(TextChannel textChannel, Event e) {
        EmbedBuilder eb = new EmbedBuilder();


        eb.setColor(Color.decode("#2ecc71"));
        eb.setTitle("Guilds with the DadiBot");
        eb.addField("▪ Number of Guilds", String.valueOf(e.getJDA().getGuilds().size()), true);
        eb.addField("▪ List of Guilds", e.getJDA().getGuildCache().stream().map(Guild::getName).collect(Collectors.joining(", ")), false);

        textChannel.sendMessage(eb.build()).queue();
    }
}
