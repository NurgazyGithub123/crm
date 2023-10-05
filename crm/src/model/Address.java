package model;

public final class Address extends BaseEntity{

    private String country;
    private String city;
    private String region;
    private String district;
    private String apartment;

    public Address() {
    }

    public Address(Long id, String country, String city, String region, String district, String apartment) {
        super(id);
        this.country = country;
        this.city = city;
        this.region = region;
        this.district = district;
        this.apartment = apartment;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", district='" + district + '\'' +
                ", apartment='" + apartment + '\'' +
                ", id=" + id +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
