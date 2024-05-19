package homework1;

public class Entry implements Comparable<Entry> {
    // implement the relevant data attributes
    private String name, address, city, postcode, country, phoneNumber;

    public Entry(String name, String address, String city, String postcode, String country, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCountry() {
        return country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public int compareTo(Entry other) {
        // implement the actual compareTo logic (remove next line)
        return this.name.compareTo(other.name);
    }
    @Override
    public String toString(){
        return  "\nName: " + this.name
                + "\nAddress: " + this.address
                + "\nCity: " + this.city
                + "\nPost Code: " + this.postcode
                + "\nCountry: " + this.country
                + "\nPhone Number: " + this.phoneNumber + "\n";
    }
}