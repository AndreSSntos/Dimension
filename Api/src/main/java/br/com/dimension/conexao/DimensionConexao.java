package br.com.dimension.conexao;
import java.sql.*;

public class DimensionConexao {
        private static final String url = "jdbc:sqlserver://dimensionandre.database.windows.net:1433;database=bdDimension;user=Dimension@dimensionandre;password={your_password_here};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
        private static final String username = "Dimension";
        private static final String password = "#Gf23084757810";
        public static Connection createConnectionToSQL() throws Exception {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Conectado ao Banco de dados");

            return connection;

    }

    public static void main(String[] args) throws Exception {
        Connection con= createConnectionToSQL();

        if (con!=null){
            System.out.println("Conectado com sucesso");
            con.close();
        }
    }
}
