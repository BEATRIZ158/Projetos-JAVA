
package br.com.curso.controller.escola;

import br.com.curso.dao.EscolaDAO;
import br.com.curso.dao.GenericDAO;
import br.com.curso.model.Escola;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EscolaCadastrar", urlPatterns = {"/EscolaCadastrar"})
public class EscolaCadastrar extends HttpServlet {

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
        response.setContentType("text/html;charset=iso-8859-1");
        int idEscola = Integer.parseInt(request.getParameter("idescola"));
        String nomeEscola = request.getParameter("nomeescola");
        String endereco = request.getParameter("endereco");
        String telefone = request.getParameter("telefone");
        String mensagem = null;
        
        try {
            Escola oEscola = new Escola();
            oEscola.setIdescola(idEscola);
            oEscola.setNomeescola(nomeEscola);
            oEscola.setEndereco(endereco);
            oEscola.setTelefone(telefone);

            GenericDAO dao = new EscolaDAO();
            if(dao.cadastrar(oEscola)){
                mensagem = "Escola cadastrada com sucesso!";
            }else{
                mensagem = "Problemas ao cadastrar Escola. Verifique os dados informados e tente novamente!";
            }
            request.setAttribute("mensagem", mensagem);
            response.sendRedirect("EscolaListar");
        } catch (Exception ex) {
            System.out.println("Problemas no servlet ao cadastrar estado! Erro: "+ex.getMessage());
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
