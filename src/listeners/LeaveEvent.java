package listeners;

import net.dv8tion.jda.core.events.guild.GuildLeaveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class LeaveEvent extends ListenerAdapter{
	
	public void onjoin(GuildLeaveEvent e) {
		System.out.println("[INFO] Der Bot hast den " + e.getGuild().getName() + " Server verlassen");
	}

}
