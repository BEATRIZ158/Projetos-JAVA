
package br.com.curso.controller.aluno;

import br.com.curso.dao.AlunoDAO;
import br.com.curso.dao.EscolaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AlunoCarregar", urlPatterns = {"/AlunoCarregar"})
public class AlunoCarregar extends HttpServlet {

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
        try {
            int idAluno = Integer.parseInt(request.getParameter("idaluno"));
            //Cria objeto de AlunoDAO - camada dao
            AlunoDAO oAlunoDAO = new AlunoDAO();
            //cria variavel no servidor para armazenar objeto de Aluno com os dados carregados
            request.setAttribute("aluno", oAlunoDAO.carregar(idAluno));
            //busca uma lista de escolas para alimentar a caixa de seleção na view (jsp)
            EscolaDAO oEscolaDAO = new EscolaDAO();
            request.setAttribute("escolas", oEscolaDAO.listar());
            //dispacha os objetos de aluno e a lista de escolas para a página jsp
            request.getRequestDispatcher("/cadastros/aluno/alunoCadastrar.jsp").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Erro ao carregar Aluno! Erro: "+ex.getMessage());
            ex.printStackTrace();
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
