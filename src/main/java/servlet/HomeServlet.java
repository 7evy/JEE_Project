package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "MyServlet",
        urlPatterns = {"/home"}
    )
public class HomeServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

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


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nickname = request.getParameter("nickname");
        String pwd = request.getParameter("password");
        System.out.println(nickname+" "+ pwd);
}
}
