package servlet;

import tools.SQL;

import java.io.IOException;
import launch.Manager;
import java.util.List;
import java.util.Arrays;

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
            List<String> games = Arrays.asList(request.getParameter("data").split(";"));
            String checkboxName = request.getParameter("checkbox");
            int numberOfGames = games.size()/2;
            String increment = "";
            int checkboxNumber = Integer.parseInt(checkboxName);
            checkboxName = ""+checkboxNumber;
            for (int i=0; i<numberOfGames; i++) {
                increment = ""+i;
                if (checkboxName.equals(increment)) {
                        SQL.deleteGame(games.get(2*i));
                }
            }
        }
        doGet(request, response);
    }
}
