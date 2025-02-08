package org.example.jpamanytoone.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "region")
public class Region {

    @Id
    @Column(length = 4)
    private String kode;
    private String navn;
    private String href;

    protected Region() {}

    public Region(String kode, String navn, String href) {
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

    @OneToMany (mappedBy = "region")
    @JsonBackReference
    private Set<Kommune> kommuner= new HashSet<>();

}
