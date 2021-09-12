import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;
import java.util.concurrent.TimeUnit;

public class Main {
    public static String prefix = ".";

    public static void main(String[] args) throws Exception {
        JDA jda = JDABuilder.createDefault("ODg2MjYyMzQxMTI0MTE2NTQw.YTzCIA.iCdT5hS8AikINr3EQ-t-fsG1NU4")
                .addEventListeners(new Commands())
                .build();

        jda.getPresence().setStatus(OnlineStatus.IDLE);
        jda.getPresence().setActivity(Activity.watching("как ты списываешь"));
    }
}
