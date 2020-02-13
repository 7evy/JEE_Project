package tools;

import java.sql.*;

/**
 * 
 * This class is composed of methods used to interact with the database
 * @author Adam RIVIÈRE 
 * 
 */

 public class SQL{

    static Connection con = null;
    static ResultSet res = null;
    static String url = "jdbc:postgresql://127.0.0.1:5432/BD";////////changer url,user,psw
	static String user = "nom-d'utilisateur";
	static String passwd = "mot_de_passe";

    /**
     * Adds a new game in the database
     * @author Adam RIVIERE
     * @param name name of the game
     */
    public static void newGame(String name) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, passwd);
            String request = "INSERT INTO Game(name) VALUES(?);";
            PreparedStatement statement = con.prepareStatement(request);
            statement.setString(1,name);
            statement.executeUpdate();
		} catch (Exception e) {
			new Message().dialog("Problème de connexion à la base de donnée vérifier le réseau "+e.getMessage());
		}		
    }
    
    /**
     * Adds a new game in the database
     * @author Adam RIVIERE
     * @param pseudo pseudo of the user
     * @param password encrypted password of the user
     * @param email mail of the user
     * @param status type of account of the user
     * @param registration registration date of the user
     * @param birthDate birth date of the user 
     */
    public static void newUser(String pseudo, String password, String email, int status, String registration, String birthDate){
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, passwd);
            String request = "INSERT INTO User(pseudo,password,email,status,registration,birthDate) VALUES(?,?,?,?,?,?);";
            PreparedStatement statement = con.prepareStatement(request);
            statement.setString(1,pseudo);
            statement.setString(1,password);
            statement.setString(1,email);
            statement.setInt(1,status);
            statement.setString(1,registration);
            statement.setString(1,birthDate);
            statement.executeUpdate();
		} catch (Exception e) {
			new Message().dialog("Problème de connexion à la base de donnée vérifier le réseau "+e.getMessage());
		}
    }

    public static int getUserId(String pseudo){
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, passwd);
            String request = "SELECT idUser FROM User WHERE pseudo = ?;";
            PreparedStatement statement = con.prepareStatement(request);
            statement.setString(1,pseudo);
            res = statement.executeQuery();
            int id = res.getInt("idUser");
            return id;
		} catch (Exception e) {
			new Message().dialog("Problème de connexion à la base de donnée vérifier le réseau "+e.getMessage());
		}
    }

 }