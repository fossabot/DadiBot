package listeners;

import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.Prefix;

public class ReconnectedEvent extends ListenerAdapter{

    public void onReconnect(net.dv8tion.jda.core.events.ReconnectedEvent e){
        System.out.println(Prefix.success + "The Bot restarted and is now again online!");
    }
}
