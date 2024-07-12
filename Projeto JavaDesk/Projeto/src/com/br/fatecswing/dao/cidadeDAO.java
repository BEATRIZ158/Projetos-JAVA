
package com.br.fatecswing.dao;

import com.br.fatecswing.model.ModeloCidade;
import com.br.fatecswing.util.SingleConnection;

public class cidadeDAO {
    public void InserirCidade(ModeloCidade mod){
        try {
            SingleConnection conn = new SingleConnection();     
            conn.conectar();
            int codigoEstado;
            String sql = "select idestado from estado where siglaestado ='"+mod.getSigla()+"'";
            conn.excutaSQL(sql);
            conn.resultset.first();
            codigoEstado = conn.resultset.getInt("idestado");
            sql = "insert into cidade(nomecidade,situacao,idestado)values("
                    + "'"+mod.getNome()+"','"+mod.getSituacao()+"',"+codigoEstado+")";
            conn.excutaSQL(sql);
           // conn.desconetaBanco();
        } catch (Exception ex) {
            System.out.println("Erro ao inserir uma cidade!Erro: "+ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    //Alterar cidade OK
    public void alterarCidade(ModeloCidade mod){
        try {
            SingleConnection conn = new SingleConnection();
            conn.conectar();
            int idestado;
            conn.excutaSQL("select idestado from estado where siglaestado = '"+mod.getSigla()+"'");
            conn.resultset.first();
            idestado = conn.resultset.getInt("idestado");
            String sql = "update cidade set nomecidade = '"+mod.getNome()+"', situacao='"+mod.getSituacao()+"', idestado="+idestado+" where idcidade = "+mod.getCodigo()+"";
            conn.excutaSQL(sql);
            //conn.desconetaBanco();
        } catch (Exception ex) {
            System.out.println("Erro ao inserir uma cidade!Erro:"+ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    //Excluir cidade OK
    public void ExcluirCidade(ModeloCidade mod){
        try {
            SingleConnection conn = new SingleConnection();
            conn.conectar();
            String sql = "delete from cidade where idcidade = "+mod.getCodigo()+"";
            conn.excutaSQL(sql);
            //conn.desconetaBanco();
        } catch (Exception ex) {
            System.out.println("Erro ao excluir uma cidade! Erro: "+ex.getMessage());
            ex.printStackTrace();
        }
    }   
}
