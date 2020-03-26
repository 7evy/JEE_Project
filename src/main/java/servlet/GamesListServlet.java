package servlet;

import tools.SQL;
import user.User;

import java.io.IOException;
import launch.Manager;
import java.util.List;
import java.util.Arrays;

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
     * @author Thomas LEPERCQ
     * @author Dejan PARIS
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String pageName = "/gameslist.jsp";
        User user = Manager.getCurrentUser();
        // Prevents access if you are not an administrator
        if (user == null)
            response.sendRedirect("/index.jsp?cred=1");
        else if (user.getStatus() == 1)
            response.sendRedirect("/index.jsp?cred=1");
        else if (user.getStatus() == 2)
            response.sendRedirect("/index.jsp?cred=2");
        else
        {
            try {
                String games = Manager.makeGamesList();
                response.sendRedirect(pageName + "?data=" + games);
            } catch (IOException e) {
                System.out.println("Error : IOException");
                e.printStackTrace();
            }
        }
    }

    /**
     * Gets checkbox value to add or remove selected game.
     * @param request
     * @param response
     * @author Thomas LEPERCQ
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String isDelete = request.getParameter("addelete");
        if(isDelete.equals("add")){
            String newgame = request.getParameter("newgame");
            if(!newgame.equals("") && !newgame.equals(null)){
                SQL.newGame(newgame);
            }
        }else{
            int numberOfGames = SQL.allGames().size();
            String increment = "";
            String checkboxName = request.getParameter("checkbox");
            int checkboxNumber = Integer.parseInt(checkboxName);
            checkboxName = ""+checkboxNumber;
            for(int i=0; i<numberOfGames; i++){
                increment = ""+i;
                if(checkboxName.equals(increment)){
                    if(isDelete.equals("delete")){
                        String data = Manager.makeGamesList();
                        List<String> games = Arrays.asList(data.split(";"));
                        String game = games.get(i);
                        SQL.deleteGame(game);
                    }
                }
            }
        }
        doGet(request, response);
    }
}
