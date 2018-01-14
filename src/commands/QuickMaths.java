package commands;

import net.dv8tion.jda.core.entities.TextChannel;

public class QuickMaths {

    public void quickmaths(TextChannel textChannel){
        textChannel.sendMessage("**2 + 2**").queue();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        textChannel.sendMessage("**= 4**").queue();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        textChannel.sendMessage("**- 1 = 3**").queue();
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        textChannel.sendMessage("**QUICK MATHS!**").queue();
    }
}
