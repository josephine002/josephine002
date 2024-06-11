public class Operatore {
	private String id;
	private String password;

	public Operatore(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public boolean verificaLogin(String id, String password) {
		this.id=id;
		this.password=password;
		return this.id.equals(id) && this.password.equals(password);
	}
	
	@Override
	public String toString() {
		return "Operatore [id=" + id + ", password=" + password + "]";
	}
	
}
