package listeners;

import commands.Help;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class MessageEvent extends ListenerAdapter{
	
	Help help = new Help();
	EmbedBuilder emb = help.help();
	
	@Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String message = event.getMessage().getContentDisplay();
        String command = event.getMessage().getContentDisplay().replace("-", "");
       
        //dadi
        if(message.equalsIgnoreCase("!dadi")) {
        	event.getTextChannel().sendMessage("Dadi ist **sehr** cool ;^)").queue();
        }
        
        //info
        if(command.equalsIgnoreCase("info")) {
        	try {
				event.getTextChannel().sendMessage("Link: https://discordapp.com/api/oauth2/authorize?client_id=396990218751967254&permissions=8&scope=bot").queue();
			} catch (Exception e) {
				//e.printStackTrace();
			}
        }
        
        //help
        if(command.equalsIgnoreCase("help")) {
        	try {
				event.getTextChannel().sendMessage(emb.build()).queue();
			} catch (Exception e) {
				//e.printStackTrace();
			}
        }
        
        //witze
        if(event.getTextChannel().getName().equalsIgnoreCase("witze")) {
        	try {
				event.getMessage().addReaction("👍").queue();
				event.getMessage().addReaction("👎").queue();
			} catch (Exception e) {
				//e.printStackTrace();
			}
        }
    	
    }

}
