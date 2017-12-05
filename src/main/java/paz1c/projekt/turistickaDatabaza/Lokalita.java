package paz1c.projekt.turistickaDatabaza;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author Michal
 */
public class Lokalita {

    //rátam s tym že tu ešte pridame dalšie veci
    private Long id;
    private String nazov;
    private String popis;
    private String poloha; //GPS suradnice - v UI moze byt odkaz na Gmaps so suradnicami
    private String autor;
    private LocalDateTime datumPridania;

    public Long getId() {
        return id;
    }

    public String getNazov() {
        return nazov;
    }

    public String getPopis() {
        return popis;
    }

    public String getPoloha() {
        return poloha;
    }

    public String getAutor() {
        return autor;
    }
    public LocalDateTime getDatumPridania() {
        return datumPridania;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }

    public void setPoloha(String poloha) {
        this.poloha = poloha;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    public void setDatumPridania(LocalDateTime datumPridania) {
        this.datumPridania = datumPridania;
        
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Lokalita other = (Lokalita) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nazov, other.nazov)) {
            return false;
        }
        if (!Objects.equals(this.autor, other.autor)) {
            return false;
        }

        if (!Objects.equals(this.popis, other.popis)) {
            return false;
        }
        if (!Objects.equals(this.poloha, other.poloha)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.nazov);
        hash = 89 * hash + Objects.hashCode(this.popis);
        hash = 89 * hash + Objects.hashCode(this.poloha);
        hash = 89 * hash + Objects.hashCode(this.autor);
        hash = 89 * hash + Objects.hashCode(this.datumPridania);
        return hash;
    }
}
