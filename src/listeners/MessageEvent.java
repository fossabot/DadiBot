package listeners;

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
        if(command.equalsIgnoreCase("info")) {
        	event.getTextChannel().sendMessage("Link: https://discordapp.com/api/oauth2/authorize?client_id=396990218751967254&permissions=8&scope=bot").queue();
        }
        
        if(event.getTextChannel().getName().equalsIgnoreCase("witze")) {
        	event.getMessage().addReaction("+1");
        	event.getMessage().addReaction(":+1:");
        	event.getMessage().addReaction("thumbsup").queue();
        	event.getMessage().addReaction(event.getGuild().getEmoteById("airplane")).queue();
        }
    	
    }

}
