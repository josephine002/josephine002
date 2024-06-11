import java.awt.*;

import javax.swing.*;

class ColorIcon implements Icon { //interfaccia icon
	private Color color; //memorizzo colore icona
	//costruttore
	public ColorIcon(String colorName) {
		switch (colorName.toLowerCase()) { //converto nome in piccolo
		case "rosso": //se rosso imposto colore a rosso
			color = Color.RED;
			break;
		case "bianco":
			color = Color.WHITE;
			break;
		case "azzurro":
			color = Color.CYAN;
			break;
		case "arancione":
			color = Color.ORANGE;
			break;
		case "giallo":
			color = Color.YELLOW;
			break;
		default: //predefinito nero
			color = Color.BLACK;
			break;
		}
	}

	@Override
	//prendo parametri componente su cui disegnare icona,contesto grafico e coordinate
	public void paintIcon(Component c, Graphics g, int x, int y) {
		g.setColor(color); //imposto colore pann grafico a colore in variabile color
		g.fillOval(x, y, getIconWidth(), getIconHeight()); //disegna cerchio pieno a coordinate specifiche largh e alt
	}
	//metodo che torna larghezza icona
	public int getIconWidth() {
		return 12;
	}

	//metodo che torna altezza icona
	public int getIconHeight() {
		return 12;
	}
}

