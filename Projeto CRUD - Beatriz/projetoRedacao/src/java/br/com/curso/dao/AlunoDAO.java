/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.curso.dao;

import br.com.curso.dao.EscolaDAO;
import br.com.curso.enums.dao.Serie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import br.com.curso.utils.SingleConnection;
import br.com.curso.model.Aluno;
import br.com.curso.model.Escola;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlunoDAO implements GenericDAO {

    private Connection conexao;

    public AlunoDAO() throws Exception {
        conexao = SingleConnection.getConnection();
    }

    @Override
    public Boolean cadastrar(Object objeto) {
        Aluno oAluno = (Aluno) objeto;
        Boolean retorno = false;
        if (oAluno.getIdaluno() == 0) {
            retorno = this.inserir(oAluno);
        } else {
            retorno = this.alterar(oAluno);
        }
        return retorno;
    }

    @Override
    public Boolean inserir(Object objeto) {
        Aluno oAluno = (Aluno) objeto;
        PreparedStatement stmt = null;
        String sql = "insert into aluno(nomealuno, serie, idescola, emailaluno) values(?,?,?,?)";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oAluno.getNomealuno());
            stmt.setInt(2, oAluno.getSerie().getId());
            stmt.setInt(3, oAluno.getEscola().getIdescola());
            stmt.setString(4, oAluno.getEmail());
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao cadastrar Aluno! Erro: " + ex.getMessage());
                ex.printStackTrace();
                conexao.rollback();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Boolean alterar(Object objeto) {
        Aluno oAluno = (Aluno) objeto;
        PreparedStatement stmt = null;
        String sql = "update aluno set nomealuno=?, serie=?, idescola=?, emailaluno=? where idaluno=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oAluno.getNomealuno());
            stmt.setInt(2, oAluno.getSerie().getId());

            stmt.setInt(3, oAluno.getEscola().getIdescola());
            stmt.setString(4, oAluno.getEmail());
            stmt.setInt(5, oAluno.getIdaluno());
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao alterar Aluno! Erro: " + ex.getMessage());
                ex.printStackTrace();
                conexao.rollback();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Boolean excluir(int numero) {
        int idAluno = numero;
        PreparedStatement stmt = null;
        String sql = "delete from aluno where idaluno = ?";
        try {
            Aluno oAluno = (Aluno) this.carregar(idAluno);
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idAluno);
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao excluir Aluno! Erro: " + ex.getMessage());
            try {
                conexao.rollback();
            } catch (SQLException e) {
                System.out.println("Erro rollback " + e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Object carregar(int numero) {
        int idAluno = numero;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Aluno oAluno = null;
        String sql = "select * from aluno where idaluno=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idAluno);
            rs = stmt.executeQuery();
            while (rs.next()) {
                oAluno = new Aluno();
                oAluno.setIdaluno(rs.getInt("idaluno"));
                oAluno.setNomealuno(rs.getString("nomealuno"));
                //Recupera a descrição da séire e converte para o enum Série
                oAluno.setSerie(Serie.toEnum(rs.getInt("serie")));

                EscolaDAO oEscolaDAO = null;
                try {
                    oEscolaDAO = new EscolaDAO();
                } catch (Exception ex) {
                    System.out.println("Erro ao buscar Escola! Erro: " + ex.getMessage());
                    ex.printStackTrace();
                }
                oAluno.setEscola((Escola) oEscolaDAO.carregar(rs.getInt("idescola")));
                oAluno.setEmail(rs.getString("emailaluno"));
            }
            
            return oAluno;
        } catch (Exception ex) {
            System.out.println("Problemas ao carregar Aluno! Erro: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "Select * from aluno order by idaluno";
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Aluno oAluno = new Aluno();
                oAluno.setIdaluno(rs.getInt("idaluno"));
                oAluno.setNomealuno(rs.getString("nomealuno"));
                //Recupera a descrição da séire e converte para o enum Série
                oAluno.setSerie(Serie.toEnum(rs.getInt("serie")));

                EscolaDAO oEscolaDAO = null;
                try {
                    oEscolaDAO = new EscolaDAO();
                } catch (Exception ex) {
                    System.out.println("Erro ao buscar Escola! Erro: " + ex.getMessage());
                    ex.printStackTrace();
                }
                oAluno.setEscola((Escola) oEscolaDAO.carregar(rs.getInt("idescola")));
                oAluno.setEmail(rs.getString("emailaluno"));
                resultado.add(oAluno);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar alunos! Erro: " + ex.getMessage());
        }
        return resultado;
    }

}
