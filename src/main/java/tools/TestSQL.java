package tools;

// import java.util.ArrayList;

// import tools.SQL;

public class TestSQL{

    public static void main(String[] args) {
        SQL.newGame("Skyrim");
        SQL.newGame("Fortnite");
        SQL.newGame("Zelda");
        SQL.newGame("LOTRO");
        String mdp = Hasher.hashing("tressecurise");
        SQL.newUser("Noobdu22", mdp, "noob@gmail.com", "2020/03/22 - 16:30:00", "2000/01/01");
        mdp = Hasher.hashing("admin");
        SQL.newUser("admin", mdp, "admin@wanadoo.fr", "2018/05/13 - 12:00:00", "1990/03/07");
        SQL.promoteAdmin("admin");
        mdp = Hasher.hashing("lol");
        SQL.newUser("Trololo", mdp, "trolldu93@yahoo.fr", "2020/03/22 - 16:30:00", "2005/06/24");
        SQL.ban("Trololo");
        mdp = Hasher.hashing("azerty1234");
        SQL.newUser("ProGamer", mdp, "pgm@free.fr", "2020/08/22 - 16:30:00", "1998/04/21");
        SQL.newUsualGames("Noobdu22", "Fortnite");
        SQL.newUsualGames("ProGamer", "Skyrim");
        SQL.newUsualGames("ProGamer", "LOTRO");
        SQL.newSession("ProGamer", "Skyrim", 1, "2020/03/22 - 16:32:00", "2020/03/22 - 20:05:00");
        // SQL.deleteSession("Skyrim", "ProGamer");
        // String psw = SQL.getPsw("admin");
        // System.out.println(psw);
        // boolean test = SQL.mailAlreadyUsed("noob@gmail.com");
        // System.out.println(test);
        // test = SQL.pseudoAlreadyUsed("admin");
        // System.out.println(test);
        System.out.println("ok");
    }

}