
package paz1c.projekt.turistickaDatabaza;

import java.util.List;


public interface Lokalita {

    List<String> getCestyKObrazkom();

    long getId();

    String getNazov();

    String getPopis();

    List<String> getRecenzie();

    String getRegion();

    boolean isSchvalena();

    void setCestyKObrazkom(List<String> cestyKObrazkom);

    void setId(long id);

    void setNazov(String nazov);

    void setPopis(String popis);

    void setRecenzie(List<String> recenzie);

    void setRegion(String region);

    void setSchvalena(boolean schvalena);
    
}
