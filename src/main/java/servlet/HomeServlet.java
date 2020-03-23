package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
// import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tools.Hasher;
import tools.SQL;

/**
 * Describes the servlet used on the home page
 * @author Sébastien HERT
 */

@WebServlet(name = "home", urlPatterns = { "" })
public class HomeServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public int cred = 0;

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
     * Checks if the user is registered and then connect him
     * @param request
     * @param response
     * @author Sébastien HERT
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nickname = request.getParameter("nickname");
        String pwd = request.getParameter("password");
        if(connectionCheck(nickname,pwd) == true){
            response.sendRedirect("/gamechoice");
        }else{
            cred = 1;
        }
    }

    public boolean connectionCheck(String nickname, String pwd){
        boolean res = false;
        if(nickname != null && pwd != null && nickname != "" && pwd != ""){
            res = false;
        }else if(Hasher.hashing(pwd) == SQL.getPsw(nickname)){
            res = true;
        }
        return res; 
    }
}
