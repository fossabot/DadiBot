package listeners;

import java.sql.Statement;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;


import commands.Help;
import commands.Info;
import commands.Jokes;
import commands.ModuleFun;
import commands.ModuleHelp;
import commands.ModuleOptions;
import commands.Modules;
import commands.Serverinfo;
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
	Serverinfo sinfo = new Serverinfo();
	Jokes jokes = new Jokes();
			
	
	@Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Properties prop = new Properties();
        OutputStream output = null;String message = event.getMessage().getContentDisplay();
        String command = event.getMessage().getContentDisplay().replaceFirst("-", "");
        Guild server = event.getGuild();
        String error = statics.error(server);
        
        
        EmbedBuilder emb_help = help.help(server);
        EmbedBuilder emb_info = info.info(server);
       	EmbedBuilder emb_modules = modules.modules(server);
       	EmbedBuilder emb_moptions = moptions.moduleoptions(server);
       	EmbedBuilder emb_mhelp = mhelp.modulehelp(server);
       	EmbedBuilder emb_mfun = mfun.modulefun(server);
       	EmbedBuilder emb_sinfo = sinfo.sinfo(server);
       	EmbedBuilder emb_jokes = jokes.jokes(server, event.getMember());
       	
       	final String hostname = "192.168.178.25"; 
    	final String port = "3306"; 
    	final String dbname = "206478634389602306"; 
    	final String user = "root"; 
    	final String password = Statics.pwd; 
       	
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
				e.printStackTrace();
			}
        	System.out.println("-------- MySQL JDBC Connection Testing ------------");

        	try {
        		Class.forName("com.mysql.jdbc.Driver");
        	} catch (ClassNotFoundException e) {
        		System.out.println("Where is your MySQL JDBC Driver?");
        		e.printStackTrace();
        		return;
        	}
        	System.out.println("MySQL JDBC Driver Registered!");
        	Connection connection = null;
        	Statement s = null;
        	try {
        		connection = DriverManager
        		.getConnection("jdbc:mysql://localhost:3306/" + event.getGuild().getId(),"root", Statics.pwd);
        		
        		s = connection.createStatement();
        		s.executeUpdate("INSERT INTO messages VALUES ('" + event.getMessageId() + "', '" + event.getAuthor().getId() + "')");
        		
        				
        	} catch (SQLException e) {
        		System.out.println("Connection Failed! Check output console");
        		e.printStackTrace();
        		return;
        	}

        	System.out.println("You made it, take control your database now!");
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
        if(command.equalsIgnoreCase("sinfo")) {
        	event.getTextChannel().sendMessage(emb_sinfo.build()).queue();
        }
        if(command.equalsIgnoreCase("jokes")) {
        	event.getTextChannel().sendMessage(emb_jokes.build()).queue();
        }

    }

}
