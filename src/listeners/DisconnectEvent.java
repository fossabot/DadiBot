package listeners;

import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.Prefix;

public class DisconnectEvent extends ListenerAdapter {

    @Override
    public void onDisconnect(net.dv8tion.jda.core.events.DisconnectEvent e){
        System.out.println(Prefix.error + "The Bot disconnected!");
    }
}
