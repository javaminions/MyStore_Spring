package pojo;

public class UserProfile {
	
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String cartProducts;
	private String email;
	
	public UserProfile(String username, String password, String firstName, String lastName, String email ) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	public String getCartProducts() {
		return cartProducts;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setCartProducts(String cartProducts) {
		this.cartProducts = cartProducts;
	}
}
