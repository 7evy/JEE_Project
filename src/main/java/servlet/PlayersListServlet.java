package servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import launch.Manager;

@WebServlet(name = "playerslist", urlPatterns = { "/playerslist" })
public class PlayersListServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
                String pageName = "/playerslist.jsp";
                try{
                    String allPlayers = Manager.makePlayersList();
                    response.sendRedirect(pageName + "?data=" + allPlayers);
                }
                catch (IOException e) {
                System.out.println("Error : IOException");
                e.printStackTrace();
            }
        }

}
