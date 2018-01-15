package listeners;

import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.Prefix;

public class ResumedEvent extends ListenerAdapter{

    @Override
    public void onResume(net.dv8tion.jda.core.events.ResumedEvent e){
        System.out.println(Prefix.success + "The Bot resumed and is now again online!");
    }
}
