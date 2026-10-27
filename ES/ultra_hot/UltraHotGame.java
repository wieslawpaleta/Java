import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

// Clase principal de la tragaperras (Główna klasa automatu hazardowego)
public class UltraHotGame extends JFrame {

    // Componentes de la interfaz gráfica (Komponenty interfejsu graficznego)
    private JLabel[][] slots; // Rejilla de 3x3 para los símbolos (Siatka 3x3 dla symboli)
    private JButton btnSpin; // Botón para girar (Przycisk do obrotu)
    private JLabel lblCredit; // Etiqueta para el crédito/saldo (Etykieta dla salda/kredytu)
    private JLabel lblWin; // Etiqueta para mostrar la ganancia (Etykieta pokazująca wygraną)

    // Variables del juego (Zmienne gry)
    private int credit = 1000; // Saldo inicial (Początkowe saldo)
    private int bet = 10; // Apuesta por giro (Zakład na obrót)
    private String[] symbols = {"77", "BAR", "PLUM", "ORANGE", "LEMON", "CHERRY", "X"}; // Símbolos estilo Ultra Hot (Symbole w stylu Ultra Hot)
    private Random random = new Random();

    public UltraHotGame() {
        // Configuración de la ventana principal (Konfiguracja głównego okna)
        setTitle("Ultra Hot Deluxe - Java Edition");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana (Wyśrodkowanie okna)
        setLayout(new BorderLayout(10, 10));

        // 1. Panel Superior - Título (Górny panel - Tytuł)
        JLabel title = new JLabel("ULTRA HOT", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 32));
        title.setForeground(Color.RED);
        add(title, BorderLayout.NORTH);

        // 2. Panel Central - Rejilla 3x3 para los carretes (Środkowy panel - Siatka 3x3 dla bębnów)
        JPanel gridPanel = new JPanel(new GridLayout(3, 3, 5, 5));
        gridPanel.setBackground(Color.BLACK);
        slots = new JLabel[3][3];

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                slots[r][c] = new JLabel("77", SwingConstants.CENTER);
                slots[r][c].setFont(new Font("Arial", Font.BOLD, 24));
                slots[r][c].setOpaque(true);
                slots[r][c].setBackground(Color.DARK_GRAY);
                slots[r][c].setForeground(Color.YELLOW);
                gridPanel.add(slots[r][c]);
            }
        }
        add(gridPanel, BorderLayout.CENTER);

        // 3. Panel Inferior - Controles y Estado (Dolny panel - Sterowanie i status)
        JPanel controlPanel = new JPanel(new FlowLayout());

        lblCredit = new JLabel("Crédito: " + credit + " "); // (Kredyt)
        lblCredit.setFont(new Font("Arial", Font.BOLD, 16));

        lblWin = new JLabel("Ganancia: 0 "); // (Wygrana)
        lblWin.setFont(new Font("Arial", Font.BOLD, 16));

        btnSpin = new JButton("START / SPIN"); // (Przycisk START)
        btnSpin.setFont(new Font("Arial", Font.BOLD, 18));
        btnSpin.setBackground(Color.ORANGE);

        // Evento del botón Girar (Zdarzenie przycisku Obrót)
        btnSpin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spinReels(); // Llamada al método para girar los carretes (Wywołanie metody obrotu bębnów)
            }
        });

        controlPanel.add(lblCredit);
        controlPanel.add(lblWin);
        controlPanel.add(btnSpin);

        add(controlPanel, BorderLayout.SOUTH);
    }

    // Método para simular el giro de los carretes (Metoda symulująca obrót bębnów)
    private void spinReels() {
        if (credit < bet) {
            JOptionPane.showMessageDialog(this, "¡No tienes suficiente crédito! (Brak wystarczających środków!)");
            return;
        }

        // Restar la apuesta (Odejmowanie zakładu)
        credit -= bet;
        lblCredit.setText("Crédito: " + credit + " ");

        // Generar símbolos aleatorios en la rejilla 3x3 (Generowanie losowych symboli w siatce 3x3)
        String[][] matrix = new String[3][3];
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                int randomIndex = random.nextInt(symbols.length);
                matrix[r][c] = symbols[randomIndex];
                slots[r][c].setText(matrix[r][c]);
            }
        }

        // Verificar ganancias en las 5 líneas de pago (Sprawdzanie wygranych na 5 liniach wypłat)
        int winAmount = checkWins(matrix);
        credit += winAmount;

        lblWin.setText("Ganancia: " + winAmount + " ");
        lblCredit.setText("Crédito: " + credit + " ");
    }

    // Método para calcular las líneas de pago (Metoda obliczająca linie wygrywające)
    private int checkWins(String[][] matrix) {
        int totalWin = 0;

        // Línea horizontal 1 (Pozioma linia 1)
        if (matrix[0][0].equals(matrix[0][1]) && matrix[0][1].equals(matrix[0][2])) {
            totalWin += getSymbolValue(matrix[0][0]);
        }
    }