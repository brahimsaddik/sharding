package com.isidis.model;

import javax.persistence.*;


	@Entity
	@Table(name="transporter_pricing")
	public class TransporterPricing {

		   @Id
		    @SequenceGenerator(name="transporter_pricing_seq", sequenceName="transporter_pricing_sequence", allocationSize=1)
		    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="transporter_pricing_seq")
		    @Column(name = "id_transporter_pricing")
		    private Integer id;

	    @ManyToOne
	    @JoinColumn(name = "id_transporter", referencedColumnName = "id_transporter")
	    private Transporter transporter;

	    @ManyToOne
	    @JoinColumn(name = "id_range", referencedColumnName = "id_range")
	    private VehicleRange vehicleRange;

	    @ManyToOne
	    @JoinColumn(name = "id_type", referencedColumnName = "id_type")
	    private VehicleType vehicleType;

	    @ManyToOne
	    @JoinColumn(name = "id_price_type", referencedColumnName = "id_price_type")
	    private PriceType priceType;

	    @Column(name = "price")
	    private double price;

	    public TransporterPricing() {
		}

	    public TransporterPricing(Transporter transporter, VehicleRange vehicleRange, VehicleType vehicleType, PriceType priceType, double price) {
	        this.transporter = transporter;
	        this.vehicleRange = vehicleRange;
	        this.vehicleType = vehicleType;
	        this.priceType = priceType;
	        this.price = price;
	    }

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public Transporter getTransporter() {
	        return transporter;
	    }

	    public void setTransporter(Transporter carrier) {
	        this.transporter = carrier;
	    }

	    public VehicleRange getVehicleRange() {
	        return vehicleRange;
	    }

	    public void setVehicleRange(VehicleRange vehicleRange) {
	        this.vehicleRange = vehicleRange;
	    }

	    public VehicleType getVehicleType() {
	        return vehicleType;
	    }

	    public void setVehicleType(VehicleType vehicleType) {
	        this.vehicleType = vehicleType;
	    }

	    public PriceType getPriceType() {
	        return priceType;
	    }

	    public void setPriceType(PriceType priceType) {
	        this.priceType = priceType;
	    }

	    public double getPrice() {
	        return price;
	    }

	    public void setPrice(double price) {
	        this.price = price;
	    }

	    @Override
	    public String toString() {
	        return "TransporterPricing{" +
	                "id=" + id +
	                ", transporter=" + transporter +
	                ", vehicleRange=" + vehicleRange +
	                ", vehicleType=" + vehicleType +
	                ", priceType=" + priceType +
	                ", price=" + price +
	                '}';
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;

	        TransporterPricing that = (TransporterPricing) o;

	        if (Double.compare(that.price, price) != 0) return false;
	        if (id != null ? !id.equals(that.id) : that.id != null) return false;
	        if (transporter != null ? !transporter.equals(that.transporter) : that.transporter != null) return false;
	        if (vehicleRange != null ? !vehicleRange.equals(that.vehicleRange) : that.vehicleRange != null) return false;
	        if (vehicleType != null ? !vehicleType.equals(that.vehicleType) : that.vehicleType != null) return false;
	        return priceType != null ? priceType.equals(that.priceType) : that.priceType == null;
	    }

	    @Override
	    public int hashCode() {
	        int result;
	        long temp;
	        result = id != null ? id.hashCode() : 0;
	        result = 31 * result + (transporter != null ? transporter.hashCode() : 0);
	        result = 31 * result + (vehicleRange != null ? vehicleRange.hashCode() : 0);
	        result = 31 * result + (vehicleType != null ? vehicleType.hashCode() : 0);
	        result = 31 * result + (priceType != null ? priceType.hashCode() : 0);
	        temp = Double.doubleToLongBits(price);
	        result = 31 * result + (int) (temp ^ (temp >>> 32));
	        return result;
	    }
	}

