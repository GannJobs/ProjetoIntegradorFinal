package Classes;

import DAO.TraducaoDAO;
import Classes.Traducao;
import java.lang.RuntimeException;
import java.util.ArrayList;
import java.util.List;

public class traducaoBO {
    
    public void Translate() throws Exception{  
    TraducaoDAO dao = new TraducaoDAO(); 
    try{
        
        dao.Translate();
   
    }catch(Exception ex){
           /*throw new RuntimeException("Erro ao traduzir" + ex);*/
          throw ex;
    }
   } 
    
    public List<Traducao> consulta(){
       TraducaoDAO dao = new TraducaoDAO();     
       List<Traducao> traducoes = new ArrayList<Traducao>();       
       try{       
           traducoes =  dao.consulta(); 
        }catch(Exception e){
            throw new RuntimeException("Erro ao recuperar no banco de dados");
        }
       return traducoes;       
    }
}
