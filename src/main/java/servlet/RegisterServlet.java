package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
// import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tools.SQL;
import user.User;
import tools.Hasher;
import tools.SDate;
import launch.Manager;

/**
 * Describes the servlet used on the register page
 * 
 * @author Sébastien HERT
 * @author Alex JOBARD

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
        String pageName = "/register.jsp";
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
     * @author Alex JOBARD

     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nickname = request.getParameter("nickname");
        String pwd1 = request.getParameter("password1");
        String pwd2 = request.getParameter("password2");
        String email = request.getParameter("email");
        String birthday = request.getParameter("birthday");
        // System.out.println(nickname + " " + pwd1 + " " + pwd2 + " " + email + " " + birthday);

         ArrayList<String> argUrlList=new ArrayList<String>();
         String argUrl = "";

        //Checking the age
        if (!this.checkBirthday(birthday)){
            //TODO
            argUrlList.add("birth=1");
            System.out.println("There is a pb with the date. You must be over 13 to register.");
        }
        
        //Checking if the passwords are the same pwd
        if (!this.checkPassword(pwd1, pwd2)){
            //TODO
            argUrlList.add("pswd=1");
            System.out.println("The 2 passwords given are different.");
        }
                
        //Checking if the address is already used
        if (!this.checkEMail(email)){
            //TODO
            argUrlList.add("email=1");
            System.out.println("Email already used.");
        }

        //Checking is the nickname is already taken
        if (!this.checkNickname(nickname)){
            //TODO
            argUrlList.add("nickname=1");
            System.out.println("The nickname is already taken");
        }
        
        for(int j =0;j<argUrlList.size();j++){
            argUrl = argUrl.concat(argUrlList.get(j)+"&");
          }

        if(argUrl.equals("")){
            // User user = new User()
            SQL.newUser(nickname, Hasher.hashing(pwd1), email, SDate.now().toString(), SDate.htmlToSdate(birthday).toString());
            Manager.setCurrentUser(new User(nickname));
            response.sendRedirect("/gamechoice");
        }
        else{
            String s = "/register.jsp?";
            s = s.concat(argUrl);
            response.sendRedirect(s);
        }
    }

    /**
     * Checks if the nickname is already used or null
     * 
     * @param pseudo the pseudo
     * @return a boolean
     * @author Sébastien HERT
     */
    public boolean checkNickname(String pseudo) {
        if (pseudo.equals("")){
            return false;
        }
        return !SQL.pseudoAlreadyUsed(pseudo);
    }

    /**
     * Checks if the passwords are different or null
     * 
     * @param pwd1 the first password
     * @param pwd2 the second password
     * @return a boolean
     * @author Sébastien HERT
     */
    public boolean checkPassword(String pwd1, String pwd2) {
        if (pwd1.equals("") || pwd2.equals("")){
            return false;
        }

        if (pwd1.equals(pwd2)){
            return true;
        }
        return false;
    }

    /**
     * Checks if the mail is already used or null
     * 
     * @param email the Email address
     * @return a boolean
     * @author Sébastien HERT
     */
    public boolean checkEMail(String email) {
        if (email.equals("")){
            return false;
        }
        return !SQL.mailAlreadyUsed(email);
    }

    /**
     * Checks if the birth Day is valid or not
     * 
     * @param birthday the birth Day
     * @return a boolean
     * @author Sébastien HERT
     */
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
