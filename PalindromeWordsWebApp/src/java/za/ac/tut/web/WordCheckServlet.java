/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.model.WordCheckerInterface;
import za.ac.tut.model.WordCheckerManager;

/**
 *
 * @author MemaniV
 */
public class WordCheckServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet WordCheckServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet WordCheckServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String word = request.getParameter("word");
        
        WordCheckerInterface wci = new WordCheckerManager();
        String reverseForm = wci.getWordReverseForm(word);
        boolean isPalindrome = wci.isWordAPalindrome(word, reverseForm);
        
        updateSession(session, isPalindrome);

        request.setAttribute("word", word);
        request.setAttribute("reverseForm", reverseForm);
        request.setAttribute("isPalindrome", isPalindrome);
        
        RequestDispatcher disp = request.getRequestDispatcher("outcome.jsp");
        disp.forward(request, response);
    }

    private void updateSession(HttpSession session, boolean isPalindrome) {
        int cnt = (Integer)session.getAttribute("cnt");
        int numPalindromes = (Integer)session.getAttribute("numPalindromes");
        
        cnt++;
        
        if(isPalindrome){
            numPalindromes++;
        }
               
        session.setAttribute("cnt", cnt);
        session.setAttribute("numPalindromes", numPalindromes);
    }

}
