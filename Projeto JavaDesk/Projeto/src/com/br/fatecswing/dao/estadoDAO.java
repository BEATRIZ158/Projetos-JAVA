package com.br.fatecswing.dao;
import com.br.fatecswing.model.ModeloEstado;
import com.br.fatecswing.util.SingleConnection;

public class estadoDAO {
    
    public void inserir(ModeloEstado mod){
        try {
            SingleConnection conn = new SingleConnection();     
            conn.conectar();
            String sql = "insert into estado(nomeestado,siglaestado)"
                    + "values('"+mod.getNomeEstado()+"','"+mod.getSiglaEstado()+"')";
            conn.excutaSQL(sql);
           // conn.desconetaBanco();
        } catch (Exception ex) {
            System.out.println("Erro ao inserir um estado!Erro: "+ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    public void alterar(ModeloEstado mod){
        try {
            SingleConnection conn = new SingleConnection();     
            conn.conectar();
            String sql = "update estado set nomeestado = '"+mod.getNomeEstado()+"',siglaestado = '"+mod.getSiglaEstado()+"'where idestado="+mod.getCodigoEstado()+"";
            conn.excutaSQL(sql);
            //conn.desconetaBanco();
        } catch (Exception ex) {
            System.out.println("Erro ao alterar um estado!Erro: "+ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    public void deletar(ModeloEstado mod){
        try {
            SingleConnection conn = new SingleConnection();     
            conn.conectar();
            String sql = "delete from estado where idestado="+mod.getCodigoEstado()+"";
            conn.excutaSQL(sql);
           // conn.desconetaBanco();
        } catch (Exception ex) {
            System.out.println("Erro ao excluir um estado!Erro: "+ex.getMessage());
            ex.printStackTrace();
        }
    }
}
