
package br.com.curso.controller.aluno;

import br.com.curso.dao.AlunoDAO;
import br.com.curso.dao.GenericDAO;
import br.com.curso.enums.dao.Serie;
import br.com.curso.model.Aluno;
import br.com.curso.model.Escola;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AlunoCadastrar", urlPatterns = {"/AlunoCadastrar"})
public class AlunoCadastrar extends HttpServlet {

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

        String idAlunoStr = request.getParameter("idaluno");
        String nomeAluno = request.getParameter("nomealuno");
        String serieIdStr = request.getParameter("serie");
        String idEscolaStr = request.getParameter("idescola");
        String email = request.getParameter("emailaluno");
        String mensagem = null;

        try {
            int idAluno = Integer.parseInt(idAlunoStr);
            int serieId = Integer.parseInt(serieIdStr);
            int idEscola = Integer.parseInt(idEscolaStr);

            Serie serie = Serie.toEnum(serieId);
            //System.out.println("idAluno: " + idAluno);
            //System.out.println("nomeAluno: " + nomeAluno);
            //System.out.println("serieId: " + serieId);
            //System.out.println("Serie: " + serie);
            //System.out.println("idEscola: " + idEscola);
            //System.out.println("email: " + email);

            Aluno oAluno = new Aluno();
            oAluno.setIdaluno(idAluno);
            oAluno.setNomealuno(nomeAluno);
            oAluno.setSerie(serie);

            // Mensagem de depuração para garantir que a série está definida
            if (oAluno.getSerie() != null) {
                System.out.println("Aluno Serie ID: " + oAluno.getSerie().getId());
            } else {
                System.out.println("Aluno Serie is null");
            }

            Escola oEscola = new Escola();
            oEscola.setIdescola(idEscola);
            oAluno.setEscola(oEscola);
            oAluno.setEmail(email);

            GenericDAO dao = new AlunoDAO();
            if (dao.cadastrar(oAluno)) {
                mensagem = "Aluno cadastrado com sucesso!";
            } else {
                mensagem = "Problemas ao cadastrar Aluno. Verifique os dados informados e tente novamente!";
            }
            request.setAttribute("mensagem", mensagem);
            response.sendRedirect("AlunoListar");
        } catch (Exception ex) {
            System.out.println("Problemas no servlet ao cadastrar Aluno! Erro: " + ex.getMessage());
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
