package com.isidis.model;

import javax.persistence.*;


@Entity
@Table(name="price_type")
public class PriceType {

    @Id
    @SequenceGenerator(name="price_type_seq", sequenceName="price_type_sequence", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="price_type_seq")
    @Column(name = "id_price_type")
    private Integer id;

    @Column(name = "libelle")
    private String libelle;

    public PriceType() {
    }

    public PriceType(String libelle) {
        this.libelle = libelle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PriceType priceType = (PriceType) o;

        if (id != null ? !id.equals(priceType.id) : priceType.id != null) return false;
        return libelle != null ? libelle.equals(priceType.libelle) : priceType.libelle == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (libelle != null ? libelle.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PriceType{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
