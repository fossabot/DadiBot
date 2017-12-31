package listeners;

import net.dv8tion.jda.core.entities.Emote;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class MessageEvent extends ListenerAdapter{
	
	@Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String message = event.getMessage().getContentDisplay();
        String command = event.getMessage().getContentDisplay().replace("-", "");
       
        if(message.equalsIgnoreCase("!dadi")) {
        	event.getTextChannel().sendMessage("Dadi ist **sehr** cool ;^)").queue();
        }
        if(message.equalsIgnoreCase("-info")) {
        	event.getTextChannel().sendMessage("Link: https://discordapp.com/api/oauth2/authorize?client_id=396990218751967254&permissions=8&scope=bot");
        }
    	
    }

}