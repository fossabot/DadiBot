package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.TextChannel;

import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Github {

    public void github(TextChannel textChannel, String url, String lang){
        String content = null;
        URLConnection connection = null;
        String gurl = null;
        try {
            if(url.contains("gist.github.com")){
                gurl = url + "/raw/";
            }
            if(url.startsWith("https://github.com")){
                gurl = url.replaceFirst("https://github.com", "https://raw.githubusercontent.com").replaceFirst("/blob", "");
            }

            connection =  new URL(gurl).openConnection();
            Scanner scanner = new Scanner(connection.getInputStream());
            scanner.useDelimiter("\\Z");
            content = scanner.next();
        }catch ( Exception ex ) {
            textChannel.sendMessage("**Error!** This is not a valid Github or Gist URL!").queue();
        }

        //System.out.println(content);

        try {
            String message = "```" + lang + "\n" + content + "```";
            textChannel.sendMessage(message).queue();
        }catch (Exception e){
            textChannel.sendMessage("**Error!** The Code might be to big!").queue();
        }
    }
}
