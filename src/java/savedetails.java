/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author user
 */
public class savedetails {
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request  request
     * @param response response
     * @throws ServletException if a -specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int id = Integer.parseInt(request.getParameter("id"));
            String f_name = request.getParameter("fname");
            String l_name = request.getParameter("lname");
            String gender = request.getParameter("gender");
            String program = request.getParameter("program");
             
            operations cops = new operations();
                cops.setStudentID(id);
                cops.setFname(f_name);
                cops.setLname(l_name);
                cops.setGender(gender);
                cops.setDegree(program);
                boolean success = cops.save();
                if (success == true){
                    out.println("Record saved!");
                }else{
                    out.println("Record NOT saved! There was an error");
                }
                 
             
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
 
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  request
     * @param response  response
     * @throws ServletException if -specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
 
    /**
     * Returns a short description of the .
     *
     * @return a String containing  description
     */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
