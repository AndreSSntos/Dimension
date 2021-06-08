package br.com.dimension.dao;

import br.com.dimension.conexao.DimensionConexao;
import br.com.dimension.insercao.Insercao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;


public class DimensionDAO {

    public void inserirBD (Insercao insercao){
        String sql = "INSERT INTO registro(nomeComponente, data, dadosColetados) VALUES (?, ?, ?) ";
        Connection conn = null;
        PreparedStatement pstm = null;
        try{
            conn = DimensionConexao.createConnectionToSQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, insercao.getNomeComponente());
            pstm.setString(2, insercao.getData());
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
    
    public void inserirMysqlBD (Insercao insercao){
        String sql = "INSERT INTO registro(nomeComponente, data, dadosColetados) VALUES (?, ?, ?) ";
        Connection mysql = null;
        PreparedStatement psmysql = null;
        try{
            
            mysql = DimensionConexao.createConnectionToMySQL();
            psmysql = (PreparedStatement) mysql.prepareStatement(sql);
            psmysql.setString(1, insercao.getNomeComponente());
            psmysql.setString(2, insercao.getData());
            psmysql.setDouble(3, insercao.getDadosColetados());
            psmysql.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try{
                if (psmysql!=null){
                    psmysql.close();
                }               
                if (mysql!=null){
                    mysql.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
