package org.example.jpamanytoone.Model;

import jakarta.persistence.*;


@Entity
@Table(name = "kommune")
public class Kommune {

    @Id
    private String kode;
    private String navn;
    private String href;

    //etablerer foreign key
    @ManyToOne
    @JoinColumn(name = "region", referencedColumnName = "kode")
    private Region region;

    protected Kommune() {}

    public Kommune(String kode, String navn, String href) {
        this.kode = kode;
        this.navn = navn;
        this.href = href;
    }

    public String getKode() {
        return kode;
    }

    public String getNavn() {
        return navn;
    }

    public String getHref() {
        return href;
    }

    public Region getRegion() {
        return region;
    }
}
