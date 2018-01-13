package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;

import java.awt.*;
import java.io.File;

public class Explosion {

    public void explosion(TextChannel textChannel) {
        textChannel.sendMessage(new EmbedBuilder().setTitle("Self-destruction in:").setColor(Color.red).build()).queue();
        try {
            Thread.sleep(1050);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        textChannel.sendMessage(new EmbedBuilder().setTitle("3").setColor(Color.red).build()).queue();
        try {
            Thread.sleep(1050);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        textChannel.sendMessage(new EmbedBuilder().setTitle("2").setColor(Color.red).build()).queue();
        try {
            Thread.sleep(1050);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        textChannel.sendMessage(new EmbedBuilder().setTitle("1").setColor(Color.red).build()).queue();
        try {
            Thread.sleep(1050);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        textChannel.sendMessage(new EmbedBuilder().setTitle("0").setColor(Color.red).build()).queue();

        EmbedBuilder  eb = new EmbedBuilder();
        eb.setImage("https://media2.giphy.com/media/12KiGLydHEdak8/giphy.gif");
        textChannel.sendMessage(eb.setColor(Color.red).build()).queue();
    }
}
