package br.com.dimension.aplicacao;

import br.com.dimension.apiinsercao.ApiInsercao;
import java.util.Timer;
import java.util.TimerTask;

public class Dimension {
    public static void main(String[] args) {
        ApiInsercao apiInsercao = new ApiInsercao();
        Timer timer = new Timer();
        final long intervalo = (1000*5);
        
        TimerTask tarefa = new TimerTask() {
            @Override
            public void run() {
                apiInsercao.memoria();
                apiInsercao.processador();
                apiInsercao.processos();
                apiInsercao.sistema();
//                System.exit(0); //To change body of generated methods, choose Tools | Templates.
            }
        };
        timer.scheduleAtFixedRate(tarefa, 0,intervalo);
        
    }}