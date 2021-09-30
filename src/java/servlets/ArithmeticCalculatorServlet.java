package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ArithmeticCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("resultOutput", "---");
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstvalue = request.getParameter("first_value");
        String secondvalue = request.getParameter("second_value");
        
        request.setAttribute("firstInt", firstvalue);
        request.setAttribute("secondInt", secondvalue);
        
        String calc = request.getParameter("calc");
        
        if(firstvalue == null || firstvalue == "" || secondvalue == null || secondvalue == "") {   
            request.setAttribute("resultOutput", "Invalid");
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
            return;              
        }
        try {
            int firstint = Integer.parseInt(firstvalue);
            int secondint = Integer.parseInt(secondvalue);
            int finalvalue = 0;

            if(calc.equals("+")) {
                finalvalue = firstint + secondint;
            } else if(calc.equals("-")) {
                finalvalue = firstint - secondint;
            } else if(calc.equals("*")) {
                finalvalue = firstint * secondint;
            } else if(calc.equals("-")) {
                finalvalue = firstint - secondint;
            } else if(calc.equals("%")) {
                finalvalue = firstint % secondint;
            }
            
            request.setAttribute("resultOutput", finalvalue);
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
            return;  
        }
        catch (NumberFormatException e){
            request.setAttribute("resultOutput", "Invalid");
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
            return;  
        }     
        
    }

}
