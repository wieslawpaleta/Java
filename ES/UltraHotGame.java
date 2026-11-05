import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.net.URL;

// Clase principal de la tragaperras con animación (Główna klasa automatu z animacją)
public class UltraHotGame extends JFrame {

    private JLabel[][] slots; 
    private JButton btnSpin; 
    private JLabel lblCredit; 
    private JLabel lblWin; 
    private JComboBox<Integer> cbBet; // Selector de apuesta (Selektor zakładu)

    private int credit = 1000; 
    private String[] symbols = {"77", "BAR", "PLUM", "ORANGE", "LEMON", "CHERRY", "X"}; 
    private Random random = new Random();

    public UltraHotGame() {
        setTitle("Ultra Hot Deluxe - Java Edition (Con Imágenes)");
        setSize(700, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setLayout(new BorderLayout(10, 10));

        // Panel Superior (Górny panel)
        JLabel title = new JLabel("ULTRA HOT", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 32));
        title.setForeground(Color.RED);
        add(title, BorderLayout.NORTH);

        // Panel Central - Cuadrícula de carretes (Środkowy panel - Siatka bębnów)
        JPanel gridPanel = new JPanel(new GridLayout(3, 3, 5, 5));
        gridPanel.setBackground(Color.BLACK);
        slots = new JLabel[3][3];

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                slots[r][c] = new JLabel("", SwingConstants.CENTER);
                slots[r][c].setOpaque(true);
                slots[r][c].setBackground(Color.DARK_GRAY);
                setSymbolIcon(slots[r][c], "77"); // Símbolo inicial por defecto (Domyślny początkowy symbol)
                gridPanel.add(slots[r][c]);
            }
        }
        add(gridPanel, BorderLayout.CENTER);

        // Panel Inferior - Controles y Selector de Apuesta (Dolny panel - Sterowanie i selektor zakładu)
        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));

        lblCredit = new JLabel("Crédito: " + credit + " "); 
        lblCredit.setFont(new Font("Arial", Font.BOLD, 16));

        lblWin = new JLabel("Ganancia: 0 "); 
        lblWin.setFont(new Font("Arial", Font.BOLD, 16));

        // Etiqueta y ComboBox para el selector de apuesta (Etykieta i ComboBox dla selektora zakładu)
        JLabel lblBetText = new JLabel("Apuesta (Zakład):");
        lblBetText.setFont(new Font("Arial", Font.BOLD, 14));

        Integer[] betOptions = {5, 10, 20, 50, 100};
        cbBet = new JComboBox<>(betOptions);
        cbBet.setSelectedItem(10); // Apuesta inicial por defecto (Domyślny początkowy zakład)
        cbBet.setFont(new Font("Arial", Font.BOLD, 14));

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
        controlPanel.add(lblBetText);
        controlPanel.add(cbBet);
        controlPanel.add(btnSpin);

        add(controlPanel, BorderLayout.SOUTH);
    }

    // Método para cargar y ajustar la imagen al tamaño del JLabel (Metoda do ładowania i dopasowywania obrazu do rozmiaru JLabel)
    private void setSymbolIcon(JLabel label, String symbol) {
        URL imgUrl = getClass().getResource("/images/" + symbol + ".png");

        if (imgUrl != null) {
            ImageIcon originalIcon = new ImageIcon(imgUrl);
            // Redimensionar la imagen a 100x100 píxeles (Zmiana rozmiaru obrazu na 100x100 pikseli)
            Image scaledImage = originalIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            label.setIcon(new ImageIcon(scaledImage));
            label.setText(""); // Quitar el texto si hay imagen (Usunięcie tekstu, jeśli jest obraz)
        } else {
            // Si no existe la imagen, mostrar texto como respaldo (Jeśli obraz nie istnieje, wyświetl tekst jako zabezpieczenie)
            label.setIcon(null);
            label.setText(symbol);
            label.setFont(new Font("Arial", Font.BOLD, 24));
            label.setForeground(Color.YELLOW);
        }
    }

    // Método para simular el giro con animación (Metoda symulująca obrót z animacją)
    private void spinReels() {
        // Obtener la apuesta seleccionada actualmente (Pobranie aktualnie wybranego zakładu)
        int currentBet = (Integer) cbBet.getSelectedItem();

        if (credit < currentBet) {
            JOptionPane.showMessageDialog(this, "¡No tienes suficiente crédito! (Brak wystarczających środków!)");
            return;
        }

        // Restar la apuesta y limpiar ganancia anterior (Odejmowanie zakładu i wyczyszczenie poprzedniej wygranej)
        credit -= currentBet;
        lblCredit.setText("Crédito: " + credit + " ");
        lblWin.setText("Ganancia: 0 ");

        // Desactivar el botón para evitar múltiples clics durante el giro (Wyłączenie przycisku, aby zapobiec wielu kliknięciom podczas obrotu)
        btnSpin.setEnabled(false);
        cbBet.setEnabled(false);

        // Crear un temporizador que se ejecuta cada 80 milisegundos (Tworzenie timera wykonującego się co 80 milisekund)
        Timer spinTimer = new Timer(80, new ActionListener() {
            private int counter = 0; // Contador de fotogramas del giro (Licznik klatek obrotu)

            @Override
            public void actionPerformed(ActionEvent e) {
                // Cambiar aleatoriamente los símbolos para dar efecto de movimiento (Losowa zmiana symboli, aby dać efekt ruchu)
                for (int r = 0; r < 3; r++) {
                    for (int c = 0; c < 3; c++) {
                        int randomIndex = random.nextInt(symbols.length);
                        setSymbolIcon(slots[r][c], symbols[randomIndex]);
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
                            setSymbolIcon(slots[r][c], matrix[r][c]);
                        }
                    }

                    // Calcular ganancias del resultado final (Obliczanie wygranych z ostatecznego wyniku)
                    int baseWin = checkWins(matrix);
                    int winAmount = baseWin * (currentBet / 10);
                    credit += winAmount;

                    lblWin.setText("Ganancia: " + winAmount + " ");
                    lblCredit.setText("Crédito: " + credit + " ");

                    // Volver a habilitar el botón de giro (Ponowne włączenie przycisku obrotu)
                    btnSpin.setEnabled(true);
                    cbBet.setEnabled(true);
                }
            }
        });

        spinTimer.start(); // Iniciar el temporizador (Uruchomienie timera)
    }
        
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

