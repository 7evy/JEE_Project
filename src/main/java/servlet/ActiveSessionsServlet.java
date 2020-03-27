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
@WebServlet(name = "activesessions", urlPatterns = { "/onsessions" })
public class ActiveSessionsServlet extends HttpServlet {

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
            throws IOException {
        String pageName = "/activesessions.jsp";
        try {
            String sessions = Manager.activeSessionsList();
            response.sendRedirect(pageName + "?data=" + sessions);
        } catch (IOException e) {}
    }

    /**
     * Gets checkbox value to add or remove selected session.
     * @param request
     * @param response
     * @author Dejan PARIS
     */
    // TODO
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        ArrayList<String> sessions = SQL.allActiveSessions();
        int nbSessions = sessions.size()/3;
        for (int i=0; i<nbSessions; i++) {
            String increment = ""+i;
            String checkbox = request.getParameter("checkbox" + increment);
            if (checkbox != null) {
                SQL.deleteSession(sessions.get(3*i), sessions.get(3*i+1));
            }
        }
        doGet(request, response);
    }
}
