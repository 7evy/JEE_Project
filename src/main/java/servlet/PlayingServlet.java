package servlet;

import java.io.IOException;

// import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
// import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    // TODO
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String game = request.getParameter("name");
        System.out.println(request.getParameter("name"));
        System.out.println(request.getParameter("start"));
        System.out.println(request.getParameter("end"));
        if (request.getParameter("end").equals("1"))
        {
            System.out.println("yolo");
            SQL.removeUserFromGame(game);
            response.sendRedirect("/gamechoice");
        }
        else if (request.getParameter("start").equals("1"))
        {
            System.out.println("oloy");
            SQL.addUserToGame(game);
        }
    }
}