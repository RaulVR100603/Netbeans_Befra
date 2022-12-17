/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 *
 * @author HP
 */
@WebServlet(name = "eliminarusuarios", urlPatterns = {"/eliminarusuarios"})
public class eliminarusuarios extends HttpServlet {

    Connection conexion;
    public void init()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conexion=DriverManager.getConnection("jdbc:mysql://localhost/befra","root","");
        }
        catch(ClassNotFoundException man)
        {
            System.out.println("no se encontro un manejador");
        }
        catch(SQLException base)
        {
            System.out.println("No hay conexion");
        }
    }
    
    public String borrar (String eliminarusuario)
    {
        String html="";
        try
        {
        Statement a=conexion.createStatement();
        int fila=a.executeUpdate(eliminarusuario);
        return html+=fila+"USUARIO ELIMINADO";
        
        }
        catch(SQLException base)
        {
            return base. getMessage();
        }
    } 
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            
             String clave=request.getParameter("clave");
            String eliminarusuario="delete from datos where clave="+clave;
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet eliminarusuarios</title>");            
            out.println("</head>");
            out.println("<body bgcolor='blue' text='yellow'>");
            
             out.println("<form action='menu'>");
            out.println("<input type='submit' value='REGRESAR A MENU PRINCIPAL'>");
            out.println(""+borrar(eliminarusuario));
            
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
