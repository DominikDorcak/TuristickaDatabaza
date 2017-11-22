
package paz1c.projekt.turistickaDatabaza;


import java.util.ArrayList;
import java.util.List;


public class LokalitaDao implements Lokalita {
    
    private String region;
    private String nazov;
    private long id;
    private String popis;
    
    private List<String> cestyKObrazkom = new ArrayList<>();
    private List<String> recenzie = new ArrayList<>();
    
    private boolean schvalena;

    @Override
    public String getRegion() {
        return region;
    }

    @Override
    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String getNazov() {
        return nazov;
    }

    @Override
    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getPopis() {
        return popis;
    }

    @Override
    public void setPopis(String popis) {
        this.popis = popis;
    }

    @Override
    public List<String> getCestyKObrazkom() {
        return cestyKObrazkom;
    }

    @Override
    public void setCestyKObrazkom(List<String> cestyKObrazkom) {
        this.cestyKObrazkom = cestyKObrazkom;
    }

    @Override
    public List<String> getRecenzie() {
        return recenzie;
    }

    @Override
    public void setRecenzie(List<String> recenzie) {
        this.recenzie = recenzie;
    }

    @Override
    public boolean isSchvalena() {
        return schvalena;
    }

    @Override
    public void setSchvalena(boolean schvalena) {
        this.schvalena = schvalena;
    }
    
    
    
}
