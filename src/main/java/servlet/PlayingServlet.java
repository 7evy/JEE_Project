package servlet;

import java.io.IOException;

// import javax.servlet.RequestDispatcher;
// import javax.servlet.ServletException;
// import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import launch.Manager;
import tools.SQL;

/**
 * Describes the servlet used on the player details page
 * 
 * @author Sébastien HERT
 */

@WebServlet(name = "playing", urlPatterns = { "/playing" })
public class PlayingServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Used to end a game.
     * 
     * @param request
     * @param response
     * @author Dejan PARIS
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        
        try {
            String game = request.getParameter("name");
            SQL.endSession(game, Manager.getCurrentUser().getPseudo());
            response.sendRedirect("/gamechoice");
        } catch (IOException e) {}
    }
}