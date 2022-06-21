/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacao;

import Infraestrutura.RepositorioPaciente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diego
 */
public class RecuperarPacienteNomeServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String busca = request.getParameter("busca");
            
            RepositorioPaciente r = new RepositorioPaciente();
                                 
            String res = "";
                        
            for(int i = 0; i < r.consultarNome(busca).size(); i++){
                 res += "<tr>" + r.consultarNome(busca).get(i).toString1() + "<tr>";
            
            }
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RecuperarPacienteNomeServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div id="+"\"tabela\"><table  border="+"\"1\" id="+"\"tabela\">");
            out.println("<tr><td>Nome</td>");
            out.println("<td>C.P.F.</td>");  
            out.println("<td>R.G.</td>"); 
            out.println("<td>Telefone</td>"); 
            out.println("" + res + "");
            out.println("</tr></table></div>");
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
