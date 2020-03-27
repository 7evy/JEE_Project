package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
        try {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/playerdetails.jsp");
            request.setAttribute("data", SQL.playerInfo(request.getParameter("pseudo")));
            System.out.println(request.getParameter("pseudo"));
            rd.forward(request, response);
        } catch (Exception e) {}
    }
}