import javax.swing.SwingUtilities;
public class Main { //avvio swing
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() { //esegue metodo runnable in modo asincrono
			public void run() { //quando chiamato da invokeLater viene eseguito il metodo in thread separato
				Operatore operatore = new Operatore("operatore123", "password123");
				new Login(operatore); //creo oggetto login:finestra passando ogg op
			}
		});
	}
}