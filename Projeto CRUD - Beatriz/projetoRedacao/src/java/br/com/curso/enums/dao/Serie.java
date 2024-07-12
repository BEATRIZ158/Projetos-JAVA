
package br.com.curso.enums.dao;

import java.util.Arrays;
import java.util.List;

public enum Serie {
    //Campos de uma enum constantes, seus nome são em maiúsculas
    PRIMEIRA(1, "Primeira Série"),
    SEGUNDA(2,"Segunda Série"),
    TERCEIRA(3,"Terceira Série");
    
    private int id;
    // Campo para armazenar a descrição
    private String descricao;
    
    Serie(int id, String descricao){
        this.id = id;
        this.descricao = descricao;
    }
    
    public int getId(){
        return id;
    }
    
    //Método para obter a descrição
    public String getDescricao(){
        return descricao;
    }
    
    public static Serie toEnum(Integer id){
        if(id==null) return null;
        for(Serie s : Serie.values()){
            if(id.equals(s.getId())){
                return s;
            }
        }
        throw new IllegalArgumentException("Série inválida");
    }
    
    // Método utilitário para obter a instância da enum a partir da descrição
    public static Serie fromDescricao(String descricao) {
        for (Serie s : Serie.values()) {
            if (s.getDescricao().equals(descricao)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Descrição da série inválida: " + descricao);
    }
    
    // Método estático para retornar todas as séries como uma lista
    public static List<Serie> getAllSeries() {
        return Arrays.asList(Serie.values());
    }
}
