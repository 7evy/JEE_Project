package servlet;

import java.io.IOException;
import java.util.ArrayList;
import tools.SQL;
import launch.Manager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
            //ArrayList<String> data = new ArrayList<String>();   // Temporary
            //data.add("Minecraft"); data.add("1");               // Temporary
            //data.add("Fortnite"); data.add("0");                // Temporary
            //data.add("Dragon Quest"); data.add("3");            // Temporary
            response.sendRedirect(pageName + "?data=" + games);
        } catch (IOException e) {
            System.out.println("Error : IOException");
            e.printStackTrace();
        }
    }
}
