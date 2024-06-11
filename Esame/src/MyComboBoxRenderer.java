import java.awt.*;
import javax.swing.DefaultListCellRenderer;
import javax.swing.*;

public class MyComboBoxRenderer extends DefaultListCellRenderer { //classe di rendering predefinita per celle lista
    //metodo chiamato per disegnare cella nella lista
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel etichetta = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); //chiamato metodo superc per avere componente LLabel base
        etichetta.setIcon(new ColorIcon(value.toString().toLowerCase())); //icona per cella, creata usando valore cella conv in min
        return etichetta;
    }
}

