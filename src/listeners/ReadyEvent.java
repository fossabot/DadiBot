package listeners;

import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.Colors;
import util.Prefix;

public class ReadyEvent extends ListenerAdapter{

    @Override
    public void onReady(net.dv8tion.jda.core.events.ReadyEvent e){
        String ascii = "" +
                "  ____              _  _  ____          _   \n" +
                " |  _ \\   __ _   __| |(_)| __ )   ___  | |_ \n" +
                " | | | | / _` | / _` || ||  _ \\  / _ \\ | __|\n" +
                " | |_| || (_| || (_| || || |_) || (_) || |_ \n" +
                " |____/  \\__,_| \\__,_||_||____/  \\___/  \\__|\n" +
                "";
        System.out.println(ascii);
        System.out.println(Prefix.success + "DadiBot started successfully!");
        System.out.println(Prefix.info + "The Bot is on " + e.getJDA().getGuilds().size() + " Guilds online.");

    }
}
