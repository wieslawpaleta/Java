import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

// Clase principal de la interfaz gráfica con efecto de fuego en líneas ganadoras (Główna klasa interfejsu z efektem ognia na liniach wygrywających)
public class MainFrame extends JFrame {

    private final GameModel gameModel;
    private final JLabel[][] slotLabels;
    private final JButton btnSpin;
    private final JComboBox<Integer> cbBet;
    private final JLabel lblCredit;
    private final JLabel lblWin;
    private final Random random = new Random();

    public MainFrame() {
        this.gameModel = new GameModel(1000);
        this.slotLabels = new JLabel[3][3];

        setTitle("Ultra Hot Deluxe - Fuego Edition");
        setSize(700, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Panel Superior (Górny panel)
        JLabel title = new JLabel("ULTRA HOT", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 32));
        title.setForeground(Color.RED);
        add(title, BorderLayout.NORTH);

        // Panel Central (Panel środkowy)
        JPanel gridPanel = new JPanel(new GridLayout(3, 3, 5, 5));
        gridPanel.setBackground(Color.BLACK);

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                slotLabels[r][c] = new JLabel("", SwingConstants.CENTER);
                slotLabels[r][c].setOpaque(true);
                slotLabels[r][c].setBackground(Color.DARK_GRAY);
                updateLabelWithSymbol(slotLabels[r][c], gameModel.getGrid()[r][c], false);
                gridPanel.add(slotLabels[r][c]);
            }
        }
        add(gridPanel, BorderLayout.CENTER);

        // Panel Inferior (Dolny panel)
        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));

        lblCredit = new JLabel("Crédito: " + gameModel.getCredit() + " ");
        lblCredit.setFont(new Font("Arial", Font.BOLD, 16));

        lblWin = new JLabel("Ganancia: 0 ");
        lblWin.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel lblBetText = new JLabel("Apuesta (Zakład):");
        lblBetText.setFont(new Font("Arial", Font.BOLD, 14));

        Integer[] betOptions = {5, 10, 20, 50, 100};
        cbBet = new JComboBox<>(betOptions);
        cbBet.setSelectedItem(10);
        cbBet.setFont(new Font("Arial", Font.BOLD, 14));
        cbBet.addActionListener(e -> gameModel.setCurrentBet((Integer) cbBet.getSelectedItem()));

        btnSpin = new JButton("START / SPIN");
        btnSpin.setFont(new Font("Arial", Font.BOLD, 18));
        btnSpin.setBackground(Color.ORANGE);
        btnSpin.addActionListener(e -> startSpinAnimation());

        controlPanel.add(lblCredit);
        controlPanel.add(lblWin);
        controlPanel.add(lblBetText);
        controlPanel.add(cbBet);
        controlPanel.add(btnSpin);

        add(controlPanel, BorderLayout.SOUTH);
    }

    // Actualizar etiqueta aplicando color de fuego si es ganadora (Aktualizacja etykiety z zastosowaniem koloru ognia, jeśli jest wygrywająca)
    private void updateLabelWithSymbol(JLabel label, Symbol symbol, boolean isWinning) {
        ImageIcon icon = symbol.getIcon(100, 100);
        if (icon != null) {
            label.setIcon(icon);
            label.setText("");
        } else {
            label.setIcon(null);
            label.setText(symbol.getName());
            label.setFont(new Font("Arial", Font.BOLD, 24));
            label.setForeground(Color.YELLOW);
        }

        // Si es una celda ganadora, cambiar fondo a color fuego/naranja brillante (Jeśli to wygrywająca komórka, zmień tło na kolor ognia/jasny pomarańcz)
        if (isWinning) {
            label.setBackground(new Color(255, 69, 0)); // Color rojo-naranja estilo fuego / Ognisty czerwono-pomarańczowy kolor
        } else {
            label.setBackground(Color.DARK_GRAY);
        }
    }

    private void startSpinAnimation() {
        if (!gameModel.canPlay()) {
            JOptionPane.showMessageDialog(this, "¡No tienes suficiente crédito! (Brak wystarczających środków!)");
            return;
        }

        gameModel.deductBet();
        lblCredit.setText("Crédito: " + gameModel.getCredit() + " ");
        lblWin.setText("Ganancia: 0 ");

        // Restablecer los colores de fondo antes de empezar a girar (Resetowanie kolorów tła przed rozpoczęciem kręcenia)
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                slotLabels[r][c].setBackground(Color.DARK_GRAY);
            }
        }

        btnSpin.setEnabled(false);
        cbBet.setEnabled(false);

        Symbol[] symbols = Symbol.values();

        Timer spinTimer = new Timer(80, new ActionListener() {
            private int counter = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                for (int r = 0; r < 3; r++) {
                    for (int c = 0; c < 3; c++) {
                        Symbol randomSymbol = symbols[random.nextInt(symbols.length)];
                        updateLabelWithSymbol(slotLabels[r][c], randomSymbol, false);
                    }
                }

                counter++;

                if (counter > 15) {
                    ((Timer) e.getSource()).stop();

                    Symbol[][] finalGrid = gameModel.spin();
                    int winAmount = gameModel.calculateWin();
                    boolean[][] winningCells = gameModel.getWinningCells();

                    // Mostrar el resultado final aplicando el efecto de fuego en las celdas ganadoras (Wyświetlenie ostatecznego wyniku z efektem ognia na wygrywających komórkach)
                    for (int r = 0; r < 3; r++) {
                        for (int c = 0; c < 3; c++) {
                            updateLabelWithSymbol(slotLabels[r][c], finalGrid[r][c], winningCells[r][c]);
                        }
                    }

                    lblWin.setText("Ganancia: " + winAmount + " ");
                    lblCredit.setText("Crédito: " + gameModel.getCredit() + " ");

                    btnSpin.setEnabled(true);
                    cbBet.setEnabled(true);
                }
            }
        });

        spinTimer.start();
    }
}