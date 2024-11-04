package com.example.StudySpringBoot.entity;

import java.util.Objects;
import jakarta.persistence.*;

@Embeddable
public class Address {
	@Column(length = 10)
	private String city;
	@Column(length = 20)
	private String street;
	@Column(length = 5)
	private String zipcode;
	

	public String fullAddress() {
		return getCity() + " " + getStreet() + " " + getZipcode();
	}
	
	/* setter는 private으로 */
	public String getCity() {
		return city;
	}
	private void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	private void setStreet(String street) {
		this.street = street;
	}
	public String getZipcode() {
		return zipcode;
	}
	private void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	/* equals and hashcode >>> JPA에서는 항상 프록시에 대비해서 코드를 작성해야 한다. */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(getCity(), address.getCity()) &&
                Objects.equals(getStreet(), address.getStreet()) &&
                Objects.equals(getZipcode(), address.getZipcode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getStreet(), getZipcode());
    }
	
	
	
	
}
