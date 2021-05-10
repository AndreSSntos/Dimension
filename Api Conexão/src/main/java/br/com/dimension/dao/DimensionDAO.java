package br.com.dimension.dao;

import br.com.dimension.conexao.DimensionConexao;
import br.com.dimension.insercao.Insercao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DimensionDAO {

    public void inserirBD (Insercao insercao){
        String sql = "INSERT INTO registro(nomeComponente, data,dadosColetados) VALUES (?, ?, ?) ";
        Connection conn = null;
        PreparedStatement pstm = null;
        try{
            conn = DimensionConexao.createConnectionToSQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, insercao.getNomeComponente());
            pstm.setDate(2, new Date(insercao.getData().getTime()));
            pstm.setDouble(3, insercao.getDadosColetados());
            pstm.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try{
                if (pstm!=null){
                    pstm.close();
                }
                if (conn!=null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
