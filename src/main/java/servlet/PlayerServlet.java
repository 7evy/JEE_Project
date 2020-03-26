package servlet;

import java.io.IOException;

// import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
// import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import launch.Manager;

/**
 * Describes the servlet used on the player details page
 * 
 * @author Sébastien HERT
 */

@WebServlet(name = "player", urlPatterns = { "/player" })
public class PlayerServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Redirect admins to the correct page
     * 
     * @param request
     * @param response
     * @author Sébastien HERT
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String pageName = "/playerdetails.jsp";
        String user = Manager.makeUserDetails();

        response.sendRedirect(pageName+"?data="+user);
    }
}