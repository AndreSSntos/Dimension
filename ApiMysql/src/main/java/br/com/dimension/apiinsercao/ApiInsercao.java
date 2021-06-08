package br.com.dimension.apiinsercao;
import br.com.dimension.dao.DimensionDAO;
import br.com.dimension.insercao.Insercao;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import java.util.Date;
import java.util.List;

public class ApiInsercao {

    public  void memoria(){
        Insercao insercao = new Insercao();
        Looca looca= new Looca();
        insercao.setNomeComponente("Memoria RAM");
        insercao.setDadosColetados(Double.valueOf(looca.getMemoria().getEmUso()));
        insercao.setData(new Date());
        DimensionDAO dimensionDAO = new DimensionDAO();
        dimensionDAO.inserirBD(insercao);
        dimensionDAO.inserirMysqlBD(insercao);
    }
    public  void processador(){
        Insercao insercao = new Insercao();
        Looca looca= new Looca();
        insercao.setNomeComponente("Processador");
        insercao.setDadosColetados(Double.valueOf(looca.getProcessador().getUso()));
        insercao.setData(new Date());
        DimensionDAO dimensionDAO = new DimensionDAO();
        dimensionDAO.inserirBD(insercao);
        dimensionDAO.inserirMysqlBD(insercao);
    }
    public void sistema(){
        Insercao insercao = new Insercao();
        Looca looca= new Looca();
        insercao.setNomeComponente("SO");
        insercao.setDadosColetados(Double.valueOf(looca.getSistema().getTempoDeAtividade()));
        insercao.setData(new Date());
        DimensionDAO dimensionDAO = new DimensionDAO();
        dimensionDAO.inserirBD(insercao);
        dimensionDAO.inserirMysqlBD(insercao);
    }
    public void processos(){
        Insercao insercao = new Insercao();
        Looca looca= new Looca();
        DimensionDAO dimensionDAO = new DimensionDAO();
        ProcessosGroup grupoDeProcessos = looca.getGrupoDeProcessos();
        List<Processo> processos = grupoDeProcessos.getProcessos();
        for (Processo processo: processos){
            if (processo.getUsoMemoria()>1 || processo.getUsoCpu()>1){
                insercao.setDadosColetados(Double.valueOf(processo.getUsoCpu()));
                insercao.setNomeComponente(String.valueOf(processo.getNome()));
                insercao.setData(new Date());
                dimensionDAO.inserirBD(insercao);
                dimensionDAO.inserirMysqlBD(insercao);

                insercao.setDadosColetados(Double.valueOf(processo.getUsoMemoria()));
                insercao.setNomeComponente(String.valueOf(processo.getNome()));
                insercao.setData(new Date());
                dimensionDAO.inserirBD(insercao);
                dimensionDAO.inserirMysqlBD(insercao);
            }
            else{ }

    }}

}
