package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {
    
    private static String DRIVE_MYSQL = "com.mysql.cj.jdbc.Driver";
    private static String ENDERECO = "jdbc:mysql://localhost:3306/pi";
    private static String USUARIO = "root";
    private static String PASSWORD = null;

    public static Connection getConexao() throws ClassNotFoundException, SQLException{
    Connection con;
    try {  
      Class.forName(DRIVE_MYSQL);
      con = DriverManager.getConnection(ENDERECO,USUARIO,PASSWORD);
    } catch (ClassNotFoundException | SQLException ex){
      throw new RuntimeException("erro ao se comunicar com o BD");
    }
        return con;
  }
  
    public static void Encerrarcon(Connection con){
      try {
          if (con != null){
              con.close();
          }
      } catch (SQLException ex) {
          throw new RuntimeException("erro ao encerrar comunicacao com o BD");
      }
  } 
    
    public static void Encerrarcon(Connection con, PreparedStatement stmt) {
        Encerrarcon(con);

        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao fechar uma conexao com o banco");
        }

    }

    public static void Encerrarcon(Connection con, PreparedStatement stmt, ResultSet rs) {
        Encerrarcon(con, stmt);

        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao fechar uma conexao com o banco");
        }

    }
}
