package servlet;

import java.io.IOException;
import java.util.ArrayList;
// import tools.SQL;
import launch.Manager;

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
     * @author Sébastien HERT
     * @author Thomas LEPERCQ
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String pageName = "/gameslist.jsp";
        try {
            // String data = Manager.listToString(SQL.gameList(Manager.getCurrentUser().getPseudo()));
            ArrayList<String> data = new ArrayList<String>();   // Temporary
            data.add("Minecraft"); data.add("1");               // Temporary
            data.add("Fortnite"); data.add("0");                // Temporary
            data.add("Dragon Quest"); data.add("3");            // Temporary
            response.sendRedirect(pageName + "?data=" + Manager.listToString(data));
        } catch (IOException e) {
            System.out.println("Error : IOException");
            e.printStackTrace();
        }
    }
}
