
package br.com.curso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import br.com.curso.utils.SingleConnection;
import br.com.curso.model.Escola;

public class EscolaDAO implements GenericDAO{
    
    private Connection conexao;
    
    public EscolaDAO() throws Exception{
        conexao = SingleConnection.getConnection();
    }

    @Override
    public Boolean cadastrar(Object objeto) {
        Escola oEscola = (Escola) objeto;
        Boolean retorno = false;
        if(oEscola.getIdescola()==0){
            retorno = this.inserir(oEscola);
        }else{
            retorno = this.alterar(oEscola);
        }
        return retorno;
    }

    @Override
    public Boolean inserir(Object objeto) {
        Escola oEscola = (Escola) objeto;
        PreparedStatement stmt = null;
        String sql = "insert into escola(nomeescola, endereco, telefone) values(?,?,?)";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oEscola.getNomeescola());
            stmt.setString(2, oEscola.getEndereco());
            stmt.setString(3, oEscola.getTelefone());
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao cadastrar a Escola! Erro:"+ex.getMessage());
                ex.printStackTrace();
                conexao.rollback();
            } catch (SQLException e) {
                System.out.println("Erros: "+e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Boolean alterar(Object objeto) {
        Escola oEscola = (Escola) objeto;
        PreparedStatement stmt = null;
        String sql = "update escola set nomeescola=?, endereco=?, telefone=? where idescola=?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oEscola.getNomeescola());
            stmt.setString(2, oEscola.getEndereco());
            stmt.setString(3, oEscola.getTelefone());
            stmt.setInt(4, oEscola.getIdescola());
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            try {
                System.out.println("Problemas ao alterar a Escola! Erro: "+ex.getMessage());
                ex.printStackTrace();
                conexao.rollback();
            } catch (SQLException e) {
                System.out.println("Erro: "+e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Boolean excluir(int numero) {
        int idEscola = numero;
        PreparedStatement stmt = null;
        String sql = "delete from escola where idescola = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idEscola);
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao excluir a Escola! Erro: "+ex.getMessage());
            try {
                conexao.rollback();
            } catch (SQLException e) {
                System.out.println("Erro roolback "+e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Object carregar(int numero) {
        int idEscola = numero;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Escola oEscola = null;
        String sql = "select * from escola where idescola=?";
        
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idEscola);
            rs=stmt.executeQuery();
            while(rs.next()){
                oEscola = new Escola();
                oEscola.setIdescola(rs.getInt("idescola"));
                oEscola.setNomeescola(rs.getString("nomeescola"));
                oEscola.setEndereco(rs.getString("endereco"));
                oEscola.setTelefone(rs.getString("telefone"));
            }
            return oEscola;
        } catch (Exception ex) {
            System.out.println("Problemas ao carregar Escola! Erro: "+ex.getMessage());
            return false;
        }
    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from escola order by idescola";
        try {
            stmt = conexao.prepareStatement(sql);
            rs=stmt.executeQuery();
            while(rs.next()){
                Escola oEscola = new Escola();
                oEscola.setIdescola(rs.getInt("idescola"));
                oEscola.setNomeescola(rs.getString("nomeescola"));
                oEscola.setEndereco(rs.getString("endereco"));
                oEscola.setTelefone(rs.getString("telefone"));
                resultado.add(oEscola);
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar escolas! Erro: "+ex.getMessage());
            ex.printStackTrace();
        }
        return resultado;
    }
}
