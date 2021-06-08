package br.com.dimension.conexao;
import java.sql.*;

public class DimensionConexao {
        private static final String url = "jdbc:sqlserver://dimension.database.windows.net:1433;database=Dimension;user=dimension@dimension;password={your_password_here};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
        private static final String username = "dimension";
        private static final String password = "#Gfgrupo10";
        
        public static Connection createConnectionToSQL() throws Exception {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Conectado ao Banco de dados Azure");

            return connection;
    }
        //private static final String urlmsql = "jdbc:mysql://localhost:3306/dimensionBD?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC?autoReconnect=true&useSSL=false";
        /*private static final String urlmsql = "jdbc:mysql://127.0.0.1:3306/dimensionBD";
        private static final String usernamemsql= "root";
        private static final String passwordmsql = "urubu100";
        
        public static Connection createConnectionToMySQL() throws Exception {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection connection = DriverManager.getConnection(urlmsql, usernamemsql, passwordmsql);
            System.out.println("Conectado ao Banco de dados");

            return connection;
        }*/
        
        //Connection con;
        public static Connection createConnectionToMySQL() throws Exception {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver"); 
                String url = "jdbc:mysql://172.17.0.1:3306/dimensionBD";
                Connection con = DriverManager.getConnection(url, "root", "urubu100");
                System.out.println("Conectado ao Banco de dados MySQL");
                return con;
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println(e);
            }      
            return null;
        }
        

    public static void main(String[] args) throws Exception {
        Connection con = createConnectionToSQL();
        
        DimensionConexao conn = new DimensionConexao();
        Connection connection = conn.createConnectionToMySQL();

        if (con!=null){
            System.out.println("Conectado com sucesso ao Azure");
            con.close();
        }
        
        if (connection!=null){
            System.out.println("Conectado com sucesso ao MySQL");
            con.close();
        }
        
        /*if (mysql!=null){
            System.out.println("Conectado com sucesso ao MySQL");
            mysql.close();
        }     */   
        
    }
}
