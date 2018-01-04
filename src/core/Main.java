package core;

import javax.security.auth.login.LoginException;

import listeners.MessageEvent;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import util.Secret;
import util.Statics;

public class Main {
	
	public static JDABuilder builder;
	
	public static void main(String[] Args) {

        builder = new JDABuilder(AccountType.BOT);

        builder.setToken(Secret.key);
        builder.setAutoReconnect(true);

        builder.setStatus(OnlineStatus.IDLE);
        builder.addEventListener(new MessageEvent());

        try {
            JDA jda = builder.buildBlocking();
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (RateLimitedException e) {
            e.printStackTrace();
        }
        

	}

}
