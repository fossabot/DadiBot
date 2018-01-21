package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.TextChannel;
import util.Prefix;
import util.Statics;

import java.sql.*;

public class Embed {

    public void sembed(TextChannel textChannel){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        Connection connection = null;
        Statement s = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://192.168.178.25:3306/" + "options","ewelohd", Statics.pwd);

            s = connection.createStatement();
            String query = "SELECT * FROM embed WHERE id = 1";
            final PreparedStatement ps = connection.prepareStatement(query);
            final ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()){
                int id = resultSet.getInt(1);
                String title = resultSet.getString(2);
                String text = resultSet.getString(3);
                String footer = resultSet.getString(4);

                EmbedBuilder eb = new EmbedBuilder();

                if(text.isEmpty()){
                    if(title.isEmpty()){
                        System.out.println(Prefix.error + "Text or Title can't be both null!");
                    }
                    else{
                        eb.setTitle(title);
                    }
                }
                else{
                    if (title.isEmpty()){
                        eb.setTitle(text);
                    }
                    else {
                        eb.addField(title, text, false);
                    }
                }
                if(!footer.isEmpty()){
                    eb.setFooter(footer, null);
                }
                try {
                    textChannel.sendMessage(eb.build()).queue();
                }catch (IllegalStateException e){
                    System.out.println(Prefix.error + "Text or Title can't be both null!");
                }

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
