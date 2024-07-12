
package br.com.curso.model;

import br.com.curso.enums.dao.Serie;

public class Aluno {
    //Atributos de Aluno
    private int idaluno;
    private String nomealuno;
    private Serie serie;
    private Escola escola;
    private String email;

    public Aluno() {
        this.idaluno = 0;
        this.nomealuno = "";
        this.serie = null;
        this.escola = new Escola();
        this.email = "";
    }

    public Aluno(int idaluno, String nomealuno, Serie serie, Escola escola, String email) {
        this.idaluno = idaluno;
        this.nomealuno = nomealuno;
        this.serie = serie;
        this.escola = escola;
        this.email = email;
    }

    public int getIdaluno() {
        return idaluno;
    }

    public void setIdaluno(int idaluno) {
        this.idaluno = idaluno;
    }

    public String getNomealuno() {
        return nomealuno;
    }

    public void setNomealuno(String nomealuno) {
        this.nomealuno = nomealuno;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
