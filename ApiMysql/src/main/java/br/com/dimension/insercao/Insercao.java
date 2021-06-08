package br.com.dimension.insercao;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Insercao {
    private  int idRegistro;
    private Date data;
    private Double dadosColetados;
    private String nomeComponente;
    
    SimpleDateFormat formatoDH = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public String getNomeComponente() {
        return nomeComponente;
    }

    public void setNomeComponente(String nomeComponente) {
        this.nomeComponente = nomeComponente;
    }

    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public String getData() {
        return formatoDH.format(data);
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getDadosColetados() {
        return dadosColetados;
    }

    public void setDadosColetados(Double dadosColetados) {
        this.dadosColetados = dadosColetados;
    }



}
