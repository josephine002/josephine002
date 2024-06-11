import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.*;

public class Login extends JFrame {
	private ArrayList<Attendimento> listaAttendimenti;
	URL url =Login.class.getResource("icona/istockphoto-877759952-612x612.jpg");
	ImageIcon icona = new ImageIcon(url);

	public Login(Operatore operatore) {
		super("Login Operatore");
		setIconImage(icona.getImage());
		this.listaAttendimenti= new ArrayList<>();

		//creo i campi per il login
		JLabel lblId = new JLabel("ID Operatore: ");
		JLabel lblPsw = new JLabel("Password: ");
		JTextField idCampo = new JTextField(20);
		JPasswordField passwordCampo = new JPasswordField(20);
		JButton loginButton = new JButton("Login");

		loginButton.setPreferredSize(new Dimension(100, 30));//dimensioni pulsante(larghezza,altezza)
		loginButton.setBackground(new Color(0, 128, 255));//colore sfondo pulsante, colore è un oggetto Color.
		loginButton.setForeground(Color.WHITE);//colore testo pulsante
		//quando premo login:
		loginButton.addActionListener(new ActionListener() {//appena premo
			public void actionPerformed(ActionEvent e) {
				dispose(); //chiude fnestra
				apriFinestraPaziente(); //apre finestra
			}
		});
		JPanel panel = new JPanel(new GridLayout(5,2,10,10)); //creo pannello con griglia in celle con numero specifico righe e colonne(3 righe e 2 colonne. Gli altri 2 numeri sono i margini oriz e vert
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); //bordo vuoto con margine 20 pixel
		panel.add(lblId); //aggiunge i bottoni col testo
		panel.add(idCampo);
		panel.add(lblPsw);
		panel.add(passwordCampo);
		panel.add(loginButton);
		//configurazione JFrame
		add(panel); //aggiunge pannello a finestra
		pack(); //ridimensiona in automatico
		setLocationRelativeTo(null); // Centra all'avvio
		setResizable(true); //boolean ridimensionamento finestra
		setVisible(true); //boolean visibilità finestra
	}

	private void apriFinestraPaziente() {
		//creo nuova finestra per inserimento dati paziente
		JFrame framePaziente = new JFrame("Inserimento dati paziente"); //titolo finestra
		//imposto un icona per la finestra
		framePaziente.setIconImage(icona.getImage());

		framePaziente.setSize(400, 300);//dimensioni finestra(larghezza,altezza)
		framePaziente.setLocationRelativeTo(null);//posizione finestra in centro

		JPanel panel = new JPanel(); //creo nuovo pannello con componenti uno dopo l'altro in ordine di aggiunta 
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); //bordo vuoto con margini

		JPanel inputPanel = new JPanel();//creo pannello per elemnti input
		inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		JTextField nomeCampo = new JTextField(10);//campo testo larghezza 10 caratteri
		JTextField orarioArrivoCampo = new JTextField(5); 
		JComboBox<Character> sessoBox = new JComboBox<>(new Character[] {'M', 'F'}); //casella a discesa per selezionare sesso
		JComboBox<String> coloreUrgenzaBox = new JComboBox<>(new String[]{"Rosso", "Bianco", "Azzurro","Arancione", "Giallo"});
		coloreUrgenzaBox.setRenderer(new MyComboBoxRenderer()); //uso renderizzatore personalizzato MyComboBoxRenderer per vedere opzioni colori

		//creo 3 caselle a discesa per selezionare la data di nascita
		JComboBox<Integer> giornoBox = new JComboBox<>(getGiorni());
		JComboBox<String> meseBox = new JComboBox<>(getMesi());
		JComboBox<Integer> annoBox = new JComboBox<>(getAnni());

		//aggiunta caselle
		inputPanel.add(new JLabel("Nome e Cognome:")); //etichetta testo
		inputPanel.add(nomeCampo); //campo testo
		inputPanel.add(new JLabel("Sesso:"));
		inputPanel.add(sessoBox); //casella a discesa
		inputPanel.add(new JLabel("Colore Urgenza:"));
		inputPanel.add(coloreUrgenzaBox);
		inputPanel.add(new JLabel("Data di nascita:"));
		inputPanel.add(giornoBox);
		inputPanel.add(meseBox);
		inputPanel.add(annoBox);
		panel.add(inputPanel);
		inputPanel.add(new JLabel("Orario di Arrivo:" + Attendimento.getOrarioArrivo()));
		//azione dopo tasto conferma
		JButton confermaButton = new JButton("Conferma"); //nuovo pulsante
		confermaButton.addActionListener(new ActionListener() { //ascoltatore di azioni per pulsante
			public void actionPerformed(ActionEvent e) { //metodo dopo premuta pulsante
				String nome = nomeCampo.getText(); //prendiamo il testo
				String coloreUrgenza =(String) coloreUrgenzaBox.getSelectedItem(); //prendiamo il colore
				String orarioArrivo = orarioArrivoCampo.getText(); // Prendiamo l'orario di arrivo
				//prendiamo i valori per la data di nascita
				int giorno = (int) giornoBox.getSelectedItem();
				String mese = (String) meseBox.getSelectedItem();
				int anno = (int) annoBox.getSelectedItem();

				char sesso = (char) sessoBox.getSelectedItem(); //prendiamo il sesso
				Paziente paziente = new Paziente(nome, sesso); //creiamo oggetto paziente passandogli il nome e sesso
				Attendimento attendimento = new Attendimento(orarioArrivo, coloreUrgenza, ""+giorno+"/"+mese+"/"+anno, paziente, null); //creiamo oggetto attendimento passandogli i parametri

				listaAttendimenti.add(attendimento); //aggiungiamo attendimento a lista pazienti
				JOptionPane.showMessageDialog(framePaziente, "Paziente aggiunto con successo.");
			}
		});
		//pulsante visualizza pazienti
		JButton visualizzaButton = new JButton("Visualizza Pazienti"); //nuovo pulsante 
		visualizzaButton.addActionListener(new ActionListener() { //ascoltatore 
			public void actionPerformed(ActionEvent e) { //metodo dopo pulsante
				StringBuilder pazientiTesto = new StringBuilder(); //creiamo oggetto per costruire stringa lista pazienti
				//a ogni ogg attendimento aggiungiamo il formato testo
				for (Attendimento attendimento : listaAttendimenti) {
					pazientiTesto.append(attendimento);
				}

				JTextArea pazientiArea = new JTextArea(pazientiTesto.toString()); //area dove vedremo la lista pazienti
				pazientiArea.setEditable(false); //vietiamo modifica testo dell'area
				JOptionPane.showMessageDialog(framePaziente, new JScrollPane(pazientiArea), "Lista Pazienti", JOptionPane.PLAIN_MESSAGE); //visualizza elenco pazienti dentro a un JScrollPane per far scorrere l'area di testo se troppo grande
			}
		});
		JPanel buttonPanel = new JPanel(); //nuovo pannello con pulsanti
		buttonPanel.add(confermaButton); //aggiunta pulsante conferma a pannello
		buttonPanel.add(visualizzaButton);//aggiunta puls visualizza paz a pann

		inputPanel.add(buttonPanel); //Aggiungiamo pannello a pann principale
		framePaziente.add(inputPanel); //aggiungiamo pann principale inputPanel a finestra framePaziente
		framePaziente.setVisible(true); //visualizziamo la finestra
	}
	//metodo che restituisce array int con giorni mese
	private Integer[] getGiorni() {
		Integer[] giorni = new Integer[31];
		for (int i = 1; i <= 31; i++) {
			giorni[i - 1] = i;
		}
		return giorni;
	}
	//metodo che restituisce array string con mesi
	private String[] getMesi() {
		return new String[]{"Gennaio", "Febbraio", "Marzo", "Aprile", "Maggio", "Giugno", "Luglio", "Agosto", "Settembre", "Ottobre", "Novembre", "Dicembre"};
	}
	//metodo che restituisce array int con anni da oggi a 110 anni fa
	private Integer[] getAnni() {
		Integer[] anni = new Integer[110];
		int annoCorrente = Calendar.getInstance().get(Calendar.YEAR); //prendiamo l'anno corrente con classe Calendar
		for (int i = 0; i < anni.length; i++) {
			anni[i] = annoCorrente - i;
		}
		return anni;
	}
}

