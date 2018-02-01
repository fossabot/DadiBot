package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.TextChannel;
import org.json.JSONObject;
import util.Statics;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

public class Fortnite {

    public void fortnite(TextChannel textChannel, String user, String console) throws IOException, KeyManagementException, NoSuchAlgorithmException {
        TrustManager[] trustAllCerts = new TrustManager[] {new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }
            public void checkClientTrusted(X509Certificate[] certs, String authType) {
            }
            public void checkServerTrusted(X509Certificate[] certs, String authType) {
            }
        }
        };

        // Install the all-trusting trust manager
        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new java.security.SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

        // Create all-trusting host name verifier
        HostnameVerifier allHostsValid = new HostnameVerifier() {
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };

        // Install the all-trusting host verifier
        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
        String url = "https://fortnite.y3n.co/v2/player/" + user;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("X-Key", Statics.x_key);
        int responseCode = con.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        EmbedBuilder eb = new EmbedBuilder();
        eb.setThumbnail("https://cdn2.unrealengine.com/Fortnite%2Fhome%2Ffn_battle_logo-1159x974-8edd8b02d505b78febe3baacec47a83c2d5215ce.png");
        eb.setFooter("Fortnite Stats powered by DadiBot and fortnite.y3n.co", null);

        JSONObject myResponse = new JSONObject(response.toString());
        eb.addField("Profile",
                "**Username:** " + myResponse.getString("displayName")
                + "\n**UserID:** " + myResponse.getString("userID")
                + "\n**Level:** " + myResponse.getJSONObject("br").getJSONObject("profile").getInt("level")
                , false);
        //eb.addBlankField(false);
        eb.addField("Stats",
                "**Score:** " + myResponse.getJSONObject("br").getJSONObject("stats").getJSONObject(console).getJSONObject("all").getInt("score")
                + "\n**Matches played:** " + myResponse.getJSONObject("br").getJSONObject("stats").getJSONObject(console).getJSONObject("all").getInt("matchesPlayed")
                + "\n**Wins:** " + myResponse.getJSONObject("br").getJSONObject("stats").getJSONObject(console).getJSONObject("all").getInt("wins")
                + "\n**Win Rate:** " + myResponse.getJSONObject("br").getJSONObject("stats").getJSONObject(console).getJSONObject("all").getDouble("winRate")
                + "\n**Deaths:** " + myResponse.getJSONObject("br").getJSONObject("stats").getJSONObject(console).getJSONObject("all").getInt("deaths")
                + "\n**Kills:** " + myResponse.getJSONObject("br").getJSONObject("stats").getJSONObject(console).getJSONObject("all").getInt("kills")
                + "\n**KD:** " + myResponse.getJSONObject("br").getJSONObject("stats").getJSONObject(console).getJSONObject("all").getDouble("kpd")
                ,false);
        textChannel.sendMessage(eb.build()).queue();
    }
}
