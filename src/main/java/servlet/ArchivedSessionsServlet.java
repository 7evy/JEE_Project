package servlet;

import tools.SQL;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
@WebServlet(name = "archivedsessions", urlPatterns = { "/offsessions" })
public class ArchivedSessionsServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Displays the page
     * @param request
     * @param response
     * @author Dejan PARIS
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/archivedsessions.jsp");
        try {
            ArrayList<String> sessions = SQL.allArchivedSessions();
            request.setAttribute("data", sessions);
            rd.forward(request, response);
        } catch (Exception e) {}
    }
}
