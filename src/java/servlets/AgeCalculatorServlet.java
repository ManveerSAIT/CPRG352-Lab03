
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AgeCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //loading up a JSP
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ageentered = request.getParameter("age_entered");
        
        request.setAttribute("ageInput", ageentered);
        
        if(ageentered == null || ageentered == "") {   
            request.setAttribute("noInput", "You must give your current age.");
            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
            return;              
        }
        try {
            int ageoutput = Integer.parseInt(ageentered) + 1;
            String finaloutput = "Your age next next birthday will be " + ageoutput;
            request.setAttribute("ageOutput", finaloutput);
            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
            return;
        }
        catch (NumberFormatException e){
            request.setAttribute("invalidInput", "You must enter a number.");
            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
            return;  
        }      
    }
}
