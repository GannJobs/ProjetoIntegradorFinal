package Classes;

public class Traducao {
    
    private int Id;
    private String Eg;
    private static String Egg;
    private String Pt;
    private static String Ptt;
    
    public int getId(){
        return this.Id;
    }
    public String getEg(){
        return this.Eg;
    }
    public String getPt(){
        return this.Pt;
    }
    public String getEgg(){
        return this.Egg;
    }
    public String getPtt(){
        return this.Ptt;
    }
    
    public void setId(int id){
        this.Id = id;
    }
    public void setEg(String eg){
        this.Eg = eg;
    }
    public void setPt(String pt){
        this.Pt = pt;
    }
    public void setEgg(String egg){
        this.Egg = egg;
    }
    public void setPtt(String ptt){
        this.Ptt = ptt;
    }
}
