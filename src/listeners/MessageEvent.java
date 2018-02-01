package listeners;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.sql.Statement;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.fabric.xmlrpc.base.Member;

import commands.*;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.Prefix;
import util.Statics;

public class MessageEvent extends ListenerAdapter{

	private Statics statics = new Statics();
	private Help help = new Help();
	private Info info = new Info();
	private Modules modules = new Modules();
	private ModuleOptions moptions = new ModuleOptions();
	private ModuleHelp mhelp = new ModuleHelp();
	private ModuleFun mfun = new ModuleFun();
	private Serverinfo sinfo = new Serverinfo();
	private Jokes jokes = new Jokes();
	private Prefix pre = new Prefix();
	private Explosion exp = new Explosion();
	private QuickMaths qm = new QuickMaths();
	private Mocking mck = new Mocking();
	private Guilds glds = new Guilds();
	private Donate don = new Donate();
	private Meme meme = new Meme();
	private Embed emb = new Embed();
	private Github gith = new Github();
	private Fortnite fort = new Fortnite();
			
	
	@Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Properties prop = new Properties();
        OutputStream output = null;String message = event.getMessage().getContentDisplay();
        String command = event.getMessage().getContentDisplay().replaceFirst(pre.prefix(event.getGuild()), "");
        Guild server = event.getGuild();
        String error = statics.error(server);
        
        
        EmbedBuilder emb_help = help.help(server);
        EmbedBuilder emb_info = info.info(server);
       	EmbedBuilder emb_modules = modules.modules(server);
       	EmbedBuilder emb_moptions = moptions.moduleoptions(server);
       	EmbedBuilder emb_mhelp = mhelp.modulehelp(server);
       	EmbedBuilder emb_mfun = mfun.modulefun(server);
       	EmbedBuilder emb_sinfo = sinfo.sinfo(server);
       	
        //dadi
        if(message.equalsIgnoreCase("!dadi")) {
        	event.getTextChannel().sendMessage("Dadi ist **sehr** cool ;^)").queue();
        }
        
        //info
        if(command.equalsIgnoreCase("info")) {
            event.getTextChannel().sendMessage(emb_info.build()).queue();
        }
        
        //help
        if(command.equalsIgnoreCase("help")) {
            event.getTextChannel().sendMessage(emb_help.build()).queue();
        }
        
