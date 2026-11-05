import javax.swing.SwingUtilities;

// Clase principal que inicia el programa (Główna klasa uruchamiająca program)
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
}