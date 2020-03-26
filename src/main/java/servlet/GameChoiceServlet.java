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
     * Displays the page
     * @param request
     * @param response
     * @author Sébastien HERT
     */
    // TODO
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pageName = "/gamechoice.jsp";
        RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);
        try {
            // String data = Manager.listToString(SQL.gameList(Manager.getCurrentUser().getPseudo()));
            ArrayList<String> data = new ArrayList<String>();
            data.add("default");
            data.add("default");
            data.add("default");
            response.sendRedirect("/gamechoice.jsp?data=" + Manager.listToString(data));
        //} catch (ServletException e) {
           // System.out.println("Error : ServletException");
           // e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error : IOException");
            e.printStackTrace();
        }
    }
}
