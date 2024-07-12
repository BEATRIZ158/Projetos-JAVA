
package br.com.curso.controller.aluno;

import br.com.curso.dao.EscolaDAO;
import br.com.curso.enums.dao.Serie;
import br.com.curso.model.Aluno;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AlunoNovo", urlPatterns = {"/AlunoNovo"})
public class AlunoNovo extends HttpServlet {

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
        //Cria objeto de Cidade vazio e seta o id como zero
        Aluno oAluno = new Aluno();
        request.setAttribute("series", Serie.values());
        //cria variavel no servidor para armazenar objeto de aluno
        request.setAttribute("aluno", oAluno);
        //busca uma lista de estados para alimentar a caixa de seleção na
        try {
            EscolaDAO oEscolaDAO = new EscolaDAO();
            //cria variavel no servidor para armazenar objeto de aluno
            request.setAttribute("escolas", oEscolaDAO.listar());
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("mensagem", "Erro ao listar escolas: " + e.getMessage());
        }
        //dispacha os objetos de aluno e a listar de estados para a pagina
        request.getRequestDispatcher("/cadastros/aluno/alunoCadastrar.jsp").forward(request, response);
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
