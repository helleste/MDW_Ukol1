
public class Format2Container {

	private String what;
	private String when;
	private Address where;
	
	public Format2Container(String nWhat, String nWhen, Address nWhere) {
		
		this.what = nWhat;
		this.when = nWhen;
		this.where = nWhere;
	}
	
	public String getWhat() {
		return this.what;
	}
	
	public void setWhat(String nWhat) {
		this.what = nWhat;
	}
	
	public String getWhen() {
		return this.when;
	}
	
	public void setWhen(String nWhen) {
		this.when = nWhen;
	}
	
	public Address getWhere() {
		return this.where;
	}
	
	public void setWhere(Address nWhere) {
		this.where = nWhere;
	}
	
	@Override
	public String toString() {
		return "{\n" +
				"\t\"what\": \"" +
				this.what + "\",\n" +
				"\t\"when\": \"" +
				this.when + "\",\n" +
				"\t\"where\": {\n" +
				"\t\t\"street\": \"" +
				this.where.getStreet() + "\",\n" +
				"\t\t\"city\": \"" +
				this.where.getCity() + "\",\n" +
				"\t\t\"zip\": \"" +
				this.where.getPostalCode() + "\"\n" +
				"\t}\n" +
				"}";
				
	}
	
}
