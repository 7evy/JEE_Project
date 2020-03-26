package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
// import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tools.SQL;

//import tools.SDate;

/**
 * Describes the servlet used on the register page
 * 
 * @author Sébastien HERT
 */
@WebServlet(name = "register", urlPatterns = { "/register" })
public class RegisterServlet extends HttpServlet {

private String argUrl = "";

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
        System.out.println(nickname + " " + pwd1 + " " + pwd2 + " " + email + " " + birthday);

        //Checking the age
        if (!this.checkBirthday(birthday)){
            //TODO
            argUrl = argUrl.concat("birth=1");
            System.out.println("There is a pb with the date. You must be over 13 to register.");
        }
        //Checking if the passwords are the same pwd
        if (!this.checkPassword(pwd1, pwd2)){
            //TODO
            argUrl = argUrl.concat("+pswd=1");
            System.out.println("The 2 passwords given are different.");
        }
                
        //Checking if the address is already used
        if (!this.checkEMail(email)){
            //TODO
            argUrl = argUrl.concat("+email=1");
            System.out.println("Email already used.");
        }
        //Checking is the nickname is already taken
        if (!this.checkNickname(nickname)){
            //TODO
            argUrl = argUrl.concat("+nickname=1");
            System.out.println("The nickname is already taken");
        }

        if(argUrl == ""){
         response.sendRedirect("/gamechoice");
        }
        else{
            String s = "/playerdetails.jsp?";
            s = s.concat(argUrl);
            response.sendRedirect(s);
        }
    }

    public boolean checkNickname(String pseudo) {
        return !SQL.pseudoAlreadyUsed(pseudo);
    }

    public boolean checkPassword(String pwd1, String pwd2) {
        return pwd1.equals(pwd2);
    }

    public boolean checkEMail(String email) {
        return !SQL.mailAlreadyUsed(email);
    }

    public boolean checkBirthday(String birthday) {
        try {
            int year = Integer.parseInt(birthday.split("-")[0]);
            if (year > 2006 || year < 1900) {
                System.out.println("invalid date");
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
        } catch (ArrayIndexOutOfBoundsException e) {
        }
        return false;
    }
}