        //witze
        if(event.getTextChannel().getName().equalsIgnoreCase("witze")) {
        	try {
				event.getMessage().addReaction("👍").queue();
				event.getMessage().addReaction("👎").queue();
			} catch (Exception e) {
			}
        	try {
        		Class.forName("com.mysql.jdbc.Driver");
        	} catch (ClassNotFoundException e) {
        		return;
        	}
        	Connection connection = null;
        	Statement s = null;
        	try {
        		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + event.getGuild().getId(),"root", Statics.pwd);
        		
        		s = connection.createStatement();
        		String query = "INSERT INTO messages VALUES ('" + event.getMessageId() + "', '" + event.getAuthor().getId() + "')";
        		final PreparedStatement ps = connection.prepareStatement(query);
                ps.execute();
        		System.out.println(Prefix.info + "Registered a new Joke by " + event.getAuthor().getName());
        	} catch (SQLException e) {
        		System.out.println(Prefix.error + "There was an SQLException while inserting a new Jokes-Message!");
        		return;
        	}
        }
        
        //modules
        if(command.equalsIgnoreCase("modules")) {
            event.getTextChannel().sendMessage(emb_modules.build()).queue();
        }
        
        //commands
        if(command.toLowerCase().startsWith("commands")) {
        	if(command.equalsIgnoreCase("commands")) {
        		event.getTextChannel().sendMessage(error).queue();
        	}
        	else {
        	
        		String arg = command.replaceFirst("commands ", "").toLowerCase();
        	
        		if(arg.startsWith("bot-options")) {
        		    event.getTextChannel().sendMessage(emb_moptions.build()).queue();
        		}
        		else if(arg.startsWith("help")) {
        		    event.getTextChannel().sendMessage(emb_mhelp.build()).queue();
        		}
        		else if(arg.startsWith("fun")) {
        		    event.getTextChannel().sendMessage(emb_mfun.build()).queue();
        		}
        		else {
        			event.getTextChannel().sendMessage(error).queue();
        		}
        	}
        }

        //sinfo
        if(command.equalsIgnoreCase("sinfo")) {
        	event.getTextChannel().sendMessage(emb_sinfo.build()).queue();
        }

        //jokes
        if(command.startsWith("jokes")) {
        	if(command.replace("jokes", "").equals("")) {
        		EmbedBuilder emb_jokes = jokes.jokes(server, event.getMember());
        		event.getTextChannel().sendMessage(emb_jokes.build()).queue();
        	}
        	else {
        		try {
        			net.dv8tion.jda.core.entities.Member mentm = event.getMessage().getMentionedMembers().get(0);
        			EmbedBuilder emb_jokes = jokes.jokes(server, mentm);
        			event.getTextChannel().sendMessage(emb_jokes.build()).queue();
        		}catch (Exception e){
        			event.getTextChannel().sendMessage(error).queue();
        		}
        	}
        }

        //explosion
        if(command.startsWith("explosion")){
            exp.explosion(event.getTextChannel());
            event.getMessage().delete();
        }

        //quickmaths
        if(command.startsWith("quickmaths")){
            qm.quickmaths(event.getTextChannel());
        }

        //mocking
        if(command.startsWith("mocking")){
            event.getTextChannel().deleteMessageById(event.getTextChannel().getLatestMessageId()).queue();
            String arg = event.getMessage().getContentDisplay().replaceFirst("-mocking", "");
            mck.mocking(event.getTextChannel(), arg.toLowerCase(), arg.length()/2);
        }

        //guilds
        if(command.startsWith("guilds")){
            glds.guilds(event.getTextChannel(), event);
        }

        //donate
		if(command.startsWith("donate")){
        	don.donate(event.getTextChannel());
		}

		//meme <top text> <bottom text> <Picture url>
        if(command.startsWith("meme")){
            event.getTextChannel().deleteMessageById(event.getTextChannel().getLatestMessageId()).queue();
            String a = command.replaceFirst("meme ", "");
            String part[] = a.split(", ");
            meme.meme(event.getTextChannel(), part[0], part[1], part[2]);
        }

        //embed
        if(command.startsWith("embed")){
            event.getTextChannel().deleteMessageById(event.getTextChannel().getLatestMessageId()).queue();
            if(event.getAuthor().getId().equalsIgnoreCase("206478287902343169")){
                emb.sembed(event.getTextChannel());
            }
        }

        //leave
        if(command.startsWith("leave")){
            if(event.getAuthor().getId().equalsIgnoreCase("206478287902343169")) {
                event.getGuild().leave().queue();
            }
        }

        //github <url> [language]
        if(command.startsWith("github")){
            String a = command.replaceFirst("github ", "");
            String part[] = a.split(" ");
            gith.github(event.getTextChannel(), part[0], part[1]);
        }

        //fortnite <user>
		if(command.startsWith("fortnite")){
        	String user = command.replaceFirst("fortnite ", "");

        	if(command.equalsIgnoreCase("fortnite") || command.equalsIgnoreCase("fortnite ")){
                event.getTextChannel().sendMessage("**Error!** User can't be found!").queue();
            }
            else {
                try {
                    try {
                        fort.fortnite(event.getTextChannel(), user, "pc");
                    } catch (KeyManagementException e) {
                        event.getTextChannel().sendMessage("**Error!** User can't be found!").queue();
                    } catch (NoSuchAlgorithmException e) {
                        event.getTextChannel().sendMessage("**Error!** User can't be found!").queue();
                    }
                } catch (IOException e) {
                    event.getTextChannel().sendMessage("**Error!** User can't be found!").queue();
                }
            }
		}

    }

}
