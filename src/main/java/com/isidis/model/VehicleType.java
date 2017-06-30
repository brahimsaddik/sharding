package com.isidis.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by BLONBOUT on 05/01/2017.
 */
@Entity
@Table(name = "vehicle_type")
public class VehicleType {
    @Id
    @SequenceGenerator(name="type_seq", sequenceName="type_sequence", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="type_seq")
    @Column(name = "id_type")
    Integer vehicleID;

    @Column(name = "libelle_type")
    String libelle;

    @Column(name = "nb_passenger")
    Integer nbPassenger;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "type_range", joinColumns = {
            @JoinColumn(name = "id_type") },
            inverseJoinColumns = { @JoinColumn(name = "id_range")})
    private Set<VehicleRange> typeRangeSet = new HashSet<VehicleRange>(0);

    public VehicleType() {
    }

    public VehicleType(String libelle, Integer nbPassenger, Set<VehicleRange> typeRangeSet) {
        this.libelle = libelle;
        this.nbPassenger = nbPassenger;
        this.typeRangeSet = typeRangeSet;
    }

    public Integer getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(Integer vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Set<VehicleRange> getTypeRangeSet() {
        return typeRangeSet;
    }

    public void setTypeRangeSet(Set<VehicleRange> typeRangeSet) {
        this.typeRangeSet = typeRangeSet;
    }

    public Integer getNbPassenger() {
        return nbPassenger;
    }

    public void setNbPassenger(Integer nbPassenger) {
        this.nbPassenger = nbPassenger;
    }

    @Override
    public String toString() {
        return "VehicleType{" +
                "vehicleID=" + vehicleID +
                ", libelle='" + libelle + '\'' +
                ", nbPassenger=" + nbPassenger +
                ", typeRangeSet=" + typeRangeSet +
                '}';
    }
}
