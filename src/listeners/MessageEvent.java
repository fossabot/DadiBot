package listeners;

import commands.Help;
import commands.Info;
import commands.ModuleFun;
import commands.ModuleHelp;
import commands.ModuleOptions;
import commands.Modules;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.Statics;

public class MessageEvent extends ListenerAdapter{
	
	Statics statics = new Statics();
	Help help = new Help();
	Info info = new Info();
	Modules modules = new Modules();
	ModuleOptions moptions = new ModuleOptions();
	ModuleHelp mhelp = new ModuleHelp();
	ModuleFun mfun = new ModuleFun();
	
	
	@Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String message = event.getMessage().getContentDisplay();
        String command = event.getMessage().getContentDisplay().replaceFirst("-", "");
        Guild server = event.getGuild();
        String error = statics.error(server);
        
        EmbedBuilder emb_help = help.help(server);
        EmbedBuilder emb_info = info.info(server);
       	EmbedBuilder emb_modules = modules.modules(server);
       	EmbedBuilder emb_moptions = moptions.moduleoptions(server);
       	EmbedBuilder emb_mhelp = mhelp.modulehelp(server);
       	EmbedBuilder emb_mfun = mfun.modulefun(server);
       
       	
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
        
        //modules
        if(command.equalsIgnoreCase("modules")) {
        	try {
        		event.getTextChannel().sendMessage(emb_modules.build()).queue();
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
        
        //commands
        if(command.toLowerCase().startsWith("commands")) {
        	if(command.equalsIgnoreCase("commands")) {
        		event.getTextChannel().sendMessage(error).queue();
        	}
        	else {
        	
        		String arg = command.replaceFirst("commands ", "").toLowerCase();
        	
        		if(arg.startsWith("bot-options")) {
        			try {
        				event.getTextChannel().sendMessage(emb_moptions.build()).queue();
        			} catch (Exception e) {
        				e.printStackTrace();
        			}
        		}
        		else if(arg.startsWith("help")) {
        			try {
        				event.getTextChannel().sendMessage(emb_mhelp.build()).queue();
        			} catch (Exception e) {
        				e.printStackTrace();
        			}
        		}
        		else if(arg.startsWith("fun")) {
        			try {
        				event.getTextChannel().sendMessage(emb_mfun.build()).queue();
        			} catch (Exception e) {
        				e.printStackTrace();
        			}
        		}
        		else {
        			event.getTextChannel().sendMessage(error).queue();
        		}
        	}
        }
    	
    }

}
