import java.util.Calendar;
public class Attendimento {
	
	//proprieta
	private String coloreUrgenza;
	private String data;
	private Paziente paziente;
	private Operatore operatore;
	
	//costruttore
	public Attendimento(String orarioArrivo, String coloreUrgenza, String data, Paziente paziente,Operatore operatore) {
		super();
		this.coloreUrgenza = coloreUrgenza;
		this.data = data;
		this.paziente = paziente;
		this.operatore = operatore;
	}

	public static String getOrarioArrivo() {
		Calendar orario = Calendar.getInstance(); //recupera data e orario pc
		int oraCorrente = orario.get(Calendar.HOUR_OF_DAY); //ottiene ora corrente 24 ore
		int minutiCorrenti = orario.get(Calendar.MINUTE); //ottiene i minuti correnti
		String orarioArrivo = String.format("%02d:%02d", oraCorrente, minutiCorrenti); //formatta ora e minuti correnti in stringa HH:mm
		return orarioArrivo;
	}

	@Override
	public String toString() {
		return paziente+ "Data di nascita= " + data + " [orarioArrivo= " + getOrarioArrivo() + ", coloreUrgenza= " + coloreUrgenza + ", operatore= " + operatore + "]\n";
	}
}
