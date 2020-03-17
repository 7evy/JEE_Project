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
            String request = "INSERT INTO Game(name) VALUES(?);";
            PreparedStatement statement = con.prepareStatement(request);
            statement.setString(1, name);
            statement.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
    }

    /**
     * Adds a new user in the database
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
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url+"/PDB_JEE",user,passwd);
            String request = "INSERT INTO User(pseudo,password,email,status,registration,birthDate) VALUES(?,?,?,1,?,?);";
            PreparedStatement statement = con.prepareStatement(request);
            statement.setString(1, pseudo);
            statement.setString(2, password);
            statement.setString(3, email);
            statement.setString(4, registration);
            statement.setString(5, birthDate);
            statement.executeUpdate();
        } catch (Exception e) {
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
        int id = 0;
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
        int id = 0;
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
    public static void newSession(String pseudo, String game, int status, String startDate, String endDate) {
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
            String request = "UPDATE User SET status = 3 WHERE pseudo = ?;";
            PreparedStatement statement = con.prepareStatement(request);
            statement.setString(1, pseudo);
            statement.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
    }

    /**
     * Debans a user
     * 
     * @author Adam RIVIERE
     * @param pseudo pseudo of the user
     */
    public static void deban(String pseudo) {
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
    public static int nbSessions(String pseudo){
        int userId = getUserId(pseudo);
        int nb = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url+"/PDB_JEE",user,passwd);
            String request = "SELECT COUNT(*) FROM Session WHERE idUser = ?;";
            PreparedStatement statement = con.prepareStatement(request);
            statement.setInt(1, userId);
            res = statement.executeQuery();
            while(res.next()) {
                nb = res.getInt(1);
            }
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
        return nb;
    }

    /**
     * Returns a list of users whith their pseudo, registration date, status and number of sessions
     * 
     * @author Adam RIVIERE
     * @return the list of all players
     */
    public static ArrayList<ArrayList<?>> playerList(){
        ArrayList<ArrayList<?>> array = new ArrayList<ArrayList<?>>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url+"/PDB_JEE",user,passwd);
            String request = "SELECT pseudo,registration,status FROM User;";
            PreparedStatement statement = con.prepareStatement(request);
            res = statement.executeQuery(); 
            while(res.next()){
                ArrayList<Object> player = new ArrayList<Object>();
                player.add(res.getString(1));
                player.add(res.getString(2));
                player.add(res.getInt(3));
                int nbSessions = nbSessions(player.get(0).toString());
                player.add(nbSessions);
                array.add(player);
            }
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
        return array;
    }

}