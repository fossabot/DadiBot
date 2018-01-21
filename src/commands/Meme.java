package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.TextChannel;
import util.Prefix;
import util.Statics;

public class Meme {
    Statics stats = new Statics();

    public void meme(TextChannel textChannel, String top, String bottom, String url){
        String toptext = top.replaceAll(" ", "_");
        String bottomtext = bottom.replaceAll(" ", "_");
        String picurl = "https://memegen.link/custom/" + toptext + "/" + bottomtext + ".jpg?alt=" + url;

        System.out.println(Prefix.info + "New Meme: " + picurl);

        try {
            EmbedBuilder eb = new EmbedBuilder();
            eb.setImage(picurl);
            //eb.setFooter("This Meme was created with Help of the memegen.link API.", null);
            textChannel.sendMessage(eb.build()).queue();
        }catch (Exception e){
            textChannel.sendMessage(stats.error(textChannel.getGuild()));
        }

    }
}
