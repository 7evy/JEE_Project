package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
// import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import launch.Manager;
import user.User;
import tools.Hasher;
import tools.SQL;

/**
 * Describes the servlet used on the home page
 * @author Sébastien HERT
 */

@WebServlet(name = "home", urlPatterns = { "/home" })
public class HomeServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Displays the page
     * Users must enter their login and their password
     * @param request
     * @param response
     * @author Sébastien HERT
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pageName = "/index.jsp";
        RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);
        try {
            rd.forward(request, response);
        } catch (ServletException e) {
            System.out.println("Error : ServletException");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error : IOException");
            e.printStackTrace();
        }
    }


    /**
     * Gets the login and the password
     * Connects the user or returns to login screen if credentials are wrong
     * @param request
     * @param response
     * @author Sébastien HERT
     * @author Thomas LEPERCQ
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nickname = request.getParameter("nickname");
        String pwd = request.getParameter("password");
        if(connectionCheck(nickname,pwd) == true){
            User user = new User(nickname);
            Manager.setCurrentUser(user);

            switch (user.getStatus()) {
                //Admin
                case 0:
                    //TODO
                    // response.sendRedirect("/gamelist");
                    response.sendRedirect("/gamechoice");
                    break;
                //Player
                case 1:
                    response.sendRedirect("/gamechoice");
                    break;
                //Banned
                case 2:
                    response.sendRedirect("/index.jsp?cred=2");
                    break;
                default:
                    break;
            }
        }else{
            response.sendRedirect("/index.jsp?cred=1");
        }
    }

    /**
     * Gets the login and the password
     * Checks if the user is registered and then compares passwords
     * @param nickname
     * @param password
     * @author Thomas LEPERCQ
     */
    public boolean connectionCheck(String nickname, String pwd){
        boolean res = false;
        if(nickname == null || pwd == null || nickname.equals("") || pwd.equals("")){
            res = false;
        }else if(Hasher.hashing(pwd).equals(SQL.getPsw(nickname))){
            res = true;
        }
        return res; 
    }
}
