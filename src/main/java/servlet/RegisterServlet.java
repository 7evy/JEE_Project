package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
// import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import tools.SDate;

/**
 * Describes the servlet used on the register page
 * 
 * @author Sébastien HERT
 */
@WebServlet(name = "register", urlPatterns = { "/register" })
public class RegisterServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Displays the page
     * 
     * @param request
     * @param response
     * @author Sébastien HERT
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pageName = "/register.html";
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
     * Gets informations send by the register page and then checks them before
     * connecting the new user
     * 
     * @param request
     * @param response
     * @author Sébastien HERT
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nickname = request.getParameter("nickname");
        String pwd1 = request.getParameter("password1");
        String pwd2 = request.getParameter("password2");
        String email = request.getParameter("email");
        String birthday = request.getParameter("birthday");
        String favoriteGames = request.getParameter("favorite");
        System.out.println(nickname + " " + pwd1 + " " + pwd2 + " " + email + " " + birthday + " " + favoriteGames);

        System.out.println(this.checkBirthday(birthday));

        // System.out.println(SDate.htmlToSdate(birthday));

        // TODO
        // check informations + database + connect or pop up

        response.sendRedirect("/gamechoice");
    }

    public boolean checkNickname(String pseudo) {
        // TODO
        return false;
    }

    public boolean checkPassword(String pwd1, String pwd2) {
        // TODO
        return false;
    }

    public boolean checkEMail(String email) {
        // TODO
        return false;
    }

    public boolean checkBirthday(String birthday) {
        try {
            if (Integer.parseInt(birthday.split("-")[0]) > 2006) {
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
        } catch (ArrayIndexOutOfBoundsException e) {
        }
        return false;
    }
}
