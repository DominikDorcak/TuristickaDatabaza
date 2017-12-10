
package paz1c.projekt.turistickaDatabaza.database;


import java.util.ArrayList;
import java.util.List;


public class Lokalita  {
    
    private String region;
    private String nazov;
    private long id;
    private String popis;

   
    /*private double suradnicaX;
    private double suradnicaY;*/
    
    /* public double getSuradnicaX() {
        return suradnicaX;
    }

    public void setSuradnicaX(double suradnicaX) {
        this.suradnicaX = suradnicaX;
    }

    public double getSuradnicaY() {
        return suradnicaY;
    }

    public void setSuradnicaY(double suradnicaY) {
        this.suradnicaY = suradnicaY;
    }*/
    
    private List<String> cestyKObrazkom = new ArrayList<>();
    private List<String> recenzie = new ArrayList<>();
    
    private boolean schvalena;

   
    public String getRegion() {
        return region;
    }

  
    public void setRegion(String region) {
        this.region = region;
    }

    
    public String getNazov() {
        return nazov;
    }

    
    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    
    public long getId() {
        return id;
    }

   
    public void setId(long id) {
        this.id = id;
    }

    
    public String getPopis() {
        return popis;
    }

    
    
    public void setPopis(String popis) {
        this.popis = popis;
    }

    
    
    public List<String> getCestyKObrazkom() {
        return cestyKObrazkom;
    }

    
    
    public void setCestyKObrazkom(List<String> cestyKObrazkom) {
        this.cestyKObrazkom = cestyKObrazkom;
    }

   
    public List<String> getRecenzie() {
        return recenzie;
    }

   
    public void setRecenzie(List<String> recenzie) {
        this.recenzie = recenzie;
    }

    
    public boolean isSchvalena() {
        return schvalena;
    }

  
    public void setSchvalena(boolean schvalena) {
        this.schvalena = schvalena;
    }
    
    
    
}
