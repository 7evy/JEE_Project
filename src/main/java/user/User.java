package user;

import java.util.ArrayList;

import tools.*;

/**
 * This class contains all the methods relative to the user
 * @author Sébastien HERT
 * @author Adam RIVIERE
 */
public class User{

    private String pseudo;
    private String pwd;
    private String eMail;
    private SDate registration;
    private SDate birth;
    private ArrayList<Game> games;
    private int nbSessions;
    
    private int status;
    /**
     * 0 = Admin
     * 1 = Player
     * 2 = Banned
     */

    /**
     * Constructor
     * @author Sébastien HERT
     */
    public User(){
        this.pseudo = null;
        this.pwd = null;
        this.eMail = null;
        this.status = -1;
        this.registration = new SDate();
        this.birth = new SDate();
        this.games = new ArrayList<Game>();
        this.nbSessions = 0;
    }

    /**
     * Constructor
     * @param pseudo the pseudo
     * @param pwd the password
     * @param eMail the eMail
     * @param status the UserStatus
     * @param registration the registration date
     * @param birth the BirthDate
     * @param games the AL of Games
     * @param nbSessions the number of sessions
     * @author Sébastien HERT
     */
    public User(String pseudo, String pwd, String eMail, int status, SDate registration, SDate birth, ArrayList<Game> games, int nbSessions){
        this.pseudo = pseudo;
        this.pwd = pwd;
        this.eMail = eMail;
        this.status = status;
        this.registration = registration;
        this.birth = birth;
        this.games = games;
        this.nbSessions = nbSessions;
    }

    /**
     * Constructor
     * @param pseudo the pseudo
     * @author Sébastien HERT
     */
    public User(String pseudo){
        this.pseudo = pseudo;
        this.pwd = SQL.getPsw(pseudo);
        this.eMail = null;
        this.status = SQL.getStatus(pseudo);
        this.registration = new SDate();
        this.birth = new SDate();
        this.games = new ArrayList<Game>();
        this.nbSessions = 0;
    }

    /**
     * Gets the pseudo
     * @return the pseudo
     * @author Sébastien HERT
     */
    public String getPseudo() {
        return this.pseudo;
    }

    /**
     * Sets the pseudo
     * @param pseudo to set
     * @author Sébastien HERT
     */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    /**
     * Gets the password
     * @return the password
     * @author Sébastien HERT
     */
    public String getPwd() {
        return this.pwd;
    }

    /**
     * Sets the password
     * @param pwd to set
     * @author Sébastien HERT
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * Gets the Email
     * @return the Email
     * @author Sébastien HERT
     */
    public String getEMail() {
        return this.eMail;
    }

    /**
     * Sets the Email
     * @param eMail to set
     * @author Sébastien HERT
     */
    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    /**
     * Gets the userStatus
     * @return the status
     * @author Sébastien HERT
     */
    public int getStatus() {
        return this.status;
    }

    /**
     * Sets the userStatus
     * @param status to set
     * @author Sébastien HERT
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Gets the registration
     * @return the registration
     * @author Sébastien HERT
     */
    public SDate getRegistration() {
        return this.registration;
    }

    /**
     * Sets the registration
     * @param registration to set
     * @author Sébastien HERT
     */
    public void setRegistration(SDate registration) {
        this.registration = registration;
    }

    /**
     * Gets the birth
     * @return the birth
     * @author Sébastien HERT
     */
    public SDate getBirth() {
        return this.birth;
    }

    /**
     * Sets the birth
     * @param birth to set
     * @author Sébastien HERT
     */
    public void setBirth(SDate birth) {
        this.birth = birth;
    }

    /**
     * Gets the AL of Games
     * @return the AL of Games
     * @author Sébastien HERT
     */
    public ArrayList<Game> getGames() {
        return this.games;
    }

    /**
     * Sets the AL of Games
     * @param games to set
     * @author Sébastien HERT
     */
    public void setGames(ArrayList<Game> games) {
        this.games = games;
    }

    /**
     * Gets the number of Sessions
     * @return the number of sessions
     * @author Sébastien HERT
     */
    public int getNbSessions() {
        return this.nbSessions;
    }

    /**
     * Sets the number of Sessions
     * @param nbSessions to set
     * @author Sébatien HERT
     * 
     */
    public void setNbSessions(int nbSessions) {
        this.nbSessions = nbSessions;
    }

    /**
     * adds a new user to the database
     * @param pseudo the pseudo
     * @param pwd the password
     * @param eMail the eMail
     * @param status the UserStatus
     * @param registration the registration date
     * @param birth the BirthDate
     * @param games the AL of Games
     * @author Adam RIVIERE
     */
    public void pushUser(String pseudo, String pwd, String eMail,int status, SDate registration, SDate birth, ArrayList<Game> games){
        // User user = new User(pseudo, pwd, eMail, status, registration, birth, games, 0);
        String hpwd = Hasher.hashing(pwd);
        SQL.newUser(pseudo, hpwd, eMail, registration.toString(), birth.toString());
    }
}