package tools;

import java.sql.*;
import java.util.ArrayList;

/**
 * 
 * This class is composed of methods used to interact with the database
 * 
 * @author Adam RIVIÈRE
 * 
 */

public class SQL {

    static Connection con = null;
    static ResultSet res = null;
    static String url = "jdbc:mysql://vps.tonychouteau.fr:3306";
    static String user = "PDB2020_JEE";
    static String passwd = "pl2*AdJP0&sE0Jhd!E2a,bRt";

    /**
     * Adds a new game in the database
     * 
     * @author Adam RIVIERE
     * @param name name of the game
     */
    public static void newGame(String name) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url+"/PDB_JEE",user,passwd);
            String request = "INSERT INTO Game(name,nbPlayers) VALUES(?,0);";
            PreparedStatement statement = con.prepareStatement(request);
            statement.setString(1, name);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Jeu non créé !");
            e.getMessage();
            e.printStackTrace();
        }
    }

    /**
     * Adds a new user in the database.
     * 
     * @author Adam RIVIERE
     * @param pseudo       pseudo of the user
     * @param password     encrypted password of the user
     * @param email        mail of the user
     * @param status       type of account of the user
     * @param registration registration date of the user
     * @param birthDate    birth date of the user
     */
    public static void newUser(String pseudo, String password, String email, String registration, String birthDate) {
        try {
            int gameNull = getGameId("None");
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url+"/PDB_JEE",user,passwd);
            String request = "INSERT INTO User(pseudo,password,email,status,registration,birthDate,currentGame) VALUES(?,?,?,1,?,?,?);";
            PreparedStatement statement = con.prepareStatement(request);
            statement.setString(1, pseudo);
            statement.setString(2, password);
            statement.setString(3, email);
            statement.setString(4, registration);
            statement.setString(5, birthDate);
            statement.setInt(6,gameNull);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.print("Utilisateur non créé !");
            e.getMessage();
        }
    }

    /**
     * Gets the id of a user
     * 
     * @author Adam RIVIERE
     * @param pseudo pseudo of the user
     * @return the id of the user
     */
    public static int getUserId(String pseudo) {
        int id = -1;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url+"/PDB_JEE",user,passwd);
            String request = "SELECT idUser FROM User WHERE pseudo = ?;";
            PreparedStatement statement = con.prepareStatement(request);
            statement.setString(1, pseudo);
            res = statement.executeQuery();
            while(res.next()) {
                id = res.getInt("idUser");
            }
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
            System.out.println("Utilisateur non valide !");
        }
        return id;
    }

    /**
     * Gets the id of a game
     * 
     * @author Adam RIVIERE
     * @param name name of the game
     * @return the id of the game
     */
    public static int getGameId(String name) {
        int id = -1;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url+"/PDB_JEE",user,passwd);
            String request = "SELECT idGame FROM Game WHERE name = ?;";
            PreparedStatement statement = con.prepareStatement(request);
            statement.setString(1, name);
            res = statement.executeQuery();
            while(res.next()) {
                id = res.getInt("idGame");
            }
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
            System.out.println("Jeu non valide !");
        }
        return id;
    }

    /**
     * Adds a new link between a game and a user in the database
     * 
     * @author Adam RIVIERE
     * @param pseudo pseudo of the user
     * @param game name of the game
     */
    public static void newUsualGames(String pseudo, String game) {
        try {
            int userId = getUserId(pseudo);
            int gameId = getGameId(game);
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url+"/PDB_JEE",user,passwd);
            String request = "INSERT INTO UsualGames(idUser,idGame) VALUES(?,?);";
            PreparedStatement statement = con.prepareStatement(request);
            statement.setInt(1, userId);
            statement.setInt(2, gameId);
            statement.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
            System.out.println("Joueur ou jeu non valide !");
        }
    }

    /**
     * Adds a new game session in the database
     * 
     * @author Adam RIVIERE
     * @param pseudo      pseudo of the user
     * @param game      name of the game
     * @param status    status of the session
     * @param startDate begin date of the session
     * @param endDate   end date of the session
     */
    public static void createSession(String pseudo, String game, int status, String startDate, String endDate) {
        try {
            int userId = getUserId(pseudo);
            int gameId = getGameId(game);
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url+"/PDB_JEE",user,passwd);
            String request = "INSERT INTO Session(idUser,idGame,status,startDate,endDate) VALUES(?,?,?,?,?);";
            PreparedStatement statement = con.prepareStatement(request);
            statement.setInt(1, userId);
            statement.setInt(2, gameId);
            statement.setInt(3, status);
            statement.setString(4, startDate);
            statement.setString(5, endDate);
            statement.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
            System.out.println("Joueur ou jeu non valide !");
        }
    }

    /**
     * Promotes a user to admin
     * 
     * @author Adam RIVIERE
     * @param pseudo pseudo of the user
     */
    public static void promoteAdmin(String pseudo) {
        try {
            int userId = getUserId(pseudo);
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url+"/PDB_JEE",user,passwd);
            String request = "UPDATE User SET status = 0 WHERE idUser = ?;";
            PreparedStatement statement = con.prepareStatement(request);
            statement.setInt(1, userId);
            statement.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
            System.out.println("Joueur non valide !");
        }
    }

    /**
     * Demotes an admin to user
     * 
     * @author Adam RIVIERE
     * @param pseudo pseudo of the admin
     */
    public static void demoteAdmin(String pseudo) {
        try {
            int userId = getUserId(pseudo);
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url+"/PDB_JEE",user,passwd);
            String request = "UPDATE User SET status = 1 WHERE idUser = ?;";
            PreparedStatement statement = con.prepareStatement(request);
            statement.setInt(1, userId);
            statement.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
            System.out.println("Joueur non valide !");
        }
    }

    /**
     * Bans a user
     * 
     * @author Adam RIVIERE
     * @param pseudo pseudo of the user
     */
    public static void ban(String pseudo) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url+"/PDB_JEE",user,passwd);
            String request = "UPDATE User SET status = 2 WHERE pseudo = ?;";
            PreparedStatement statement = con.prepareStatement(request);
            statement.setString(1, pseudo);
            statement.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
            System.out.println("Joueur non valide !");
        }
    }

    /**
     * Unbans a user
     * 
     * @author Adam RIVIERE
     * @param pseudo pseudo of the user
     */
    public static void unban(String pseudo) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url+"/PDB_JEE",user,passwd);
            String request = "UPDATE User SET status = 1 WHERE pseudo = ?;";
            PreparedStatement statement = con.prepareStatement(request);
            statement.setString(1, pseudo);
            statement.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
            System.out.println("Joueur non valide !");
        }
    }

    // /**
    //  * Suspends a user
    //  * 
    //  * @author Adam RIVIERE
    //  * @param pseudo pseudo of the user
    //  */
    // public static void suspend(String pseudo) {
    //     try {
    //         Class.forName("com.mysql.cj.jdbc.Driver");
    //         con = DriverManager.getConnection(url+"/PDB_JEE",user,passwd);
    //         String request = "UPDATE FROM User SET status = 2 WHERE pseudo = ?;";
    //         PreparedStatement statement = con.prepareStatement(request);
    //         statement.setString(1, pseudo);
    //         statement.executeQuery();
    //     } catch (Exception e) {
    //         e.getMessage();
    //     }
    // }

    // /**
    //  * Unsuspends a user
    //  * 
    //  * @author Adam RIVIERE
    //  * @param pseudo pseudo of the user
    //  */
    // public static void unsuspend(String pseudo) {
    //     try {
    //         Class.forName("com.mysql.cj.jdbc.Driver");
    //         con = DriverManager.getConnection(url+"/PDB_JEE",user,passwd);
    //         String request = "UPDATE FROM User SET status = 1 WHERE pseudo = ?;";
    //         PreparedStatement statement = con.prepareStatement(request);
    //         statement.setString(1, pseudo);
    //         statement.executeQuery();
    //     } catch (Exception e) {
    //         e.getMessage();
    //     }
    // }

    /**
     * Returns the list of the games of the player
     * 
     * @author Adam RIVIERE
     * @param pseudo pseudo of the player
     * @return the list of the games
     */
    public static ArrayList<String> gameList(String pseudo){
        int userId = getUserId(pseudo);
        ArrayList<String> array = new ArrayList<String>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url+"/PDB_JEE",user,passwd);
            String request = "SELECT name FROM Game JOIN UsualGames ON Game.idGame = UsualGames.idGame WHERE idUser = ?;";
            PreparedStatement statement = con.prepareStatement(request);
            statement.setInt(1, userId);
            res = statement.executeQuery();
            while(res.next()){
                array.add(res.getString("name"));
            }
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
            System.out.println("Joueur non valide !");
        }
        return array;
    }

    /**
     * Returns the number of sessions of the player
     * 
     * @author Adam RIVIERE
     * @param pseudo pseudo of the player
     * @return the number of sessions
     */
    public static ArrayList<ArrayList<String>> nbSessions(){
        // int userId = getUserId(pseudo);
        ArrayList<ArrayList<String>> nb = new ArrayList<ArrayList<String>>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url+"/PDB_JEE",user,passwd);
            String request = "SELECT COUNT(*),pseudo FROM Session JOIN User ON Session.idUser = User.idUser GROUP BY User.idUser;";
            PreparedStatement statement = con.prepareStatement(request);
            // statement.setInt(1, userId);
            res = statement.executeQuery();
            while(res.next()) {
                ArrayList<String> player = new ArrayList<String>();
                player.add(res.getString(1));
                player.add(res.getString(2));
                nb.add(player);
            }
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
            System.out.println("Joueur non valide !");
        }
        return nb;
    }

    /**
     * Returns a list of users whith their pseudo, registration date, status and number of sessions
     * 
     * @author Adam RIVIERE
     * @return the list of all players
     */
    public static ArrayList<ArrayList<String>> playerList(){
        ArrayList<ArrayList<String>> array = new ArrayList<ArrayList<String>>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url+"/PDB_JEE",user,passwd);
            String request = "SELECT pseudo,registration,status FROM User GROUP BY idUser;";
            PreparedStatement statement = con.prepareStatement(request);
            res = statement.executeQuery(); 
            while(res.next()){
                // System.out.println("tour");
                ArrayList<String> player = new ArrayList<String>();
                player.add(res.getString(1));
                player.add(res.getString(2));
                player.add(res.getString(3));
                // int nbSessions = nbSessions(player.get(0).toString());
                // player.add(nbSessions);
                // System.out.println(player.toString());
                array.add(player);
            }
            ArrayList<ArrayList<String>> nbSessions = nbSessions();
            for(int i = 0;i < array.size();i++){
                boolean ok = false;
                for(int j = 0;j < nbSessions.size();j++){
                    if(nbSessions.get(j).get(1).equals(array.get(i).get(0))){
                        array.get(i).add(nbSessions.get(j).get(0));
                        ok = true;
                    }
                }
                if(ok == false){
                    array.get(i).add("0");
                }
            }
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
        return array;
    }

    /**
     * Adds a user to a game
     * 
     * @author Adam RIVIERE
     * @param game name of the game
     */
    public static void addUserToGame(String game) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url+"/PDB_JEE",user,passwd);
            String request = "UPDATE Game SET nbPlayers = ? WHERE name = ?;";
            PreparedStatement statement = con.prepareStatement(request);
            int nb = nbPlayers(game);
            statement.setInt(1, nb+1);
            statement.setString(2, game);
            statement.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
            System.out.println("Jeu non valide !");
        }
    }

    /**
     * Removes a user from a game
     * 
     * @author Adam RIVIERE
     * @param game name of the game
     */
    public static void removeUserFromGame(String game) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url+"/PDB_JEE",user,passwd);
            String request = "UPDATE Game SET nbPlayers = ? WHERE name = ?;";
            PreparedStatement statement = con.prepareStatement(request);
            int nb = nbPlayers(game);
            if (nb > 0) nb -= 1;
            statement.setInt(1, nb);
            statement.setString(2, game);
            statement.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
            System.out.println("Jeu non valide !");
        }
    }

    /**
     * Returns the number of players for a game
     * 
     * @author Adam RIVIERE
     * @param game name of the game
     * @return the number of players
     */
    public static int nbPlayers(String game){
        int gameId = getGameId(game);
        int nb = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url+"/PDB_JEE",user,passwd);
            String request = "SELECT COUNT(*) FROM Session WHERE idGame = ? AND status = 1;";
            PreparedStatement statement = con.prepareStatement(request);
            statement.setInt(1, gameId);
            res = statement.executeQuery();
            while(res.next()) {
                nb = res.getInt(1);
            }
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
            System.out.println("Jeu non valide !");
        }
        return nb;
    }

    /**
     * Modifies the current game for a player
     * 
     * @author Adam RIVIERE
     * @param game name of the game
     * @param pseudo pseudo of the player
     */
    public static void currentGame(String game, String pseudo) {
        try {
            int idGame = getGameId(game);
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url+"/PDB_JEE",user,passwd);
            String request = "UPDATE User SET currentGame = ? WHERE pseudo = ?;";
            PreparedStatement statement = con.prepareStatement(request);
            statement.setInt(1, idGame);
            statement.setString(2, pseudo);
            statement.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
            System.out.println("Joueur ou jeu non valide !");
        }
    }

    /**
     * Adds a session of a game for a player and modifies the differents tables in consequence
     * 
     * @author Adam RIVIERE
     * @param pseudo pseudo of the user
     * @param game game played
     * @param status status of the player
     * @param startDate begin date
     * @param endDate end date
     */
    public static void newSession(String pseudo, String game, int status, String startDate, String endDate){
        currentGame(game, pseudo);
        addUserToGame(game);
        createSession(pseudo, game, status, startDate, endDate);
    }

    /**
     * Archives a session by setting its status to 0.
     * 
     * @author Dejan PARIS
     * @param game name of the game
     * @param pseudo pseudo of the player
     */
    public static void archiveSession(String game, String pseudo) {
        try {
            int idGame = getGameId(game);
            int idUser = getUserId(pseudo);
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url+"/PDB_JEE",user,passwd);
            String request = "UPDATE Session SET status = 0 WHERE idUser = ? AND idGame = ?;";
            PreparedStatement statement = con.prepareStatement(request);
            statement.setInt(1, idUser);
            statement.setInt(2, idGame);
            statement.executeUpdate();
            request = "UPDATE Session SET endDate = ? WHERE idUser = ? AND idGame = ?;";
            statement = con.prepareStatement(request);
            statement.setString(1, SDate.now().toString());
            statement.setInt(2, idUser);
            statement.setInt(3, idGame);
            statement.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
            System.out.println("Session non existante !");
        }
    }

    /**
     * Deletes a session of a player and modifies the differents tables in consequence
     * 
     * @author Adam RIVIERE
     * @param game name of the game
     * @param pseudo pseudo of the player
     */
    public static void endSession(String game, String pseudo){
        removeUserFromGame(game);
        archiveSession(game, pseudo);
        currentGame("None", pseudo);
    }

    /**
     * Deletes a session of a player and modifies the differents tables in consequence
     * 
     * @author Adam RIVIERE
     * @param game name of the game
     * @param pseudo pseudo of the player
     */
    public static void deleteSession(String game, String pseudo){
        supprSession(game, pseudo);
        currentGame("None", pseudo);
    }

    public static void supprSession(String game, String pseudo)
    {
        try {
            int idGame = getGameId(game);
            int idUser = getUserId(pseudo);
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url+"/PDB_JEE",user,passwd);
            String request = "DELETE FROM Session WHERE idGame = ? AND idUser = ?;";
            PreparedStatement statement = con.prepareStatement(request);
            statement.setInt(1, idGame);
            statement.setInt(2, idUser);
            statement.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
            System.out.println("Jeu non existant ! !");
        }
    }

    /**
     * Checks if the pseudo is already used
     * 
     * @author Adam RIVIERE
     * @param pseudo pseudo of the new user
     * @return a boolean
     */
    public static boolean pseudoAlreadyUsed(String pseudo){
        boolean ok = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url+"/PDB_JEE",user,passwd);
            String request = "SELECT pseudo FROM User;";
            PreparedStatement statement = con.prepareStatement(request);
            res = statement.executeQuery();
            while(res.next()) {
                if(res.getString(1).equals(pseudo)){
                    ok = true;
                }
            }
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
        return ok;
    }

    /**
     * Checks if an email is already used
     * 
     * @author Adam RIVIERE
     * @param email new emaail to test
     * @return a boolean
     */
    public static boolean mailAlreadyUsed(String email){
        boolean ok = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url+"/PDB_JEE",user,passwd);
            String request = "SELECT email FROM User;";
            PreparedStatement statement = con.prepareStatement(request);
            res = statement.executeQuery();
            while(res.next()) {
                if(res.getString(1).equalsIgnoreCase(email)){
                    ok = true;
                }
            }
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
        return ok;
    }

    /**
     * Gets the hashed password of a user
     * 
     * @author Adam RIVIERE
     * @param pseudo pseudo of the user
     * @return the hashed password
     */
    public static String getPsw(String pseudo){
        String psw = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url+"/PDB_JEE",user,passwd);
            String request = "SELECT password FROM User WHERE pseudo = ?;";
            PreparedStatement statement = con.prepareStatement(request);
            statement.setString(1, pseudo);
            res = statement.executeQuery();
            while(res.next()) {
                psw = res.getString(1);
            }
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
            System.out.println("Joueur non valide !");
        }
        return psw;
    }

    /**
     * Gets the status of a user
     * 
     * @author Adam RIVIERE
     * @param pseudo pseudo of the user
     * @return the status of the user
     */
    public static int getStatus(String pseudo){
        int status = -1;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url+"/PDB_JEE",user,passwd);
            String request = "SELECT status FROM User WHERE pseudo = ?;";
            PreparedStatement statement = con.prepareStatement(request);
            statement.setString(1, pseudo);
            res = statement.executeQuery();
            while(res.next()) {
                status = res.getInt(1);
            }
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
            System.out.println("Joueur non valide !");
        }
        return status;
    }

    /**
     * Returns a list of all the games associated with the number of players who are playing
     * 
     * @author Adam RIVIERE
     * @return the list of all games and their respective numbers of players.
     */
    public static ArrayList<String> allGames(){
        ArrayList<String> game = new ArrayList<String>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url+"/PDB_JEE",user,passwd);
            String request = "SELECT name,nbPlayers FROM Game WHERE name != 'None';";
            PreparedStatement statement = con.prepareStatement(request);
            res = statement.executeQuery(); 
            while(res.next()){
                game.add(res.getString(1));
                game.add(res.getString(2));
            }
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
        return game;
    }

    /**
     * Returns a list of all the games.
     * 
     * @author Dejan PARIS
     * @return the list of all games
     */
    public static ArrayList<String> allGameTitles(){
        ArrayList<String> game = new ArrayList<String>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url+"/PDB_JEE",user,passwd);
            String request = "SELECT name FROM Game WHERE name != 'None';";
            PreparedStatement statement = con.prepareStatement(request);
            res = statement.executeQuery();
            while(res.next()){
                game.add(res.getString(1));
            }
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
        return game;
    }

    /**
     * Deletes a game
     * 
     * @author Adam RIVIERE
     * @param game name of the game
     */
    public static void removeGame(String game) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url+"/PDB_JEE",user,passwd);
            String request = "DELETE FROM Game WHERE name = ?;";
            PreparedStatement statement = con.prepareStatement(request);
            statement.setString(1, game);
            statement.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
            System.out.println("Jeu non existant ! !");
        }
    }

    /**
     * Gets all active sessions
     * 
     * @author Dejan PARIS
     */
    public static ArrayList<String> allActiveSessions() {
        ArrayList<String> sessions = new ArrayList<String>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url+"/PDB_JEE",user,passwd);
            String request = "SELECT Game.name, User.pseudo, Session.startDate FROM User JOIN Session ON User.idUser = Session.idUser JOIN Game ON Session.idGame = Game.idGame WHERE Session.status = 1;";
            PreparedStatement statement = con.prepareStatement(request);
            res = statement.executeQuery();
            while(res.next()){
                sessions.add(res.getString(1));
                sessions.add(res.getString(2));
                sessions.add(res.getString(3));
            }
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
        return sessions;
    }
    
    /**
     * Gets all archived sessions
     * 
     * @author Dejan PARIS
     */
    public static ArrayList<String> allArchivedSessions() {
        ArrayList<String> sessions = new ArrayList<String>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url+"/PDB_JEE",user,passwd);
            String request = "SELECT Game.name, User.pseudo, Session.startDate, Session.endDate FROM User JOIN Session ON User.idUser = Session.idUser JOIN Game ON Session.idGame = Game.idGame WHERE Session.status = 0;";
            PreparedStatement statement = con.prepareStatement(request);
            res = statement.executeQuery();
            while(res.next()){
                sessions.add(res.getString(1));
                sessions.add(res.getString(2));
                sessions.add(res.getString(3));
                sessions.add(res.getString(4));
            }
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
        return sessions;
    }

    /**
     * Deletes all sessions of a game
     * 
     * @author Adam RIVIERE
     * @param game name of the game
     */
    public static void deleteAllSessions(String game) {
        try {
            int idGame = getGameId(game);
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url+"/PDB_JEE",user,passwd);
            String request = "SELECT pseudo FROM User JOIN Session ON User.idUser = Session.idUser WHERE idGame = ?;";
            PreparedStatement statement = con.prepareStatement(request);
            statement.setInt(1, idGame);
            res = statement.executeQuery();
            while(res.next()){
                deleteSession(game, res.getString(1));
            }
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
            System.out.println("Jeu non existant ! !");
        }
    }

    /**
     * Deletes a game from all preferences
     * 
     * @author Adam RIVIERE
     * @param game name of the game
     */
    public static void deleteAllUsualGames(String game) {
        try {
            int idGame = getGameId(game);
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url+"/PDB_JEE",user,passwd);
            String request = "DELETE FROM UsualGames WHERE idGame = ?;";
            PreparedStatement statement = con.prepareStatement(request);
            statement.setInt(1, idGame);
            statement.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
            System.out.println("Jeu non existant ! !");
        }
    }

    public static void deleteGame(String game){
        deleteAllSessions(game);
        deleteAllUsualGames(game);
        removeGame(game);
    }

    /**
     * Returns all information about a player
     * 
     * @author Adam RIVIERE
     * @return the pseudo, the email, the current game, the registration date and the birth date of the player.
     */
    public static ArrayList<String> playerInfo(String pseudo){
        ArrayList<String> array = new ArrayList<String>();
        int idUser = getUserId(pseudo);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url+"/PDB_JEE",user,passwd);
            String request = "SELECT User.pseudo,User.email,Game.name,User.registration,User.birthDate FROM User JOIN Game ON User.currentGame = Game.idGame WHERE idUser = ?;";
            PreparedStatement statement = con.prepareStatement(request);
            statement.setInt(1, idUser);
            res = statement.executeQuery(); 
            while(res.next()){
                array.add(res.getString(1));
                array.add(res.getString(2));
                array.add(res.getString(3));
                array.add(res.getString(4));
                array.add(res.getString(5));
            }
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
        return array;
    }

    /**
     * Returns all the nicknames of players
     * 
     * @author Dejan PARIS
     * @return list of pseudos
     */
    public static ArrayList<String> allPlayers(){
        ArrayList<String> array = new ArrayList<String>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url+"/PDB_JEE",user,passwd);
            String request = "SELECT pseudo FROM User;";
            PreparedStatement statement = con.prepareStatement(request);
            res = statement.executeQuery(); 
            while(res.next()){
                array.add(res.getString(1));
            }
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
        return array;
    }
}