package listeners;

import commands.Help;
import commands.Info;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class MessageEvent extends ListenerAdapter{
	
	Help help = new Help();
	Info info = new Info();
	
	EmbedBuilder emb_help = help.help();
	EmbedBuilder emb_info = info.info();
	
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
        		event.getTextChannel().sendMessage(emb_info.build()).queue();
			} catch (Exception e) {
				//e.printStackTrace();
			}
        }
        
        //help
        if(command.equalsIgnoreCase("help")) {
        	try {
				event.getTextChannel().sendMessage(emb_help.build()).queue();
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
