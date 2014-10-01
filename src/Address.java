
public class Address {
	
	private String street;
	private String postalCode;
	private String city;
	
	public Address(String nStreet, String nPostalCode, String nCity) {
		
		this.street = nStreet;
		this.postalCode = nPostalCode;
		this.city = nCity;
	}
	
	public String getStreet() {
		return this.street;
	}
	
	public void setStreet(String nStreet) {
		this.street = nStreet;
	}
	
	public String getPostalCode() {
		return this.postalCode;
	}
	
	public void setPostalCode(String nPostalCode) {
		this.postalCode = nPostalCode;
	}
	
	public String getCity() {
		return this.city;
	}
	
	public void setCity(String nCity) {
		this.city = nCity;
	}
	
}
