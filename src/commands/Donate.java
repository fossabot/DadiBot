package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.TextChannel;

import java.awt.*;

public class Donate {

    public void donate(TextChannel textChannel){
        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(Color.decode("#f1c40f"));
        eb.setTitle("Donate");
        eb.addBlankField(false);
        eb.setDescription("You can dontate to the Developer, so that we can improve the performance of the Bot.");
        eb.addField("How can you donate?", "You can donate on Patreon https://patreon.com/user?u=7472045, there are two tiers of Donations.", false);
        eb.addBlankField(false);
        eb.addField("Tier 1 (1$ per month)", "- You get a special Role on the Discord and here in the Forum.\n" +
                "- You will get listed on Github.", false);
        eb.addBlankField(false);
        eb.addField("Tier 2 (5$ per month)", "- You get 2 special Roles on the Discord and here in the Forum.\n" +
                "- You will get listed on Github.\n" +
                "- You will be shown in the `-donators` Command.\n" +
                "- You get your own custom Command in the Bot.", false);

        textChannel.sendMessage(eb.build()).queue();
    }
}
