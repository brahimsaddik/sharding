package com.isidis.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by BLONBOUT on 05/01/2017.
 */
@Entity
@Table(name = "vehicle_range")
public class VehicleRange {
    @Id
    @SequenceGenerator(name="range_seq", sequenceName="range_sequence", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="range_seq")
    @Column(name = "id_range")
    private Integer idVehicleRange;

    @Column(name = "libelle_range")
    private String libelle;

    @Column(name="comfort")
    private Integer comfort;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "typeRangeSet")
    private Set<VehicleType> rangeTypeSet= new HashSet<VehicleType>(0);

    public VehicleRange() {
    }

    public VehicleRange(String libelle, Integer comfort, Set<VehicleType> rangeTypeSet) {
        this.libelle = libelle;
        this.comfort = comfort;
        this.rangeTypeSet = rangeTypeSet;
    }

    public Integer getIdVehicleRange() {
        return idVehicleRange;
    }

    public void setIdVehicleRange(Integer idVehicleRange) {
        this.idVehicleRange = idVehicleRange;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Integer getComfort() {
        return comfort;
    }

    public void setComfort(Integer comfort) {
        this.comfort = comfort;
    }

    public Set<VehicleType> getRangeTypeSet() {
        return rangeTypeSet;
    }

    public void setRangeTypeSet(Set<VehicleType> rangeTypeSet) {
        this.rangeTypeSet = rangeTypeSet;
    }

    @Override
    public String toString() {
        return "VehicleRange{" +
                "idVehicleRange=" + idVehicleRange +
                ", libelle='" + libelle + '\'' +
                ", comfort=" + comfort +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VehicleRange that = (VehicleRange) o;

        if (idVehicleRange != null ? !idVehicleRange.equals(that.idVehicleRange) : that.idVehicleRange != null)
            return false;
        if (libelle != null ? !libelle.equals(that.libelle) : that.libelle != null) return false;
        if (comfort != null ? !comfort.equals(that.comfort) : that.comfort != null) return false;
        return rangeTypeSet != null ? rangeTypeSet.equals(that.rangeTypeSet) : that.rangeTypeSet == null;
    }

    @Override
    public int hashCode() {
        int result = idVehicleRange != null ? idVehicleRange.hashCode() : 0;
        result = 31 * result + (libelle != null ? libelle.hashCode() : 0);
        result = 31 * result + (comfort != null ? comfort.hashCode() : 0);
        result = 31 * result + (rangeTypeSet != null ? rangeTypeSet.hashCode() : 0);
        return result;
    }
}
