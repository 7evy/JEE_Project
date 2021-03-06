package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tools.SQL;

@WebServlet(name = "playerslist", urlPatterns = { "/playerslist" })
public class PlayersListServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/playerslist.jsp");
        try {
            request.setAttribute("data", SQL.playerList());
            rd.forward(request, response);
        } catch (Exception e) {}
    }
    
    /**
     * Shows the details of the selected player.
     * @param request
     * @param response
     * @author Dejan PARIS
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            if (request.getParameter("ban").equals("ban"))
            {  
                ArrayList<String> players = SQL.allPlayers();
                String checkbox = request.getParameter("checkbox");
                for (int i=0; i<players.size(); i++) {
                    if(checkbox.equals(""+i)) {
                        SQL.ban(players.get(i));
                    }
                }
            }
            else {
                String pseudo = request.getParameter("pseudo");
                response.sendRedirect("/playerdetails.jsp?pseudo=" + pseudo);
            }
        } catch (Exception e) {}
        doGet(request, response);
    }
}
