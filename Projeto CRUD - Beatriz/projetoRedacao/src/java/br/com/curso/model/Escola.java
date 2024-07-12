
package br.com.curso.model;

public class Escola {
    //Atributos de Escola
    private int idescola;
    private String nomeescola;
    private String endereco;
    private String telefone;

    public Escola() {
        this.idescola = 0;
        this.nomeescola = "";
        this.endereco = "";
        this.telefone = "";
    }
    
    public Escola(int idescola, String nomeescola, String endereco, String telefone) {
        this.idescola = idescola;
        this.nomeescola = nomeescola;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public int getIdescola() {
        return idescola;
    }

    public void setIdescola(int idescola) {
        this.idescola = idescola;
    }

    public String getNomeescola() {
        return nomeescola;
    }

    public void setNomeescola(String nomeescola) {
        this.nomeescola = nomeescola;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
}
