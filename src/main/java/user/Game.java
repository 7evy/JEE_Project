package user;

import tools.SQL;

public class Game{

    private String name;

    /**
     * Constructor
     * @author Adam RIVIERE
     * @param name name of the game
     */
    public Game(String name){
        this.name = name;
    }

    /**
     * Constructor
     * @author Adam RIVIERE
     */
    public Game(){
        this.name = null;
    }

    /**
     * Gets the name of the game
     * @return the name
     * @author Adam RIVIERE
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name
     * @param name to set
     * @author Adam RIVIERE
     */
    public void setPseudo(String name) {
        this.name = name;
    }

    public void pushGame(String name){
        SQL.newGame(name);
    }

}