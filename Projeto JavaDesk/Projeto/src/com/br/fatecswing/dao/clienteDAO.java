
package com.br.fatecswing.dao;

import com.br.fatecswing.model.ModeloCliente;
import com.br.fatecswing.util.SingleConnection;

public class clienteDAO {
    public void InserirCliente(ModeloCliente mod){
        try {
            SingleConnection conn = new SingleConnection();     
            conn.conectar();
            int codigoCidade;
            String sql = "select idcidade from cidade where nomecidade ='"+mod.getNomecidade()+"'";
            conn.excutaSQL(sql);
            conn.resultset.first();
            codigoCidade = conn.resultset.getInt("idcidade");
            sql = "insert into cliente(nome,status,cidade)values("
                    + "'"+mod.getNome()+"','"+mod.getStatus()+"',"+codigoCidade+")";
            conn.excutaSQL(sql);
           // conn.desconetaBanco();
        } catch (Exception ex) {
            System.out.println("Erro ao inserir um Cliente! Erro: "+ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    public void alterarCliente(ModeloCliente mod){
        try {
            SingleConnection conn = new SingleConnection();
            conn.conectar();
            int codigoCidade;
            String sql = "select idcidade from cidade where nomecidade = '"+mod.getNomecidade()+"'";
            conn.excutaSQL(sql);
            conn.resultset.first();
            codigoCidade = conn.resultset.getInt("idcidade");
            sql = "update cliente set nome = '"+mod.getNome()+"', status='"+mod.getStatus()+"', cidade="+codigoCidade+" where idcliente = "+mod.getCodigocliente()+"";
            conn.excutaSQL(sql);
        } catch (Exception ex) {
            System.out.println("Erro ao inserir um Cliente! Erro:"+ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    public void excluirCliente(ModeloCliente mod){
        try {
            SingleConnection conn = new SingleConnection();
            conn.conectar();
            String sql = "delete from cliente where idcliente = "+mod.getCodigocliente()+"";
            conn.excutaSQL(sql);
            //conn.desconetaBanco();
        } catch (Exception ex) {
            System.out.println("Erro ao excluir um Cliente! Erro: "+ex.getMessage());
            ex.printStackTrace();
        }
    }
}
