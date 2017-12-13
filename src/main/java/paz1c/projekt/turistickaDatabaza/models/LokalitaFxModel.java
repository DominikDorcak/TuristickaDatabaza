package paz1c.projekt.turistickaDatabaza.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;

/**
 *
 * @author Michal
 */
public class LokalitaFxModel {

    private StringProperty nazov = new SimpleStringProperty();
    private StringProperty region = new SimpleStringProperty();
    private LongProperty id = new SimpleLongProperty();
    private StringProperty popis = new SimpleStringProperty();

    public String getNazov() {
        return nazov.get();
    }

    public StringProperty nazovProperty() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov.set(nazov);
    }

    public String getRegion() {
        return region.get();
    }

    public StringProperty regionProperty() {
        return region;
    }

    public void setRegion(String region) {
        this.region.set(region);
    }

    public String getPopis() {
        return popis.get();
    }

    public StringProperty popisProperty() {
        return popis;
    }

    public void setPopis(String popis) {
        this.popis.set(popis);
    }

}
