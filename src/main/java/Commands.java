import java.awt.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class Commands extends ListenerAdapter {
    public static Random random = new Random();
    public static EmbedBuilder error1 = new EmbedBuilder();
    public static final String prefix = Main.prefix;

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e)
    {
        boolean antispam_state = false;
        String word;
        String new_word = null;
        String[] message = e.getMessage().getContentRaw().split(" ");
        String[] heys = {"Привет", "Прив", "Ку", "Дарова", "Драсте", "Категорически вас приветствую сударь", "Йоу", "Хай", "qq", "Хеллоу", "Бонжур", "Давно не виделись"};

        if (message[0].equalsIgnoreCase("котангенс")) {
            if (message[1].equalsIgnoreCase("ты") && message[2] != null) {
                e.getChannel().sendMessage("Сам ты " + message[2] + ", " + e.getMember().getNickname()).queue();
            }
            if (message[1].equalsIgnoreCase("привет")) {
                int hey = random.nextInt(11);
                e.getChannel().sendMessage(heys[hey] + " " + e.getMember().getNickname()).queue();
            }

            if (message[1].equalsIgnoreCase("спокойной") && (message[2].equalsIgnoreCase("ночи!") || message[2].equalsIgnoreCase("ночи"))) {
                e.getChannel().sendMessage("Приятных снов!").queue();
            }

            if (message[1].equalsIgnoreCase("кто") && message[2].equalsIgnoreCase("попуск?")) {
                int choice = random.nextInt(5);
                switch (choice) {
                    case 0:
                        e.getChannel().sendMessage(error1.setColor(Color.RED).setTitle("чел с ником: ы №1 попуск хвахвхавхвахах").build()).queue();
                        return;
                    case 1:
                        e.getChannel().sendMessage(error1.setColor(Color.GREEN).setTitle("чел с ником: ы попуск хвахвхавхвахах").build()).queue();
                        return;
                    case 2:
                        e.getChannel().sendMessage(error1.setColor(Color.BLUE).setTitle("чел с ником: ы №2 попуск хвахвхавхвахах").build()).queue();
                        return;
                    case 3:
                        e.getChannel().sendMessage(error1.setColor(Color.YELLOW).setTitle("чел с ником: Котангенс попуск хвахвха..Стоп, это я чтоли...?").build()).queue();
                        return;
                    case 4:
                        e.getChannel().sendMessage(error1.setColor(Color.CYAN).setTitle("все попуски бугаагагагага").build()).queue();
                }
            }

            if (message[1].equalsIgnoreCase("поздоровайся") && message[2].equalsIgnoreCase("с")) {
                int hey = random.nextInt(11);
                e.getChannel().sendMessage(heys[hey] + " " + message[3]).queue();
            }
        }

        if (message[0].equalsIgnoreCase(prefix + "clear")) {
            error1.setColor(Color.RED);
            error1.setTitle("ZA HANDO!");
            e.getChannel().sendMessage(error1.build()).queue(m -> m.delete().queueAfter(5, TimeUnit.SECONDS));
            e.getChannel().delete().queue();
        }

        if (message[0].equalsIgnoreCase(prefix + "antispam")) {
            if (message[1].equalsIgnoreCase("start")) {
                antispam_state = true;
                e.getChannel().sendMessage(error1.setColor(Color.GREEN).setTitle("Режим антиспама включен").build()).queue();
            }
            else if (message[1].equalsIgnoreCase("stop")) {
                antispam_state = false;
                e.getChannel().sendMessage(error1.setColor(Color.RED).setTitle("Режим антиспама выключен").build()).queue();
            }
        }



        if (antispam_state) {
            word = e.getMessage().getContentDisplay();
            if (new_word != null) {

            }
            new_word = e.getMessage().getContentDisplay();


            e.getMessage().delete().queue();
            e.getChannel().sendMessage("Спамус вырезатус!").queue();
        }
    } // конец метода onGuildMessageReceived

    /*
    public int existA(String elem, String[] m) {
        int b = 0;
        for (int i = 0;i < m.length;i++) {
            if (elem.equals(m[i])) {
                b = 1;
            }
        }
        return b;
    }
    */
}
