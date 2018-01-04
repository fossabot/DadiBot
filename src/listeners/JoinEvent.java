package listeners;

import net.dv8tion.jda.core.events.guild.GuildJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class JoinEvent extends ListenerAdapter{
	
	public void onjoin(GuildJoinEvent e) {
		System.out.println("[INFO] Der Bot ist dem " + e.getGuild().getName() + " Server beigetreten");
	}

}
