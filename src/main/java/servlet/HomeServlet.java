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
        urlPatterns = {""}
    )
public class HomeServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // ServletOutputStream out = response.getOutputStream();
        // out.write("Voici le second test".getBytes());
        // out.flush();
        // out.close();
        // System.out.println(request);
        // System.out.println(response);
        // // System.out.println(req);




        // RequestDispatcher req = getServletContext().getRequestDispatcher("/../../html/index.jsp");
        // try{
        
        // req.forward(request, response);
        // }
        // catch (ServletException e){
        //     e.printStackTrace();
        // }
        // catch (IOException e){
        //     e.printStackTrace();
        // }
    }
}
