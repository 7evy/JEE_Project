package tools;

import java.sql.*;

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
  static String url = "jdbc:postgresql://127.0.0.1:5432/BD";//////// changer url,user,psw
  static String user = "nom-d'utilisateur";
  static String passwd = "mot_de_passe";

  /**
   * Adds a new game in the database
   * 
   * @author Adam RIVIERE
   * @param name name of the game
   */
  public static void newGame(String name) {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection(url, user, passwd);
      String request = "INSERT INTO Game(name) VALUES(?);";
      PreparedStatement statement = con.prepareStatement(request);
      statement.setString(1, name);
      statement.executeUpdate();
    } catch (Exception e) {
      e.getMessage();
    }
  }

  /**
   * Adds a new game in the database
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
      con = DriverManager.getConnection(url, user, passwd);
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
      con = DriverManager.getConnection(url, user, passwd);
      String request = "SELECT idUser FROM User WHERE pseudo = ?;";
      PreparedStatement statement = con.prepareStatement(request);
      statement.setString(1, pseudo);
      res = statement.executeQuery();
      id = res.getInt("idUser");
    } catch (Exception e) {
      e.getMessage();
    }
    return id;
  }

  /**
   * Gets the id of a game
   * 
   * @author Adam RIVIERE
   * @param pseudo name of the game
   * @return the id of the game
   */
  public static int getGameId(String name) {
    int id = 0;
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection(url, user, passwd);
      String request = "SELECT idGame FROM Game WHERE name = ?;";
      PreparedStatement statement = con.prepareStatement(request);
      statement.setString(1, name);
      res = statement.executeQuery();
      id = res.getInt("idGame");
    } catch (Exception e) {
      e.getMessage();
    }
    return id;
  }

  /**
   * Adds a new link between a game and a user in the database
   * 
   * @author Adam RIVIERE
   * @param user pseudo of the user
   * @param game name of the game
   */
  public static void newUsualGames(String user, String game) {
    try {
      int userId = getUserId(user);
      int gameId = getGameId(game);
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection(url, user, passwd);
      String request = "INSERT INTO UsualGames(idUser,idGame) VALUES(?,?);";
      PreparedStatement statement = con.prepareStatement(request);
      statement.setInt(1, userId);
      statement.setInt(2, gameId);
      statement.executeUpdate();
    } catch (Exception e) {
      e.getMessage();
    }
  }

  /**
   * Adds a new game session in the database
   * 
   * @author Adam RIVIERE
   * @param user      pseudo of the user
   * @param game      name of the game
   * @param status    status of the session
   * @param startDate begin date of the session
   * @param endDate   end date of the session
   */
  public static void newSession(String user, String game, int status, String startDate, String endDate) {
    try {
      int userId = getUserId(user);
      int gameId = getGameId(game);
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection(url, user, passwd);
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
    }
  }

  /**
   * Gets the id of a user
   * 
   * @author Adam RIVIERE
   * @param pseudo pseudo of the user
   * @return the id of the user
   */
  public static void promoteAdmin(String pseudo) {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection(url, user, passwd);
      String request = "UPDATE FROM User SET status = 0 WHERE pseudo = ?;";
      PreparedStatement statement = con.prepareStatement(request);
      statement.setString(1, pseudo);
      statement.executeQuery();
    } catch (Exception e) {
      e.getMessage();
    }
  }

}