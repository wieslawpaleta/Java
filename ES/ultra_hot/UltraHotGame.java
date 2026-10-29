import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

// Clase principal de la tragaperras con animación (Główna klasa automatu z animacją)
public class UltraHotGame extends JFrame {

    private JLabel[][] slots; 
    private JButton btnSpin; 
    private JLabel lblCredit; 
    private JLabel lblWin; 

    private int credit = 1000; 
    private int bet = 10; 
    private String[] symbols = {"77", "BAR", "PLUM", "ORANGE", "LEMON", "CHERRY", "X"}; 
    private Random random = new Random();

    public UltraHotGame() {
        setTitle("Ultra Hot Deluxe - Java Edition (Animado)");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setLayout(new BorderLayout(10, 10));

        // Panel Superior (Górny panel)
        JLabel title = new JLabel("ULTRA HOT", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 32));
        title.setForeground(Color.RED);
        add(title, BorderLayout.NORTH);

        // Panel Central (Środkowy panel)
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

        // Panel Inferior (Dolny panel)
        JPanel controlPanel = new JPanel(new FlowLayout());

        lblCredit = new JLabel("Crédito: " + credit + " "); 
        lblCredit.setFont(new Font("Arial", Font.BOLD, 16));

        lblWin = new JLabel("Ganancia: 0 "); 
        lblWin.setFont(new Font("Arial", Font.BOLD, 16));

        btnSpin = new JButton("START / SPIN"); 
        btnSpin.setFont(new Font("Arial", Font.BOLD, 18));
        btnSpin.setBackground(Color.ORANGE);

        btnSpin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spinReels(); 
            }
        });

        controlPanel.add(lblCredit);
        controlPanel.add(lblWin);
        controlPanel.add(btnSpin);

        add(controlPanel, BorderLayout.SOUTH);
    }

    // Método para simular el giro con animación (Metoda symulująca obrót z animacją)
    private void spinReels() {
        if (credit < bet) {
            JOptionPane.showMessageDialog(this, "¡No tienes suficiente crédito! (Brak wystarczających środków!)");
            return;
        }

        // Restar la apuesta y limpiar ganancia anterior (Odejmowanie zakładu i wyczyszczenie poprzedniej wygranej)
        credit -= bet;
        lblCredit.setText("Crédito: " + credit + " ");
        lblWin.setText("Ganancia: 0 ");

        // Desactivar el botón para evitar múltiples clics durante el giro (Wyłączenie przycisku, aby zapobiec wielu kliknięciom podczas obrotu)
        btnSpin.setEnabled(false);

        // Crear un temporizador que se ejecuta cada 80 milisegundos (Tworzenie timera wykonującego się co 80 milisekund)
        Timer spinTimer = new Timer(80, new ActionListener() {
            private int counter = 0; // Contador de fotogramas del giro (Licznik klatek obrotu)

            @Override
            public void actionPerformed(ActionEvent e) {
                // Cambiar aleatoriamente los símbolos para dar efecto de movimiento (Losowa zmiana symboli, aby dać efekt ruchu)
                for (int r = 0; r < 3; r++) {
                    for (int c = 0; c < 3; c++) {
                        int randomIndex = random.nextInt(symbols.length);
                        slots[r][c].setText(symbols[randomIndex]);
                    }
                }

                counter++;
                
                // Después de 15 ciclos (aprox. 1.2 segundos), detenemos el temporizador (Po 15 cyklach ok. 1.2 sekundy, zatrzymujemy timer)
                if (counter > 15) {
                    ((Timer) e.getSource()).stop(); // Detener el temporizador (Zatrzymanie timera)

                    // Generar la matriz con el resultado final real (Generowanie macierzy z ostatecznym, prawdziwym wynikiem)
                    String[][] matrix = new String[3][3];
                    for (int r = 0; r < 3; r++) {
                        for (int c = 0; c < 3; c++) {
                            int randomIndex = random.nextInt(symbols.length);
                            matrix[r][c] = symbols[randomIndex];
                            slots[r][c].setText(matrix[r][c]);
                        }
                    }

                    // Calcular ganancias del resultado final (Obliczanie wygranych z ostatecznego wyniku)
                    int winAmount = checkWins(matrix);
                    credit += winAmount;

                    lblWin.setText("Ganancia: " + winAmount + " ");
                    lblCredit.setText("Crédito: " + credit + " ");

                    // Volver a habilitar el botón de giro (Ponowne włączenie przycisku obrotu)
                    btnSpin.setEnabled(true);
                }
            }
        });
        
    // Método para calcular las líneas de pago (Metoda obliczająca linie wygrywające)
    private int checkWins(String[][] matrix) {
        int totalWin = 0;

        // Línea horizontal 1 (Pozioma linia 1)
        if (matrix[0][0].equals(matrix[0][1]) && matrix[0][1].equals(matrix[0][2])) {
            totalWin += getSymbolValue(matrix[0][0]);
        }
        // Línea horizontal 2 (Pozioma linia 2)
        if (matrix[1][0].equals(matrix[1][1]) && matrix[1][1].equals(matrix[1][2])) {
            totalWin += getSymbolValue(matrix[1][0]);
        }
        // Línea horizontal 3 (Pozioma linia 3)
        if (matrix[2][0].equals(matrix[2][1]) && matrix[2][1].equals(matrix[2][2])) {
            totalWin += getSymbolValue(matrix[2][0]);
        }
        // Diagonal principal (Przekątna główna)
        if (matrix[0][0].equals(matrix[1][1]) && matrix[1][1].equals(matrix[2][2])) {
            totalWin += getSymbolValue(matrix[0][0]);
        }
        // Diagonal secundaria (Przekątna poboczna)
        if (matrix[2][0].equals(matrix[1][1]) && matrix[1][1].equals(matrix[0][2])) {
            totalWin += getSymbolValue(matrix[2][0]);
        }

        return totalWin;
    }

    // Asignar valor a cada símbolo (Przypisanie wartości do każdego symbolu)
    private int getSymbolValue(String symbol) {
        switch (symbol) {
            case "77": return 1500;
            case "BAR": return 300;
            case "PLUM": return 80;
            case "ORANGE": return 80;
            case "LEMON": return 80;
            case "CHERRY": return 80;
            case "X": return 10;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        // Ejecutar la interfaz gráfica en el hilo de eventos (Uruchomienie GUI w wątku zdarzeń)
        SwingUtilities.invokeLater(() -> {
            new UltraHotGame().setVisible(true);
        });
    }
}

