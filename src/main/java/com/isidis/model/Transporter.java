package com.isidis.model;

import javax.persistence.*;


@Entity
@javax.persistence.Table(name = "transporter")
public class Transporter {

    
	 @SequenceGenerator(name="Car_Gen", sequenceName="transporter_sequence")
	    @Id @GeneratedValue(generator="Car_Gen")
	    @Column(name = "id_transporter")
    private int id;

    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "zip_code")
    private String zip_code;
    @Basic
    @Column(name = "mail")
    private String mail;
    @Basic
    @Column(name = "phone")
    private String phone;


    public Transporter(int id, String name, String address, String zip_code, String email, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.zip_code = zip_code;
        this.mail = email;
        this.phone = phone;
    }

    public Transporter() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getZip_code() {
        return zip_code;
    }

    public String getMail() {
        return mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Transporter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", zip_code='" + zip_code + '\'' +
                ", mail='" + mail + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transporter transporter = (Transporter) o;

        if (id != transporter.id) return false;
        if (name != null ? !name.equals(transporter.name) : transporter.name != null) return false;
        if (address != null ? !address.equals(transporter.address) : transporter.address != null) return false;
        if (zip_code != null ? !zip_code.equals(transporter.zip_code) : transporter.zip_code != null) return false;
        if (mail != null ? !mail.equals(transporter.mail) : transporter.mail != null) return false;
        return phone != null ? phone.equals(transporter.phone) : transporter.phone == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (zip_code != null ? zip_code.hashCode() : 0);
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }

}