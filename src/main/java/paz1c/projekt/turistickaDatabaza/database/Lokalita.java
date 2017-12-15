package paz1c.projekt.turistickaDatabaza.database;

import java.util.ArrayList;
import java.util.List;

public class Lokalita {

    private String region;
    private String nazov;
    private long id;
    private String popis;
    private double hodnotenie;

    public double getHodnotenie() {
        return hodnotenie;
    }

    public void setHodnotenie(double hodnotenie) {
        this.hodnotenie = hodnotenie;
    }
    

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
    private List<Long> obrazky = new ArrayList<>();
    private List<Recenzia> recenzie = new ArrayList<>();

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

    public List<Long> getObrazky() {
        return obrazky;
    }

    public void setObrazky(List<Long> obrazky) {
        this.obrazky = obrazky;
    }

    public List<Recenzia> getRecenzie() {
        return recenzie;
    }

    public void setRecenzie(List<Recenzia> recenzie) {
        this.recenzie = recenzie;
    }

    public boolean isSchvalena() {
        return schvalena;
    }

    public void setSchvalena(boolean schvalena) {
        this.schvalena = schvalena;
    }
    
    public void PriemerneHodnotenie(){
        List<Recenzia> rec = getRecenzie();
        if(rec.isEmpty())
            setHodnotenie(0.0);
        double priemer = 0d;
        for (Recenzia r: rec) {
            priemer += r.getHodnotenie();
        }
        
        setHodnotenie(priemer/rec.size());
    }

}
