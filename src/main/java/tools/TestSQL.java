package tools;

// import java.util.ArrayList;

// import tools.SQL;

public class TestSQL{

    public static void main(String[] args) {
        // SQL.newGame("Skyrim");
        // SQL.newGame("Fortnite");
        // SQL.newGame("Zelda");
        // SQL.newGame("LOTRO");
        // SQL.newGame("Minecraft");
        // SQL.newGame("SWTOR");
        // SQL.newGame("Oblivion");
        // SQL.newGame("Total War Warhammer");
        // SQL.newGame("Spellcaster University");
        // SQL.newGame("Dragon Quest");

        // String mdp = Hasher.hashing("tressecurise");
        // SQL.newUser("Noobdu22", mdp, "noob@gmail.com", "2020/03/22 - 16:30:00", "2000/01/01 - 00:00:00");
        // mdp = Hasher.hashing("admin");
        // SQL.newUser("admin", mdp, "admin@wanadoo.fr", "2018/05/13 - 12:00:00", "1990/03/07 - 00:00:00");
        // SQL.promoteAdmin("admin");
        // mdp = Hasher.hashing("lol");
        // SQL.newUser("Trololo", mdp, "trolldu93@yahoo.fr", "2020/03/22 - 16:30:00", "2005/06/24 - 00:00:00");
        // SQL.ban("Trololo");
        // mdp = Hasher.hashing("azerty1234");
        // SQL.newUser("ProGamer", mdp, "pgm@free.fr", "2020/08/22 - 16:30:00", "1998/04/21 - 00:00:00");
        // mdp = Hasher.hashing("ceciestunmotdepasse");
        // SQL.newUser("jaiplusdidee", mdp, "jaipas@didee.com", "2019/07/12 - 19:00:50", "2002/11/30 - 00:00:00");
        // mdp = Hasher.hashing("30112002");
        // SQL.newUser("Darius1325", mdp, "darius1325@gmail.com", "2019/12/12 - 19:35:25", "1990/03/07 - 00:00:00");
        // mdp = Hasher.hashing("password");
        // SQL.newUser("pseudo", mdp, "email@mail.fr", "2020/03/26 - 08:00:00", "1960/12/26 - 00:00:00");

        // SQL.newUsualGames("Noobdu22", "Fortnite");
        // SQL.newUsualGames("Noobdu22", "Minecraft");
        // SQL.newUsualGames("Noobdu22", "Dragon Quest");
        // SQL.newUsualGames("ProGamer", "Skyrim");
        // SQL.newUsualGames("ProGamer", "LOTRO");
        // SQL.newUsualGames("ProGamer", "Oblivion");
        // SQL.newUsualGames("Trololo", "Total War Warhammer");
        // SQL.newUsualGames("Trololo", "LOTRO");
        // SQL.newUsualGames("jaiplusdidee", "Spellcaster University");
        // SQL.newUsualGames("jaiplusdidee", "Zelda");
        // SQL.newUsualGames("Darius1325", "Skyrim");
        // SQL.newUsualGames("Darius1325", "Total War Warhammer");
        // SQL.newUsualGames("Darius1325", "Minecraft");
        // SQL.newUsualGames("pseudo", "Skyrim");
        // SQL.newUsualGames("pseudo", "Zelda");

        // SQL.newSession("ProGamer", "Skyrim", 1, "2020/03/22 - 14:30:00", "2020/03/22 - 23:05:00");
        // SQL.newSession("Noobdu22", "Minecraft", 1, "2020/03/24 - 02:00:50", "2020/03/24 - 20:05:00");
        // SQL.newSession("jaiplusdidee", "Zelda", 1, "2020/03/26 - 16:32:00", "2020/03/26 - 15:26:00");
        // SQL.newSession("Darius1325", "Total War Warhammer", 1, "2020/03/23 - 16:32:00", "2020/03/23 - 21:05:00");

        // System.out.println(SQL.nbSessions().toString());
        System.out.println(SQL.playerList().toString());
        
        System.out.println("ok");
    }

}