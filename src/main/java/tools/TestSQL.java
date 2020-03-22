package tools;

// import java.util.ArrayList;

// import tools.SQL;

public class TestSQL{

    public static void main(String[] args) {
        SQL.newGame("None");
        SQL.newGame("Skyrim");
        SQL.newGame("Fortnite");
        SQL.newGame("Zelda");
        SQL.newGame("LOTRO");
        SQL.newUser("Noobdu22", "tressecurise", "noob@gmail.com", "2020/03/22 - 16:30:00", "2000/01/01");
        SQL.newUser("admin", "admin", "admin@wanadoo.fr", "2018/05/13 - 12:00:00", "1990/03/07");
        SQL.promoteAdmin("admin");
        SQL.newUser("Trololo", "lol", "trolldu93@yahoo.fr", "2020/03/22 - 16:30:00", "2005/06/24");
        SQL.ban("Trololo");
        SQL.newUser("ProGamer", "azerty1234", "pgm@free.fr", "2020/08/22 - 16:30:00", "1998/04/21");
        SQL.newUsualGames("Noobdu22", "Fortnite");
        SQL.newUsualGames("ProGamer", "Skyrim");
        SQL.newUsualGames("ProGamer", "LOTRO");
        SQL.newSession("ProGamer", "Skyrim", 1, "2020/03/22 - 16:32:00", "2020/03/22 - 20:05:00");
        System.out.println("ok");
    }

}