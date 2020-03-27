package servlet;

import tools.SQL;

import java.io.IOException;
import launch.Manager;
import java.util.ArrayList;

// import javax.servlet.RequestDispatcher;
// import javax.servlet.ServletException;
// import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Describes the servlet used on the gameslist page
 * @author Thomas LEPERCQ
 */
@WebServlet(name = "gameslist", urlPatterns = { "/gameslist" })
public class GamesListServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Displays the page
     * @param request
     * @param response
     * @author Thomas LEPERCQ
     * @author Dejan PARIS
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String pageName = "/gameslist.jsp";
        try {
            String games = Manager.makeGamesList();
            response.sendRedirect(pageName + "?data=" + games);
        } catch (IOException e) {
            System.out.println("Error : IOException");
            e.printStackTrace();
        }
    }

    /**
     * Gets checkbox value to add or remove selected game.
     * @param request
     * @param response
     * @author Thomas LEPERCQ
     * @author Dejan PARIS
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String isDelete = request.getParameter("addelete");
        if (isDelete.equals("add")) {
            String newgame = request.getParameter("newgame");
            if(!newgame.equals("") && !newgame.equals(null)){
                SQL.newGame(newgame);
            }
        } else if (isDelete.equals("delete")) {
            ArrayList<String> games = SQL.allGameTitles();
            int numberOfGames = games.size();
            for (int i=0; i<numberOfGames; i++) {
                String increment = ""+i;
                String checkbox = request.getParameter("checkbox" + increment);
                if (checkbox != null) {
                    SQL.deleteGame(games.get(i));
                }
            }
        }
        doGet(request, response);
    }
}
