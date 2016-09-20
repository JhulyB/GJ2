package com.jhuly.wtcs.MODELO;

/**
 * Created by STI01 on 15/09/2016.
 */
public class Especialidade_Servico {

    int id_especialidade;
    int id_servico;
    String descricao;

    public int getId_especialidade() {
        return id_especialidade;
    }

    public void setId_especialidade(int id_especialidade) {
        this.id_especialidade = id_especialidade;
    }

    public int getId_servico() {
        return id_servico;
    }

    public void setId_servico(int id_servico) {
        this.id_servico = id_servico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
