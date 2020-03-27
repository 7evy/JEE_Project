package servlet;

import java.io.IOException;

// import java.util.ArrayList;
// import tools.SQL;
import launch.Manager;
import tools.SDate;
import tools.SQL;

// import javax.servlet.RequestDispatcher;
// import javax.servlet.ServletException;
// import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Describes the servlet used on the gamechoice page
 * @author Sébastien HERT
 */
@WebServlet(name = "gamechoice", urlPatterns = { "/gamechoice" })
public class GameChoiceServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Displays the page with the list of the games.
     * @param request
     * @param response
     * @author Sébastien HERT
     * @author Dejan PARIS
     */
    // TODO
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String pageName = "/gamechoice.jsp";
        try {
            String games = Manager.makeGamesList();
            response.sendRedirect(pageName + "?data=" + games);
        } catch (IOException e) {}
    }
    
    /**
     * Starts the chosen game for the user.
     * @param request
     * @param response
     * @author Dejan PARIS
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String pageName = "/playing.jsp";
        try {
            String game = request.getParameter("game");
            SQL.newSession(Manager.getCurrentUser().getPseudo(), game, 1, SDate.now().toString(), new SDate().toString());
            response.sendRedirect(pageName + "?name=" + game);
        } catch (IOException e) {}
    }
}
