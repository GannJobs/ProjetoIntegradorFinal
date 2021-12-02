package DAO;

import Conexao.Conexao;
import Classes.Traducao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TraducaoDAO {
    
    public void Translate() throws ClassNotFoundException, SQLException{
        
        Connection con = Conexao.getConexao();
        
        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        
        String sql = "SELECT Pt FROM traducao WHERE Eg LIKE ?;";
        String trad = null;
        
            try{
                Traducao traducao = new Traducao();
                String eg = traducao.getEgg();
                
                stmt = con.prepareStatement(sql);
                stmt.setString(1, "%"+eg+"%");
                
                rs = stmt.executeQuery();
                
                if(rs.next()){
                    trad = rs.getString("Pt");
                }
                traducao.setPtt(trad);
            }catch (SQLException ex){
                throw new RuntimeException("Error " + ex);
            }  
    }
    
    public List<Traducao> consulta() throws ClassNotFoundException, SQLException{
       Connection con = Conexao.getConexao();
       PreparedStatement stmt = null;  
       ResultSet rs = null;
       String sql = "SELECT Eg,Pt FROM pi.traducao";
       List<Traducao> trad = new ArrayList<Traducao>();
       try{
           stmt = con.prepareStatement(sql);
           rs = stmt.executeQuery();  
           while(rs.next()){
               Traducao traducao =  new Traducao();         
               traducao.setEg(rs.getString("Eg"));
               traducao.setPt(rs.getString("Pt")); 
               trad.add(traducao);     
           }
       }catch (SQLException s){
           s.printStackTrace();
       }
        finally {
           Conexao.Encerrarcon(con, stmt);
        }
      return trad;      
   }
}
