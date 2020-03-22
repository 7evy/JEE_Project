package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
// import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        String pageName = "/index.html";
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
     * Checks if the user is registered
     * @param request
     * @param response
     * @author Sébastien HERT
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nickname = request.getParameter("nickname");
        String pwd = request.getParameter("password");
        System.out.println(nickname + " " + pwd);
        // TODO
        response.sendRedirect("/gamechoice");
    }
}
