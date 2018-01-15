package core;

import javax.security.auth.login.LoginException;

import listeners.*;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.Game.GameType;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import util.Statics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static JDABuilder builder;
	
	public static void main(String[] Args) {

        builder = new JDABuilder(AccountType.BOT);

        builder.setToken(Statics.token);
        builder.setAutoReconnect(true);
        builder.setStatus(OnlineStatus.ONLINE);
        
        builder.setGame(Game.of(GameType.WATCHING, "sich Witze"));

        builder.addEventListener(new MessageEvent());
        builder.addEventListener(new JoinEvent());
        builder.addEventListener(new LeaveEvent());
        builder.addEventListener(new ReactionEvent());
        builder.addEventListener(new ReactionEventRemove());
        builder.addEventListener(new ReadyEvent());
        builder.addEventListener(new DisconnectEvent());
        builder.addEventListener(new ResumedEvent());
        builder.addEventListener(new ReconnectedEvent());


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
